package com.personal;

import java.time.LocalDate;
import java.util.List;

public abstract class Automotor {
    //Atributos
    private String tipo;
    private NombreSeccional nombreSeccional;
    private Propietario propietario;
    private List<Autorizado> autorizados;
    private LocalDate fechaAltaAutomotor;
    private String patente="";
    private NombreUso nombreUso;
    private LocalDate fechaAltaPropietario;

    //Constructor

    public Automotor(NombreSeccional nombreSeccional, Propietario propietario, List<Autorizado> autorizados,
                     LocalDate fechaAltaAutomotor, NombreUso nombreUso,
                     LocalDate fechaAltaNuevoPropietario) {
        this.nombreSeccional = nombreSeccional;
        this.propietario = propietario;
        this.autorizados = autorizados;
        this.fechaAltaAutomotor = fechaAltaAutomotor;
        this.patente = patente;
        this.nombreUso = nombreUso;
        this.fechaAltaPropietario = fechaAltaNuevoPropietario;
    }


    // Getter & Setter


    public NombreSeccional getSeccional() {
        return nombreSeccional;
    }

    public void setSeccional(NombreSeccional nombreSeccional) {
        this.nombreSeccional = nombreSeccional;
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

    public NombreUso getUso() {
        return nombreUso;
    }

    public void setUso(NombreUso nombreUso) {
        this.nombreUso = nombreUso;
    }

    public LocalDate getFechaAltaPropietario() {
        return fechaAltaPropietario;
    }

    public void setFechaAltaPropietario(LocalDate fechaAltaPropietario) {
        this.fechaAltaPropietario = fechaAltaPropietario;
    }
}
