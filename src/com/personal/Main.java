//Vanessa Neira

package com.personal;

import java.time.LocalDate;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Registro r = new Registro();

    // Fecha de Alta
        //Automotor
        LocalDate fechaAltaAutomotor1 = LocalDate.of(2021, 02, 18);
        LocalDate fechaAltaAutomotor2 = LocalDate.of(2020, 12, 20);
        LocalDate fechaAltaAutomotor3 = LocalDate.of(2019, 04, 05);
        LocalDate fechaAltaAutomotor4 = LocalDate.of(2018, 03, 18);
        LocalDate fechaAltaAutomotor5 = LocalDate.of(2018, 03, 16);
        LocalDate fechaAltaAutomotor6 = LocalDate.of(1993, 11, 30);

        //Propietario
        LocalDate fechaAltaNuevoPropietario1 = LocalDate.of(2020, 03, 18);
        LocalDate fechaAltaNuevoPropietario2 = LocalDate.of(2020, 04, 18);
        LocalDate fechaAltaNuevoPropietario3 = LocalDate.of(2021, 05, 18);
        LocalDate fechaAltaNuevoPropietario4 = LocalDate.of(2021, 06, 18);
        LocalDate fechaAltaNuevoPropietario5 = LocalDate.of(2019, 10, 18);
        LocalDate fechaAltaNuevoPropietario6 = LocalDate.of(2019, 12, 18);


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
        MotoElectrica me = new MotoElectrica(NombreSeccional.TIERRA_DEL_FUEGO, prop1, autorizados1, fechaAltaAutomotor1, NombreUso.PARTICULAR, fechaAltaNuevoPropietario1);
        AutoElectrico ae = new AutoElectrico(NombreSeccional.BUENOS_AIRES, prop2, autorizados2, fechaAltaAutomotor2, NombreUso.PARTICULAR, fechaAltaNuevoPropietario2);
        Motocicleta  mc = new Motocicleta(NombreSeccional.CORRIENTES, prop3, autorizados1, fechaAltaAutomotor3, NombreUso.PARTICULAR, fechaAltaNuevoPropietario3);
        Automovil  ac = new Automovil(NombreSeccional.CHACO, prop4, autorizados2, fechaAltaAutomotor4, NombreUso.PARTICULAR, fechaAltaNuevoPropietario4);
        Colectivo  coc = new Colectivo(NombreSeccional.RIO_NEGRO, prop5, autorizados1, fechaAltaAutomotor5, NombreUso.PARTICULAR, fechaAltaNuevoPropietario5);
        Utilitario  uc = new Utilitario(NombreSeccional.SALTA, prop6, autorizados2, fechaAltaAutomotor5, NombreUso.PARTICULAR, fechaAltaNuevoPropietario5);
        Camion  cac = new Camion(NombreSeccional.SAN_JUAN, prop7, autorizados1, fechaAltaAutomotor6, NombreUso.PARTICULAR, fechaAltaNuevoPropietario6);


    // Metodos
        r.registrarAutomotor(me);
        r.registrarAutomotor(ae);
        r.registrarAutomotor(mc);
        r.registrarAutomotor(ac);
        r.registrarAutomotor(coc);
        r.registrarAutomotor(uc);
        r.registrarAutomotor(cac);



        //Menú de opciones
        Scanner sc = new Scanner(System.in);
        int op = 0;
        System.out.println("*****Bienvenido al DNRPA*****");
        do{
            System.out.println("Elija una opción: ");
            System.out.println("1. Mostrar automotores registrados");
            System.out.println("2. Buscar propietarios");
            System.out.println("3. Agregar nuevo automotor");
            System.out.println("4. Cambiar el propietario de un automotor");
            System.out.println("5. Comprobar fecha para cambio de propietario");
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
                case 4: r.registrarNuevoPropietario(); break;
                case 5: r.consultarHabilitacionCambioPropietario(); break;
            }
        }while(op!=0);


    }
}
