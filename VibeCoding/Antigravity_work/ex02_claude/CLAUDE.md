# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 프로젝트 개요

게시판 CRUD 웹 애플리케이션 (VibeCoding ex02 실습)

- **Frontend**: React + Vite (포트 5173)
- **Backend**: Node.js + Express (포트 3001)
- **Database**: MySQL on AWS EC2 (host: 15.164.95.226, db: myDb)
- **HTTP Client**: Axios

## 개발 명령어

### Backend

```bash
cd backend
npm install
node app.js          # 서버 실행
npm run dev          # nodemon으로 실행 (핫리로드)
```

### Frontend

```bash
cd frontend
npm install
npm run dev          # Vite 개발 서버 (localhost:5173)
npm run build        # dist/ 프로덕션 빌드
```

## 환경 변수

### backend/.env

```
DB_HOST=15.164.95.226
DB_USER=root
DB_PASSWORD=1234
DB_NAME=myDb
PORT=3001
```

### frontend/.env

```
VITE_API_URL=http://localhost:3001
```

## 아키텍처

### 백엔드 레이어 구조

```
app.js → routes/boards.js → controllers/boardController.js → services/boardService.js → db/connection.js
```

- **routes**: URL 매핑만 담당, 비즈니스 로직 없음
- **controllers**: 요청/응답 처리, 입력 유효성 검사
- **services**: 실제 DB 쿼리 로직 (mysql2/promise 사용)
- **db/connection.js**: `mysql2/promise` 커넥션 풀, `.env`에서 설정 로드

### 프론트엔드 구조

- `src/api/boardApi.js`: 모든 백엔드 API 호출을 Axios로 중앙화. `VITE_API_URL` 기준으로 baseURL 설정
- `src/pages/`: 라우트별 페이지 컴포넌트
  - `BoardListPage`: 목록 조회 + 검색
  - `BoardDetailPage`: 상세 보기
  - `BoardFormPage`: 작성/수정 공용 (useParams의 `id` 유무로 분기)
- `src/components/`: 재사용 UI (`BoardCard`, `SearchBar`)

### API 엔드포인트

| Method | URL | 설명 |
|--------|-----|------|
| GET | /api/boards?search= | 목록 조회 (검색 포함) |
| GET | /api/boards/:id | 상세 조회 |
| POST | /api/boards | 글 작성 |
| PUT | /api/boards/:id | 글 수정 |
| DELETE | /api/boards/:id | 글 삭제 |

### DB 스키마

```sql
CREATE TABLE board (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  content TEXT,
  author VARCHAR(100),
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
```
