import { useReducer, useRef } from "react";
import "./App.css";
import Editor from "./components/Editor";
import Header from "./components/Header";
import List from "./components/List";
import { useCallback } from "react";
import { createContext } from "react";

export const TodoContext = createContext();

//랜더링이 될때 다시 실행되지 않아도 되기에 함수 밖에 선언한다.
const mockData = [
  { id: 0, isDone: false, content: "React study", date: new Date().getTime() },
  { id: 1, isDone: false, content: "친구만나기", date: new Date().getTime() },
  { id: 2, isDone: false, content: "낮잠자기", date: new Date().getTime() },
];

const reducer = (state, action) => {
  switch (action.type) {
    case "CREATE":
      return [action.data, ...state];
    case "UPDATE":
      return state.map((todo) =>
        todo.id === action.targetId ? { ...todo, isDone: !todo.isDone } : todo,
      );
    case "DELETE":
      return state.filter((todo) => todo.id !== action.targetId);
    default:
      return state;
  }
};

function App() {
  console.log("App Loading");
  const [todos, dispatch] = useReducer(reducer, mockData);
  const idRef = useRef(3); //상태관리

  //등록하기
  const onCreate = useCallback((content) => {
    dispatch({
      type: "CREATE",
      data: {
        id: idRef.current++,
        isDone: false,
        content: content,
        date: new Date().getTime(),
      },
    });
  }, []);

  //수정하기
  const onUpdate = useCallback((targetId) => {
    dispatch({
      type: "UPDATE",
      targetId: targetId,
    });
  }, []);

  //삭제하기
  const onDelete = useCallback((targetId) => {
    dispatch({
      type: "DELETE",
      targetId,
    });
  }, []);

  return (
    <div className="App">
      <Header />
      {/* 결국 props로 값을 전달하는 것과 같아짐 */}
      {/* 해결: 변경되지 말아야하는 부분을 별도의 context로 분리 */}
      <TodoContext value={{ todos, onCreate, onUpdate, onDelete }}>
        <Editor />
        <List />
      </TodoContext>
    </div>
  );
}

export default App;
