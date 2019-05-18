'use strict';

const sqlite3 = require('sqlite3').verbose();

const db = new sqlite3.Database('./database.db', sqlite3.OPEN_CREATE | sqlite3.OPEN_READWRITE,
    (err) => { (err) ? console.log(err) : console.log("Connected to database") });

let databaseAPI = {
    table: {
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
            });
        },
    }
}
module.exports = databaseAPI;