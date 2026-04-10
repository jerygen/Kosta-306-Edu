import React, { useEffect, useRef } from "react";
import { useState } from "react";
import "./Editor.css";
import { useDispatch } from "react-redux";
import { onCreate } from "../redux/crud";

function Editor() {
  console.log("editor call");

  let dispatch = useDispatch();

  //함수가 전달
  const [content, setContent] = useState("");
  const contentRef = useRef(); //DOM 요소 접근

  //마운트 되었을 때 커서놓기
  useEffect(() => {
    contentRef.current.focus(); //커서놓기
  }, []); //[] -> 최초의 딱 한 번만 해라

  const onSubmit = () => {
    if (content === "") {
      contentRef.current.focus(); //커서놓기, 부모쪽으로 가지 않음
      return;
    }

    // onCreate(content); //부모쪽 함수 호출!!! (입력한 내용을 전달한다.)
    dispatch(onCreate(content));
    setContent(""); //내용비우기
    contentRef.current.focus();
  }; //onSubmitEnd

  //키보드에 enter를 했을때 onSubmit을  호출해주기위한 이벤트 함수
  const onKeyDownEnter = (e) => {
    console.log(e.keyCode);

    if (e.keyCode === 13) onSubmit();
  };

  return (
    <div className="Editor">
      <input
        type="text"
        placeholder="새로운 todo"
        value={content}
        onChange={(e) => setContent(e.target.value)}
        ref={contentRef}
        onKeyDown={onKeyDownEnter}
      />
      <button onClick={onSubmit}>추가</button>
    </div>
  );
}

export default Editor;
