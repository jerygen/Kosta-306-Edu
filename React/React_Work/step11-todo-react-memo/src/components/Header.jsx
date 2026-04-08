import React, { memo } from "react";
import "./Header.css";

function Header() {
  console.log("Header loading");
  return (
    <div className="Header">
      <h3>오늘의 Plan🌼</h3>
      <h1>{new Date().toDateString()}</h1>
    </div>
  );
}

export default memo(Header);
