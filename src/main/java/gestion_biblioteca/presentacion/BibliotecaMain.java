package gestion_biblioteca.presentacion;

import gestion_biblioteca.dominio.Funcionario;

import java.util.Scanner;

public class BibliotecaMain {
    public static void main(String[] args) {
        bibliotecaApp();
    }

    private static void bibliotecaApp(){
        var salir = false;
        var consola = new Scanner(System.in);

        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpcion(opcion, consola);
            }catch(Exception e){
                System.out.println("Error al ingresar una opción: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                -------------------------------
                *** Gestión de Biblioteca ***
                -------------------------------
                1. Gestión de Usuarios
                2. Gestión de Libros
                3. Gestión de Préstamos
                4. Gestión de Funcionarios
                5. Gestión de Eventos
                6. Salir
                Elige una opción:\s""");

        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpcion(int opcion, Scanner consola){
        var salir = false;
        switch(opcion){
            case 1 -> UsuarioCRUD.usuarioApp();
            case 2 -> LibrosCRUD.libroApp();
            case 3 -> PrestamoCRUD.prestamoApp();
            case 4 -> FuncionarioCRUD.funcionariosApp();
            case 5 -> EventoCRUD.eventosApp();
            case 6 -> {
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opción No reconocida: " + opcion);
        }
        return salir;
    }
}
