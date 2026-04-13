import { Outlet } from 'react-router-dom';
import "../App.css";
import Header from '../components/Header';
import Footer from '../components/Footer';
import { createContext, useState } from 'react';
import data from '../db/fruit';

//모든 컴포넌트들의 공유할 fruit 배열을 Context영역에 저장한다.
 export const FruitsContext = createContext();

function MainLayout() {
   const [fruit , setFruit] = useState(data);

  return (
    <div className="App">
      <Header/>
      {/* 여기 안에 라우트별 페이지가 바뀌어 들어옴 */}
      <FruitsContext value={{fruit,setFruit}}>
       <Outlet />
      </FruitsContext>

      <Footer/>
    </div>
  );
}

export default MainLayout;
