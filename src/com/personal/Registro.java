package com.personal;

import javax.management.StringValueExp;
import java.time.Duration;
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
        //Verificador de patentes unicas
        while(patentes.contains(patente)){
            patente=generarPatente();
        }
        automotor.setPatente(patente);
        automotores.add(automotor);
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

                if (obj.equals(tipoAutomotor)) {
                    Propietario propietario = automotor.getPropietario();
                    nombrePropietarios.add(propietario.getNombre());
                }
            }
        }
        System.out.println("nombre(s) de propietario(s): ");
        for(String i: nombrePropietarios){
            System.out.println(i);
        }
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

    // Metodo para ingresar datos de una persona
    Scanner sc = new Scanner(System.in);
    List<String> datos;
    public List<String> ingresarDatosPersona(){
        datos = new ArrayList();
        System.out.println("Ingrese el nombre: ");
        String nombre=sc.nextLine();
        datos.add(nombre);
        System.out.println("Ingrese el numero de dni: ");
        String elDni=sc.nextLine();
        int dni;
        try{
            dni= Integer.parseInt(elDni);
        } catch (NumberFormatException e){
            dni=0;
        }
        datos.add(Integer.toString(dni));
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
    public NombreSeccional seleccionarSeccional(){
        NombreSeccional[] possibleValues = NombreSeccional.values();
        Integer op = 0;
        System.out.println("Seleccione la seccional donde va a registrar su automotor");
        for(int i = 0; i<possibleValues.length; i++){
            System.out.println((i+1)+") "+possibleValues[i].toString());
        }
        System.out.println("Seleccione opción: ");
        op = Integer.parseInt(sc.nextLine());
        NombreSeccional seccional = possibleValues[op-1];
        return seccional;
    }

    // metodo seleccionar uso del automotor
    public NombreUso seleccionarUso(){
        NombreUso[] possibleValues = NombreUso.values();
        Integer op = 0;
        System.out.println("Seleccione el uso que le va a dar al automotor");
        for(int i = 0; i<possibleValues.length; i++){
            System.out.println((i+1)+") "+possibleValues[i].toString());
        }
        System.out.println("Seleccione opción: ");
        op = Integer.parseInt(sc.nextLine());
        NombreUso nombreUso = possibleValues[op-1];
        return nombreUso;
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
        NombreSeccional seccional = seleccionarSeccional();
        NombreUso uso = seleccionarUso();

        int op = 0;
        do{
            System.out.println("Que tipo de automotor desea registrar: ");
            System.out.println("1. Auto Electrico");
            System.out.println("2. Moto Electrica");
            System.out.println("3. Automovil");
            System.out.println("4. Moto");
            System.out.println("5. Camion");
            System.out.println("6. Colectivo");
            System.out.println("7. Utilitario");
            System.out.print("Opción: ");
        }while(op!=0);
        op = Integer.parseInt(sc.nextLine());
        switch (op) {
            case 1: AutoElectrico ae=new AutoElectrico(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario); registrarAutomotor(ae); break;
            case 2: MotoElectrica me=new MotoElectrica(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario); registrarAutomotor(me); break;
            case 3: Automovil ac=new Automovil(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario); registrarAutomotor(ac); break;
            case 4: Motocicleta mc=new Motocicleta(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario); registrarAutomotor(mc); break;
            case 5: Camion cac=new Camion(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario); registrarAutomotor(cac); break;
            case 6: Colectivo coc=new Colectivo(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario); registrarAutomotor(coc); break;
            case 7: Utilitario uc=new Utilitario(seccional, propietario, autorizados, fechaAltaAutomotor, uso, fechaAltaPropietario); registrarAutomotor(uc); break;
        }
        System.out.println("Se agrego el automotor correctamente");

    }

    // metodo para seleccionar un automotor por patente
    public Automotor seleccionarAutomor(){
        System.out.println("Ingrese la patente del automotor que desea cambiar de propietario: ");
        String patente = sc.nextLine();
        Automotor automotor = null;
        for (Automotor a:this.automotores) {
            String patenteAutomotor=a.getPatente();
            if (patenteAutomotor.equals(patente)) {
                automotor = a;
                if(automotor!=null){
                    break;
                }
            }
        }

        if (automotor == null){
            System.out.println("La patente no existe en el sistema");
        }
        return automotor;
    }

    // Cambiar propietario de un automotor
    public void cambiarPropietario(Automotor automotor, String patente, Propietario nuevoPropietario, LocalDate fechaRegistro) {
        automotor.setPropietario(nuevoPropietario);
        automotor.setFechaAltaPropietario(fechaRegistro);
        System.out.println("El automotor con patente: "+patente+" ahora es propiedad de: "+automotor.getPropietario().getNombre());
    }

    //metodo para registrar un nuevo propietario
    public void registrarNuevoPropietario(){
        Automotor automotor=seleccionarAutomor();

        if (automotor!=null)
            System.out.println("Ingrese la fecha de alta del nuevo propietario (DD-MM-AAAA):");
            String fechaAlta=sc.nextLine();
            String[] fecha=fechaAlta.split("-");
            LocalDate fechaAltaNuevoPropietario= LocalDate.of(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]));
            LocalDate fechaAltaPropietario= automotor.getFechaAltaPropietario();
            long diasDesdeElAltaPropietario = Duration.between(fechaAltaPropietario.atStartOfDay(), fechaAltaNuevoPropietario.atStartOfDay()).toDays();

            if (diasDesdeElAltaPropietario > 365) {
                String patente=automotor.getPatente();
                ingresarDatosPersona();
                Propietario nuevoPropietario = new Propietario(datos.get(0), datos.get(1), datos.get(2));
                cambiarPropietario(automotor, patente, nuevoPropietario, fechaAltaNuevoPropietario);
            }else{
                System.out.println("No se puede ingresar un nuevo propietario, la fecha desde el ultimo cambio de propietario debe ser mayor a un año.");
                System.out.println("La fecha de registro del ultimo propietario es: "+fechaAltaPropietario);
            }
    }


    // metodo para consultar si ya paso un año desde el ultimo registro del propietario
    public void consultarHabilitacionCambioPropietario() {
        Automotor automotor = seleccionarAutomor();

        if (automotor!=null) {
            LocalDate hoy = LocalDate.now();
            LocalDate fechaAltaPropietario= automotor.getFechaAltaPropietario();
            long diasDesdeElAltaPropietario = Duration.between(fechaAltaPropietario.atStartOfDay(), hoy.atStartOfDay()).toDays();
            if (diasDesdeElAltaPropietario < 365) {
                System.out.println("Ha trasncurrido menos de un año desde el ultimo alta de propietario.");
                System.out.println("La fecha del ultimo cambio fue en: " + automotor.getFechaAltaPropietario());
            } else {
                System.out.println("La ultima alta de propietario fue en : "+fechaAltaPropietario+", puede hacer el cambio.");
            }
        }
    }
}
