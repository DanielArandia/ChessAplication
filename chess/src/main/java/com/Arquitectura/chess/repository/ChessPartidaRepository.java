package com.Arquitectura.chess.repository;

import com.Arquitectura.chess.model.ChessPartida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChessPartidaRepository extends JpaRepository<ChessPartida, Integer> {
}
