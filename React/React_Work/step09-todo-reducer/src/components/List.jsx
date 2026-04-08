import React from "react";
import TodoItem from "./TodoItem";
import "./List.css";
import { useState } from "react";

function List({ todos, onUpdate, onDelete }) {
  console.log("list call");
  console.log(todos);
  const [search, setSearch] = useState("");

  //검색어에 해당하는 todo정보 또는 모든 todo를 리턴하는 함수 작성
  const getFilterData = () => {
    if (search === "") return todos;
    else
      return todos.filter((todo) =>
        todo.content.toLowerCase().includes(search.toLowerCase()),
      );
  };

  const filterTodos = getFilterData();

  return (
    <div className="List">
      <h4>Todo List 🌱</h4>
      <input
        placeholder="검색어를 입력해주세요."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />

      <div className="todos_wrapper">
        {
          //todos.map((todo)=><TodoItem key={todo.id} {...todo} />)
          filterTodos.map((todo) => (
            <TodoItem
              key={todo.id}
              {...todo}
              onDelete={onDelete} //props drilling
              onUpdate={onUpdate}
            />
          ))
        }
      </div>
    </div>
  );
}

export default List;
