// /project-root/app.js
const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const path = require('path');
const authRoutes = require('./routes/auth');
const userRoutes = require('./routes/user');
const productRoutes = require('./routes/product');
const { initDB } = require('./database');

app.use(bodyParser.json());
app.use('/auth', authRoutes);
app.use('/user', userRoutes);
app.use('/product', productRoutes);
app.use(express.static(path.join(__dirname, 'views')));

// Rota para a página inicial
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'views', 'html', 'login.html'));
});

initDB();

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
