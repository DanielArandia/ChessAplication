package com.Arquitectura.chess.controler;

import com.Arquitectura.chess.ChessPartidaService;
import com.Arquitectura.chess.model.ChessPartida;
import com.Arquitectura.chess.model.logicaAjedrez.Movimiento;
import com.Arquitectura.chess.model.logicaAjedrez.Verificar_movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/chessPartida")
public class ChessPartidaController {

    ChessPartidaService chessPartidaService;
    Verificar_movimiento verificarMovimiento;

    public ChessPartidaController(ChessPartidaService chessPartidaService) {
        this.chessPartidaService = chessPartidaService;
        this.verificarMovimiento = new Verificar_movimiento(); // Creación directa en el constructor
    }

    @PostMapping
    public ChessPartida crearPartida(ChessPartida partida){
        return chessPartidaService.createPartida(partida);
    }

    @GetMapping("{id}")
    public void deletePartida(@PathVariable Integer id){
        chessPartidaService.deletePartida(id);
    }
    @DeleteMapping("{id}")
    public ChessPartida getPartidaById(@PathVariable Integer id){
        return chessPartidaService.getPartidaById(id);
    }

    @PostMapping ("/movimiento")
    public Movimiento agregarMovimiento(@RequestBody Integer movimiento){
        return verificarMovimiento.verificarMovimientos(String.valueOf(movimiento));
    }
    @PostMapping("/nuevaPartida")
    public void PartidaNueva(){
        this.verificarMovimiento = new Verificar_movimiento();
    }
}
