package com.personal;

public abstract class Persona {
    //Atributos
    private String nombre;
    private String dni;
    private String direccion;

    //Constructor

    public Persona(String nombre, String dni, String direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }


    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws DatosIncorrectosException{
        if(String.valueOf(dni).length()!=8){
            throw new DatosIncorrectosException("El DNI debe tener 8 dígitos");
        }else {
            this.dni = dni;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
