// /project-root/routes/product.js
const express = require('express');
const router = express.Router();
const { addProduct, listProducts, editProduct, removeProduct } = require('../controllers/productController');
const { authenticateToken } = require('../middleware/authMiddleware');

router.post('/', authenticateToken, addProduct);
router.get('/', listProducts);
router.put('/:id', authenticateToken, editProduct);
router.delete('/:id', authenticateToken, removeProduct);

module.exports = router;
