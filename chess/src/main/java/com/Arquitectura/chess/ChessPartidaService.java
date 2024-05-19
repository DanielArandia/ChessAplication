package com.Arquitectura.chess;

import com.Arquitectura.chess.model.ChessPartida;
import com.Arquitectura.chess.model.User;
import com.Arquitectura.chess.repository.ChessPartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ChessPartidaService {

    @Autowired
    ChessPartidaRepository chessPartidaRepository;

    public ChessPartida createPartida(ChessPartida partida){
        return chessPartidaRepository.save(partida);
    }

    public ChessPartida getPartidaById(Integer id){
        Optional<ChessPartida> optionalChessPartida = chessPartidaRepository.findById(id);
        return optionalChessPartida.get();
    }

    public void deletePartida(Integer id){
        chessPartidaRepository.deleteById(id);
    }

}
