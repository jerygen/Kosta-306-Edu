import Ex08_Child03 from "./Ex08_Child03";

const Ex08_Child02 = () => {
  return (
    <div style={{ border: "1px green solid", padding: "10px" }}>
      <h3>Child02입니다.</h3>
      <Ex08_Child03 />
    </div>
  );
};

export default Ex08_Child02;
