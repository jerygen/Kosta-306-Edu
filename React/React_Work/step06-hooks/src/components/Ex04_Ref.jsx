import React, { useEffect, useRef } from "react";

function Ex04_Ref() {
  console.log("Ex04_Ref 실행됨!");

  const inputRef = useRef();
  //console.log(inputRef); //{current: undefined}, 아직 input 태그가 안 만난 상태에서 출력하려고 하니 undefined라고 출력됨

  useEffect(() => {
    console.log(inputRef); //mount 된 후에 출력, {current: input}

    inputRef.current.focus(); //커서 놓기
  });

  //클릭 이벤트
  const clickCheck = () => {
    alert(`${inputRef.current.value}님 클릭했네요`);
    inputRef.current.value = "";
    inputRef.current.focus();
  };

  return (
    <>
      <h3>useRef로 Dom 접근하기</h3>
      <input type="text" ref={inputRef} />
      <button onClick={clickCheck}>클릭하세요</button>
    </>
  );
}

export default Ex04_Ref;
