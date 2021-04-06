package com.personal;

public interface VehiculoElectrico {
    int energia =100;

    public default int indicarEnergiaDisponible(){
        System.out.println("La energia disponible es de: "+ energia+"%");
        return energia;
    }



}
