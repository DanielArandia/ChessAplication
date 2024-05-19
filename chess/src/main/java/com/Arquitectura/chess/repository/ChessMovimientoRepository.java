package com.Arquitectura.chess.repository;


import com.Arquitectura.chess.model.ChessMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChessMovimientoRepository extends JpaRepository<ChessMovimiento, Integer> {
}
