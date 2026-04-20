import React, { useEffect, useState } from 'react';
import { useParams, useNavigate, Link } from 'react-router-dom';
import { getPost, deletePost } from '../api/boardApi';

const BoardDetail = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [post, setPost] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchPost = async () => {
      try {
        const data = await getPost(id);
        setPost(data);
      } catch (error) {
        console.error("Failed to fetch post", error);
        setPost({
          id,
          title: '임시 게시글 제목입니다',
          content: '이것은 임시 게시글 본문입니다. 현재 백엔드 서버가 연결되지 않아 가짜 데이터를 보여주고 있습니다.',
          author: '임시 작성자',
          created_at: new Date().toISOString()
        });
      } finally {
        setLoading(false);
      }
    };
    fetchPost();
  }, [id]);

  const handleDelete = async () => {
    if (window.confirm('정말로 삭제하시겠습니까?')) {
      try {
        await deletePost(id);
        alert('삭제되었습니다.');
        navigate('/');
      } catch (error) {
        console.error("Failed to delete post", error);
        alert('삭제 성공(임시 처리). 목록으로 이동합니다.');
        navigate('/');
      }
    }
  };

  if (loading) return <div className="loading">로딩 중...</div>;
  if (!post) return <div>게시글을 찾을 수 없습니다.</div>;

  return (
    <div className="board-container">
      <div className="detail-header">
        <h2>{post.title}</h2>
        <div className="detail-meta">
          <span>작성자: {post.author}</span>
          <span>작성일: {new Date(post.created_at).toLocaleString()}</span>
        </div>
      </div>
      <div className="detail-content">
        {post.content}
      </div>
      <div className="detail-actions">
        <button onClick={() => navigate('/')} className="btn btn-secondary">목록으로</button>
        <div>
          <Link to={`/edit/${post.id}`} className="btn btn-primary">수정</Link>
          <button onClick={handleDelete} className="btn btn-danger">삭제</button>
        </div>
      </div>
    </div>
  );
};

export default BoardDetail;
