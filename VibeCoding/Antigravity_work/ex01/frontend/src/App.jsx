import { Routes, Route } from 'react-router-dom';
import BoardList from './pages/BoardList';
import BoardDetail from './pages/BoardDetail';
import BoardForm from './pages/BoardForm';
import './index.css';

function App() {
  return (
    <div className="app-container">
      <header className="app-header">
        <h1>Antigravity Board</h1>
      </header>
      <main className="app-main">
        <Routes>
          <Route path="/" element={<BoardList />} />
          <Route path="/post/:id" element={<BoardDetail />} />
          <Route path="/write" element={<BoardForm />} />
          <Route path="/edit/:id" element={<BoardForm />} />
        </Routes>
      </main>
    </div>
  );
}

export default App;
