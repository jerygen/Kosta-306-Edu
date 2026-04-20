# 게시판 프로젝트 구현 계획

PRD와 가이드라인 문서에 기반하여 React + Vite 프론트엔드 프로젝트를 구축하기 위한 구현 계획입니다.

## User Review Required

> [!IMPORTANT]
> - 프로젝트 초기화를 위해 `ex01` 폴더 내에 `frontend`라는 하위 폴더를 생성하고 거기에 React 프로젝트를 세팅하려고 합니다. 기존 `ex01` 폴더에 바로 생성하면 기존 마크다운 파일과 충돌이 발생할 수 있기 때문입니다. 괜찮으신가요?
> - 현재 백엔드 API가 실제로 배포되어 동작하는 상태인지, 아니면 프론트엔드 코드 내에서 Mocking(가짜 데이터) 처리를 먼저 해야 하는지 알려주시면 맞춰서 작업하겠습니다. (기본적으로는 `.env`에 설정된 URL로 API 호출 코드를 작성하겠습니다.)

## Proposed Changes

---

### 1. 프로젝트 초기화 및 환경 설정
- **위치:** `ex01/frontend`
- **작업 내용:**
  - `npx create-vite@latest frontend --template react` 명령어로 프로젝트 생성
  - 라우팅 및 API 통신을 위한 패키지 설치: `npm install react-router-dom axios`
  - `.env` 파일 생성 및 `VITE_API_BASE_URL=http://localhost:8080/api/posts` (임시) 설정

---

### 2. API 연동 모듈 (Axios Configuration)
#### [NEW] `src/api/boardApi.js`
- `axios.create()`를 사용하여 `baseURL`을 `import.meta.env.VITE_API_BASE_URL`로 설정한 axios 인스턴스 생성
- 게시글 전체 조회(`getPosts`), 상세 조회(`getPost`), 생성(`createPost`), 수정(`updatePost`), 삭제(`deletePost`) 함수 구현

---

### 3. 라우팅 및 기본 컴포넌트 틀 구성
#### [MODIFY] `src/main.jsx` & `src/App.jsx`
- `BrowserRouter`, `Routes`, `Route`를 사용하여 페이지 라우팅 설정
  - `/`: 게시글 목록 (`BoardList`)
  - `/post/:id`: 게시글 상세 (`BoardDetail`)
  - `/write`: 게시글 등록 (`BoardForm`)
  - `/edit/:id`: 게시글 수정 (`BoardForm` 재사용)

---

### 4. 페이지 컴포넌트 구현 (UI/UX 포함)
#### [NEW] `src/pages/BoardList.jsx`
- 전체 검색 API 호출 및 테이블 형태의 목록 렌더링
- '새 글 작성' 버튼 및 각 행 클릭 시 상세 페이지 이동 로직
- 모던하고 깔끔한 데이터 테이블 디자인 적용

#### [NEW] `src/pages/BoardDetail.jsx`
- 특정 글번호(`id`) 검색 API 호출 및 내용 렌더링
- 하단에 '목록으로', '수정', '삭제' 버튼 제공
- 삭제 시 `DELETE` API 호출 및 완료 후 목록으로 이동

#### [NEW] `src/pages/BoardForm.jsx`
- 등록 및 수정 모드에 따른 분기 처리 (수정 시에는 기존 데이터 fetch 및 작성자 읽기 전용 처리)
- 폼 유효성 검사 및 저장 버튼 클릭 시 API (`POST` 또는 `PUT`) 호출

---

### 5. 전역 스타일링 (Premium Design)
#### [MODIFY] `src/index.css`
- TailwindCSS 없이 Vanilla CSS를 활용하여 최상의 사용자 경험 제공
- CSS Variables를 활용한 일관된 컬러 팔레트 (모던 화이트/그레이/블루 톤)
- 호버(Hover) 효과, 부드러운 트랜지션 애니메이션, 그림자 효과(Glassmorphism 등) 적용
- 깔끔한 타이포그래피(Inter, Roboto 등) 적용

## Verification Plan

