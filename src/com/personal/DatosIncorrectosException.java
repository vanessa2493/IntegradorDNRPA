package com.personal;

public class DatosIncorrectosException extends Exception{
    public DatosIncorrectosException(String mensajeError) {
        super(mensajeError);
    }
}
