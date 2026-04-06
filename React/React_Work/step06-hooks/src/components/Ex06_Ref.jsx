import React, { useRef, useState } from "react";

let letCount = 0; //전역 필드

function Ex06_Ref() {
  //값이 변경될 때마다 rerendering 된다
  const [count, setCount] = useState(0); //count

  //값이 변경이 되어도 rerendering이 되지 않는다.
  //컴포넌트는 재사용을 위함, 각각 영역 안에서 관리되는 상태
  //let은 다른 영역의 let과 공유함 -> 어디서 값이 변경됐는지 알기 어렵다.
  const countRef = useRef(0); //countRef.current

  console.log("Ex06_Ref() call.... letCount=" + letCount);

  return (
    <div>
      <h2>useRef vs let 차이</h2>
      <p>
        useState: {count}
        <button onClick={() => setCount(count + 1)}>state UP</button>
      </p>
      <hr />
      <p>
        useRef: {countRef.current}
        <button onClick={() => (countRef.current = countRef.current + 1)}>
          ref UP
        </button>
      </p>
      <hr />
      <p>
        letCount: {letCount}
        <button onClick={() => letCount++}>let UP</button>
      </p>
    </div>
  );
}

export default Ex06_Ref;
