import { BrowserRouter, Routes, Route } from 'react-router-dom';
import BoardListPage from './pages/BoardListPage';
import BoardDetailPage from './pages/BoardDetailPage';
import BoardFormPage from './pages/BoardFormPage';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<BoardListPage />} />
        <Route path="/boards/:id" element={<BoardDetailPage />} />
        <Route path="/new" element={<BoardFormPage />} />
        <Route path="/boards/:id/edit" element={<BoardFormPage />} />
      </Routes>
    </BrowserRouter>
  );
}
