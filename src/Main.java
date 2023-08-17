import java.util.Scanner;

public class Main {
    static String[][] admin= new  String[5][5];
    static String[][] vehiculos= new  String[10][6];
    static int[][] descuentos= new  int[5][2];
    public static void main(String[] args) {
        datosPrueba();
        login();
    }
    public static void  login(){
        System.out.println("ingrese el nombre de usuario");
        Scanner sc = new Scanner(System.in);
        try {
            String datos = sc.nextLine();
            for (int i =0; i< admin.length;i++) {
                if (admin[i][0] != null && admin[i][0].equals(datos)) {
                    if (admin[i][2] != null) {
                        System.out.println("Ingrese la contraseña");
                        String clave = sc.nextLine();
                        if (admin[i][1].equals(clave)) {
                            menuAdmin();
                            break;
                        } else {
                            System.out.println("Clave equivocada");
                            sc.close();
                            login();
                        }
                    } else {
                        menuCliente();
                        break;
                    }
                }
            }
        }catch (Exception ie){
            System.out.println("Error de usuario");
            login();
        }
    }
    public static void menuAdmin() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Menu Administrador");
        System.out.println("1.Agregar Vehiculo");
        System.out.println("2.Agregar descuento");
        System.out.println("3.Realizar Reportes");
        System.out.println("4.Mostrar usuarios");
        System.out.println("5.cerrar sesion");
        System.out.println("Escoja el numero de la opcion");
        int opcion=0;
        try {
            opcion = scn.nextInt();
            switch (opcion){
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    agregarDescuento();
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    mostrarUsers();
                    break;
                case 5:
                    login();
                    break;
                default:
                    System.out.println("Escoja el numero de la opcion correspondiente");
                    menuAdmin();
                    break;
            }
        } catch (Exception ie) {
            System.out.println("Escoja el numero de la opcion correcta");
            menuAdmin();
        }
    }
    public static void menuCliente(){
        Scanner scC = new Scanner(System.in);
        System.out.println("Menu Cliente");
        System.out.println("1.Registrase");
        System.out.println("2.Iniciar  sesion");
        System.out.println("3.Realizar rezerva");
        System.out.println("4.Mostrar usuarios");
        System.out.println("5.cerrar Seccion");
        System.out.println("Escoja el numero de la opcion");
        int opcion=0;
        try {
            opcion = scC.nextInt();
            switch (opcion){
                case 1:
                    registro();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    ordeRenta();
                    break;
                case 4:
                    mostrarUsers();
                    break;
                case 5:
                    login();
                    break;
                default:
                    System.out.println("Escoja el numero de la opcion correspondiente");
                    menuCliente();
                    break;
            }
        } catch (Exception ie) {
            System.out.println("Escoja el numero de la opcion correcta");
            menuCliente();
        }
    }
    /*
    *           Administracion de vehiculos
    * */

    public static void agregarVehiculo(){
        //vehiculo [marca][linea][modelo][placa][alquiler][arendado]
        vehiculos[1][3]="apa";
        Scanner scV= new Scanner(System.in);
        System.out.println("Ingrese la placa");
        String placa = scV.nextLine();
        if(placaRepetida(placa)!=true){
            System.out.println("Ingrese la Marca");
            String marca = scV.nextLine();
            System.out.println("Ingrese la linea");
            String linea = scV.nextLine();
            System.out.println("Ingrese el modelo");
            String modelo = scV.nextLine();
            try {
                System.out.println("costo del alquiler por dia");
                int alquiler = scV.nextInt();
                System.out.println("");
                System.out.println("Marca:"+marca+"\tLinea:"+linea+"\tModelo:"+modelo+"\nPlaca:"+placa+"\tAlquiler:Q"+alquiler);
                System.out.println("");
                for(int i=0;i<vehiculos.length;i++){
                    if (vehiculos[i][3]==null ){
                        vehiculos[i][0]=marca;
                        vehiculos[i][1]=linea;
                        vehiculos[i][2]=modelo;
                        vehiculos[i][3]=placa;
                        vehiculos[i][4]=String.valueOf(alquiler);
                        vehiculos[i][5]="no";
                        menuAdmin();
                        break;
                    }
                }

            }catch (Exception e){
                System.out.println("Ingrese el precio de manera correcta");
                agregarVehiculo();
            }
        }else{
            agregarVehiculo();
        }
    }
    public static void agregarDescuento(){
        /*Descuento [dias][descuento]*/
        try {
            Scanner scd = new Scanner(System.in);
            System.out.println("ingrese la cantidad de dias para que se apliquen los descuentos");
            int dias =scd.nextInt();
            if (descuentoDias(dias)!=true){
                System.out.println("ingrese la cantidad del descuento (sin simbolo de porcentaje)");
                int porcentaje =scd.nextInt();
                if(descuentoPorcentaje(porcentaje)!=true){
                    for(int i =0;i<descuentos.length;i++){
                        if(descuentos[i][0]==0 && descuentos[i][1]==0){
                            descuentos[i][0]=dias;
                            descuentos[i][1]=porcentaje;
                            menuAdmin();
                        }
                    }
                }else{
                    System.out.println("Ya existe este porcentaje");
                    agregarDescuento();
                }
            }else{
                System.out.println("Ya existe esta cantidad de dias");
                agregarDescuento();
            }


        }catch (Exception ei){
            System.out.println("Ingrese Valores numericos unicamente");
            agregarDescuento();
        }
    }
    public static void mostrarUsers(){
        System.out.println("usuario"+"  "+"nombre"+"  "+"apellido");
        for (int i=0;i<admin.length;i++){
            if(admin[i][0]!=null){
                System.out.println(admin[i][0]+"  "+admin[i][3]+"  "+admin[i][4]);
            }
        }
        menuAdmin();
    }
    public static boolean placaRepetida(String placa){
        boolean existe=false;
        for(int i=0;i<vehiculos.length;i++){
            if (  vehiculos[i][3]!=null && vehiculos[i][3].equals(placa)){
                System.out.println("placa ya existente");
                existe=true;
            }
        }
        return existe;
    }
    public static boolean descuentoDias(int dias){
        boolean cumple=false;
            if (dias>0){
                for(int i =0; i<descuentos.length;i++){
                    if(descuentos[i][0]!=0 && descuentos[i][0]==dias){
                        cumple=true;
                    }
                }
            }
        return cumple;
    }
    public static boolean descuentoPorcentaje(int descuento){
        boolean cumple=false;
        if (descuento>0){
            for(int i =0; i<descuentos.length;i++){
                if(descuentos[i][1]!=0 && descuentos[i][1]==descuento){
                    cumple=true;
                }
            }
        }
        return cumple;
    }

    public static void datosPrueba(){
        /*Vehiculo*/
        vehiculos[0][0]="adf";
        vehiculos[0][1]="as";
        vehiculos[0][2]="asdfa";
        vehiculos[0][3]="plzxvbzaca";
        vehiculos[0][4]= String.valueOf(120);
        vehiculos[0][5]=String.valueOf(true);
        /*descuento*/
        descuentos[0][0]=10;
        descuentos[0][1]=5;
        /*usuarios*/
        admin[0][0] = "1";/*admin_201800559*/
        admin[0][1] = "1";/*201800559*/
        admin[0][2] = "admin";
        admin[0][3] = "Carlos";
        admin[0][4] = "Franco";
        admin[1][0] = "123";
        admin[1][3] = "paco";
        admin[1][4] = "Lopez";

    }
    /*
     *           Administracion de cliente
     * */
    public static void registro(){
        Scanner usua= new Scanner(System.in);
       try {
           System.out.println("ingrese su nit");
           int nit = usua.nextInt();
           if(comparacionNit(nit)!=true){
               usua.nextLine();
               System.out.println("ingrese su nombre");
               String nombre = usua.nextLine();

               System.out.println("ingrese su apellido");
               String apellido = usua.nextLine();
               for(int i =0;i<admin.length;i++){
                   if(admin[i][0]==null){
                       admin[i][0]=String.valueOf(nit);
                       admin[i][3]=nombre;
                       admin[i][4]=apellido;
                       menuCliente();
                       break;
                   }
               }
           }else {registro();}
       }catch (Exception ie){
           System.out.println("ingrese su nit solo con numeros");
           registro();
       }

    }
    public static void ordeRenta(){
        mostrarCarros();
        menuCliente();
    }
    public static boolean comparacionNit(int nit){
        boolean existe=false;
        for(int i=0;i<admin.length;i++){
            if (  admin[i][0]!=null && Integer.valueOf(admin[i][0])==nit){
                System.out.println("nit ya existente");
                existe=true;
            }
        }
        return existe;
    }
    public static void mostrarCarros(){
        System.out.println("-------------- Vehiculos------------------");
        System.out.println("Marca   Linea     Modelo      Placa      Dias       arriendo");
        for (int i =0;i<vehiculos.length;i++){
            if(vehiculos[i][3]!=null){
                System.out.println(vehiculos[i][0]+"   "+vehiculos[i][1]+"  "+vehiculos[i][2]+"   "+vehiculos[i][3]+"  "+vehiculos[i][4]+"   "+vehiculos[i][5]);
                System.out.println("------------------------------------------");
            }

        }
    }
}