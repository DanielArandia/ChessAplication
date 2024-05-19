package com.Arquitectura.chess.model.logicaAjedrez;

import lombok.Getter;
import lombok.Setter;

public class Movimiento {

    @Setter
    @Getter
    private Integer fichaOrigen;
    @Setter
    @Getter
    private Integer FichaDestino;

    public Movimiento() {
        this.fichaOrigen = null;
        this.FichaDestino = null;
    }

}
