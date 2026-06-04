output "vpc_id" {
  description = "VPC ID"
  value       = aws_vpc.kosta_vpc.id
}

output "public_subnets" {
  description = "Public subnet IDs"
  value       = [aws_subnet.public_1.id, aws_subnet.public_2.id]
}

output "private_subnets" {
  description = "Private subnet IDs"
  value       = [aws_subnet.private_1.id, aws_subnet.private_2.id]
}

output "bastion_public_ip" {
  description = "Bastion public IP address"
  value       = aws_instance.bastion.public_ip
}

output "docker_public_ip" {
  description = "Docker host public IP address"
  value       = aws_instance.docker.public_ip
}

output "internal_private_ip" {
  description = "Internal server private IP address"
  value       = aws_instance.internal.private_ip
}
