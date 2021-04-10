package com.personal;

import java.time.LocalDate;
import java.util.List;

public class Colectivo extends Automotor implements VehiculoACombustion{
    String tipo="Colectivo";
    public Colectivo(NombreSeccional nombreSeccional, Propietario propietario, List<Autorizado> autorizados, LocalDate fechaAltaAutomotor, NombreUso nombreUso, LocalDate fechaAltaPropietario) {
        super(nombreSeccional, propietario, autorizados, fechaAltaAutomotor, nombreUso, fechaAltaPropietario);
    }
}
