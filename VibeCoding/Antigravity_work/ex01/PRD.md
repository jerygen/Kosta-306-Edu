# 게시판 프로젝트 PRD (Product Requirements Document)

## 1. 프로젝트 개요
React와 Vite를 프론트엔드로 사용하고, 원격(EC2) MySQL 데이터베이스와 REST API를 통해 통신하는 간단한 게시판(Bulletin Board) 애플리케이션입니다. Vibe Coding 방식으로 빠르고 효율적으로 프론트엔드를 개발하는 것을 목표로 합니다.

## 2. 주요 기능
게시판의 기본 CRUD 기능을 포함합니다.
- **전체검색 (목록 조회):** 모든 게시글의 목록(글번호, 제목, 작성자, 작성일)을 조회합니다.
- **글번호 검색 (상세 조회):** 특정 글번호를 선택하여 제목, 내용, 작성자, 작성일을 상세 조회합니다.
- **등록 (글 작성):** 새로운 게시글(제목, 내용, 작성자)을 작성하여 등록합니다.
- **수정 (글 수정):** 기존 게시글의 제목과 내용을 수정합니다.
- **삭제 (글 삭제):** 특정 게시글을 삭제합니다.

## 3. 기술 스택
- **Frontend:** React, Vite, Axios, React Router (SPA 라우팅용)
- **Backend (API 서버):** REST API (이 문서에서는 이미 구축되었거나 별도 구축된다고 가정합니다.)
- **Database:** MySQL (AWS EC2 환경에 호스팅)
- **Data Format:** JSON 통신
- **Environment Configuration:** `.env` 파일을 활용한 환경 변수 관리

## 4. 데이터베이스 스키마
테이블명: `board`
| 컬럼명 | 데이터 타입 | 제약 조건 | 설명 |
|---|---|---|---|
| id | INT | PK, Auto Increment | 글 번호 |
| title | VARCHAR(255) | NOT NULL | 글 제목 |
| content | TEXT | NOT NULL | 글 내용 |
| author | VARCHAR(100) | NOT NULL | 작성자 |
| created_at | DATETIME | DEFAULT CURRENT_TIMESTAMP | 작성일시 |

## 5. API 명세 (REST API Endpoint)
**Base URL 설정:** 
`.env` 파일에 `VITE_API_BASE_URL` 환경 변수로 서버 주소를 설정합니다. (예: `VITE_API_BASE_URL=http://<EC2-IP>:<PORT>/api/posts`)

**Axios 인스턴스 구성:**
`axios.create()` 메서드를 사용하여 기본 URL(`baseURL: import.meta.env.VITE_API_BASE_URL`)이 설정된 전용 Axios 객체를 생성하고, 이를 모든 API 요청에 재사용합니다.

| 기능 | Method | Endpoint | Request Body (JSON) | Response (JSON) |
|---|---|---|---|---|
| 전체 목록 | GET | `/` | - | `[{id, title, author, created_at}, ...]` |
| 상세 조회 | GET | `/{id}` | - | `{id, title, content, author, created_at}` |
| 글 등록 | POST | `/` | `{title, content, author}` | `{id, title, content, author, created_at}` |
| 글 수정 | PUT | `/{id}` | `{title, content}` | `{id, title, content, author, created_at}` |
| 글 삭제 | DELETE | `/{id}` | - | 성공 상태 코드 (200/204) |

## 6. 사용자 인터페이스 (UI) 화면 구성
1. **게시글 목록 화면 (`/`)**
   - 게시글 목록(테이블 형태) 노출
   - 최상단 '새 글 작성' 버튼
   - 각 게시글(행) 클릭 시 상세 화면으로 이동
2. **게시글 상세 화면 (`/post/{id}`)**
   - 글 제목, 작성자, 작성일, 본문 내용 표시
   - 하단 '목록으로', '수정', '삭제' 버튼
3. **게시글 작성/수정 화면 (`/write`, `/edit/{id}`)**
   - 제목, 작성자(수정 시에는 읽기 전용), 내용 입력 폼
   - 하단 '저장', '취소' 버튼
