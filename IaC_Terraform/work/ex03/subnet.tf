resource "aws_subnet" "public_1" {
  vpc_id            = aws_vpc.kosta_vpc.id
  cidr_block        = var.public_subnet_01
  availability_zone = "ap-northeast-2a"
  map_public_ip_on_launch = true

  tags = {
    Name = "kosta-public01"
  }
}

resource "aws_subnet" "public_2" {
  vpc_id            = aws_vpc.kosta_vpc.id
  cidr_block        = var.public_subnet_02
  availability_zone = "ap-northeast-2c"
  map_public_ip_on_launch = true

  tags = {
    Name = "kosta-public02"
  }
}

resource "aws_subnet" "private_1" {
  vpc_id            = aws_vpc.kosta_vpc.id
  cidr_block        = var.private_subnet_01
  availability_zone = "ap-northeast-2a"
  map_public_ip_on_launch = false

  tags = {
    Name = "kosta-private01"
  }
}

resource "aws_subnet" "private_2" {
  vpc_id            = aws_vpc.kosta_vpc.id
  cidr_block        = var.private_subnet_02
  availability_zone = "ap-northeast-2c"
  map_public_ip_on_launch = false

  tags = {
    Name = "kosta-private02"
  }
}
