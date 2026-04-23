const pool = require('../db/connection');

const getAll = async (search) => {
  if (search) {
    const [rows] = await pool.query(
      'SELECT * FROM board WHERE title LIKE ? OR content LIKE ? ORDER BY created_at DESC',
      [`%${search}%`, `%${search}%`]
    );
    return rows;
  }
  const [rows] = await pool.query('SELECT * FROM board ORDER BY created_at DESC');
  return rows;
};

const getById = async (id) => {
  const [rows] = await pool.query('SELECT * FROM board WHERE id = ?', [id]);
  return rows[0];
};

const create = async ({ title, content, author }) => {
  const [result] = await pool.query(
    'INSERT INTO board (title, content, author) VALUES (?, ?, ?)',
    [title, content, author]
  );
  return result.insertId;
};

const update = async (id, { title, content, author }) => {
  const [result] = await pool.query(
    'UPDATE board SET title = ?, content = ?, author = ? WHERE id = ?',
    [title, content, author, id]
  );
  return result.affectedRows;
};

const remove = async (id) => {
  const [result] = await pool.query('DELETE FROM board WHERE id = ?', [id]);
  return result.affectedRows;
};

module.exports = { getAll, getById, create, update, remove };
