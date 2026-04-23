const mysql = require('mysql2/promise');
require('dotenv').config({ path: './.env' });

async function testConnection() {
  console.log('Connecting to:', process.env.DB_HOST);
  try {
    const connection = await mysql.createConnection({
      host: process.env.DB_HOST,
      user: process.env.DB_USER,
      password: process.env.DB_PASSWORD,
      database: process.env.DB_NAME,
      connectTimeout: 5000
    });
    console.log('Successfully connected to the database!');
    const [rows] = await connection.query('SELECT * FROM board LIMIT 1');
    console.log('Query successful, rows found:', rows.length);
    await connection.end();
  } catch (err) {
    console.error('Connection failed:', err.message);
    if (err.code === 'ETIMEDOUT') {
      console.error('Timeout occurred. This usually means port 3306 is blocked or the host is unreachable.');
    }
  }
}

testConnection();
