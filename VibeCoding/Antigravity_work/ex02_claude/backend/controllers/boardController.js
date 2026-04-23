const boardService = require('../services/boardService');

const getAll = async (req, res) => {
  try {
    const { search } = req.query;
    const boards = await boardService.getAll(search);
    res.json(boards);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

const getById = async (req, res) => {
  try {
    const board = await boardService.getById(req.params.id);
    if (!board) return res.status(404).json({ error: 'Not found' });
    res.json(board);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

const create = async (req, res) => {
  try {
    const { title, content, author } = req.body;
    if (!title || !content || !author) {
      return res.status(400).json({ error: '제목, 내용, 작성자를 입력해주세요.' });
    }
    const id = await boardService.create({ title, content, author });
    res.status(201).json({ id });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

const update = async (req, res) => {
  try {
    const { title, content, author } = req.body;
    const affected = await boardService.update(req.params.id, { title, content, author });
    if (!affected) return res.status(404).json({ error: 'Not found' });
    res.json({ success: true });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

const remove = async (req, res) => {
  try {
    const affected = await boardService.remove(req.params.id);
    if (!affected) return res.status(404).json({ error: 'Not found' });
    res.json({ success: true });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

module.exports = { getAll, getById, create, update, remove };
