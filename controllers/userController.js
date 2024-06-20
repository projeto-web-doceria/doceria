// /project-root/controllers/userController.js
const { createUser, updateUser } = require('../models/user');
const bcrypt = require('bcrypt');

const register = (req, res) => {
    const { name, email, password } = req.body;
    bcrypt.hash(password, 10, (err, hash) => {
        if (err) {
            return res.status(500).send('Error hashing password');
        }
        createUser(name, email, hash, (err) => {
            if (err) {
                return res.status(500).send('Error creating user');
            }
            res.send('User created');
        });
    });
};

const update = (req, res) => {
    const { id } = req.params;
    const { name, email, password } = req.body;
    bcrypt.hash(password, 10, (err, hash) => {
        if (err) {
            return res.status(500).send('Error hashing password');
        }
        updateUser(id, name, email, hash, (err) => {
            if (err) {
                return res.status(500).send('Error updating user');
            }
            res.send('User updated');
        });
    });
};

module.exports = { register, update };
