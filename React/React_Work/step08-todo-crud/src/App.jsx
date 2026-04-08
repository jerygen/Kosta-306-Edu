import { useRef, useState } from "react";
import "./App.css";
import Editor from "./components/Editor";
import Header from "./components/Header";
import List from "./components/List";

//랜더링이 될때 다시 실행되지 않아도 되기에 함수 밖에 선언한다.
const mockData = [
  { id: 0, isDone: false, content: "React study", date: new Date().getTime() },
  { id: 1, isDone: false, content: "친구만나기", date: new Date().getTime() },
  { id: 2, isDone: false, content: "낮잠자기", date: new Date().getTime() },
];

function App() {
  console.log("App Loading");
  const [todos, setTodos] = useState(mockData);
  const idRef = useRef(3); //상태관리

  //등록하기
  const onCreate = (content) => {
    //console.log(content);
    const newTodo = {
      id: idRef.current++,
      isDone: false,
      content: content,
      date: new Date().getTime(),
    };
    //등록
    setTodos([newTodo, ...todos]);
  };
  //수정하기
  const onUpdate = (targetId) => {
    setTodos(
      todos.map((todo) =>
        todo.id === targetId ? { ...todo, isDone: !todo.isDone } : todo,
      ),
    );
  };

  //삭제하기
  const onDelete = (targetId) => {
    setTodos(todos.filter((todo) => todo.id !== targetId));
  };

  return (
    <div className="App">
      <Header />
      <Editor onCreate={onCreate} />
      <List todos={todos} onUpdate={onUpdate} onDelete={onDelete} />

      {/* <List {...todos} onUpdate={onUpdate} onDelete={onDelete}/> */}

      {/* <List obj={{todos:todos,onUpdate:onUpdate,onDelete:onDelete}}/> */}
    </div>
  );
}

export default App;
