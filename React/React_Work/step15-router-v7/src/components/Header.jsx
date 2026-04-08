import React from "react";
import { Link, useNavigate } from "react-router-dom";

function Header() {
  const nav = useNavigate();

  const btn1 = function () {
    //기능, 유효성체크(성공하면 페이지 전환, 아니면 메시지 출력)
    //이동
    nav("/"); //Home으로 이동
  };

  const btn2 = function () {
    nav("/user/50");
  };

  const btn3 = function () {
    nav("/admin");
  };

  return (
    <div style={{ border: "1px red solid" }}>
      <h1>Header 영역입니다.</h1>
      {/* 페이지에 가서 개발자도구로 보면 a 태그로 삽입됨 */}
      <Link to={"/"}>Home</Link> &nbsp;&nbsp;&nbsp;
      <Link to={"/User/kim"}>User</Link> &nbsp;&nbsp;&nbsp;
      <Link to={"/admin"}>Admin</Link> &nbsp;&nbsp;&nbsp;
      <hr />
      {/* a 태그는 새로고침됨 고로 a 태그는 사용 X*/}
      <a href="/">Home</a> &nbsp;&nbsp;&nbsp;
      <a href="/user/jang">User</a> &nbsp;&nbsp;&nbsp;
      <a href="/admin">Admin</a> &nbsp;&nbsp;&nbsp;
      <hr />
      <button onClick={btn1}>클릭1</button>
      <button onClick={btn2}>클릭2</button>
      <button onClick={btn3}>클릭3</button>
    </div>
  );
}

export default Header;
