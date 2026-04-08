import React, { useReducer } from "react";

//가독성이 좋아지고 관리가 편해진다.
const reducer = (state, action) => {
  console.log(state, action);
  switch (action.type) {
    case "down":
      return state - action.data;
    case "up":
      return state + action.data;
    default:
      return state;
  }
};

function Ex01_Count() {
  //useState의 리턴은 배열 [초기값, 변경함수]

  const [state, dispatch] = useReducer(reducer, 100);
  console.log(state);
  console.log(dispatch);

  const minusClick = function () {
    dispatch({
      type: "down",
      data: 1,
      info: "OK",
    }); //reducer 함수가 호출된다.
  };

  const plusClick = function () {
    dispatch({
      type: "up",
      data: 1,
      info: "success",
    });
  };

  return (
    <div>
      <h2>숫자 증가 or 감소</h2>
      <button onClick={minusClick}>빼기</button>
      <span>state = {state}</span>
      <button onClick={plusClick}>더하기</button>
    </div>
  );
}

export default Ex01_Count;
