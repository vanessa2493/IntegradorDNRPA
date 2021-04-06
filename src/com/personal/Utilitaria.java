package com.personal;

import java.util.Random;

public class Utilitaria {
    Random objetoAleatorio = new Random();
    //Metodo para elegir caracteres aleatorios desde un string especificado
    public String elegirCaracteresAleatorios(String listaCaracteres, Integer cantidad) {
        String caracteres="";
        for (int i = 0; i < cantidad; i++) {
            char caracter = listaCaracteres.charAt(objetoAleatorio.nextInt(listaCaracteres.length()));
            caracteres += caracter;
        }
        return caracteres;
    }
}
