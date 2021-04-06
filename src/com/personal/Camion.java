package com.personal;

import java.time.LocalDate;
import java.util.List;

public class Camion extends Automotor implements VehiculoACombustion{
    String tipo = "Camion";
    public Camion(Seccional seccional, Propietario propietario, List<Autorizado> autorizados, LocalDate fechaAltaAutomotor, Uso uso, LocalDate fechaAltaPropietario) {
        super(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario);
    }
}
