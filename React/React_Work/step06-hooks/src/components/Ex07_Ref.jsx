import React from "react";
import { useRef } from "react";
import { useEffect } from "react";
import { useState } from "react";

function Ex07_Ref() {
  const [count, setCount] = useState(0);
  //const [renderCount, setRenderCount] = useState(1);
  const countRef = useRef(0);

  useEffect(() => {
    //console.log("랜더링");
    //setRenderCount(renderCount + 1);
    countRef.current = countRef.current + 1;
    console.log("countRef.current = " + countRef.current);
  });

  return (
    <div>
      <p>
        Count : {count} :{" "}
        <button onClick={() => setCount(count + 1)}>Up</button>
      </p>
    </div>
  );
}

export default Ex07_Ref;
