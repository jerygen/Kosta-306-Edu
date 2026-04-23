import { useState } from "react";
import "./Editor.css";

function Editor({ onCreate }) {
  const [content, setContent] = useState("");

  const onSubmit = () => {
    if (content.trim() === "") {
      alert("내용을 입력하세요.");
      return;
    }
    onCreate(content);
    setContent("");
  };

  const onKeyDown = (e) => {
    if (e.key === "Enter") {
      onSubmit();
    }
  };

  return (
    <div className="editor">
      <input
        type="text"
        placeholder="새로운 할 일을 입력하세요"
        value={content}
        onChange={(e) => setContent(e.target.value)}
        onKeyDown={onKeyDown}
      />
      <button onClick={onSubmit}>추가</button>
    </div>
  );
}

export default Editor;
