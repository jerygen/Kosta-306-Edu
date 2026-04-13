import TodoItem from "./TodoItem";
import "./List.css";
import { useState } from "react";
import { useMemo } from "react";
import { shallowEqual, useSelector } from "react-redux";

function List() {
  let todos = useSelector((state) => state.todoCRUD.mockData, shallowEqual);
  const [search, setSearch] = useState("");

  const getFilterData = () => {
    if (search === "") return todos;
    else
      return todos.filter((todo) =>
        todo.content.toLowerCase().includes(search.toLowerCase()),
      );
  };

  const filterTodos = getFilterData();

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
        {filterTodos.map((todo) => (
          <TodoItem key={todo.id} {...todo} />
        ))}
      </div>
    </div>
  );
}

export default List;
