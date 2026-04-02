import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "./assets/vite.svg";
import heroImg from "./assets/hero.png";
import "./App.css";

function App() {
  //컴포넌트 함수는 대문자로 시작
  const [count, setCount] = useState(0);

  return (
    <>
      <h1>React 시작하기 안녕하세요</h1>
    </>
  );
}

export default App;
