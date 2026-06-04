data "aws_ami" "amazon_linux_2" {
  most_recent = true
  owners      = ["amazon"]

  filter {
    name   = "name"
    values = ["amzn2-ami-hvm-*-x86_64-gp2"]
  }
}

resource "aws_instance" "bastion" {
  ami                    = data.aws_ami.amazon_linux_2.id
  instance_type          = var.instance_type
  subnet_id              = aws_subnet.public_2.id
  key_name               = aws_key_pair.kosta.key_name
  vpc_security_group_ids = [aws_security_group.bastion.id]

  tags = {
    Name = "bastion"
  }
}

resource "aws_instance" "docker" {
  ami                    = data.aws_ami.amazon_linux_2.id
  instance_type          = var.instance_type
  subnet_id              = aws_subnet.public_1.id
  key_name               = aws_key_pair.kosta.key_name
  vpc_security_group_ids = [aws_security_group.docker.id]

  user_data = <<-EOT
              #!/bin/bash
              sudo dnf install -y docker
              sudo systemctl enable docker --now
              sudo usermod -aG docker ec2-user
              EOT

  tags = {
    Name = "docker"
  }
}

resource "aws_instance" "internal" {
  ami                    = data.aws_ami.amazon_linux_2.id
  instance_type          = var.instance_type
  subnet_id              = aws_subnet.private_1.id
  key_name               = aws_key_pair.kosta.key_name
  vpc_security_group_ids = [aws_security_group.internal.id]

  tags = {
    Name = "internal"
  }
}
