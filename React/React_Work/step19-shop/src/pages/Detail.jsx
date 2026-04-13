import React, { use , useEffect ,useState} from 'react';
import { useParams } from 'react-router-dom';
import { FruitsContext } from '../layout/MainLayout';
import { Nav } from 'react-bootstrap'

import { addItem } from '../store.js'
 import { useDispatch } from 'react-redux'
 import { Button } from 'react-bootstrap'
 import { Link } from 'react-router-dom';

 const Detail = () => {
     // dispatch 정의 추가
    const dispatch = useDispatch(); 

    const {fruit} = use(FruitsContext);
    let {paramId} = useParams();
   // console.log(paramId);
    
    //전달된 paramId에 해당하는 데이터가 있는지 찾기!
    let item = fruit.find((f)=>f.id === Number(paramId))
   console.log(item);
 
   if(!item){
     return (<div>해당 상품이 존재하지 않습니다.</div>) 
   }

   const { id, imgUrl, title, content, price } = item;
   const [tap, setTap] = useState(0); 
    let [fade2, setFade2] = useState('')
    useEffect(()=>{
      setFade2('end')
      return ()=>{
        setFade2('')
      }
    },[])

    return (
        <div className={'container start ' + fade2}>
            <div className="row">
                <div className="col-md-6">
                   <img src={"/"+imgUrl} width="100%" />
                </div>
                <div className="col-md-6">
                    <h4 className="pt-5">{title}</h4>
                    <p>{content}</p>
                    <p>{price}원</p>

            <Button
            variant="primary"
            onClick={() => {
              //  dispatch(addItem(  {id : 1,  imgurl : 'fruit1.jpg', name : 'Grey Yordan', count : 1}))
              dispatch(
                addItem({
                  id: id,
                  imgurl: imgUrl.replace("img/", ""),
                  name: title,
                  count: 1,
                })
              );
            }}
            style={{ marginRight: "10px" }}
          >
            장바구니담기
          </Button>
          <Link to="/cart">
            <Button variant="outline-success" style={{ marginRight: "10px" }}>
                 장바구니 확인하기 
            </Button>
       </Link> 

           <Link to="/order">
            <Button variant="outline-success"> 
                주문하기 
                </Button>
            </Link>
        </div>
            </div>

        <Nav variant="tabs"  defaultActiveKey="link0" style={{marginTop:"50px"}}>
            <Nav.Item>
              <Nav.Link  onClick={()=>{ setTap(0) }} eventKey="link0">버튼0</Nav.Link>
            </Nav.Item>
            <Nav.Item>
              <Nav.Link onClick={()=>{ setTap(1) }} eventKey="link1">버튼1</Nav.Link>
            </Nav.Item>
            <Nav.Item>
              <Nav.Link  onClick={()=>{ setTap(2) }} eventKey="link2">버튼2</Nav.Link>
            </Nav.Item>
     </Nav>
      <TabContent tap={tap} />

        </div>
    );
 };

 function TabContent({tap}){
    let [fade, setFade] = useState('')

     useEffect( ()=>{

      setTimeout(()=>{ 
        setFade('end')
      }, 10);

      return ()=>{// 화면에서 사라질때 자원정리
          setFade('')
      }
     } ,[tap]);

  
    return (
      <div className={'start ' + fade}>
        { [<div>내용0</div>, <div>내용1</div>, <div>내용2</div>][tap] }
      </div>
    )
  }



 export default Detail;