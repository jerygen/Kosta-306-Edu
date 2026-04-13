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
    contentRef.current.focus();
  }, []); //[] -> 최초의 딱 한 번만 해라

  const onSubmit = () => {
    if (content === "") {
      contentRef.current.focus();
      return;
    }

    dispatch(onCreate(content));
    setContent("");
    contentRef.current.focus();
  }; //onSubmitEnd

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
