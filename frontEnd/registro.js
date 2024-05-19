document.getElementById('registroForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evitar que el formulario se envíe automáticamente
    
    // Obtener los valores de nombre de usuario y contraseña del formulario
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    // Objeto con los datos del usuario
    const usuarioDTO = {
        username: username,
        password: password
    };
    
    // Enviar los datos del usuario al backend para crear un nuevo usuario
    fetch('http://localhost:8080/api/users/crear', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuarioDTO)
    })
    .then(response => {
        if (response.ok) {
            alert('Usuario creado exitosamente');
            // Redirigir al usuario a la página de inicio de sesión
            window.location.href = 'login.html';
        } else {
            throw new Error('Error al crear usuario');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        // Manejar el error, por ejemplo, mostrar un mensaje de error genérico
        alert('Ha ocurrido un error al crear usuario');
    });
});
