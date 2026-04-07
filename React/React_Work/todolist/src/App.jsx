import "./App.css";
import Header from "./components/Header";
import Editor from "./components/Editor";
import List from "./components/List";
import { useRef } from "react";
import { useReducer } from "react";
import { useCallback } from "react";
import { createContext } from "react";
import { useMemo } from "react";

//렌더링 될 때 다시 실행되지 않아도 되기에 함수 밖에서 선언
const mockData = [
  { id: 0, isDone: false, content: "React Study", date: new Date().getTime() },
  { id: 1, isDone: false, content: "친구 만나기", date: new Date().getTime() },
  { id: 2, isDone: false, content: "낮잠자기", date: new Date().getTime() },
];
/*
 * onCreate, onDelete, onUpdate함수를 useCallback을 이용해서 만들어보자.
 * 함수를 자식 컴포넌트에 props로 전달 할 때 마다 props가 변경되면 리랜더링 되는것을 막기 위함.
 * 즉, useCallback을 통해서 정의된 함수는 메모이제이션을 해서 매번 새로운 함수를 만들지 않고
 * 기존의 함수를 그대로 전달 함으로써 props변경으로 인한 리랜더링을 막는다.
 */

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

export const TodoContext = createContext();
export const TodoDispatchContext = createContext();

function App() {
  //const [todos, setTodos] = useState(mockData);
  const [todos, dispatch] = useReducer(reducer, mockData);
  const idRef = useRef(3);

  //추가하기
  const onCreate = useCallback((content) => {
    // const newTodo = {
    //   id: idRef.current++,
    //   isDone: false,
    //   content: content,
    //   date: new Date().getTime(),
    // };
    // setTodos([newTodo, ...todos]);

    console.log("onCreate content = " + content);
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
    //TodoItem에서 호출할 때 전달한 id
    //todo state의 값들 중에 targetId와 일치하는 todoitem의 isDone 변경
    // const updateTodos = todos.map((todo) => {
    //   return todo.id == targetId ? { ...todo, isDone: !todo.isDone } : todo;
    // });
    // setTodos(updateTodos);

    console.log("onUpdate targetId = " + targetId);
    dispatch({
      type: "UPDATE",
      targetId,
    });
  }, []);

  //삭제하기
  const onDelete = useCallback((targetId) => {
    // const resultTodos = todos.filter((todo) => todo.id != targetId);

    // setTodos(resultTodos);
    console.log("onDelete targetId = " + targetId);
    dispatch({
      type: "DELETE",
      targetId: targetId,
    });
  }, []);

  const memoizedDispatch = useMemo(() => {
    return { onCreate, onUpdate, onDelete };
  }, []);

  return (
    <div className="App">
      <Header />
      <TodoContext value={todos}>
        <TodoDispatchContext value={memoizedDispatch}>
          <Editor onCreate={onCreate} />
          <List todos={todos} onUpdate={onUpdate} onDelete={onDelete} />
        </TodoDispatchContext>
      </TodoContext>
    </div>
  );
}

export default App;
