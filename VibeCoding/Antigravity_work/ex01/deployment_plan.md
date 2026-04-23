# EC2 배포 및 공유 계획

현재 로컬에서 동작하는 프로젝트를 EC2 서버로 배포하여 외부에서 접속 가능하도록 설정하는 계획입니다.

## User Review Required

> [!IMPORTANT]
> - **프론트엔드 재빌드**: 현재 생성된 `dist` 폴더가 `localhost`를 바라보고 있다면 외부에서 접속 시 에러가 발생합니다. EC2 주소를 바라보도록 환경 변수를 수정하고 다시 빌드해야 합니다.
> - **EC2 접속 권한**: EC2에 파일을 업로드하고 명령어를 실행할 수 있는 SSH 접근 권한(또는 배포 방식)이 준비되어 있어야 합니다.
> - **포트 개방**: EC2 보안 그룹에서 **80 포트(HTTP)**와 **8080 포트(API)**가 열려 있어야 합니다.

## Proposed Changes

### 1. 프론트엔드 환경 변수 수정 및 재빌드
- **파일:** `frontend/.env`
- **내용:** `VITE_API_BASE_URL`을 EC2 퍼블릭 DNS 주소로 수정
  ```env
  VITE_API_BASE_URL=http://ec2-15-164-95-226.ap-northeast-2.compute.amazonaws.com:8080/api/posts
  ```
- **작업:** `npm run build` 실행하여 새로운 `dist` 생성

---

### 2. 백엔드 배포 준비
- **파일:** `backend/.env`
- **내용:** EC2 내부에서 실행될 때 DB 호스트를 `localhost`로 설정 (DB가 같은 EC2에 있는 경우)
  ```env
  DB_HOST=localhost
  DB_USER=root
  DB_PASSWORD=1234
  DB_NAME=myDb
  PORT=8080
  ```

---

### 3. EC2 서버 설정 (명세 및 가이드)
- **Nginx 설치 및 설정**:
  - `dist` 폴더의 정적 파일 서비스
  - 80번 포트로 들어오는 요청을 처리
- **PM2 설치 및 실행**:
  - 백엔드 서버(`server.js`)를 무중단으로 실행하기 위해 `pm2` 사용
  - `pm2 start server.js --name "my-backend"`

## Verification Plan

### Automated Tests
- `curl http://ec2-15-164-95-226.ap-northeast-2.compute.amazonaws.com` 명령어로 메인 페이지 로드 확인
- `curl http://ec2-15-164-95-226.ap-northeast-2.compute.amazonaws.com:8080/api/posts` 명령어로 API 응답 확인

### Manual Verification
- 외부 브라우저에서 EC2 주소로 접속하여 게시판 목록이 정상적으로 출력되는지 확인
- 글쓰기, 수정, 삭제 기능이 정상 동작하는지 테스트
