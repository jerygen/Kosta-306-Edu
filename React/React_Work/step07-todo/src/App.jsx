
import { useState } from 'react';
import './App.css'
import Editor from './components/Editor'
import Header from './components/Header'
import List from './components/List'

//랜더링이 될때 다시 실행되지 않아도 되기에 함수 밖에 선언한다.
const mockData = [
  {id:0, isDone:false, content:"React study", date: new Date().getTime()},
  {id:1, isDone:false, content:"친구만나기", date: new Date().getTime()},
  {id:2, isDone:false, content:"낮잠자기", date: new Date().getTime()},
];

function App() {
  const [todos, setTodos] = useState(mockData);

  return (
    <div className="App">
      <Header/>
      <Editor/>
      <List todos={todos}/>
    </div>
  )
}

export default App
