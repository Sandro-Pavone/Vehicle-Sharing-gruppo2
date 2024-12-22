document.getElementById('loginForm').addEventListener('submit', async (event) => {
    event.preventDefault();
    
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('http://localhost:8080/api/auth/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password })
        });

        if (response.ok) {
            const data = await response.json();
            // Salva il token di autenticazione (se necessario)
            localStorage.setItem('authToken', data.token);
            alert('Login avvenuto con successo!');
            window.location.href = 'home.html'; // Reindirizza alla pagina principale
        } else {
            alert('Credenziali non valide. Riprova.');
        }
    } catch (error) {
        console.error('Errore durante il login:', error);
        alert('Si è verificato un errore. Riprova più tardi.');
    }
});