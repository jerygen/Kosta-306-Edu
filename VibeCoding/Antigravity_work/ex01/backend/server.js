require('dotenv').config();
const express = require('express');
const cors = require('cors');
const boardRoutes = require('./src/routes/boardRoutes');

const app = express();
const PORT = process.env.PORT || 8080;

app.use(cors());
app.use(express.json());

// 라우터 설정
app.use('/api/posts', boardRoutes);

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
