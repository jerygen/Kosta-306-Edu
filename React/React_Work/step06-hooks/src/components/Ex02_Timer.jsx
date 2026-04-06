import React, { useEffect } from "react";

function Ex02_Timer() {
  //마운트가 되었을 때 1초마다 콘솔에 출력
  useEffect(() => {
    const timeStop = setInterval(() => {
      console.log("타이머가 실행중입니다.");
    }, 1000);

    //unmount 될 때 해야될 일이 있다면 return () 작업을 한다.
    return () => {
      console.log("자원 정리해요~~");
      clearInterval(timeStop);
    };
  });

  return (
    <>
      <span>Timer를 시작합니다. 콘솔을 확인해주세요</span>
    </>
  );
}

export default Ex02_Timer;
