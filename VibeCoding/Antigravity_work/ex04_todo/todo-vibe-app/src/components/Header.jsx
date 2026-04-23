import "./Header.css";

function Header() {
  const today = new Date();
  const formattedDate = today.toLocaleDateString("ko-KR", {
    year: "numeric",
    month: "long",
    day: "numeric",
    weekday: "long",
  });

  return (
    <div className="header">
      <h1>오늘의 Plan 😍</h1>
      <p className="date">{formattedDate}</p>
    </div>
  );
}

export default Header;
