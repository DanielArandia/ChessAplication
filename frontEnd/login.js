document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evitar que el formulario se envíe automáticamente
    
    // Obtener los valores de nombre de usuario y contraseña del formulario
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    // Objeto con los datos del usuario
    const usuarioDTO = {
      username: username,
      password: password
    };
    
    // Enviar los datos del usuario al backend para iniciar sesión
    fetch('http://localhost:8080/api/users/verificarUsuarios', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(usuarioDTO)
    })
    .then(response => response.json())
    .then(data => {
      // Verificar la respuesta del backend
      if (data === true) {
        // Si la respuesta es true, redireccionar a la vista tablero.html
        window.location.href = 'tablero.html';
      } else {
        // Si la respuesta es false, mostrar un mensaje de error
        alert('Usuario o contraseña incorrectos');
      }
    })
    .catch(error => {
      console.error('Error:', error);
      // Manejar el error, por ejemplo, mostrar un mensaje de error genérico
      alert('Ha ocurrido un error al iniciar sesión');
    });
  });

  document.getElementById('crearUsuario').addEventListener('click', function(event) {
    // Redireccionar al archivo registro.html
    window.location.href = 'registro.html';
});
  
  /*document.getElementById('crearUsuario').addEventListener('click', function(event) {
    // Enviar una solicitud POST al backend para crear un usuario
    fetch('http://localhost:8080/api/users/crear', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({}) // Cuerpo vacío, ya que el usuario se crea en el backend
    })
    .then(response => {
      if (response.ok) {
        alert('Usuario creado exitosamente');
      } else {
        throw new Error('Error al crear usuario');
      }
    })
    .catch(error => {
      console.error('Error:', error);
      // Manejar el error, por ejemplo, mostrar un mensaje de error genérico
      alert('Ha ocurrido un error al crear usuario');
    });
  });*/
  