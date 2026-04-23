import "./TodoItem.css";

function TodoItem({ todo, onUpdate, onDelete }) {
  const onChangeCheckbox = () => {
    onUpdate(todo.id);
  };

  const onClickDelete = () => {
    onDelete(todo.id);
  };

  return (
    <div className="todo-item">
      <input
        type="checkbox"
        checked={todo.isDone}
        onChange={onChangeCheckbox}
      />
      <span className={todo.isDone ? "done" : ""}>{todo.content}</span>
      <span className="date">
        {new Date(todo.createdDate).toLocaleDateString("ko-KR")}
      </span>
      <button onClick={onClickDelete}>삭제</button>
    </div>
  );
}

export default TodoItem;
