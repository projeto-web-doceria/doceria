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
            </div>
        `).join('');
    } else {
        alert('Error fetching products.');
    }
});
