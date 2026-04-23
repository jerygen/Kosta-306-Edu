import { useState } from "react";
import Header from "./components/Header";
import Editor from "./components/Editor";
import List from "./components/List";
import "./App.css";

const mockData = [
  {
    id: 0,
    content: "React 공부하기",
    isDone: false,
    createdDate: new Date().getTime(),
  },
  {
    id: 1,
    content: "빨래하기",
    isDone: false,
    createdDate: new Date().getTime(),
  },
  {
    id: 2,
    content: "노래 연습하기",
    isDone: true,
    createdDate: new Date().getTime(),
  },
];

function App() {
  const [todos, setTodos] = useState(mockData);

  const onCreate = (content) => {
    const newTodo = {
      id: todos.length > 0 ? Math.max(...todos.map((todo) => todo.id)) + 1 : 0,
      content,
      isDone: false,
      createdDate: new Date().getTime(),
    };
    setTodos([newTodo, ...todos]);
  };

  const onUpdate = (targetId) => {
    setTodos(
      todos.map((todo) =>
        todo.id === targetId ? { ...todo, isDone: !todo.isDone } : todo,
      ),
    );
  };

  const onDelete = (targetId) => {
    setTodos(todos.filter((todo) => todo.id !== targetId));
  };

  return (
    <div className="app">
      <Header />
      <Editor onCreate={onCreate} />
      <List todos={todos} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}

export default App;
