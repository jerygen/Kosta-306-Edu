import { useState } from "react";
import TodoItem from "./TodoItem";
import "./List.css";

function List({ todos, onUpdate, onDelete }) {
  const [search, setSearch] = useState("");

  const filteredTodos = todos.filter((todo) =>
    todo.content.toLowerCase().includes(search.toLowerCase()),
  );

  const totalCount = todos.length;
  const doneCount = todos.filter((todo) => todo.isDone).length;

  return (
    <div className="list">
      <h2>Todo List</h2>
      <div className="search">
        <input
          type="text"
          placeholder="검색어를 입력하세요"
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />
      </div>
      <div className="stats">
        <p>
          전체: {totalCount} | 완료: {doneCount}
        </p>
      </div>
      <div className="todo-list">
        {filteredTodos.map((todo) => (
          <TodoItem
            key={todo.id}
            todo={todo}
            onUpdate={onUpdate}
            onDelete={onDelete}
          />
        ))}
      </div>
    </div>
  );
}

export default List;
