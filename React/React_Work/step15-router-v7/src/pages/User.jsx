import React from "react";
import { useParams } from "react-router-dom";

function User() {
  const params = useParams();
  console.log(params.id);

  //queryString 사용

  return (
    <div>
      <h1>User: {params.id} 영역입니다.</h1>
    </div>
  );
}

export default User;
