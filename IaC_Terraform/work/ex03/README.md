# AWS Terraform Infrastructure

## 프로젝트 개요

본 프로젝트는 Terraform을 사용하여 AWS 환경에 네트워크 및 EC2 인프라를 구축하기 위한 코드입니다.

구성된 아키텍처는 다음과 같습니다.

- VPC 1개 (kosta-VPC)
- Public Subnet 2개
- Private Subnet 2개
- EC2 Instance 3개
- Internet Gateway
- Public/Private Route Table
- AZ 이중화 구성

### 이미지 기반 구성

`terraform_vpc2.drawio.png`에 따르면 다음과 같은 네트워크 구성이 정의되어 있습니다.

- VPC: `kosta-VPC` (172.16.0.0/16)
- AZ: `ap-northeast-2a`, `ap-northeast-2c`
- `ap-northeast-2a`에 Public Subnet `kosta-public01`과 Private Subnet `kosta-private01`
- `ap-northeast-2c`에 Public Subnet `kosta-public02`와 Private Subnet `kosta-private02`
- Public Subnet `kosta-public01`에는 Docker 서버
- Public Subnet `kosta-public02`에는 Bastion 서버
- Private Subnet `kosta-private01`에는 Internal 서버
- `kosta-private02`는 현재 별도 인스턴스가 배치되지 않은 Private Subnet

---

## 아키텍처

### Network Topology

```
VPC (172.16.0.0/16)

├── ap-northeast-2a
│   ├── Public Subnet
│   │   └── kosta-public01 (172.16.0.0/24)
│   │       └── Docker Server
│   │
│   └── Private Subnet
│       └── kosta-private01 (172.16.100.0/24)
│           └── Internal Server
│
└── ap-northeast-2c
    ├── Public Subnet
    │   └── kosta-public02 (172.16.10.0/24)
    │       └── Bastion Server
    │
    └── Private Subnet
        └── kosta-private02 (172.16.110.0/24)
```

---

## 구성 정보

### VPC

| Name      | CIDR          |
| --------- | ------------- |
| kosta-vpc | 172.16.0.0/16 |

---

### Subnet

| Name            | AZ              | CIDR            | Type    |
| --------------- | --------------- | --------------- | ------- |
| kosta-public01  | ap-northeast-2a | 172.16.0.0/24   | Public  |
| kosta-private01 | ap-northeast-2a | 172.16.100.0/24 | Private |
| kosta-public02  | ap-northeast-2c | 172.16.10.0/24  | Public  |
| kosta-private02 | ap-northeast-2c | 172.16.110.0/24 | Private |

---

### EC2 Instance

| Name     | Subnet          | Purpose         | Key Pair |
| -------- | --------------- | --------------- | -------- |
| docker   | kosta-public01  | Docker Host     | kosta    |
| bastion  | kosta-public02  | Bastion Host    | kosta    |
| internal | kosta-private01 | Internal Server | kosta    |

---

## Docker 인스턴스 User Data

Docker 인스턴스는 시작 시 다음 User Data를 실행하도록 구성됩니다.

```bash
sudo dnf install -y docker
sudo systemctl enable docker --now
sudo usermod -aG docker ec2-user
```

설명: Docker 패키지를 설치하고 서비스를 활성화하며 `ec2-user`를 Docker 그룹에 추가하여 권한을 설정합니다.

---

## 디렉토리 구조

```bash
terraform/
│
├── provider.tf
├── variables.tf
├── outputs.tf
│
├── vpc.tf
├── subnet.tf
├── route.tf
├── security_group.tf
├── ec2.tf
│
└── terraform.tfvars
```

---

## Terraform 리소스 구성

### Network

- aws_vpc
- aws_subnet
- aws_internet_gateway
- aws_route_table
- aws_route
- aws_route_table_association

### Compute

- aws_instance

### Security

- aws_security_group
- aws_security_group_rule

---

## 예상 Security Group 구성

### Bastion SG

| 방향    | Protocol | Port | Source / Destination |
| ------- | -------- | ---- | -------------------- |
| Ingress | TCP      | 22   | 관리자 IP / CIDR     |
| Egress  | All      | All  | 0.0.0.0/0            |

설명: 외부 관리자는 Bastion 서버에 SSH로 접속합니다.

---

### Docker SG

| 방향    | Protocol | Port | Source / Destination |
| ------- | -------- | ---- | -------------------- |
| Ingress | TCP      | 22   | Bastion SG           |
| Ingress | TCP      | 80   | 0.0.0.0/0            |
| Ingress | TCP      | 443  | 0.0.0.0/0            |
| Egress  | All      | All  | 0.0.0.0/0            |

설명: Docker 서버는 HTTP/HTTPS를 외부에 공개하며 SSH는 Bastion을 통해서만 허용됩니다.

---

### Internal SG

| 방향    | Protocol | Port | Source / Destination |
| ------- | -------- | ---- | -------------------- |
| Ingress | TCP      | 22   | Bastion SG           |
| Ingress | TCP      | 8080 | Docker SG            |
| Egress  | All      | All  | 0.0.0.0/0            |

설명: Internal 서버는 Bastion에서만 SSH 접근이 가능하고, Docker 서버에서 전달된 애플리케이션 트래픽을 수신합니다.

---

## 배포 방법

### SSH 키페어 생성 및 저장

Terraform이 자동으로 SSH key pair를 생성하고 로컬 `~/.ssh/kosta.pem`에 private 키를 저장합니다.

```bash
mkdir -p ~/.ssh
terraform init
terraform apply
```

> 생성된 키페어 `kosta`는 모든 EC2 인스턴스에 동일하게 적용됩니다.

### 1. 초기화

```bash
terraform init
```

### 2. 실행 계획 확인

```bash
terraform plan
```

### 3. 인프라 생성

```bash
terraform apply
```

### 4. 인프라 삭제

```bash
terraform destroy
```

---

## Terraform 변수 예시

```hcl
region = "ap-northeast-2"

vpc_cidr = "172.16.0.0/16"

public_subnet_01 = "172.16.0.0/24"
public_subnet_02 = "172.16.10.0/24"

private_subnet_01 = "172.16.100.0/24"
private_subnet_02 = "172.16.110.0/24"

instance_type = "t3.micro"
key_name      = "kosta"
```

---

## 접속 흐름

```text
Internet
    │
    ▼
Bastion Host
    │
    ▼
Internal Server

Internet
    │
    ▼
Docker Host
    │
    ▼
Internal Server
```

---

## 구축 목표

- Terraform을 이용한 Infrastructure as Code(IaC) 구현
- Public / Private 네트워크 분리
- Bastion Host를 통한 Private 자원 접근
- Docker 기반 서비스 운영 환경 구축
- 멀티 AZ 기반 고가용성 네트워크 구조 구성
