import { createContext, useState } from "react";
import Ex08_Child01 from "./Ex08_Child01";

//Ex08_Context의 하위에 있는 모든 컴포넌트들이 공유해서 사용한 context를 생성
export const GlobalContext = createContext(); //외부에서 사용할 수 있도록 export

const Ex08_Context = () => {
  const [list, setList] = useState([
    { id: 1, name: "희정" },
    { id: 2, name: "나영" },
    { id: 3, name: "효리" },
  ]);

  const btnClick01 = () => {
    console.log("btnClick01 호출됨...");
  };

  const btnClick02 = () => {
    console.log("btnClick02 호출됨...");
  };

  return (
    <GlobalContext value={{ list:list, setList, btnClick01:btnClick01, btnClick02 }}>
      <div style={{ border: "1px red solid", padding: "10px" }}>
        <h1>useContext TEST</h1>
        <h3 onClick={btnClick01}>클릭</h3>
        {list.map((user) => (
          <div key={user.id}>
            {" "}
            {user.id} : {user.name}{" "}
          </div>
        ))}
        {/* <Ex08_Child01 list={list} setList={setList} /> */}
        <Ex08_Child01 />
      </div>
    </GlobalContext>
  );
};

export default Ex08_Context;
