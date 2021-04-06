package com.personal;

import java.time.LocalDate;
import java.util.List;

public class Automovil extends Automotor implements VehiculoACombustion{
    public Automovil(Seccional seccional, Propietario propietario, List<Autorizado> autorizados, LocalDate fechaAltaAutomotor, Uso uso, LocalDate fechaAltaPropietario) {
        super(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario);
    }
}
