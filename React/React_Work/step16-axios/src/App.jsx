import "./App.css";
import axios from "axios";

const serverIp = import.meta.env.VITE_API_SERVER_IP;

function App() {
  console.log(serverIp);
  const selectAll = async () => {
    try {
      const res = await fetch(serverIp + "/users/");
      console.log(res);

      const jsonResult = await res.json();
      jsonResult.forEach((user, index) => {
        console.log(
          index + " = " + user.id + " | " + user.name + " | " + user.email,
        );
      });
    } catch (err) {
      console.log(err);
    }
  };
  //////////////axios 사용하기/////////////////////////////
  const axiosSelectAll = async () => {
    /*axios
      .get(serverIp+"/users/")
      .then((result) => {
        console.log(result.data);
        result.data.forEach((user, index) => {
          console.log(
            index + " = " + user.id + " | " + user.name + " | " + user.email,
          );
        });
      })
      .catch((err) => {
        console.log(err);
      });*/

    //위 코드를 async와 await으로 변경

    try {
      const result = await axios.get(serverIp + "/users/");
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
    /*axios({
      method: "GET",
      url: serverIp+"/users/5",
      //data:
    })
      .then((result) => {
        console.log(result.data);
      })
      .catch((err) => console.log(err));*/

    //async와 await으로 변경
    try {
      const result = await axios({
        method: "GET",
        url: serverIp + "/users/5",
      });
      console.log(result.data);
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <>
      <h1>fetch Test</h1>
      <button onClick={selectAll}>get - selectAll</button>
      <h1>Axios Test</h1>
      <button onClick={axiosSelectAll}>get - axiosSelectAll</button>
      <button onClick={axiosSelectById}>get - axiosSelectById</button>

      <h3>json-server 연동하기(CRUD)</h3>
      {/* <button onClick={insertUser}>post - user등록</button> 
      <button onClick={deleteUser}>delete - user삭제</button> 
      <button onClick={updateUser}>put - user수정</button> 
      <button onClick={getbyId}>get - user 부분조회 </button> 
      <button onClick={getUsers}>get - user전체조회</button> */}
    </>
  );
}

export default App;
