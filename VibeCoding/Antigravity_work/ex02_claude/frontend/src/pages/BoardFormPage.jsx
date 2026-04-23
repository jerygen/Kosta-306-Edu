import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getBoardById, createBoard, updateBoard } from '../api/boardApi';

export default function BoardFormPage() {
  const { id } = useParams();
  const navigate = useNavigate();
  const isEdit = Boolean(id);
  const [form, setForm] = useState({ title: '', content: '', author: '' });

  useEffect(() => {
    if (isEdit) {
      getBoardById(id)
        .then((res) => setForm(res.data))
        .catch(() => alert('불러오기 실패'));
    }
  }, [id]);

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (isEdit) {
        await updateBoard(id, form);
        navigate(`/boards/${id}`);
      } else {
        const res = await createBoard(form);
        navigate(`/boards/${res.data.id}`);
      }
    } catch {
      alert('저장 실패');
    }
  };

  return (
    <div style={{ maxWidth: 800, margin: '0 auto', padding: 20 }}>
      <button onClick={() => navigate(-1)}>← 뒤로</button>
      <h2>{isEdit ? '글 수정' : '글 작성'}</h2>
      <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
        <input
          name="title"
          placeholder="제목"
          value={form.title}
          onChange={handleChange}
          required
          style={{ padding: 8, fontSize: 14 }}
        />
        <input
          name="author"
          placeholder="작성자"
          value={form.author}
          onChange={handleChange}
          required
          style={{ padding: 8, fontSize: 14 }}
        />
        <textarea
          name="content"
          placeholder="내용"
          value={form.content}
          onChange={handleChange}
          required
          rows={10}
          style={{ padding: 8, fontSize: 14 }}
        />
        <button type="submit" style={{ padding: 10 }}>
          {isEdit ? '수정 완료' : '작성 완료'}
        </button>
      </form>
    </div>
  );
}
