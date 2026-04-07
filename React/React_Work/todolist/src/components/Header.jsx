import React from "react";
import "./Header.css";
import { memo } from "react";

function Header() {
  return (
    <div className="Header">
      <h3>오늘의 Plan✨</h3>
      <h1>{new Date().toLocaleString()}</h1>
    </div>
  );
}

export default memo(Header);
