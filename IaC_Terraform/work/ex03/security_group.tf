resource "aws_security_group" "bastion" {
  name        = "kosta-bastion-sg"
  description = "Bastion SSH access"
  vpc_id      = aws_vpc.kosta_vpc.id

  ingress {
    description      = "SSH from admin IP"
    from_port        = 22
    to_port          = 22
    protocol         = "tcp"
    cidr_blocks      = [var.bastion_ssh_cidr]
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
  }

  tags = {
    Name = "kosta-bastion-sg"
  }
}

resource "aws_security_group" "docker" {
  name        = "kosta-docker-sg"
  description = "Docker host security group"
  vpc_id      = aws_vpc.kosta_vpc.id

  ingress {
    description      = "SSH from bastion"
    from_port        = 22
    to_port          = 22
    protocol         = "tcp"
    security_groups  = [aws_security_group.bastion.id]
  }

  ingress {
    description      = "HTTP public"
    from_port        = 80
    to_port          = 80
    protocol         = "tcp"
    cidr_blocks      = ["0.0.0.0/0"]
  }

  ingress {
    description      = "HTTPS public"
    from_port        = 443
    to_port          = 443
    protocol         = "tcp"
    cidr_blocks      = ["0.0.0.0/0"]
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
  }

  tags = {
    Name = "kosta-docker-sg"
  }
}

resource "aws_security_group" "internal" {
  name        = "kosta-internal-sg"
  description = "Internal server security group"
  vpc_id      = aws_vpc.kosta_vpc.id

  ingress {
    description      = "SSH from bastion"
    from_port        = 22
    to_port          = 22
    protocol         = "tcp"
    security_groups  = [aws_security_group.bastion.id]
  }

  ingress {
    description      = "Application port from Docker"
    from_port        = var.docker_app_port
    to_port          = var.docker_app_port
    protocol         = "tcp"
    security_groups  = [aws_security_group.docker.id]
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
  }

  tags = {
    Name = "kosta-internal-sg"
  }
}
