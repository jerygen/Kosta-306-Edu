// 여기서부터는 자바스크립트 영역입니다.
/*부분 or 여러줄 주석 */

//브라우저에 출력
// document.write("<h1>난 어디에 출력되나요?</h1>");
//콘솔 출력
console.log("1.콘솔창에 출력되어요^^");

// h1태그를 클릭하면 css를 적용하고 싶다. - 함수를 작성
function text(th) {
  // th는 this가 전달됨
  // alert("h1 태그 클릭하셨네요?");
  th.style.backgroundColor = "red";
}

for (i = 0; i < 10000; i++) {}

// alert("끝~~")
console.log("test.js 끝");
