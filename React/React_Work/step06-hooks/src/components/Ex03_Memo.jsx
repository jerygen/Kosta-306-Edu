import React, { useMemo, useState } from "react";

function Ex03_Memo() {
  const [list, setList] = useState([1, 2, 3, 4, 5, 6]);
  const [str, setStr] = useState("합계");

  //list 배열의 값을 더하는 함수
  const getSumResult = () => {
    console.log("getSumResult...call");
    let sum = 0;
    list.forEach((i) => {
      sum += i;
    });
    return sum;
  };

  //////////////////////////////
  const memoResult = useMemo(() => {
    console.log("useMemo...call");
    let sum = 0;
    list.forEach((i) => {
      sum += i;
    });
    return sum;
  }, [list]);

  return (
    <div>
      <h3>useMemo Test</h3>
      {list.map((no, i) => (
        <h5 key={i}>{no}</h5>
      ))}
      {/* <h3>
        {str}: {getSumResult()}
      </h3> */}
      <h3>
        {str}: {memoResult}
      </h3>
      <button onClick={() => setList([10, ...list])}>추가</button>
      <button onClick={() => setStr("총계")}>str값 변경</button>
    </div>
  );
}

export default Ex03_Memo;
