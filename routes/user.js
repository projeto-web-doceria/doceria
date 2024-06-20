// /project-root/routes/user.js
const express = require('express');
const router = express.Router();
const { register, update } = require('../controllers/userController');
const { authenticateToken } = require('../middleware/authMiddleware');

router.post('/register', register);
router.put('/update/:id', authenticateToken, update);

module.exports = router;
