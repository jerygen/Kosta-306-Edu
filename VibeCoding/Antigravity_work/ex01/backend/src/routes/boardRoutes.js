const express = require('express');
const router = express.Router();
const pool = require('../config/db');

// 전체 목록 조회
router.get('/', async (req, res) => {
  try {
    const [rows] = await pool.query('SELECT * FROM board ORDER BY id DESC');
    res.json(rows);
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: 'Database query error' });
  }
});

// 상세 조회
router.get('/:id', async (req, res) => {
  try {
    const [rows] = await pool.query('SELECT * FROM board WHERE id = ?', [req.params.id]);
    if (rows.length === 0) {
      return res.status(404).json({ error: 'Post not found' });
    }
    res.json(rows[0]);
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: 'Database query error' });
  }
});

// 글 등록
router.post('/', async (req, res) => {
  const { title, content, author } = req.body;
  if (!title || !content || !author) {
    return res.status(400).json({ error: 'Missing required fields' });
  }
  
  try {
    const [result] = await pool.query(
      'INSERT INTO board (title, content, author) VALUES (?, ?, ?)',
      [title, content, author]
    );
    res.status(201).json({ id: result.insertId, title, content, author, created_at: new Date() });
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: 'Database insert error' });
  }
});

// 글 수정
router.put('/:id', async (req, res) => {
  const { title, content } = req.body;
  if (!title || !content) {
    return res.status(400).json({ error: 'Missing required fields' });
  }

  try {
    const [result] = await pool.query(
      'UPDATE board SET title = ?, content = ? WHERE id = ?',
      [title, content, req.params.id]
    );
    if (result.affectedRows === 0) {
      return res.status(404).json({ error: 'Post not found' });
    }
    res.json({ id: req.params.id, title, content });
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: 'Database update error' });
  }
});

// 글 삭제
router.delete('/:id', async (req, res) => {
  try {
    const [result] = await pool.query('DELETE FROM board WHERE id = ?', [req.params.id]);
    if (result.affectedRows === 0) {
      return res.status(404).json({ error: 'Post not found' });
    }
    res.status(204).send();
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: 'Database delete error' });
  }
});

module.exports = router;
