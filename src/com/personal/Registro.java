package com.personal;

import java.time.LocalDate;
import java.util.*;

public class Registro {
    private List<Automotor> automotores = new ArrayList<>();
    private HashSet<String> patentes = new HashSet<>();

    //Generar patente Aleatoria
    Utilitaria caracteresAleatorios = new Utilitaria();
    String alfabeto = "ABCDEFGHYJKLMNOPQRSTUVWXYZ";
    String numeros = "0123456789";
    String patente="";
    public String generarPatente(){
        String l=caracteresAleatorios.elegirCaracteresAleatorios(alfabeto, 3);
        String n=caracteresAleatorios.elegirCaracteresAleatorios(numeros, 3);
        return patente=l+n;
    }

    //Registrar Automotor
    public void registrarAutomotor(Automotor automotor){
        patente="";
        patente=generarPatente();
        automotor.setPatente(patente);
        automotores.add(automotor);
        System.out.println("Se agrego el automotor con patente: "+automotor.getPatente());
    }

    //Listar automotores
    public List<Automotor> getAutomotores(){
        System.out.println("Los automotores registrados son: \n");
        for (Automotor automotor:automotores){
            Object obj=automotor.getClass().getSimpleName();
            String nombrePropietario=automotor.getPropietario().getNombre();
            System.out.println("Patente: "+automotor.getPatente()+ " - Tipo de Auto: "+obj+ " - Propietario: "+ nombrePropietario+" - Seccional: "+automotor.getSeccional());
        }
        return automotores;
    }

    //Listar Propietarios
    public void listarPropietarios(String tipoAutomotor) {
        Set<String> nombrePropietarios = new TreeSet<>();
        if (tipoAutomotor=="All") {
            for (Automotor automotor : this.automotores) {
                Propietario propietario = automotor.getPropietario();
                nombrePropietarios.add(propietario.getNombre());
            }
        }else{
            for (Automotor automotor : this.automotores) {
                String obj=automotor.getClass().getSimpleName();
                //No esta haciendo bien la comparacion
                if (tipoAutomotor==obj) {
                    Propietario propietario = automotor.getPropietario();
                    nombrePropietarios.add(propietario.getNombre());
                }
            }
        }
        System.out.println(nombrePropietarios);
    }

    // Listar Tipo de Automotor
    public List listarTipoAutomotor() {
        Integer contador=1;
        List<String> tipoAutomotores = new ArrayList<>();
        for (Automotor automotor : this.automotores) {
            Object obj=automotor.getClass().getSimpleName();
            tipoAutomotores.add(obj.toString());
            System.out.println(contador+") "+tipoAutomotores.get(contador-1));
            contador+=1;
        }
        System.out.println(contador+") "+"Todas las categorias");
        tipoAutomotores.add("All");
        return tipoAutomotores;
    }

    // Cambiar propietario de un automotor
    public void cambiarPropietario(String patente, Propietario nuevoPropietario, LocalDate fechaRegistro) {
        for (Automotor automotor:automotores) {
            if (automotor.getPatente() == patente) {
                automotor.setPropietario(nuevoPropietario);
                automotor.setFechaAltaPropietario(fechaRegistro);
            }
            System.out.println("El automotor con patente: "+patente+"ahora es propiedad de: "+automotor.getPatente());
        }
    }

    // Metodo para ingresar datos de una persona
    Scanner sc = new Scanner(System.in);
    List<String> datos;
    public List<String> ingresarDatosPersona(){
        datos = new ArrayList();
        System.out.println("Ingrese el nombre: ");
        String nombre=sc.nextLine();
        datos.add(nombre);
        System.out.println("Ingrese el numero de dni: ");
        String dni=sc.nextLine();
        datos.add(dni);
        System.out.println("Ingrese la direccion: ");
        String direccion=sc.nextLine();
        datos.add(direccion);
        return datos;
    }

