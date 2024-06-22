const sqlite3 = require('sqlite3').verbose();
const db = new sqlite3.Database('docinhos.db');

const initDB = () => {
    db.serialize(() => {
        db.run("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, email TEXT, password TEXT)");
        db.run("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY, name TEXT, description TEXT, price REAL)");
    });
};

module.exports = { db, initDB };
