// /project-root/views/js/register.js
const validateForm = () => {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if (!name || !email || !password) {
        alert('Todos os campos são obrigatórios.');
        return false;
    }

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        alert('Por favor, insira um email válido.');
        return false;
    }

    if (password.length < 6) {
        alert('A senha deve ter pelo menos 6 caracteres.');
        return false;
    }

    return true;
};

document.getElementById('register-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    if (!validateForm()) return;

    const userId = document.getElementById('user-id').value;
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const url = userId ? `/user/update/${userId}` : '/user/register';
    const method = userId ? 'PUT' : 'POST';

    const response = await fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, email, password })
    });

    if (response.ok) {
        alert(userId ? 'Usuário atualizado com sucesso!' : 'Usuário registrado com sucesso!');
        window.location.href = '/html/login.html';
    } else {
        alert('Erro ao processar a solicitação.');
    }
});

// Função para carregar dados do usuário no formulário para edição
const loadUserData = async () => {
    const userId = localStorage.getItem('userId');
    if (userId) {
        const response = await fetch(`/user/${userId}`);
        const user = await response.json();
        document.getElementById('user-id').value = user.id;
        document.getElementById('name').value = user.name;
        document.getElementById('email').value = user.email;
    }
};

document.addEventListener('DOMContentLoaded', loadUserData);
