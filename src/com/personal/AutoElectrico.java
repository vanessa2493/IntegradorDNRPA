package com.personal;

import java.time.LocalDate;
import java.util.List;

public class AutoElectrico extends Automotor implements VehiculoElectrico{
    String tipo = "AutoElectrico";
    public AutoElectrico(Seccional seccional, Propietario propietario, List<Autorizado> autorizados, LocalDate fechaAltaAutomotor, Uso uso, LocalDate fechaAltaPropietario) {
        super(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario);
    }


}
