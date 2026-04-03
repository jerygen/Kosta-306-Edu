import "./App.css";
import A, { Ex01_Export2, num } from "./components/Ex01_Export";
import Ex02_Library from "./components/Ex02_Library";
import Ex03_ButtonTest from "./components/Ex03_ButtonTest";

//컴포넌트 작성
function Header() {
  //선언적
  return (
    <>
      <h3>여기는 Header 영역입니다. : {num}</h3>
    </>
  );
}

const Footer = function () {
  //함수 표현식
  return (
    <>
      <h3>여기는 footer 입니다.</h3>
    </>
  );
};

/////////////////////////////
function App() {
  return (
    <>
      <h1>Component 실습하기</h1>
      {/* <Header />
      <Footer /> */}

      {/* 외부의 ~.jsx 컴포넌트 사용하기 */}
      {/* <A /> */}
      {/* default인 컴포넌트는 별칭을 사용할 수 있다. */}
      {/* <Ex01_Export2 /> */}

      {/* 2. Library 연습하기 */}
      {/* <Ex02_Library /> */}

      {/* 3. button 연습 - img 처리 */}
      <Ex03_ButtonTest />
    </>
  );
}

export default App;
