import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { getBoards, deleteBoard } from '../api/boardApi';
import SearchBar from '../components/SearchBar';
import BoardCard from '../components/BoardCard';

export default function BoardListPage() {
  const [boards, setBoards] = useState([]);
  const [search, setSearch] = useState('');
  const navigate = useNavigate();

  const fetchBoards = async (keyword = '') => {
    try {
      const res = await getBoards(keyword);
      setBoards(res.data);
    } catch {
      alert('목록 불러오기 실패');
    }
  };

  useEffect(() => {
    fetchBoards();
  }, []);

  const handleSearch = (keyword) => {
    setSearch(keyword);
    fetchBoards(keyword);
  };

  const handleDelete = async (id) => {
    if (!confirm('삭제하시겠습니까?')) return;
    try {
      await deleteBoard(id);
      fetchBoards(search);
    } catch {
      alert('삭제 실패');
    }
  };

  return (
    <div style={{ maxWidth: 800, margin: '0 auto', padding: 20 }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 20 }}>
        <h1 style={{ margin: 0 }}>게시판</h1>
        <button onClick={() => navigate('/new')}>글쓰기</button>
      </div>
      <SearchBar onSearch={handleSearch} />
      {boards.length === 0 ? (
        <p style={{ color: '#999' }}>게시글이 없습니다.</p>
      ) : (
        boards.map((board) => (
          <BoardCard key={board.id} board={board} onDelete={handleDelete} />
        ))
      )}
    </div>
  );
}
