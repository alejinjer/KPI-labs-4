'use strict';

const http = require('http');
const fs = require('fs');
const url = require('url');
const path = require('path');

const Busboy = require('busboy');
const database = require('./db');
const pug = require('pug');


let throwError = function (err) {
    if (err) {
        throw err;
    }
}

const formDB = database.feedbackDB;
const notesDB = database.notesDB;
formDB.ctor((err) => { throwError(err) });
notesDB.ctor((err) => { throwError(err) });

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

const map = {
    "./notes.pug": notes,
    "./schedule.html": schedule,
    "./recentlydeleted.html": recentlydeleted,
    "./feedback.html": feedback,
    "./admin.pug": admin
};

function notes(req, res) {
    if (req.method == 'GET') {
        notesDB.getAllRecords((rows) => {                                    
            let filePath = './notes.pug';
            const compiledFunction = pug.compileFile(filePath);
            let resp = compiledFunction({ rows: rows });
            res.writeHead(200, { 'Content-Type': "text/html" });
            res.end(resp);
        });
    } else if (req.method === "POST") {
        let busboy = new Busboy({ headers: req.headers });
        let fieldValues = [];
        busboy.on('file', function (fieldname, file, filename, encoding, mimetype) {
            if (filename) {
                let filepath = path.join('./storage/notes/', path.basename(filename));
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
            notesDB.insertRecord(fieldValues, throwError);
            console.log('Done parsing form!');
            res.writeHead(303, { Connection: 'close', Location: '/notes.pug' });
            res.end();
        });
        req.pipe(busboy);
    }
};

function schedule(req, res) {
    if (req.method == 'GET') {
        def(req, res);
    }
};

function recentlydeleted(req, res) {
    if (req.method == 'GET') {
        def(req, res);
    }
};

function feedback(req, res) {
    if (req.method == 'GET') {
        def(req, res);
    } else if (req.method === "POST") {
        let busboy = new Busboy({ headers: req.headers });
        let fieldValues = [];
        busboy.on('file', function (fieldname, file, filename, encoding, mimetype) {
            if (filename) {
                let filepath = path.join('./storage/feedback/', path.basename(filename));
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
            formDB.insertRecord(fieldValues, throwError);
            console.log('Done parsing form!');
            res.writeHead(303, { Connection: 'close', Location: '/feedback.html' });
            res.end();
        });
        req.pipe(busboy);
    }
};

function admin(req, res) {
    if (req.method == 'GET') {        
        formDB.getAllRecords((rows) => {                                    
            let filePath = './admin.pug';
            const compiledFunction = pug.compileFile(filePath);
            let resp = compiledFunction({ rows: rows });
            res.writeHead(200, { 'Content-Type': "text/html" });
            res.end(resp);
        });        
    }
};

function def(req, res) {
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
};

const server = http.createServer(function (req, res) {
    let filename = '.' + url.parse(req.url).pathname;
    filename in map ? map[filename](req, res) : def(req, res);
});

server.listen(8080);