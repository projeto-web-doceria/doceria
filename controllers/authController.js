// /project-root/controllers/authController.js
const { getUserByEmail } = require('../models/user');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');

const login = (req, res) => {
    const { email, password } = req.body;
    getUserByEmail(email, (err, user) => {
        if (err || !user) {
            return res.status(400).send('User not found');
        }
        bcrypt.compare(password, user.password, (err, result) => {
            if (result) {
                const token = jwt.sign({ id: user.id }, 'secret', { expiresIn: '1h' });
                res.json({ token });
            } else {
                res.status(400).send('Invalid password');
            }
        });
    });
};

const logout = (req, res) => {
    // Invalidate the token (handled client-side by deleting the token)
    res.send('Logged out');
};

module.exports = { login, logout };
