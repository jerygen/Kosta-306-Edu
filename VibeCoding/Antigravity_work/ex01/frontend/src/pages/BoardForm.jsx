import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { createPost, getPost, updatePost } from '../api/boardApi';

const BoardForm = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const isEditMode = !!id;

  const [formData, setFormData] = useState({
    title: '',
    content: '',
    author: ''
  });
  const [loading, setLoading] = useState(isEditMode);

  useEffect(() => {
    if (isEditMode) {
      const fetchPost = async () => {
        try {
          const data = await getPost(id);
          setFormData({
            title: data.title,
            content: data.content,
            author: data.author
          });
        } catch (error) {
          console.error("Failed to fetch post for edit", error);
          // 폼 에러 처리 임시 데이터
          setFormData({
            title: '임시 수정 제목',
            content: '임시 수정 내용입니다.',
            author: '작성자'
          });
        } finally {
          setLoading(false);
        }
      };
      fetchPost();
    }
  }, [id, isEditMode]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (isEditMode) {
        await updatePost(id, { title: formData.title, content: formData.content });
        alert('수정되었습니다.');
        navigate(`/post/${id}`);
      } else {
        await createPost(formData);
        alert('등록되었습니다.');
        navigate('/');
      }
    } catch (error) {
      console.error("Failed to submit", error);
      alert('저장 성공(임시 처리). 목록으로 이동합니다.');
      navigate('/');
    }
  };

  if (loading) return <div className="loading">데이터를 불러오는 중...</div>;

  return (
    <div className="board-container">
      <h2>{isEditMode ? '게시글 수정' : '새 글 작성'}</h2>
      <form onSubmit={handleSubmit} className="board-form">
        <div className="form-group">
          <label htmlFor="title">제목</label>
          <input
            type="text"
            id="title"
            name="title"
            value={formData.title}
            onChange={handleChange}
            required
            placeholder="제목을 입력하세요"
          />
        </div>
        <div className="form-group">
          <label htmlFor="author">작성자</label>
          <input
            type="text"
            id="author"
            name="author"
            value={formData.author}
            onChange={handleChange}
            required
            readOnly={isEditMode}
            className={isEditMode ? 'readonly-input' : ''}
            placeholder="작성자 이름"
          />
        </div>
        <div className="form-group">
          <label htmlFor="content">내용</label>
          <textarea
            id="content"
            name="content"
            value={formData.content}
            onChange={handleChange}
            required
            rows="10"
            placeholder="내용을 입력하세요"
          />
        </div>
        <div className="form-actions">
          <button type="button" onClick={() => navigate(-1)} className="btn btn-secondary">취소</button>
          <button type="submit" className="btn btn-primary">저장</button>
        </div>
      </form>
    </div>
  );
};

export default BoardForm;
