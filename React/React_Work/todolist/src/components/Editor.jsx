import React from "react";
import { useState } from "react";
import "./Editor.css";
import { useRef } from "react";
import { useContext } from "react";
import { TodoDispatchContext } from "../App";

function Editor() {
  const { onCreate } = useContext(TodoDispatchContext);
  const [content, setContent] = useState("");
  const contentRef = useRef(); //input Dom 요소에 접근하기 위한 Ref

  //추가 버튼 클릭
  const onSubmit = () => {
    if (content === "") {
      contentRef.current.focus();
      return;
    }

    onCreate(content);
    setContent("");
  };

  //엔터 입력했을 때 onsubmit 호출
  const onkeydown = (e) => {
    if (e.keyCode === 13) {
      onSubmit();
    }
  };

  return (
    <div className="Editor">
      <input
        type="text"
        placeholder="새로운 todo"
        value={content}
        onChange={(e) => {
          setContent(e.target.value);
        }}
        ref={contentRef}
        onKeyDown={onkeydown}
      />
      <button onClick={onSubmit}>추가</button>
    </div>
  );
}

export default Editor;
