import React from "react";
import TodoItem from "./TodoItem";
import "./List.css";
import { useState } from "react";
import { useMemo } from "react";

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

  // 검색할 때마다 이부분도 계속 리렌더링 된다. 의도치 않는 렌더링 발생 -> useMemo로 해결
  // const getAnalyedData = () => {
  //   console.log("getAnalyedData call");

  //   const totalCount = todos.length;
  //   const doneCount = todos.filter((todo) => todo.isDone).length;
  //   const notDoneCount = totalCount - doneCount;

  //   return { totalCount, doneCount, notDoneCount };
  // };

  // const { totalCount, doneCount, notDoneCount } = getAnalyedData();

  //useMemo를 사용해서 count들이 변하지 않을 때는 아래값들이 다시 렌더링되지 않도록 한다.
  const { totalCount, doneCount, notDoneCount } = useMemo(() => {
    console.log("useMemo call");

    const totalCount = todos.length;
    const doneCount = todos.filter((todo) => todo.isDone).length;
    const notDoneCount = totalCount - doneCount;

    return { totalCount, doneCount, notDoneCount };
  }, [todos]);

  return (
    <div className="List">
      <h4>Todo List 🌱</h4>
      <div>
        <div>totoalCount: {totalCount}</div>
        <div>doneCount: {doneCount}</div>
        <div>notDoneCount: {notDoneCount}</div>
      </div>
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
