import React from "react";
import Trip from "./Trip";

function Article({ title, body }) {
  return (
    <>
      <h1>{title}</h1>
      <p>이번 여름에 바다가 있는 테마 여행을 시작합니다.</p>
      <p>{body}</p>
      <Trip />
    </>
  );
}

export default Article;
