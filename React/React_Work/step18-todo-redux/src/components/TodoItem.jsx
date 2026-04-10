import "./TodoItem.css";
import { memo } from "react";
import { onDelete, onUpdate } from "../redux/crud";
import { useDispatch } from "react-redux";

function TodoItem({ id, isDone, content, date }) {
  let dispatch = useDispatch();

  console.log("TodoItem call");
  const onChangeCheckbox = () => {
    //수정하기(checkbox 상태변경)
    dispatch(onUpdate(id));
  };

  return (
    <div className="TodoItem">
      <input type="checkbox" checked={isDone} onChange={onChangeCheckbox} />
      <div className="content">{content}</div>
      <div className="date">{new Date(date).toLocaleString()}</div>
      <button onClick={() => dispatch(onDelete(id))}>삭제</button>
    </div>
  );
}

export default memo(TodoItem);
