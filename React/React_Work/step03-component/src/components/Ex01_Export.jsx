export let num = 0; //멤버 변수도 내보내기 가능

export default function Ex01_Export() {
  return (
    <>
      <h3>여기는 Ex01_Export 입니다. - {num}</h3>
    </>
  );
}

//Parsing error: Duplicate export 'default'
//하나의 jsx에서는 default는 하나 밖에 안 됨.
export /*default*/ function Ex01_Export2() {
  return (
    <>
      <h3>여기는 Ex01_Export2 component</h3>
    </>
  );
}
