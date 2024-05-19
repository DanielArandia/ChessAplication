package com.Arquitectura.chess.model.logicaAjedrez;

import java.util.Map;

public class CrearDiccionario {

    public CrearDiccionario(Map<String, String> diccionario){

        diccionario.put("0", "Torre negra");
        diccionario.put("1", "Caballo negro");
        diccionario.put("2", "Alfil negro");
        diccionario.put("3", "Dama negra");
        diccionario.put("4", "Rey negro");
        diccionario.put("5", "Alfil negro");
        diccionario.put("6", "Caballo negro");
        diccionario.put("7", "Torre negra");
        diccionario.put("8", "Peon negro");
        diccionario.put("9", "Peon negro");
        diccionario.put("10", "Peon negro");
        diccionario.put("11", "Peon negro");
        diccionario.put("12", "Peon negro");
        diccionario.put("13", "Peon negro");
        diccionario.put("14", "Peon negro");
        diccionario.put("15", "Peon negro");
        for(int i = 16; i <= 47; i++ ){
            diccionario.put(""+i, "Casilla");
        }
        diccionario.put("48", "Peon blanco");
        diccionario.put("49", "Peon blanco");
        diccionario.put("50", "Peon blanco");
        diccionario.put("51", "Peon blanco");
        diccionario.put("52", "Peon blanco");
        diccionario.put("53", "Peon blanco");
        diccionario.put("54", "Peon blanco");
        diccionario.put("55", "Peon blanco");
        diccionario.put("56", "Torre blanca");
        diccionario.put("57", "Caballo blanco");
        diccionario.put("58", "Alfil blanco");
        diccionario.put("59", "Dama blanca");
        diccionario.put("60", "Rey blanco");
        diccionario.put("61", "Alfil blanco");
        diccionario.put("62", "Caballo blanco");
        diccionario.put("63", "Torre blanca");


    }
    public void crearPeones(Map<String, Boolean> diccionario){
        diccionario.put("8", false);
        diccionario.put("9", false);
        diccionario.put("10", false);
        diccionario.put("11", false);
        diccionario.put("12", false);
        diccionario.put("13", false);
        diccionario.put("14", false);
        diccionario.put("15", false);

        diccionario.put("48", false);
        diccionario.put("49", false);
        diccionario.put("50", false);
        diccionario.put("51", false);
        diccionario.put("52", false);
        diccionario.put("53", false);
        diccionario.put("54", false);
        diccionario.put("55", false);


    }
}

