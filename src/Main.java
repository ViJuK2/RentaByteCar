import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        login();

    }
    public static void  login(){
        String[][] admin= new  String[5][3];
        admin[0][0] = "admin_201800559";
        admin[0][1] = "201800559";
        admin[0][2] = "admin";
        admin[1][0] = "123";
        System.out.println("ingrese el nombre de usuario");
        Scanner sc = new Scanner(System.in);
        String datos = sc.nextLine();
        for (int i =0; i< admin.length;i++) {
            if (admin[i][0] != null && admin[i][0].equals(datos)) {
                if (admin[i][2] != null) {
                    System.out.println("Ingrese la contraseña");
                    String clave = sc.nextLine();
                    System.out.println(clave);
                    if (admin[i][1].equals(clave)) {
                        menuAdmin();
                        break;
                    } else {
                        login();
                    }
                } else {
                    menuCliente();
                    break;
                }
            } else {
                login();
            }
        }
    }
    public static void menuAdmin(){
        System.out.println("Menu Administrador");
        System.out.println("1.Agregar Vehiculo");
        System.out.println("2.Agregar descuento");
        System.out.println("3.Realizar Reportes");
        System.out.println("4.Mostrar usuarios");
        System.out.println("5.Regresar al menu");
        System.out.println("Escoja el numero de la opcion");



    }
    public static void menuCliente(){
        System.out.println("Menu Cliente");
        System.out.println("1.Registrase");
        System.out.println("2.Iniciar  sesion");
        System.out.println("3.Realizar rezerva");
        System.out.println("4.Mostrar usuarios");
        System.out.println("5.Regresar al menu");
        System.out.println("Escoja el numero de la opcion");
    }
}