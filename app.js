const express = require('express');
const app = express();
const server = require('http').createServer(app);
const io = require('socket.io')(server);
const bodyParser = require('body-parser')
const path = require('path')
const port = process.env.PORT || 3000 ;
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended : false}))
// app.use(express.static(path.join(__dirname,'index')))
app.set('views',path.join(__dirname,'views'));
app.set("view engine","jade");
app.use(express.static('./'))


app.get('/',(req,res)=>{
    var fullUrl = req.protocol + '://' + req.get('host') + req.originalUrl;

    res.render('index',{fullUrl:fullUrl});
})

io.sockets.on('connection', (socket) => {
    socket.on('mousemove', (data) => {
      socket.broadcast.emit('moving', data);
    });
  });
  io.on('connection', (socket) => {

    console.log('made socket connection', socket.id);

    // Handle chat event
    socket.on('chat', function(data){
        // console.log(data);
        io.sockets.emit('chat', data);
    });

    // Handle typing event
    socket.on('typing', function(data){
        socket.broadcast.emit('typing', data);
    });

});

server.listen(port, function(err) {
    console.log(port)
    if(!err) { console.log("Listening on port " + port); }
});
