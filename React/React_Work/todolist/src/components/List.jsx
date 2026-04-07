import React from "react";
import "./List.css";
import { useState } from "react";
import TodoItem from "./TodoItem";
import { useMemo } from "react";
import { useContext } from "react";
import { TodoContext } from "../App";

function List() {
  const [search, setSearch] = useState("");
  const todos = useContext(TodoContext);

  const getFilterData = (search) => {
    if (search === "") return todos;

    return todos.filter((todo) =>
      todo.content.toLowerCase().includes(search.toLowerCase()),
    );
  };

  // const getAnalyzedData = () => {
  //   console.log("getAnalyzedData call");

  //   const totalCount = todos.length;
  //   const doneCount = todos.filter((todo) => todo.isDone).length;
  //   const notDoneCount = totalCount - doneCount;

  //   return { totalCount, doneCount, notDoneCount };
  // };

  const { totalCount, doneCount, notDoneCount } = useMemo(() => {
    console.log("getAnalyzedData call");

    const totalCount = todos.length;
    const doneCount = todos.filter((todo) => todo.isDone).length;
    const notDoneCount = totalCount - doneCount;

    return { totalCount, doneCount, notDoneCount };
  }, [todos]);

  return (
    <div className="List">
      <h4>Todo List🥝</h4>
      <div>
        <div>total: {totalCount}</div>
        <div>done: {doneCount}</div>
        <div>notDone: {notDoneCount}</div>
      </div>
      <input
        placeholder="검색어를 입력해주세요."
        value={search}
        onChange={(e) => {
          setSearch(e.target.value);
        }}
      />

      <div className="todos_wrapper">
        {getFilterData(search).map((todo) => {
          return <TodoItem key={todo.id} {...todo} />;
        })}
      </div>
    </div>
  );
}

export default List;
