import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { createBrowserRouter,RouterProvider} from 'react-router-dom';
import MainLayout from './layout/MainLayout.jsx';
import Detail from './pages/Detail.jsx';
import Cart from './pages/Cart.jsx';
import FruitBoard from './pages/FruitBoard.jsx';
import Notfound from './pages/Notfound.jsx';
import AboutLayout from './layout/AboutLayout.jsx';
import About from './pages/About.jsx';
import Member from './pages/Member.jsx';
import Location from './pages/Location.jsx';

import store from './store.js';
 import { Provider } from 'react-redux';

const router = createBrowserRouter([
  {
    path: '/',
    element: <MainLayout />,          // 레이아웃 (Header + Footer + Outlet)
    errorElement: <Notfound />, // 에러(없는 경로 등) 기본 처리
    children: [
      {
        index: true,           
        element: <App />,
      },
       {
        path: 'detail/:paramId',                    
        element: <Detail/>,         
      },
      {
        path: 'cart',      
        element: <Cart />,
      },
      {
        path: 'board',      
        element: <FruitBoard />,
      },
      {
        path: 'about',      
        element: <AboutLayout />,
        children:[
          {index: true, element: <About />},
          {path: 'member', element: <Member/>},
          {path: 'location', element: <Location/>}
        ]
       },
      {
        path: '*',             // 나머지 모든 서브 경로 처리
        element: <Notfound />,
      },
    ],
  },
]);

createRoot(document.getElementById('root')).render(
  <Provider store={store}>
    <RouterProvider router={router} />
  </Provider>
)
