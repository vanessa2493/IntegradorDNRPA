package com.personal;

import java.time.LocalDate;
import java.util.List;

public abstract class Automotor {
    //Atributos
    private String tipo;
    private Seccional seccional;
    private Propietario propietario;
    private List<Autorizado> autorizados;
    private LocalDate fechaAltaAutomotor;
    private String patente="";
    private Uso uso;
    private LocalDate fechaAltaPropietario;

    //Constructor

    public Automotor(Seccional seccional, Propietario propietario, List<Autorizado> autorizados,
                     LocalDate fechaAltaAutomotor, Uso uso,
                     LocalDate fechaAltaNuevoPropietario) {
        this.seccional = seccional;
        this.propietario = propietario;
        this.autorizados = autorizados;
        this.fechaAltaAutomotor = fechaAltaAutomotor;
        this.patente = patente;
        this.uso = uso;
        this.fechaAltaPropietario = fechaAltaNuevoPropietario;
    }


    // Getter & Setter


    public Seccional getSeccional() {
        return seccional;
    }

    public void setSeccional(Seccional seccional) {
        this.seccional = seccional;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public List<Autorizado> getAutorizados() {
        return autorizados;
    }

    public void setAutorizados(List<Autorizado> autorizados) {
        this.autorizados = autorizados;
    }

    public LocalDate getFechaAltaAutomotor() {
        return fechaAltaAutomotor;
    }

    public void setFechaAltaAutomotor(LocalDate fechaAltaAutomotor) {
        this.fechaAltaAutomotor = fechaAltaAutomotor;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Uso getUso() {
        return uso;
    }

    public void setUso(Uso uso) {
        this.uso = uso;
    }

    public LocalDate getFechaAltaPropietario() {
        return fechaAltaPropietario;
    }

    public void setFechaAltaPropietario(LocalDate fechaAltaPropietario) {
        this.fechaAltaPropietario = fechaAltaPropietario;
    }
}
