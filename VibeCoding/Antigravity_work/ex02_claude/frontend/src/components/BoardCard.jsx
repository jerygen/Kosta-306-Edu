import { useNavigate } from 'react-router-dom';

export default function BoardCard({ board, onDelete }) {
  const navigate = useNavigate();

  return (
    <div style={{ border: '1px solid #ddd', padding: 16, marginBottom: 12, borderRadius: 8 }}>
      <h3
        style={{ margin: 0, cursor: 'pointer' }}
        onClick={() => navigate(`/boards/${board.id}`)}
      >
        {board.title}
      </h3>
      <p style={{ color: '#666', margin: '4px 0', fontSize: 14 }}>
        {board.author} · {new Date(board.created_at).toLocaleDateString()}
      </p>
      <div style={{ marginTop: 8 }}>
        <button onClick={() => navigate(`/boards/${board.id}/edit`)}>수정</button>
        <button
          onClick={() => onDelete(board.id)}
          style={{ marginLeft: 8, color: 'red' }}
        >
          삭제
        </button>
      </div>
    </div>
  );
}
