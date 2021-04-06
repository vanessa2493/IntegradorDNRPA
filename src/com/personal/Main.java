package com.personal;

import java.time.LocalDate;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Registro r = new Registro();

    // Fecha de Alta
        LocalDate fechaAltaAutomotor = LocalDate.of(2021, 03, 18);
        LocalDate fechaAltaNuevoPropietario = LocalDate.of(2021, 03, 18);
    // Propietarios
        Propietario prop1 = new Propietario("Vanessa Neira", "98765445", "Av Siempre Viva 15");
        Propietario prop2 = new Propietario("Pancho Villa", "89764523", "Av Siempre Viva 16");
        Propietario prop3 = new Propietario("Billy Elliot", "56347856", "Av Siempre Viva 17");
        Propietario prop4 = new Propietario("Ed Sheeran", "09764523", "Av Siempre Viva 18");
        Propietario prop5 = new Propietario("Katy Perry", "89563212", "Av Siempre Viva 19");
        Propietario prop6 = new Propietario("Bruno Mars", "89237645", "Av Siempre Viva 20");
        Propietario prop7 = new Propietario("Charlie Puth", "12897634", "Av Siempre Viva 20");
    // Autorizados
        Autorizado autor1 = new Autorizado("Nirvana", "09237834", "Av Siempre Viva 15");
        Autorizado autor2 = new Autorizado("Pearl Jam", "78235609", "Av Siempre Viva 16");
        Autorizado autor3 = new Autorizado("Alice In Chains", "12893476", "Av Siempre Viva 17");
        Autorizado autor4 = new Autorizado("Stone Temple Pilots", "89347645", "Av Siempre Viva 18");
        Autorizado autor5 = new Autorizado("Soundgarden", "34782376", "Av Siempre Viva 19");
        Autorizado autor6 = new Autorizado("Mad Season", "3482309", "Av Siempre Viva 20");
        Autorizado autor7 = new Autorizado("Skin Yard", "34789230", "Av Siempre Viva 20");

        List<Autorizado> autorizados1 = new ArrayList<>();
        autorizados1.add(autor1);
        autorizados1.add(autor2);

        List<Autorizado> autorizados2 = new ArrayList<>();
        autorizados2.add(autor3);
        autorizados2.add(autor4);
        autorizados2.add(autor5);

    // Creacion de automotores
        MotoElectrica me = new MotoElectrica(Seccional.TIERRA_DEL_FUEGO, prop1, autorizados1, fechaAltaAutomotor, Uso.PARTICULAR, fechaAltaNuevoPropietario);
        AutoElectrico ae = new AutoElectrico(Seccional.BUENOS_AIRES, prop2, autorizados2, fechaAltaAutomotor, Uso.PARTICULAR, fechaAltaNuevoPropietario);
        Motocicleta  mc = new Motocicleta(Seccional.CORRIENTES, prop3, autorizados1, fechaAltaAutomotor, Uso.PARTICULAR, fechaAltaNuevoPropietario);
        Automovil  ac = new Automovil(Seccional.CHACO, prop4, autorizados2, fechaAltaAutomotor, Uso.PARTICULAR, fechaAltaNuevoPropietario);
        Colectivo  coc = new Colectivo(Seccional.RIO_NEGRO, prop5, autorizados1, fechaAltaAutomotor, Uso.PARTICULAR, fechaAltaNuevoPropietario);
        Utilitario  uc = new Utilitario(Seccional.SALTA, prop6, autorizados2, fechaAltaAutomotor, Uso.PARTICULAR, fechaAltaNuevoPropietario);
        Camion  cac = new Camion(Seccional.SAN_JUAN, prop7, autorizados1, fechaAltaAutomotor, Uso.PARTICULAR, fechaAltaNuevoPropietario);


    // Metodos
        r.registrarAutomotor(me);
        r.registrarAutomotor(ae);
        r.registrarAutomotor(mc);
        r.registrarAutomotor(ac);
        r.registrarAutomotor(coc);
        r.registrarAutomotor(uc);
        r.registrarAutomotor(cac);

        r.getAutomotores();

        ae.indicarEnergiaDisponible();
        me.indicarEnergiaDisponible();

        r.generarPatente();
        r.listarPropietarios("AutoElectrico");
        r.listarTipoAutomotor();

        r.cambiarPropietario("VJW550", prop2, LocalDate.of(2021, 03, 28));
        r.getAutomotores();



        //Menú de opciones
        Scanner sc = new Scanner(System.in);
        int op = 0;
        System.out.println("Bienvenido al Registros de la Propiedad Automotor");
        do{
            System.out.println("Elija una opción: ");
            System.out.println("1. Mostrar automotores registrados");
            System.out.println("2. Buscar propietarios");
            System.out.println("3. Agregar nuevo automotor");
            System.out.println("4. Cambiar el propietario de un automotor");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1: r.getAutomotores();break;
                case 2:
                    {
                    System.out.println("Elige un tipo de automotor de la lista: ");
                    List<String> tipoAutomotor=r.listarTipoAutomotor();
                    System.out.print("Opción: ");
                    op = Integer.parseInt(sc.nextLine());
                    String tipo=tipoAutomotor.get(op-1);
                    r.listarPropietarios(tipo);
                }break;
                case 3: r.agregarNuevoAutomotor(); break;
                case 4: {

                    r.cambiarPropietario();
                }break;
            }
        }while(op!=0);
    }
}
