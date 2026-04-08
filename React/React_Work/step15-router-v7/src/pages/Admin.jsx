import React from "react";
import { useSearchParams } from "react-router-dom";

function Admin() {
  const [params] = useSearchParams();
  return (
    <div>
      <h1>Admin 영역입니다.</h1>
      <h1>
        {params.get("name")} / {params.get("age")}
      </h1>
    </div>
  );
}

export default Admin;
