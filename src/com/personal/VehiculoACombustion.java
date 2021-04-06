package com.personal;

public interface VehiculoACombustion {
    int combustible = 100;

    public default int indicarEnergiaDisponible(){
        System.out.println("La energia disponible es de: "+ combustible+"Lts");
        return combustible;
    }


}

