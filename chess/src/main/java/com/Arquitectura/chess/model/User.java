package com.Arquitectura.chess.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<ChessPartida> chessPartida;

    public User(){

    }

    public User(String usuario, String contraseña, List<ChessPartida> chessPartida) {
        this.username = usuario;
        this.password = contraseña;
        this.chessPartida = chessPartida;
    }

    public User(String usuario, String contraseña) {
        this.username = usuario;
        this.password = contraseña;
    }

    public List<ChessPartida> getChessPartida() {
        return chessPartida;
    }

    public void setChessPartida(List<ChessPartida> chessPartida) {
        this.chessPartida = chessPartida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return username;
    }

    public void setUsuario(String usuario) {
        this.username = usuario;
    }

    public String getContraseña() {
        return password;
    }

    public void setContraseña(String contraseña) {
        this.password = contraseña;
    }

}
