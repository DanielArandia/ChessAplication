package com.Arquitectura.chess.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chessMovimiento")
public class ChessMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer movimiento;
    @ManyToOne
    @JoinColumn(name = "partida_id")
    private ChessPartida chessPartida;

    public ChessPartida getChessPartida() {
        return chessPartida;
    }

    public void setChessPartida(ChessPartida chessPartida) {
        this.chessPartida = chessPartida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Integer movimiento) {
        this.movimiento = movimiento;
    }


}
