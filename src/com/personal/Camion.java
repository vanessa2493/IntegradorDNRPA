package com.personal;

import java.time.LocalDate;
import java.util.List;

public class Camion extends Automotor implements VehiculoACombustion{
    String tipo = "Camion";
    public Camion(NombreSeccional nombreSeccional, Propietario propietario, List<Autorizado> autorizados, LocalDate fechaAltaAutomotor, NombreUso nombreUso, LocalDate fechaAltaPropietario) {
        super(nombreSeccional, propietario, autorizados, fechaAltaAutomotor, nombreUso, fechaAltaPropietario);
    }
}
