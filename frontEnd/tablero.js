class Tablero{

    constructor(){

      this.iconoPeonN = "Imagenes/Ficha PeonNegra.png";
      this.iconoAlfilN = "Imagenes/AlfilNegro.png";
      this.iconoTorreN = "Imagenes/TorreNegra.png";
      this.iconoDamaN = "Imagenes/ReinaNegra.png";
      this.iconoReyN = "Imagenes/ReyNegro.png";
      this.iconoCaballoN = "Imagenes/CaballoNegro.png";
      this.iconoPeon = "Imagenes/Ficha Peon.png";
      this.iconoAlfil = "Imagenes/Alfil.png";
      this.iconoTorre = "Imagenes/Torre.png";
      this.iconoDama = "Imagenes/Reina.png";
      this.iconoRey = "Imagenes/Rey.png";
      this.iconoCaballo = "Imagenes/Caballo.png";
      this.botones = [];

        
        
    }
     // Lista para almacenar los botones

    createChessboard() {
        const board = document.getElementById('board');
        let isWhite = true;
        const botonId = 0;
      
        for (let i = 1; i <= 8; i++) {
          for (let j = 1; j <= 8; j++) {
            const button = document.createElement('button');
            const position = String.fromCharCode(96 + j) + i;
      
            button.id = position;
            button.style.width = '80px';
            button.style.height = '80px';
      
            if (isWhite) {
              button.classList.add('white');
            } else {
              button.classList.add('black');
            }
      
            this.setPieceImage(button, position);
      
            board.appendChild(button);
      
            // Agregar el botón a la lista
            this.botones.push(button);
      
            isWhite = !isWhite;
          }
          isWhite = !isWhite;
        }
      
        return this.botones; // Devolver la lista de botones
      }

    setPieceImage(button, position) {
      let icono = null;
      switch (position) {
        case "a7":
        case "b7":
        case "c7":
        case "d7":
        case "e7":
        case "f7":
        case "g7":
        case "h7":
            icono = this.iconoPeon;
        break;
        case "c8":
        case "f8":
            icono = this.iconoAlfil;
        break;
        case "a8":
        case "h8":
            icono = this.iconoTorre;
        break;
        case "b8":
        case "g8":
            icono = this.iconoCaballo;
        break;
        case "e8":
            icono = this.iconoRey;
        break;
        case "d8":
            icono = this.iconoDama;
        break;

        case "a2":
        case "b2":
        case "c2":
        case "d2":
        case "e2":
        case "f2":
        case "g2":
        case "h2":
            icono = this.iconoPeonN;
        break;
        case "c1":
        case "f1":
            icono = this.iconoAlfilN;
        break;
        case "a1":
        case "h1":
            icono = this.iconoTorreN;
        break;
        case "b1":
        case "g1":
            icono = this.iconoCaballoN;
        break;
        case "e1":
            icono = this.iconoReyN;
        break;
        case "d1":
            icono = this.iconoDamaN;
        break;
        
        default:
          icono = "";
          break;
      }
      if (icono) {
        const img = document.createElement('img');
        img.src = icono;
        img.style.width = '100%';
        img.style.height = '100%';
        button.appendChild(img);
      }
    }

    enviarNumeroAPI(numero) {
      // Crear un objeto con el número a enviar
      const data = { numero: numero };
  
      fetch('http://localhost:8080/api/chessPartida/movimiento', {
          method: 'POST',
          body: JSON.stringify(numero),
          headers: {
              'Content-Type': 'application/json'
          }
      })
      .then(response => response.json())
      .then(data => {
          // Verificar si los datos de fichaOrigen y fichaDestino no son nulos
          if (data.fichaOrigen !== null && data.fichaDestino !== null) {
              // Si los datos no son nulos, llamar a la función movePiece()
              this.movePiece(data.fichaOrigen, data.fichaDestino);
          }
      })
      .catch(error => {
          console.error('Error:', error);
      });
  
     
  }


  movePiece(origen, destino) {
    // Obtener los botones de origen y destino según sus índices en la lista
    const botonOrigen = this.botones[origen];
    const botonDestino = this.botones[destino];

    // Obtener la imagen del botón de origen y clonarla
    const imgOrigen = botonOrigen.querySelector('img');
    if (imgOrigen) {
        // Clonar la imagen para evitar eliminarla del botón de origen
        const imgNuevaDestino = imgOrigen.cloneNode(true);

        // Limpiar el contenido del botón de origen (imagen y número)
        botonOrigen.innerHTML = '';

        // Obtener el color de fondo actual del botón de origen
        const colorFondoOrigen = botonOrigen.classList.contains('white') ? 'white' : 'black';

        // Obtener el color de fondo actual del botón de destino
        const colorFondoDestino = botonDestino.classList.contains('white') ? 'white' : 'black';

        // Limpiar el contenido del botón de destino antes de agregar la nueva imagen
        botonDestino.innerHTML = '';

        // Mantener el mismo color de fondo para el botón de destino
        botonDestino.classList.add(colorFondoDestino);

        // Agregar la imagen clonada al botón de destino
        botonDestino.appendChild(imgNuevaDestino);

        // Establecer estilos CSS para centrar la imagen dentro del botón de destino
        botonDestino.style.display = 'flex';
        botonDestino.style.justifyContent = 'center';
        botonDestino.style.alignItems = 'center';

        // Establecer un tamaño máximo para la imagen para que no se vea más grande que los otros botones
        imgNuevaDestino.style.maxWidth = '120%';
        imgNuevaDestino.style.maxHeight = '110%';

        // Actualizar la referencia de la imagen en la lista de botones
        botonDestino.querySelector('img').src = imgOrigen.src;

        // Restaurar el color de fondo del botón de origen
        botonOrigen.classList.add(colorFondoOrigen);
    }
}


}

const tablero = new Tablero();
tablero.createChessboard();

tablero.botones.forEach(boton => {
  boton.addEventListener('click', () => {
    const numero = tablero.botones.indexOf(boton);
    console.log(numero);

    tablero.enviarNumeroAPI(numero);
  });
});




