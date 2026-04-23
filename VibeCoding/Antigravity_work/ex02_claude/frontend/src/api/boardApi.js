import axios from 'axios';

const api = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
});

export const getBoards = (search = '') =>
  api.get('/api/boards', { params: search ? { search } : {} });

export const getBoardById = (id) => api.get(`/api/boards/${id}`);

export const createBoard = (data) => api.post('/api/boards', data);

export const updateBoard = (id, data) => api.put(`/api/boards/${id}`, data);

export const deleteBoard = (id) => api.delete(`/api/boards/${id}`);
