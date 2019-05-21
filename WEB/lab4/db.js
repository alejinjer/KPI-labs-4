'use strict';

const sqlite3 = require('sqlite3').verbose();

const db = new sqlite3.Database('./database.db', sqlite3.OPEN_CREATE | sqlite3.OPEN_READWRITE,
    (err) => { (err) ? console.log(err) : console.log("Connected to database") });

let databaseAPI = {
    feedbackDB: {
        ctor: function (callback) {
            db.run(`CREATE TABLE IF NOT EXISTS feedback (
                id INTEGER PRIMARY KEY,
                name TEXT,
                org TEXT,
                type TEXT,
                body TEXT,
                file TEXT);`, callback)
        },
        insertRecord: function (record, callback) {
            let query = `INSERT INTO feedback
                (name, org, type, body, file) VALUES
                ((?), (?), (?), (?), (?))`;
            console.log(`Inserting into feedback: `);
            console.log(record);
            db.run(query, record, callback);
        },
        getAllRecords: function (callback) {
            let query = `SELECT * FROM feedback`;
            db.all(query, [], (err, rows) => {
                if (err) {
                    throw err;
                }
                rows.forEach((row) => {
                    console.log(row);
                });
                callback(rows);
            });
        },

    },
    notesDB: {
        ctor: function (callback) {
            db.run(`CREATE TABLE IF NOT EXISTS notes (
                id INTEGER PRIMARY KEY,                
                body TEXT,
                file TEXT,
                date TEXT);`, callback)
        },
        insertRecord: function (record, callback) {
            let query = `INSERT INTO notes
                (date, body, file) VALUES
                ((?), (?), (?))`;
            console.log(`Inserting into notes: `);
            let d = new Date();
            let date = d.toLocaleDateString() + ' at ' + d.toLocaleTimeString();
            record.unshift(date);
            console.log(record);
            db.run(query, record, callback);
        },
        getAllRecords: function (callback) {
            let query = `SELECT * FROM notes`;
            db.all(query, [], (err, rows) => {
                if (err) {
                    throw err;
                }
                rows.forEach((row) => {
                    console.log(row);
                });
                callback(rows);
            });
        },
    }
}
module.exports = databaseAPI;