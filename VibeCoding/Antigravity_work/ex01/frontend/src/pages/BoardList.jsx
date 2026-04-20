import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { getPosts } from '../api/boardApi';

const BoardList = () => {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const data = await getPosts();
        setPosts(data);
      } catch (error) {
        console.error("Failed to fetch posts", error);
        // Fallback to mock data for demonstration if backend is not ready
        setPosts([
          { id: 1, title: '첫 번째 게시글', author: '작성자1', created_at: new Date().toISOString() },
          { id: 2, title: '두 번째 게시글', author: '작성자2', created_at: new Date(Date.now() - 86400000).toISOString() },
        ]);
      } finally {
        setLoading(false);
      }
    };
    fetchPosts();
  }, []);

  if (loading) return <div className="loading">로딩 중...</div>;

  return (
    <div className="board-container">
      <div className="board-header">
        <h2>게시글 목록</h2>
        <Link to="/write" className="btn btn-primary">새 글 작성</Link>
      </div>
      <table className="board-table">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          {posts.length > 0 ? (
            posts.map(post => (
              <tr key={post.id}>
                <td>{post.id}</td>
                <td>
                  <Link to={`/post/${post.id}`} className="post-link">{post.title}</Link>
                </td>
                <td>{post.author}</td>
                <td>{new Date(post.created_at).toLocaleDateString()}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" style={{textAlign: 'center', padding: '2rem'}}>게시글이 없습니다.</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default BoardList;
