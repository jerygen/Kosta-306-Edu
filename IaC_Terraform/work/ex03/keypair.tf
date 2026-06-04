resource "tls_private_key" "kosta" {
  algorithm = "RSA"
  rsa_bits  = 4096
}

resource "aws_key_pair" "kosta" {
  key_name   = var.key_name
  public_key = tls_private_key.kosta.public_key_openssh
}

resource "local_file" "kosta_private_key" {
  content      = tls_private_key.kosta.private_key_pem
  filename     = pathexpand("~/.ssh/${var.key_name}.pem")
  file_permission = "0400"
}
