import "./App.css";
import { Button, Navbar, Container, Nav } from "react-bootstrap";
import data from "./db/fruit";
import { useState } from "react";
import Product from "./components/Product";
import { Link, Navigate, Route, Routes, useNavigate } from "react-router-dom";
import Detail from "./components/Detail";

function App() {
  const [fruit] = useState(data);
  const navigate = useNavigate();

  return (
    <div className="App" style={{ textAlign: "center" }}>
      <>
        <Navbar bg="dark" variant="dark">
          <Container>
            <Navbar.Brand href="#home">과일농장</Navbar.Brand>
            <Nav className="me-auto">
              <Nav.Link
                onClick={() => {
                  navigate("/");
                }}
              >
                홈으로
              </Nav.Link>
              <Nav.Link
                onClick={() => {
                  navigate("/detail");
                }}
              >
                상세페이지
              </Nav.Link>
              <Nav.Link
                onClick={() => {
                  navigate("/cart");
                }}
              >
                장바구니
              </Nav.Link>
              <Nav.Link
                onClick={() => {
                  navigate("/about");
                }}
              >
                회사소개
              </Nav.Link>
            </Nav>
          </Container>
        </Navbar>
        {/* <Link to="/">홈</Link>
        <Link to="/detail">상세페이지</Link> */}
        <Routes>
          <Route
            path="/"
            element={
              <div>
                <div className="slider"></div>
                <div className="container">
                  <div className="row">
                    {fruit.map((ele, i) => {
                      return (
                        <Product fruit={fruit[i]} i={i} key={data[i].id} />
                      );
                    })}
                  </div>
                </div>
              </div>
            }
          />
          <Route path="/about" element={<About />}>
            <Route path="member" element={<Member />} />
            <Route path="location" element={<Location />} />
          </Route>
        </Routes>
      </>
    </div>
  );
}

function About() {
  return (
    <>
      <h4>회사정보</h4>
      <Outlet></Outlet>
    </>
  );
}

function Member() {
  return (
    <>
      <h4>Member</h4>
    </>
  );
}
function Location() {
  return (
    <>
      <h4>Location</h4>
    </>
  );
}

export default App;
