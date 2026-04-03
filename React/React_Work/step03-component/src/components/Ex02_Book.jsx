/*function Ex02_Book(props) {
  return (
    <>
      <h1>이책은 {props.name} 책입니다.</h1>
      <h2>이 책의 총 페이지 수는 {props.page}페이지로 이뤄져 있습니다.</h2>
    </>
  );
}

export default Ex02_Book;*/

function Ex02_Book({ name = "java", page, author }) {
  return (
    <>
      <h1>이책은 {name} 책입니다.</h1>
      <h4>이 책의 총 페이지 수는 {page}페이지로 이뤄져 있습니다.</h4>
      <h4>
        지은이: {author.pName} 나이: {author.age} 주소: {author.addr}
      </h4>
    </>
  );
}

export default Ex02_Book;