### Automated Tests
- `npm run dev`를 실행하여 로컬 개발 서버를 띄운 뒤, 콘솔 에러가 없는지 확인합니다.
- API 호출 코드가 정상적으로 Axios 인스턴스를 사용하는지 확인합니다.

### Manual Verification
- 라우팅이 의도대로 동작하여 화면 전환이 원활한지 확인합니다.
- API 엔드포인트가 정상적으로 호출되는지 브라우저 개발자 도구의 Network 탭을 통해 확인합니다. (현재는 백엔드가 없다면 Network 에러가 나는 것이 정상입니다.)


# 백엔드(Express) 프로젝트 구현 계획

프론트엔드(React)에서 데이터를 요청하고, 원격 EC2의 MySQL 데이터베이스와 통신할 수 있는 Express 백엔드 애플리케이션을 구축합니다.

## User Review Required

> [!IMPORTANT]
> - 백엔드 프로젝트는 프론트엔드와 분리하기 위해 `ex01` 폴더 내에 `backend`라는 새로운 폴더를 생성하여 세팅할 예정입니다.
> - 백엔드의 로컬 포트는 프론트엔드의 기본 환경 변수 설정(`http://localhost:8080/api/posts`)에 맞추어 **8080 포트**로 설정하겠습니다.
> - EC2 데이터베이스 접속 정보는 실제 보안 정보 대신 샘플 더미 정보로 `.env` 파일에 작성하겠습니다. 추후 실제 정보로 직접 수정해 주셔야 합니다.

## Proposed Changes

---

### 1. 백엔드 프로젝트 초기화
- **위치:** `ex01/backend`
- **작업 내용:**
  - `npm init -y`로 Node.js 프로젝트 생성
  - 필수 패키지 설치: `express`, `cors`, `dotenv`, `mysql2`

---

### 2. 데이터베이스 연동 및 환경 변수 설정
#### [NEW] `backend/.env`
- EC2 환경의 MySQL(도커) 접속을 위한 샘플 환경 변수 설정
  ```env
  DB_HOST=ec2-198-51-100-1.ap-northeast-2.compute.amazonaws.com # 샘플 IP
  DB_USER=root
  DB_PASSWORD=your_password
  DB_NAME=myDb
  PORT=8080
  ```

#### [NEW] `backend/src/config/db.js`
- `mysql2/promise`를 사용하여 커넥션 풀(Connection Pool) 설정 코드 작성

---

### 3. API 라우터 및 로직 구현
#### [NEW] `backend/src/routes/boardRoutes.js`
- PRD 명세에 따른 CRUD 라우트와 실제 MySQL 쿼리 로직 구현
  - `GET /`: `SELECT * FROM board ORDER BY id DESC`
  - `GET /:id`: `SELECT * FROM board WHERE id = ?`
  - `POST /`: `INSERT INTO board (title, content, author) VALUES (?, ?, ?)`
  - `PUT /:id`: `UPDATE board SET title = ?, content = ? WHERE id = ?`
  - `DELETE /:id`: `DELETE FROM board WHERE id = ?`

---

### 4. 메인 서버 파일 구성
#### [NEW] `backend/server.js`
- Express 앱 생성 및 `cors`, `express.json()` 미들웨어 등록
- `/api/posts` 경로로 `boardRoutes.js` 라우터 연결
- 포트 8080번으로 서버 실행 리스너 등록

## Verification Plan

### Automated Tests
- 백엔드 폴더에서 `node server.js` 명령어로 서버를 띄워 포트 충돌 여부 및 에러를 확인합니다.

### Manual Verification
- 프론트엔드(`npm run dev`)와 백엔드(`node server.js`)를 동시에 띄운 상태에서 프론트엔드 화면에서 글 작성을 시도합니다.
- (현재 EC2의 접속 정보가 샘플이므로 실제 DB에 연결되지 않아 DB 커넥션 에러가 발생할 것입니다. 이는 정상이며, 나중에 `.env`에 실제 EC2 DB 정보를 입력하시면 정상 동작하게 됩니다.)
