import React from "react";
import Ex02_Book from "./Ex02_Book";

//자바스크립트에서는 호이스팅 때문에 선언적 함수를 잘 사용하지 않았지만
//react에서는 선언적 함수가 함수다라는 것이 명확하고 빠르게 인식 가능하기 때문에
//서버 사이드에 있는 node.js에서 다 실행해서 자바스크립트로 던져주기 때문에 호이스팅을 걱정할 필요가 없다.
//rfce
function Ex02_Library() {
  const author = { pName: "hee", age: 30, addr: "서울" };
  return (
    <>
      <Ex02_Book name="SpringBoot" page={300} author={author} />
      <Ex02_Book
        name="JPA"
        page={200}
        author={{ pName: "king", age: 20, addr: "용인" }}
      />
      <Ex02_Book page={350} author={author} />
    </>
  );
}
export default Ex02_Library;
