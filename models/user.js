// /project-root/models/user.js
const { db } = require('../database');

const createUser = (name, email, password, callback) => {
    db.run("INSERT INTO users (name, email, password) VALUES (?, ?, ?)", [name, email, password], callback);
};

const updateUser = (id, name, email, password, callback) => {
    db.run("UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?", [name, email, password, id], callback);
};

const getUserByEmail = (email, callback) => {
    db.get("SELECT * FROM users WHERE email = ?", [email], callback);
};

module.exports = { createUser, updateUser, getUserByEmail };
