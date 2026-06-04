variable "region" {
  description = "AWS 리전"
  type        = string
  default     = "ap-northeast-2"
}

variable "vpc_cidr" {
  description = "VPC CIDR 블록"
  type        = string
  default     = "172.16.0.0/16"
}

variable "public_subnet_01" {
  description = "첫 번째 Public Subnet CIDR"
  type        = string
  default     = "172.16.0.0/24"
}

variable "public_subnet_02" {
  description = "두 번째 Public Subnet CIDR"
  type        = string
  default     = "172.16.10.0/24"
}

variable "private_subnet_01" {
  description = "첫 번째 Private Subnet CIDR"
  type        = string
  default     = "172.16.100.0/24"
}

variable "private_subnet_02" {
  description = "두 번째 Private Subnet CIDR"
  type        = string
  default     = "172.16.110.0/24"
}

variable "instance_type" {
  description = "EC2 인스턴스 타입"
  type        = string
  default     = "t3.micro"
}

variable "key_name" {
  description = "AWS EC2 Key Pair 이름"
  type        = string
  default     = "kosta"
}

variable "bastion_ssh_cidr" {
  description = "Bastion SSH 접속을 허용할 CIDR"
  type        = string
  default     = "0.0.0.0/0"
}

variable "docker_app_port" {
  description = "Docker에서 내부 애플리케이션이 사용할 포트"
  type        = number
  default     = 8080
}
