'use strict'
const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const qs = require('querystring');

let urlencodedParser = bodyParser.urlencoded({extended: false});

app.use('/', express.static('./'))
app.use('/styles/', express.static('./styles'))
app.use('/img/', express.static('./img'))
app.use('/audio/', express.static('./audio'))
app.use('/video/', express.static('./video'))

app.get('/', (req, res) => {
    res.send('<h1 style="margin:30px;">Put your path ^^^<h1>');
});

app.post('/feedback', urlencodedParser, (req, res) => {
    console.log(req.body);
    res.render('./feedback', {qs: req.query});
});

app.listen(8080, () => console.log('Listening on port 8080'));