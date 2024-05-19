package com.Arquitectura.chess.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chessPartida")
public class ChessPartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "chessPartida")
    private List<ChessMovimiento> chessMovimientos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ChessMovimiento> getChessMovimientos() {
        return chessMovimientos;
    }

    public void setChessMovimientos(List<ChessMovimiento> chessMovimientos) {
        this.chessMovimientos = chessMovimientos;
    }
}