    // con el metodo anterior se agregan autorizados
    List<Autorizado> autorizados;
    public void agregarAutorizados(){
        int op = 0;
        autorizados= new ArrayList<>();
        do{
            System.out.println("Desea agregar un autorizado");
            System.out.println("1. Si");
            System.out.println("2. No");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1: {
                    ingresarDatosPersona();
                    // 0: nombre, 1: dni, 2: direccion
                    Autorizado autorizado = new Autorizado(datos.get(0), datos.get(1), datos.get(2));
                    autorizados.add(autorizado);
                    break;
                }
            }
        }while(op!=2);
    }

    // metodo agregar fecha de alta del automotor
    public String[] agregarFechaAlta(){
        System.out.println("Ingrese la fecha de alta del automotor (DD-MM-AAAA):");
        String fechaAlta=sc.nextLine();
        String[] fecha=fechaAlta.split("-");
        return fecha;
    }

    // metodo seleccionar seccional
    public Object seleccionarSeccional(){
        List<String> seccionales=new ArrayList<>();
        List<Object> seccionalesObjects= new ArrayList<>();
        Object[] possibleValues = Seccional.values();
        Integer op = null;
        System.out.println("Seleccione la seccional donde vas a registrar tu automotor");
        Integer contador=1;
        for(Object i:possibleValues){
            seccionalesObjects.add(i);
            seccionales.add(String.valueOf(i));
            System.out.println(contador+") "+seccionales.get(contador-1));
            contador+=1;
        }
        System.out.println("Seleccione opción: ");
        op = Integer.parseInt(sc.nextLine());
        Object seccional = seccionalesObjects.get(op-1);
        return seccional;
    }

    // metodo seleccionar uso del automotor
    public Object seleccionarUso(){
        List<String> usos=new ArrayList<>();
        List<Object> usosObjects= new ArrayList<>();
        Object[] possibleValues = Uso.values();
        Integer op = null;
        System.out.println("Seleccione la seccional donde vas a registrar tu automotor");
        Integer contador=1;
        for(Object i:possibleValues){
            usosObjects.add(i);
            usos.add(String.valueOf(i));
            System.out.println(contador+") "+usos.get(contador-1));
            contador+=1;
        }
        System.out.println("Seleccione opción: ");
        op = Integer.parseInt(sc.nextLine());
        Object seccional = usosObjects.get(op-1);
        return seccional;
    }

    // metodo para agregar un nuevo automotor en el registro
    public void agregarNuevoAutomotor(){
        String[] fecha=agregarFechaAlta(); // con esto creo una lista para luego hacer la fecha
        LocalDate fechaAltaAutomotor = LocalDate.of(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]));
        LocalDate fechaAltaPropietario= fechaAltaAutomotor; // porque si es la primera vez asumo que es la misma fecha
        //Agregar nuevo propietario
        ingresarDatosPersona();
        Propietario propietario = new Propietario(datos.get(0), datos.get(1), datos.get(2));
        agregarAutorizados();
        Object seccional = seleccionarSeccional();
        Seccional secc=Seccional.valueOf(seccional.getClass().getSimpleName());
        Object uso = seleccionarUso();
        Uso use=Uso.valueOf(uso.getClass().getSimpleName());

        int op = 0;
        do{
            System.out.println("Desea agregar un autorizado");
            System.out.println("1. Auto Electrico");
            System.out.println("2. Moto Electrica");
            System.out.println("3. Automovil");
            System.out.println("4. Moto");
            System.out.println("5. Camion");
            System.out.println("6. Colectivo");
            System.out.println("7. Utilitario");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1: AutoElectrico ae=new AutoElectrico(secc, propietario, autorizados, fechaAltaAutomotor, use, fechaAltaPropietario); registrarAutomotor(ae); break;
                case 2: MotoElectrica me=new MotoElectrica(secc, propietario, autorizados, fechaAltaAutomotor, use, fechaAltaPropietario); registrarAutomotor(me); break;
                case 3: Automovil ac=new Automovil(secc, propietario, autorizados, fechaAltaAutomotor, use, fechaAltaPropietario); registrarAutomotor(ac); break;
                case 4: Motocicleta mc=new Motocicleta(secc, propietario, autorizados, fechaAltaAutomotor, use, fechaAltaPropietario); registrarAutomotor(mc); break;
                case 5: Camion cac=new Camion(secc, propietario, autorizados, fechaAltaAutomotor, use, fechaAltaPropietario); registrarAutomotor(cac); break;
                case 6: Colectivo coc=new Colectivo(secc, propietario, autorizados, fechaAltaAutomotor, use, fechaAltaPropietario); registrarAutomotor(coc); break;
                case 7: Utilitario uc=new Utilitario(secc, propietario, autorizados, fechaAltaAutomotor, use, fechaAltaPropietario); registrarAutomotor(uc); break;
            }
        }while(op!=0);
    }

}
