package com.Arquitectura.chess;

import com.Arquitectura.chess.model.ChessMovimiento;
import com.Arquitectura.chess.model.ChessPartida;
import com.Arquitectura.chess.repository.ChessMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChessMovimientoService {

    @Autowired
    private ChessMovimientoRepository chessMovimientoRepository;

    public ChessMovimiento crearMovimiento(ChessMovimiento movimiento){
        return chessMovimientoRepository.save(movimiento);
    }

    public ChessMovimiento getMovimientoById(Integer id){
        Optional<ChessMovimiento> optionalChessMovimiento = chessMovimientoRepository.findById(id);
        return optionalChessMovimiento.get();
    }

    public void deleteMovimientoById(Integer id){
        chessMovimientoRepository.deleteById(id);
    }

}
