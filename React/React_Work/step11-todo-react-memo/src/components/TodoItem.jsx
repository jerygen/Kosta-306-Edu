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

export default memo(TodoItem, (prevProps, nextProps) => {
  //리턴값에 props가 바뀌었는지 안 바뀌었는지 판단한다.
  //true -> Props가 바뀌지 않음(리랜더링안됨)
  //false -> Props 바뀜(리랜더링됨)
  if (prevProps.id !== nextProps.id) return false;
  if (prevProps.isDone !== nextProps.isDone) return false;
  if (prevProps.content !== nextProps.content) return false;
  if (prevProps.date !== nextProps.date) return false;

  return true; //리랜더링안됨.
});
