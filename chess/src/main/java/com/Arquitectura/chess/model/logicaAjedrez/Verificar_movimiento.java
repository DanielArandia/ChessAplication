package com.Arquitectura.chess.model.logicaAjedrez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.Arquitectura.chess.controler.ChessMovimientoController;


public class Verificar_movimiento {

    Map<String, String> diccionario;
    Map<String, Boolean> peones;
    boolean agarrandoB;
    boolean agarrandoN;
    String fichaSeleccionada;
    String numeroFichaSeleccionada;
    boolean turno1;
    ArrayList<Integer> nFichas;
    Integer nJugada;
    CrearDiccionario crearDiccionario;
    VerificarJaque verificarJaque;


    public Verificar_movimiento(){
        turno1 = true;
        agarrandoB = false;
        agarrandoN = false;
        nJugada = 0;
        nFichas = new ArrayList<>();
        diccionario = new HashMap<>();
        peones = new HashMap<>();
        crearDiccionario = new CrearDiccionario(diccionario);
        crearDiccionario.crearPeones(peones);
        verificarJaque = new VerificarJaque(diccionario);
    }

    public Movimiento verificarMovimientos(String pieza){
        Movimiento movimiento = new Movimiento();

        for (Map.Entry<String, String> entrada : diccionario.entrySet()) {

            if(pieza.equals(entrada.getKey())&& entrada.getValue().equals("Casilla")){

                movimiento = moverCasilla(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Caballo blanco")){

                movimiento = moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Peon blanco")){

                movimiento = moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Alfil blanco")){

                movimiento = moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey())  && entrada.getValue().equals("Rey blanco")){

                movimiento = moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Dama blanca")){

                movimiento = moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Torre blanca")){

                movimiento = moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Caballo negro")){

                movimiento = moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Peon negro")){

                movimiento = moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Alfil negro")){

                movimiento = moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Rey negro")){

                movimiento = moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Dama negra")){

                movimiento = moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Torre negra")){

                movimiento = moverFichaNegra(entrada.getKey(), entrada.getValue());
            }


        }
        return movimiento;
    }
    public Movimiento moverCasilla(String clave, String valor){

        Movimiento movimiento = new Movimiento();
        System.out.println("clave: "+ clave);
        for (Integer ficha : nFichas) {
        }


        // si esta agarrando una ficha blanca y da click en una casilla vacia
        if(agarrandoB == true && nFichas.contains(Integer.parseInt(clave))){


            verificarJaque.reiniciarJaques();
            verificarJaque.verificarJaqueB();
            if(verificarJaque.hayJaqueB() == false){

                if (peones.containsKey(numeroFichaSeleccionada)) {
                    if(fichaSeleccionada.equals("Peon blanco") && peones.get(numeroFichaSeleccionada) == false){

                        peones.remove(numeroFichaSeleccionada);
                        peones.put(clave, true);
                    }
                }

                diccionario.put(clave, fichaSeleccionada);
                diccionario.put(numeroFichaSeleccionada,"Casilla");

            }else{
                diccionario.put(clave, fichaSeleccionada);
                diccionario.put(numeroFichaSeleccionada,"Casilla");
            }

            verificarJaque.reiniciarJaques();
            verificarJaque.verificarJaqueB();

            if(verificarJaque.hayJaqueB() == true){
                diccionario.put(numeroFichaSeleccionada, fichaSeleccionada);
                diccionario.put(clave, "Casilla");

            }else{
                agarrandoB = false;
                turno1 = false;
                nJugada ++;
                nMovimiento(fichaSeleccionada, clave);
                //Movimiento movimiento = new Movimiento(Integer.parseInt(numeroFichaSeleccionada), Integer.parseInt(clave));
                //chessMovimientoController. (enviar peticion de que cambie la vista) con parametro  (numeroFichaSeleccionada, clave)
                movimiento.setFichaOrigen(Integer.parseInt(numeroFichaSeleccionada));
                movimiento.setFichaDestino(Integer.parseInt(clave));
            }

            verificarJaque.reiniciarJaques();


        }
        // si esta agarrando una ficha negra y da click en una casilla vacia
        if(agarrandoN == true && nFichas.contains(Integer.parseInt(clave))){

            verificarJaque.reiniciarJaques();
            verificarJaque.verificarJaqueN();
            if(verificarJaque.hayJaqueN() == false){

                if(peones.containsKey(numeroFichaSeleccionada)){
                    if(fichaSeleccionada.equals("Peon negro") && peones.get(numeroFichaSeleccionada) == false){
                        peones.remove(numeroFichaSeleccionada);
                        peones.put(clave, true);
                    }
                }

                diccionario.put(clave, fichaSeleccionada);
                diccionario.put(numeroFichaSeleccionada,"Casilla");
            }else{
                diccionario.put(clave, fichaSeleccionada);
                diccionario.put(numeroFichaSeleccionada,"Casilla");
            }

            verificarJaque.reiniciarJaques();
            verificarJaque.verificarJaqueN();

            if(verificarJaque.hayJaqueN() == true){
                diccionario.put(numeroFichaSeleccionada, fichaSeleccionada);
                diccionario.put(clave, "Casilla");

            }else{

                agarrandoN = false;
                turno1 = true;
                nJugada++;
                nMovimiento(fichaSeleccionada, clave);
                //chessMovimientoController. (enviar peticion de que cambie la vista) con parametro  (numeroFichaSeleccionada, clave)
                movimiento.setFichaOrigen(Integer.parseInt(numeroFichaSeleccionada));
                movimiento.setFichaDestino(Integer.parseInt(clave));
            }
            verificarJaque.reiniciarJaques();
        }
        return movimiento;
    }
    public Movimiento moverFichaBlanca(String clave, String valor){

        Movimiento movimiento = new Movimiento();
        //si da click en una ficha blanca, tiene agarrada una ficha blanca y es el turno del jugador blanco
        if(agarrandoB == true && turno1 == true){

            fichaSeleccionada = diccionario.get(clave);
            numeroFichaSeleccionada = clave;
            nMovimiento(valor, clave);

        }
        //si da click en una ficha blanca, no tiene agarrada una ficha blanca y es el turno del jugador blanco
        else if(agarrandoB == false && turno1 == true){
            fichaSeleccionada = diccionario.get(clave);
            numeroFichaSeleccionada = clave;
            agarrandoB = true;
            nMovimiento(valor, clave);
        }

        // si da click en una ficha blanca, tiene agarrada una ficha negra y es el turno del jugador negro
        else if(agarrandoN == true && turno1 == false && nFichas.contains(Integer.parseInt(clave))){

            //chessMovimientoController. (enviar peticion de que cambie la vista) con parametro  (numeroFichaSeleccionada, clave)
            diccionario.put(clave, fichaSeleccionada);
            diccionario.put(numeroFichaSeleccionada, "Casilla");
            agarrandoN = false;
            turno1 = true;
            movimiento.setFichaOrigen(Integer.parseInt(numeroFichaSeleccionada));
            movimiento.setFichaDestino(Integer.parseInt(clave));

        }

        return movimiento;
    }
    public Movimiento moverFichaNegra(String clave, String valor){

        Movimiento movimiento = new Movimiento();
        //si da click en una ficha negra, tiene agarrada una ficha negra y es el turno del jugador de las negras
        if(agarrandoN == true && turno1 == false){
            fichaSeleccionada = diccionario.get(clave);
            numeroFichaSeleccionada = clave;
            nMovimiento(valor, clave);
        }
        //si da click en una ficha negra, no tiene agarrada una ficha negra y es el turno del jugador de las negras
        else if(agarrandoN == false && turno1 == false){

            fichaSeleccionada = diccionario.get(clave);
            numeroFichaSeleccionada = clave;
            agarrandoN = true;
            nMovimiento(valor, clave);

            //si da click en una ficha negra, tiene agarrada una ficha blanca y es el turno de las blancas
        }
        else if(agarrandoB == true && turno1 == true && nFichas.contains(Integer.parseInt(clave))){


            diccionario.put(clave, fichaSeleccionada);
            diccionario.put(numeroFichaSeleccionada, "Casilla");
            agarrandoB = false;
            turno1 = false;
            //chessMovimientoController. (enviar peticion de que cambie la vista) con parametro  (numeroFichaSeleccionada, clave)
            movimiento.setFichaOrigen(Integer.parseInt(numeroFichaSeleccionada));
            movimiento.setFichaDestino(Integer.parseInt(clave));
        }
        return movimiento;
    }
    public ArrayList<Integer> nMovimiento(String value, String clave){

        nFichas.clear();

        if(value.equals("Caballo blanco") || value.equals("Caballo negro")){

            if( (Integer.parseInt(clave) + 6) < 65 && (Integer.parseInt(clave) + 6) > 0){
                nFichas.add(Integer.parseInt(clave) + 6);
            }
            if( (Integer.parseInt(clave) + 10) < 65 && (Integer.parseInt(clave)) + 10 > 0){
                nFichas.add(Integer.parseInt(clave) + 10);
            }
            if( (Integer.parseInt(clave) + 17) < 65 && (Integer.parseInt(clave) + 17) > 0){
                nFichas.add(Integer.parseInt(clave) + 17);
            }
            if( (Integer.parseInt(clave) + 15) < 65 && (Integer.parseInt(clave) + 15) > 0){
                nFichas.add(Integer.parseInt(clave) + 15);
            }
            if( (Integer.parseInt(clave) - 10) < 65 && (Integer.parseInt(clave) - 10) > 0){
                nFichas.add(Integer.parseInt(clave) - 10);
            }
            if( (Integer.parseInt(clave) - 6) < 65 && (Integer.parseInt(clave) - 6) > 0){
                nFichas.add(Integer.parseInt(clave) - 6);
            }
            if( (Integer.parseInt(clave) - 15) < 65 && (Integer.parseInt(clave) - 15) > 0){
                nFichas.add(Integer.parseInt(clave) - 15);
            }
            if( (Integer.parseInt(clave) - 17) < 64 && (Integer.parseInt(clave) - 17) > 0){
                nFichas.add(Integer.parseInt(clave) - 17);
            }
        }

        else if((value.equals("Rey blanco")) || (value.equals("Rey negro"))){

            if( (Integer.parseInt(clave) + 1) < 64 && (Integer.parseInt(clave) + 1) > 0){
                nFichas.add(Integer.parseInt(clave) + 1);
            }
            if( (Integer.parseInt(clave) + 7) < 64 && (Integer.parseInt(clave) + 7) > 0){
                nFichas.add(Integer.parseInt(clave) + 7);
            }
            if( (Integer.parseInt(clave) + 8) < 64 && (Integer.parseInt(clave) + 8) > 0){
                nFichas.add(Integer.parseInt(clave) + 8);
            }
            if( (Integer.parseInt(clave) + 9) < 64 && (Integer.parseInt(clave) + 9) > 0){
                nFichas.add(Integer.parseInt(clave) + 9);
            }
            if( (Integer.parseInt(clave) - 1) < 64 && (Integer.parseInt(clave) - 1) > 0){
                nFichas.add(Integer.parseInt(clave) - 1);
            }
            if( (Integer.parseInt(clave) - 7) < 64 && (Integer.parseInt(clave) - 7) > 0){
                nFichas.add(Integer.parseInt(clave) - 7);
            }
            if( (Integer.parseInt(clave) - 8) < 64 && (Integer.parseInt(clave) - 8) > 0){
                nFichas.add(Integer.parseInt(clave) - 8);
            }
            if( (Integer.parseInt(clave) - 9) < 64 && (Integer.parseInt(clave) - 9) > 0){
                nFichas.add(Integer.parseInt(clave) - 9);
            }

        }
        else if(value.equals("Peon blanco") || value.equals("Peon negro")){
            boolean contiene;

            contiene = peones.containsKey(clave);

            if(value.equals("Peon blanco")){
                if(contiene){
                    if(peones.get(clave) == false && contiene){
                        nFichas.add(Integer.parseInt(clave)- 16);
                    }
                }

                if( (Integer.parseInt(clave) - 8) < 64 && (Integer.parseInt(clave) -8) > 0 && diccionario.get(""+(Integer.parseInt(clave) - 8)).equals("Casilla")){
                    nFichas.add(Integer.parseInt(clave) -8);
                }
                if(diccionario.get(""+(Integer.parseInt(clave) - 7)).matches(".*\\b(negro|negra)")){
                    nFichas.add(Integer.parseInt(clave) -7);
                }
                if(diccionario.get(""+(Integer.parseInt(clave) - 9)).matches(".*\\b(negro|negra)")){
                    nFichas.add(Integer.parseInt(clave) -9);
                }
            }
            if(value.equals("Peon negro")){
                if(contiene){
                    if(peones.get(clave) == false){
                        nFichas.add(Integer.parseInt(clave) + 16);
                    }
                }

                if( (Integer.parseInt(clave) + 8) < 64 && (Integer.parseInt(clave) +8) > 0 && diccionario.get(""+(Integer.parseInt(clave) + 8)).equals("Casilla")){
                    nFichas.add(Integer.parseInt(clave) +8);
                }
                if(diccionario.get(""+(Integer.parseInt(clave) + 7)).matches(".*\\b(blanco|blanca)")){
                    nFichas.add(Integer.parseInt(clave) +7);
                }
                if(diccionario.get(""+(Integer.parseInt(clave) + 9)).matches(".*\\b(blanco|blanca)")){
                    nFichas.add(Integer.parseInt(clave) +9);
                }
            }


        }

        else if(value.equals("Alfil blanco")||value.equals("Alfil negro")){
            for (int i = Integer.parseInt(clave) + 7 ; i < 64; i +=7) {
                if(!(diccionario.get(""+ (i)).equals("Casilla"))){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }

            }
            for (int i = Integer.parseInt(clave) + 9; i < 64; i += 9) {
                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }
            }
            for (int i = Integer.parseInt(clave) - 7; i >= 0; i -=7) {
                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);

                    i = -1;
                }
                else{
                    nFichas.add(i);
                }

            }
            for (int i = Integer.parseInt(clave) - 9; i >= 0; i -=9) {

                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }
            }
        }

        else if(value.equals("Torre blanca")|| value.equals("Torre negra")){
            for(int i = Integer.parseInt(clave); i < 64 ; i++){


                if(((!diccionario.get(""+ (i)).equals("Casilla")) && Integer.parseInt(clave) != i) || (i % 8 == 7)){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave); i >= 0 ; i--){

                if(((!diccionario.get(""+ (i)).equals("Casilla")) && Integer.parseInt(clave) != i)|| (i % 8 == 0)){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave)+8; i < 64 ; i +=8){

                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave)- 8; i >= 0 ; i -=8){

                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }

            }

        }
        else if(value.equals("Dama blanca") || value.equals("Dama negra")){
            for (int i = Integer.parseInt(clave) + 7 ; i < 64; i +=7) {
                if(!(diccionario.get(""+ (i)).equals("Casilla"))){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }

            }
            for (int i = Integer.parseInt(clave) + 9; i < 64; i += 9) {
                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }
            }
            for (int i = Integer.parseInt(clave) - 7; i >= 0; i -=7) {
                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);

                    i = -1;
                }
                else{
                    nFichas.add(i);
                }

            }
            for (int i = Integer.parseInt(clave) - 9; i >= 0; i -=9) {

                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }
            }
            for(int i = Integer.parseInt(clave); i < 64 ; i++){


                if(((!diccionario.get(""+ (i)).equals("Casilla")) && Integer.parseInt(clave) != i) || (i % 8 == 7)){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave); i >= 0 ; i--){

                if(((!diccionario.get(""+ (i)).equals("Casilla")) && Integer.parseInt(clave) != i)|| (i % 8 == 0)){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave)+8; i < 64 ; i +=8){

                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave)- 8; i >= 0 ; i -=8){

                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }

            }
        }
        return nFichas;

    }


}

