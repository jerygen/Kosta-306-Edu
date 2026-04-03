import React from "react";
import { useState } from "react";

function Ex04_ConditionRendering() {
  const [isLogin, setIsLogin] = useState(false);
  return (
    <div>
      <h3>ConditionRendering Test</h3>
      <button
        onClick={() => {
          setIsLogin(!isLogin);
        }}
      >
        {isLogin ? "Logout" : "Login"}
      </button>
    </div>
  );
}

export default Ex04_ConditionRendering;
