'use strict'
const express = require('express');
const app = express();

app.use('/', express.static('./src'))
app.use('/styles/', express.static('./styles'))
app.use('/img/', express.static('./img'))
app.use('/audio/', express.static('./audio'))
app.use('/video/', express.static('./video'))

app.get('/', (req, res) => {
    res.send('<h1 style="margin:30px;">Put your path ^^^<h1>');
});

app.listen(8080, () => console.log('Listening on port 8080'));