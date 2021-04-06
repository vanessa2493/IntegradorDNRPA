package com.personal;

import java.time.LocalDate;
import java.util.List;

public class MotoElectrica extends Automotor implements VehiculoElectrico{
    String tipo="MotoElectrica";
    public MotoElectrica(Seccional seccional, Propietario propietario, List<Autorizado> autorizados,
                         LocalDate fechaAltaAutomotor, Uso uso, LocalDate fechaAltaPropietario) {
        super(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario);
    }
}
