import React from "react";
import "./TodoItem.css";
import { memo } from "react";

function TodoItem({ id, isDone, content, date, onDelete, onUpdate }) {
  console.log("TodoItem call");
  const onChangeCheckbox = () => {
    //수정하기(checkbox 상태변경)
    onUpdate(id);
  };

  return (
    <div className="TodoItem">
      <input type="checkbox" checked={isDone} onChange={onChangeCheckbox} />
      <div className="content">{content}</div>
      <div className="date">{new Date(date).toLocaleString()}</div>
      <button onClick={() => onDelete(id)}>삭제</button>
    </div>
  );
}

//export default memo(TodoItem);
//TodoItem으로 전달되는 인자값들이 다 변하지 않아야 하는데
//React.memo()는 props를 얕은 비교를 하기 때문에서
//함수, 배열, 객체가 props로 <--- 중요 포인트
//전달되면 항상 새로운 주소로 전달되어 최적화가 되지 않는다
//onUpdate, onDelete가 계속 새로운 주소로 전달되는 것
//App 컴포넌트가 새로 생성될 때마다 그 안에 있는 onCreate, onUpdate, onDelete 변수들이
// 새로 생성되기 때문에 리렌더링이 됐던 것

export default memo(TodoItem);
//useCallback 사용해서 함수들이 변경되지 않도록 하므로 memo만으로 가능해진다.
