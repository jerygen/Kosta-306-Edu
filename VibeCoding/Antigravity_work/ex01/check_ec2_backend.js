const http = require('http');

const options = {
  hostname: 'ec2-43-200-169-149.ap-northeast-2.compute.amazonaws.com',
  port: 8080,
  path: '/api/posts',
  method: 'GET',
  timeout: 5000
};

console.log('Checking backend at:', `http://${options.hostname}:${options.port}${options.path}`);

const req = http.request(options, (res) => {
  console.log(`Status: ${res.statusCode}`);
  res.on('data', (d) => {
    process.stdout.write(d);
  });
});

req.on('error', (e) => {
  console.error(`Error: ${e.message}`);
});

req.on('timeout', () => {
  console.error('Request timed out');
  req.destroy();
});

req.end();
