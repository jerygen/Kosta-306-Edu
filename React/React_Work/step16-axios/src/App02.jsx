import axiosInstance from "./api/axiosInstance";
import "./App.css";

function App02() {
  // useEffect(() => {
  //   /*axios
  //     .get("http://localhost:4000/posts/2")
  //     .then((res) => console.log(res.data));*/

  //   axios.post("http://localhost:4000/posts/", { title: "집에 갑시다.." });
  // }, []);

  //////////////axiosInstance 사용하기///////////////////////
  const axiosSelectAll = async () => {
    try {
      const result = await axiosInstance.get("/users/");
      console.log(result.data);
      result.data.forEach((user, index) => {
        console.log(
          index + " = " + user.id + " | " + user.name + " | " + user.email,
        );
      });
    } catch (err) {
      console.log(err);
    }
  };

  const axiosSelectById = async function () {
    try {
      const result = await axiosInstance({
        method: "GET",
        url: "/users/5",
      });
      console.log(result.data);
    } catch (err) {
      console.log(err);
    }
  };

  const insertUser = async function () {
    try {
      const result = await axiosInstance({
        method: "POST",
        url: "/users",
        data: { name: "아이유", email: "789@gmail.com", age: "33" },
      });
      console.log(result.data);
    } catch (err) {
      console.log(err);
    }
  };

  const deleteUser = async function () {
    try {
      await axiosInstance({
        method: "DELETE",
        url: "/users/1",
      });
    } catch (err) {
      console.log(err);
    }
  };

  const updateUser = async function () {
    try {
      const result = await axiosInstance({
        method: "PATCH",
        url: "/users/2",
        data: { name: "이상순", email: "456@gmail.com" },
      });
      console.log(result.data);
    } catch (err) {
      console.log(err);
    }
  };

  const getbyId = async function () {
    try {
      const result = await axiosInstance({
        method: "GET",
        url: "/users/1",
      });
      console.log(result.data);
    } catch (err) {
      console.log(err);
    }
  };

  const getUsers = async function () {
    try {
      const result = await axiosInstance({
        method: "GET",
        url: "/users/",
      });
      console.log(result.data);
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <>
      <h1>Axios Test</h1>
      <button onClick={axiosSelectAll}>get - axiosSelectAll</button>
      <button onClick={axiosSelectById}>get - axiosSelectById</button>

      <h3>json-server 연동하기(CRUD)</h3>
      <button onClick={insertUser}>post - user등록</button>
      <button onClick={deleteUser}>delete - user삭제</button>
      <button onClick={updateUser}>put - user수정</button>
      <button onClick={getbyId}>get - user 부분조회 </button>
      <button onClick={getUsers}>get - user전체조회</button>
    </>
  );
}

export default App02;
