package com.personal;

import java.time.LocalDate;
import java.util.List;

public class AutoElectrico extends Automotor implements VehiculoElectrico{
    String tipo = "AutoElectrico";
    public AutoElectrico(NombreSeccional nombreSeccional, Propietario propietario, List<Autorizado> autorizados, LocalDate fechaAltaAutomotor, NombreUso nombreUso, LocalDate fechaAltaPropietario) {
        super(nombreSeccional, propietario, autorizados, fechaAltaAutomotor, nombreUso, fechaAltaPropietario);
    }


}
