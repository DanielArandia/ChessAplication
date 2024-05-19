package com.Arquitectura.chess.model.logicaAjedrez;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerificarJaque {


    Map<String, String> diccionario;
    ArrayList<Integer> jaquesB;
    ArrayList<Integer> jaquesN;
    String colorF;
    String colorM;
    String colorContrarioF;
    String colorContrarioM;
    /*
    BooleanAdapter fichaDiagonalIzqAr;
    BooleanAdapter fichaDiagonalDerAr;
    BooleanAdapter fichaDiagonalIzqAb;
    BooleanAdapter fichaDiagonalDerAb;
    BooleanAdapter fichaDerecha;
    BooleanAdapter fichaIzquierda;
    BooleanAdapter fichaArriba;
    BooleanAdapter fichaAbajo;
    */
    boolean fichaDiagonalIzqAr;
    boolean fichaDiagonalDerAr;
    boolean fichaDiagonalIzqAb;
    boolean fichaDiagonalDerAb;
    boolean fichaDerecha;
    boolean fichaIzquierda;
    boolean fichaArriba;
    boolean fichaAbajo;



    public VerificarJaque(Map<String, String> diccionario){

        this.diccionario = diccionario;

        jaquesB = new ArrayList<>();
        jaquesN = new ArrayList<>();
        /*
        fichaDiagonalIzqAr = new BooleanAdapter(false);
        fichaDiagonalDerAr = new BooleanAdapter(false);
        fichaDiagonalIzqAb = new BooleanAdapter(false);
        fichaDiagonalDerAb = new BooleanAdapter(false);
        fichaDerecha = new BooleanAdapter(false);
        fichaIzquierda = new BooleanAdapter(false);
        fichaArriba = new BooleanAdapter(false);
        fichaAbajo = new BooleanAdapter(false);
        */
        fichaDiagonalIzqAr = false;
        fichaDiagonalDerAr = false;
        fichaDiagonalIzqAb = false;
        fichaDiagonalDerAb = false;
        fichaDerecha = false;
        fichaIzquierda = false;
        fichaArriba = false;
        fichaAbajo = false;


    }

    public static <K, V> K getKey(Map<K, V> mapa, V valorBuscado) {
        for (Map.Entry<K, V> entry : mapa.entrySet()) {
            if (valorBuscado.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null; // Devuelve null si no se encuentra el valor
    }


    public void verificarJaqueN(){
        verificarJaque("negro", jaquesN);
    }
    public void verificarJaqueB(){
        verificarJaque("blanco", jaquesB);
    }
    public void verificarJaque(String color, ArrayList<Integer> jaques){

        ArrayList<Integer> nJaques = new ArrayList<>();



        if (color.equals("negro")) {
            colorF = "blanca";
            colorM = "blanco";
            colorContrarioF = "negra";
            colorContrarioM = "negro";
        }else if (color.equals("blanco")) {
            colorF = "negra";
            colorM = "negro";
            colorContrarioF = "blanca";
            colorContrarioM = "blanco";
        }

        String claveRey = getKey(diccionario, "Rey "+color);

        /*
        fichaDiagonalIzqAr.setValue(false);
        fichaDiagonalDerAr.setValue(false);
        fichaDiagonalIzqAb.setValue(false);
        fichaDiagonalDerAb.setValue(false);
        fichaDerecha.setValue(false);
        fichaIzquierda.setValue(false);
        fichaArriba.setValue(false);
        fichaAbajo.setValue(false);
        */
        fichaDiagonalIzqAr = false;
        fichaDiagonalDerAr = false;
        fichaDiagonalIzqAb = false;
        fichaDiagonalDerAb = false;
        fichaDerecha = false;
        fichaIzquierda = false;
        fichaArriba = false;
        fichaAbajo = false;

        int arriba = Integer.parseInt(claveRey) - 8;
        int abajo = Integer.parseInt(claveRey) + 8;
        int der = Integer.parseInt(claveRey) + 1;
        int izq = Integer.parseInt(claveRey) - 1;
        int diagonalIzqAr = Integer.parseInt(claveRey) - 9;
        int diagonalDerAr = Integer.parseInt(claveRey) - 7;
        int diagonalDerAb = Integer.parseInt(claveRey) + 9;
        int diagonalIzqAb = Integer.parseInt(claveRey) + 7;

        fichaDiagonalDerAr = agregarJaques(diagonalDerAr, "Peon "+colorM, fichaDiagonalDerAr, jaques,colorContrarioF, colorContrarioM);
        fichaDiagonalDerAr = agregarJaques(diagonalDerAr, "Rey "+colorM, fichaDiagonalDerAr, jaques,colorContrarioF, colorContrarioM);

        fichaDiagonalIzqAr = agregarJaques(diagonalIzqAr, "Peon "+colorM, fichaDiagonalIzqAr, jaques,colorContrarioF, colorContrarioM);
        fichaDiagonalIzqAr = agregarJaques(diagonalIzqAr, "Rey "+colorM, fichaDiagonalIzqAr, jaques,colorContrarioF, colorContrarioM);

        fichaArriba = agregarJaques(arriba, "Rey "+colorM, fichaArriba, jaques,colorContrarioF, colorContrarioM);

        fichaAbajo = agregarJaques(abajo, "Rey "+colorM, fichaAbajo, jaques,colorContrarioF, colorContrarioM);

        fichaDerecha = agregarJaques(der, "Rey "+colorM, fichaDerecha, jaques,colorContrarioF, colorContrarioM);

        fichaIzquierda = agregarJaques(izq, "Rey "+colorM, fichaIzquierda, jaques,colorContrarioF, colorContrarioM);

        fichaDiagonalDerAb = agregarJaques(diagonalDerAb, "Rey "+colorM, fichaDiagonalDerAb, jaques,colorContrarioF, colorContrarioM);

        fichaDiagonalIzqAb = agregarJaques(diagonalIzqAb, "Rey "+ colorM, fichaDiagonalIzqAb, jaques,colorContrarioF, colorContrarioM);

        for(int i = 0; i <= 8; i++){

            fichaDiagonalIzqAr = agregarJaques(diagonalIzqAr, "Dama "+ colorF, fichaDiagonalIzqAr, jaques,colorContrarioF, colorContrarioM);
            fichaDiagonalIzqAr = agregarJaques(diagonalIzqAr, "Alfil "+ colorM, fichaDiagonalIzqAr, jaques,colorContrarioF, colorContrarioM);

            fichaDiagonalIzqAb = agregarJaques(diagonalIzqAb, "Dama " + colorF, fichaDiagonalIzqAb, jaques,colorContrarioF, colorContrarioM);
            fichaDiagonalIzqAb = agregarJaques(diagonalIzqAb, "Alfil "+colorM, fichaDiagonalIzqAb, jaques,colorContrarioF, colorContrarioM);

            fichaDiagonalDerAb = agregarJaques(diagonalDerAb, "Dama "+colorF, fichaDiagonalDerAb, jaques,colorContrarioF, colorContrarioM);
            fichaDiagonalDerAb = agregarJaques(diagonalDerAb, "Alfil "+colorM, fichaDiagonalDerAb, jaques,colorContrarioF, colorContrarioM);

            fichaDiagonalDerAr = agregarJaques(diagonalDerAr, "Dama "+colorF, fichaDiagonalDerAr, jaques,colorContrarioF, colorContrarioM);
            fichaDiagonalDerAr = agregarJaques(diagonalDerAr, "Alfil "+ colorM, fichaDiagonalDerAr, jaques,colorContrarioF, colorContrarioM);

            fichaDerecha = agregarJaques(der, "Dama "+colorF, fichaDerecha, jaques,colorContrarioF, colorContrarioM);
            fichaDerecha = agregarJaques(der,  "Alfil "+ colorM, fichaDerecha, jaques,colorContrarioF, colorContrarioM);
            fichaDerecha = agregarJaques(der, "Torre "+colorF, fichaDerecha, jaques,colorContrarioF, colorContrarioM);

            fichaIzquierda = agregarJaques(izq, "Dama "+colorF, fichaIzquierda, jaques, colorContrarioF, colorContrarioM);
            fichaIzquierda = agregarJaques(izq,  "Alfil "+ colorM, fichaIzquierda, jaques, colorContrarioF, colorContrarioM);
            fichaIzquierda = agregarJaques(izq, "Torre "+colorF, fichaIzquierda, jaques, colorContrarioF, colorContrarioM);

            fichaArriba = agregarJaques(arriba, "Dama "+colorF, fichaArriba, jaques, colorContrarioF, colorContrarioM);
            fichaArriba = agregarJaques(arriba,  "Alfil "+ colorM, fichaArriba, jaques, colorContrarioF, colorContrarioM);
            fichaArriba = agregarJaques(arriba, "Torre "+colorF, fichaArriba, jaques, colorContrarioF, colorContrarioM);

            fichaAbajo = agregarJaques(abajo, "Dama "+colorF, fichaAbajo, jaques, colorContrarioF, colorContrarioM);
            fichaAbajo = agregarJaques(abajo,  "Alfil "+ colorM, fichaAbajo, jaques, colorContrarioF, colorContrarioM);
            fichaAbajo = agregarJaques(abajo, "Torre "+colorF, fichaAbajo, jaques, colorContrarioF, colorContrarioM);

            diagonalIzqAr -= 9;
            diagonalDerAr -= 7;
            diagonalDerAb += 9;
            diagonalIzqAb += 7;
            der += 1;
            izq -=1;
            arriba -= 8;
            abajo += 8;
        }

    }

    public boolean agregarJaques(int movimiento, String ficha, boolean fichaEncontrada, ArrayList<Integer> jaques, String colorF, String colorM){
        if(diccionario.containsKey(String.valueOf(movimiento)) && fichaEncontrada == false){
            if(diccionario.get(String.valueOf(movimiento)).matches(".*\\b("+colorF+"|"+colorM+")\\b$")){


                System.out.println("la siguiente ficha obstruye al rey: " + diccionario.get(String.valueOf(movimiento)));

                return true;
            }
            else /*if (diccionario.get(String.valueOf(movimiento)).matches(".*\\b(negra|negro)\\b$"))*/{

                System.out.println(diccionario.get(String.valueOf(movimiento)) + " Es diferente a "+ ficha + "?");
                if(diccionario.get(String.valueOf(movimiento)).equals(ficha)){
                    System.out.println("hay jaque por la ficha" + ficha);
                    jaques.add(movimiento);
                    return true;
                }
                else{
                    return false;
                }

            }


        }else{
            return true;
        }
    }
    public void reiniciarJaques(){
        jaquesB.clear();
        jaquesN.clear();
    }
    public boolean hayJaqueB(){
        if(jaquesB.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean hayJaqueN(){
        if(jaquesN.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean validaListaJaqueB(String valor){
        return jaquesB.contains(Integer.parseInt(valor));
    }
    public boolean validaListaJaqueN(String valor){
        return jaquesN.contains(Integer.parseInt(valor));
    }
}
