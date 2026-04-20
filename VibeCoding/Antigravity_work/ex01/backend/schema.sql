-- 1. 데이터베이스 생성 및 선택 (이미 있다면 생략 가능)
CREATE DATABASE IF NOT EXISTS myDb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE myDb;

-- 2. 기존 테이블이 있다면 삭제 (초기화 목적, 원치 않으시면 주석 처리하세요)
DROP TABLE IF EXISTS board;

-- 3. 테이블 생성
CREATE TABLE board (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author VARCHAR(100) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 4. 예시 데이터 (레코드 3개) 삽입
INSERT INTO board (title, content, author) VALUES 
('Welcome to the Board', 'This is the first example post for our board project. Nice to meet you!', 'Admin'),
('Vibe Coding with Antigravity', 'Building applications with Antigravity is fast and efficient. The full stack is ready.', 'Developer'),
('Project Status Update', 'Successfully connected Express backend with React frontend and EC2 MySQL database.', 'User1');
