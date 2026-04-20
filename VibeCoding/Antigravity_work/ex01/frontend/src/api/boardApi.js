import axios from 'axios';

const api = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080/api/posts',
  headers: {
    'Content-Type': 'application/json',
  },
});

export const getPosts = async () => {
  const response = await api.get('/');
  return response.data;
};

export const getPost = async (id) => {
  const response = await api.get(`/${id}`);
  return response.data;
};

export const createPost = async (postData) => {
  const response = await api.post('/', postData);
  return response.data;
};

export const updatePost = async (id, postData) => {
  const response = await api.put(`/${id}`, postData);
  return response.data;
};

export const deletePost = async (id) => {
  const response = await api.delete(`/${id}`);
  return response.data;
};
