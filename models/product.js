// /project-root/models/product.js
const { db } = require('../database');

const createProduct = (name, description, price, callback) => {
    db.run("INSERT INTO products (name, description, price) VALUES (?, ?, ?)", [name, description, price], callback);
};

const getAllProducts = (callback) => {
    db.all("SELECT * FROM products", callback);
};

const updateProduct = (id, name, description, price, callback) => {
    db.run("UPDATE products SET name = ?, description = ?, price = ? WHERE id = ?", [name, description, price, id], callback);
};

const deleteProduct = (id, callback) => {
    db.run("DELETE FROM products WHERE id = ?", [id], callback);
};

module.exports = { createProduct, getAllProducts, updateProduct, deleteProduct };
