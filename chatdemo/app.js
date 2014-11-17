var app = require('http').createServer(handler)
  , io = require('socket.io').listen(app)
  , fs = require('fs')

app.listen(9000);

function handler (req, res) {
  fs.readFile(__dirname + '/index.html',
  function (err, data) {
    if (err) {
      res.writeHead(500);
      return res.end('Error loading index.html');
    }

    res.writeHead(200);
    res.end(data);
  });
}

io.sockets.on('connection', function (socket) {
  socket.on('message', function (msg) {
    console.log(msg);
    //处理消息
	doMsg(socket,msg);	
		
  });
  
  //处理客户端消息
function doMsg(socket,msg)
{  
  //获取客户端ip地址 
  var addr = socket.handshake.address.address;	
  //后台打印消息
  console.log("receive msg from "+addr+":"+msg);
  //回传消息给客户端
  socket.send("Server received messag!");
  //广播消息给其他客户端
  socket.broadcast.send(addr+" send msg:"+msg);
}


});