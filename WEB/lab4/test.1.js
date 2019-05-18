'use strict';

const http = require('http');
const fs = require('fs');
const url = require('url');
const path = require('path');

const Busboy = require('busboy');
const inspect = require('util').inspect;
const database = require('./db');

let throwError = function (err) {
    if (err) {
        throw err;
    }
}

const db = database.table;
db.ctor((err) => { throwError(err) });

const defineContentType = type => {
    switch (type) {
        case '.css': return 'text/css';
        case '.js': return 'text/javascript';
        case '.json': return 'application/json';
        case '.mp4': return 'video/mp4';
        case '.mp3': return 'audio/mp3';
        case '.png': return 'image/png';
        case '.jpg': return 'image/jpg';
        case '.jpeg': return 'image/jpeg';
        default: return 'text/html';
    }
};

const server = http.createServer(function (req, res) {
    if (req.method == 'GET') {
        let filename = '.' + url.parse(req.url).pathname;
        fs.readFile(filename, function (err, data) {
            if (err) {
                res.writeHead(404, { 'Content-Type': 'text/html' });
                return res.end("404 Not Found");
            }
            res.writeHead(200, { 'Content-Type': defineContentType(path.extname(filename)) });
            res.write(data);
            res.end();
        });
    } else if (req.method === "POST") {
        let busboy = new Busboy({ headers: req.headers });
        let fieldValues = [];
        busboy.on('file', function (fieldname, file, filename, encoding, mimetype) {
            if (filename) {
                let filepath = path.join('./storage/', path.basename(filename));
                console.log(filepath);
                fieldValues.push(filename);
                file.pipe(fs.createWriteStream(filepath));
            } else {
                file.resume();
            }            
        });
        busboy.on('field', function (fieldname, val, fieldnameTruncated, valTruncated, encoding, mimetype) {
            fieldValues.push(val);
        });
        busboy.on('finish', function () {
            db.insertRecord(fieldValues, throwError);
            console.log('Done parsing form!');
            db.getAllRecords(throwError);
            res.writeHead(303, { Connection: 'close', Location: '/feedback.html' });
            res.end();
        });
        req.pipe(busboy);
    }
});

server.listen(8080);