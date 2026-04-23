import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getBoardById, deleteBoard } from '../api/boardApi';

export default function BoardDetailPage() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [board, setBoard] = useState(null);

  useEffect(() => {
    getBoardById(id)
      .then((res) => setBoard(res.data))
      .catch(() => alert('불러오기 실패'));
  }, [id]);

  const handleDelete = async () => {
    if (!confirm('삭제하시겠습니까?')) return;
    try {
      await deleteBoard(id);
      navigate('/');
    } catch {
      alert('삭제 실패');
    }
  };

  if (!board) return <p style={{ padding: 20 }}>로딩 중...</p>;

  return (
    <div style={{ maxWidth: 800, margin: '0 auto', padding: 20 }}>
      <button onClick={() => navigate('/')}>← 목록으로</button>
      <h2>{board.title}</h2>
      <p style={{ color: '#666', fontSize: 14 }}>
        {board.author} · {new Date(board.created_at).toLocaleDateString()}
      </p>
      <hr />
      <p style={{ whiteSpace: 'pre-wrap', lineHeight: 1.8 }}>{board.content}</p>
      <div style={{ marginTop: 24 }}>
        <button onClick={() => navigate(`/boards/${id}/edit`)}>수정</button>
        <button onClick={handleDelete} style={{ marginLeft: 8, color: 'red' }}>삭제</button>
      </div>
    </div>
  );
}
