// chessGame.js
class ChessGame {
    constructor() {
      this.init();
    }
  
    init() {
      document.getElementById('newGameBtn').addEventListener('click', () => {
        this.startNewGame();
      });
    }
  
    startNewGame() {

        window.location.reload();

      fetch('http://localhost:8080/api/chessPartida/nuevaPartida', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({}) 
      })
      .then(response => {
        if (!response.ok) {
          throw new Error('Error en la solicitud');
        }
        return response.json();
      })
      .then(data => {
        console.log('Se creó una nueva partida:', data);
      })
      .catch(error => {
        console.error('Error al iniciar una nueva partida:', error);
      });
    }
  }
  
  const game = new ChessGame();
  