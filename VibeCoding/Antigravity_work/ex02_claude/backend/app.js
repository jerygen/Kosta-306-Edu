const express = require('express');
const cors = require('cors');
require('dotenv').config();

const boardsRouter = require('./routes/boards');

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());

app.use('/api/boards', boardsRouter);

app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
