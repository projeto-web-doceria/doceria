// /project-root/views/js/manage-products.js
document.addEventListener('DOMContentLoaded', async () => {
    const token = localStorage.getItem('token');

    if (!token) {
        alert('You are not logged in!');
        window.location.href = '/html/login.html';
        return;
    }

    const response = await fetch('/product', {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    });

    if (response.ok) {
        const products = await response.json();
        const productList = document.getElementById('product-list');
        productList.innerHTML = products.map(product => `
            <div class="product">
                <img src="/images/products/${product.image}" alt="${product.name}">
                <h3>${product.name} (${product.weight})</h3>
                <p>${product.description}</p>
                <p>R$ ${product.price}</p>
                <button onclick="editProduct(${product.id}, '${product.name}', '${product.description}', ${product.price}, '${product.image}')">Edit</button>
                <button onclick="deleteProduct(${product.id})">Delete</button>
            </div>
        `).join('');
    } else {
        alert('Error fetching products.');
    }
});

document.getElementById('add-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = document.getElementById('add-product-name').value;
    const description = document.getElementById('add-product-description').value;
    const price = document.getElementById('add-product-price').value;
    const image = document.getElementById('add-product-image').value;

    const response = await fetch('/product', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
        body: JSON.stringify({ name, description, price, image })
    });

    if (response.ok) {
        alert('Product added successfully!');
        window.location.reload();
    } else {
        alert('Error adding product.');
    }
});

const editProduct = (id, name, description, price, image) => {
    document.getElementById('edit-product-id').value = id;
    document.getElementById('edit-product-name').value = name;
    document.getElementById('edit-product-description').value = description;
    document.getElementById('edit-product-price').value = price;
    document.getElementById('edit-product-image').value = image;
    document.getElementById('edit-product-form').style.display = 'block';
};

document.getElementById('edit-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('edit-product-id').value;
    const name = document.getElementById('edit-product-name').value;
    const description = document.getElementById('edit-product-description').value;
    const price = document.getElementById('edit-product-price').value;
    const image = document.getElementById('edit-product-image').value;

    const response = await fetch(`/product/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
        body: JSON.stringify({ name, description, price, image })
    });

    if (response.ok) {
        alert('Product updated successfully!');
        window.location.reload();
    } else {
        alert('Error updating product.');
    }
});

const deleteProduct = async (id) => {
    const response = await fetch(`/product/${id}`, {
        method: 'DELETE',
        headers: {
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        }
    });

    if (response.ok) {
        alert('Product deleted successfully!');
        window.location.reload();
    } else {
        alert('Error deleting product.');
    }
};
