import { use } from "react";
import { GlobalContext } from "./Ex08_Context";

const Ex08_Child03 = () => {
  const { btnClick02 } = use(GlobalContext);
  return (
    <div style={{ border: "1px orange solid", padding: "10px" }}>
      <h3>Child 03입니다.</h3>
      <button onClick={btnClick02}>클릭!</button>
      {/* 함수를 등록한 것  */}
      <button onClick={()=>{btnClick02()}}>클릭!</button> 
      {/* 눌렀을 때 일을 한 것  */}
    </div>
  );
};

export default Ex08_Child03;
