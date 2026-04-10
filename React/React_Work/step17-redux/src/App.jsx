import { useDispatch, useSelector } from "react-redux";
import "./App.css";
import { down, incrementByNo, up } from "./redux/store";
import Cart from "./Cart";
import Order from "./Order";

function App() {
  //store에 있는 count를 가져온다.(조회)
  const no = useSelector((state) => {
    //console.log("useSelector");
    //console.log(state);
    return state.count.no;
  });

  const dispatch = useDispatch();
  //console.log(dispatch);

  return (
    <>
      <h1>React-Redux TEST</h1>
      {/* 카운트 UI 영역 */}
      <div className="Count">
        {/* 버튼 클릭 시 각각 액션을 디스패치 */}
        <button onClick={() => dispatch(down())}>빼기</button>

        {/* 현재 Redux store에 저장된 상태 값 표시 */}
        <span> 숫자 {no} </span>

        <button onClick={() => dispatch(up())}>더하기</button>
        {/* 5만큼 증가시키는 커스텀 액션 실행 */}
        <button onClick={() => dispatch(incrementByNo(5))}>5씩 증가</button>
      </div>
      <hr />
      <Cart />
      <hr />
      <Order />
    </>
  );
}

export default App;
