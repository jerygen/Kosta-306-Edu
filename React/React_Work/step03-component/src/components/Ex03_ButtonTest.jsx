import React from "react";
import Ex03_ButtonImg from "./Ex03_ButtonImg";

import mail from "../assets/images/mail.png";
import location from "../assets/images/location.png";
import search from "../assets/images/search.png";
import emotion2 from "../assets/images/emotion2.png";

function Ex03_ButtonTest() {
  //assets 폴더 안에 있는 이미지는 import해서 사용한다.
  const btnClick = (e) => {
    console.log(e.target);
    console.log(e.target.innerText + " 반응있어요");
  };

  const obj = {
    no: 1,
    name: "hee",
    age: 20,
    addr: "서울",
  };

  return (
    <div style={{ display: "flex", gap: "30px" }}>
      <Ex03_ButtonImg imgSrc={mail} text="메일" btnClick={btnClick} {...obj} />
      <Ex03_ButtonImg
        imgSrc={location}
        text="위치"
        btnClick={btnClick}
        obj={obj}
      />
      <Ex03_ButtonImg imgSrc={search} text="검색" btnClick={btnClick} />
      <hr></hr>
      <img src="emotion1.png" />
      <br />
      <img src={emotion2} />
      <br />
      {/* assets 폴더 안에 있는 거는 경로를 직접 입력해도 나오지 않는다. */}
      <img src="../assets/images/emotion1.png" />
      <br />
    </div>
  );
}

export default Ex03_ButtonTest;
