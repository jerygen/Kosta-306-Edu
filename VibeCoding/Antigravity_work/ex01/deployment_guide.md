# EC2 배포 최종 가이드

프론트엔드 빌드 및 백엔드 설정이 배포용으로 완료되었습니다. 이제 다음 단계에 따라 EC2에 업로드하고 실행하시면 됩니다.

## 1. 현재 완료된 작업
*   **프론트엔드 빌드 완료**: `VITE_API_BASE_URL`을 EC2 주소로 설정하여 `dist` 폴더를 새로 생성했습니다.
*   **백엔드 설정 변경**: EC2 내부 환경에 맞춰 `DB_HOST`를 `localhost`로 변경했습니다.

## 2. 파일 업로드 (Local -> EC2)
SSH 또는 SCP를 사용하여 다음 폴더들을 EC2로 업로드해 주세요.
*   `frontend/dist` 폴더 전체
*   `backend` 폴더 전체 (`node_modules` 제외 권장, EC2에서 직접 `npm install` 수행)

## 3. EC2 서버 설정 명령어

### (1) 필수 패키지 설치
EC2 터미널에서 다음을 실행합니다.
```bash
sudo apt update
sudo apt install nginx -y
sudo npm install -g pm2
```

### (2) 백엔드 실행 (PM2)
```bash
cd /path/to/backend
npm install
pm2 start server.js --name "board-api"
```

### (3) 프론트엔드 배포 (Nginx)
`dist` 폴더의 내용을 `/var/www/html`로 복사하거나 Nginx 설정을 변경합니다.
```bash
sudo cp -r /path/to/dist/* /var/www/html/
sudo systemctl restart nginx
```

## 4. 보안 그룹(Security Group) 최종 확인
*   **80 포트 (HTTP)**: 프론트엔드 접속용 (모든 IP 허용)
*   **8080 포트 (Custom TCP)**: 백엔드 API 통신용 (모든 IP 허용)

이제 공유하신 주소로 다른 사람들이 접속할 수 있습니다!
