import { use, useRef } from "react";
import Ex08_Child02 from "./Ex08_Child02";
import { GlobalContext } from "./Ex08_Context";

/*const Ex08_Child01 = ({list, setList}) => {
  const idRef = useRef(4);
  return (
    <div style={{ border: "1px blue solid", padding: "10px" }}>
      <h3>Child01입니다.</h3>
      <button>눌려봐</button>
      <button
        onClick={() => {
          setList([...list, { id: idRef.current++, name: "희정2" }]);
        }}
      >
        추가
      </button>

      <hr />
      <Ex08_Child02 />
    </div>
  );
};*/

const Ex08_Child01 = () => {
  //Context 영역에 있는 상태정보 가져오기
  const { list, setList, btnClick01 } = use(GlobalContext);
  const idRef = useRef(4);
  return (
    <div style={{ border: "1px blue solid", padding: "10px" }}>
      <h3>Child01입니다.</h3>
      <button onClick={btnClick01}>눌려봐</button>
      <button
        onClick={() => {
          setList([...list, { id: idRef.current++, name: "희정2" }]);
        }}
      >
        추가
      </button>

      <hr />
      <Ex08_Child02 />
    </div>
  );
};

export default Ex08_Child01;
