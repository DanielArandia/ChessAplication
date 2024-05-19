package com.Arquitectura.chess.controler;

import com.Arquitectura.chess.ChessMovimientoService;
import com.Arquitectura.chess.model.ChessMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/chessMovimiento")
public class ChessMovimientoController {

    @Autowired
    ChessMovimientoService chessMovimientoService;

    @PostMapping
    public ChessMovimiento CreateMovimiento(ChessMovimiento chessMovimiento){
        return chessMovimientoService.crearMovimiento(chessMovimiento);
    }
    @GetMapping("{id}")
    public ChessMovimiento GetMovimientoById(@PathVariable Integer id){
        return chessMovimientoService.getMovimientoById(id);
    }

    @DeleteMapping("{id}")
    public void deleteMovimientoById(@PathVariable Integer id){
        chessMovimientoService.deleteMovimientoById(id);
    }

}
