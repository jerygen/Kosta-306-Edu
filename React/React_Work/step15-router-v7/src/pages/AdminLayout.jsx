import React from "react";
import { Outlet } from "react-router-dom";

function AdminLayout() {
  return (
    <div style={{ backgroundColor: "skyblue" }}>
      <h2>관리자 공통 영역입니다.</h2>
      <Outlet />
    </div>
  );
}

export default AdminLayout;
