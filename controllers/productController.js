// /project-root/controllers/productController.js
const { createProduct, getAllProducts, updateProduct, deleteProduct } = require('../models/product');

const addProduct = (req, res) => {
    const { name, description, price } = req.body;
    createProduct(name, description, price, (err) => {
        if (err) {
            return res.status(500).send('Error adding product');
        }
        res.send('Product added');
    });
};

const listProducts = (req, res) => {
    getAllProducts((err, products) => {
        if (err) {
            return res.status(500).send('Error fetching products');
        }
        res.json(products);
    });
};

const editProduct = (req, res) => {
    const { id } = req.params;
    const { name, description, price } = req.body;
    updateProduct(id, name, description, price, (err) => {
        if (err) {
            return res.status(500).send('Error updating product');
        }
        res.send('Product updated');
    });
};

const removeProduct = (req, res) => {
    const { id } = req.params;
    deleteProduct(id, (err) => {
        if (err) {
            return res.status(500).send('Error deleting product');
        }
        res.send('Product deleted');
    });
};

module.exports = { addProduct, listProducts, editProduct, removeProduct };
