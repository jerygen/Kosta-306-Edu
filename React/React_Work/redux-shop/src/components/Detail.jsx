import React from "react";

function Detail() {
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6">
          <img src="img/fruit1.jpg" width="100%" />
        </div>
        <div className="pt-5">상품명</div>
        <p>상품설명</p>
        <p>12999원</p>
        <button className="btn btn-danger">주문하기</button>
      </div>
    </div>
  );
}

export default Detail;
