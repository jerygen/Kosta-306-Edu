import { useState } from 'react';

export default function SearchBar({ onSearch }) {
  const [keyword, setKeyword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onSearch(keyword);
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginBottom: 16, display: 'flex', gap: 8 }}>
      <input
        value={keyword}
        onChange={(e) => setKeyword(e.target.value)}
        placeholder="제목 또는 내용 검색..."
        style={{ flex: 1, padding: 8, fontSize: 14 }}
      />
      <button type="submit">검색</button>
      <button type="button" onClick={() => { setKeyword(''); onSearch(''); }}>초기화</button>
    </form>
  );
}
