package gestion_biblioteca.presentacion;

import gestion_biblioteca.datos.FuncionarioDAO;
import gestion_biblioteca.datos.IFuncionarioDAO;
import gestion_biblioteca.dominio.Funcionario;

import java.util.Scanner;

public class FuncionarioCRUD {
    public static void funcionariosApp(){
        var salir = false;
        var consola = new Scanner(System.in);

        IFuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpcion(opcion, consola, funcionarioDAO);
            }catch(Exception e){
                System.out.println("Error al ingresar opción: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu (Scanner consola){
        System.out.print("""
                --------------------------------
                --- Gestión de Funcionarios ---
                --------------------------------
                1. Listar Funcionarios
                2. Buscar Funcionario
                3. Agregar Funcionario
                4. Modificar Funcionario
                5. Eliminar Funcionario
                6. Regresar
                Elige una opción:\s""");

        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpcion(int opcion, Scanner consola, IFuncionarioDAO funcionarioDAO){
        var salir = false;
        switch(opcion){
            case 1 -> {
                System.out.println("--- Listado de los Funcionarios ---");
                var lisrFuncionario = funcionarioDAO.listarFuncionarios();
                lisrFuncionario.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("--- Buscar Funcionario Por Id ---");
                System.out.print("Id del funcionario a buscar: ");
                var idFuncionario = Integer.parseInt(consola.nextLine());
                var buscarFuncionario = new Funcionario(idFuncionario);
                var encontrado = funcionarioDAO.buscarFuncionarioPorId(buscarFuncionario);
                if(encontrado){
                    System.out.println("Funcionario encontrado: " + buscarFuncionario);
                }
                else{
                    System.out.println("Funcionario No encontrado: " + buscarFuncionario);
                }
            }
            case 3 -> {
                System.out.println("--- Agregar Funcionario ---");
                System.out.print("Tipo de documento: ");
                var tipoDocumento = consola.nextLine();
                System.out.print("Número de documento: ");
                var numeroDocumento = consola.nextLine();
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Cargo: ");
                var cargo = consola.nextLine();
                System.out.print("Teléfono: ");
                var telefono = consola.nextLine();
                System.out.print("Correo: ");
                var correo = consola.nextLine();
                var agregarFuncionario = new Funcionario(tipoDocumento, numeroDocumento,nombre,
                        apellido,cargo,telefono,correo);
                var agregado = funcionarioDAO.agregarFuncionario(agregarFuncionario);
                if(agregado){
                    System.out.println("Funcionario agregado: " + agregarFuncionario);
                }
                else{
                    System.out.println("Funcionario No agregado: " + agregarFuncionario);
                }
            }
            case 4 -> {
                System.out.println("--- Modificar Funcionario ---");
                System.out.print("Id del funcionario a modificar: ");
                var idFuncionario = Integer.parseInt(consola.nextLine());
                var buscarFuncionario = new Funcionario(idFuncionario);
                var encontrado = funcionarioDAO.buscarFuncionarioPorId(buscarFuncionario);
                if(encontrado){
                    System.out.print("Tipo de documento: ");
                    var tipoDocumento = consola.nextLine();
                    System.out.print("Número de documento: ");
                    var numeroDocumento = consola.nextLine();
                    System.out.print("Nombre: ");
                    var nombre = consola.nextLine();
                    System.out.print("Apellido: ");
                    var apellido = consola.nextLine();
                    System.out.print("Cargo: ");
                    var cargo = consola.nextLine();
                    System.out.print("Teléfono: ");
                    var telefono = consola.nextLine();
                    System.out.print("Correo: ");
                    var correo = consola.nextLine();
                    var modificarFuncionario = new Funcionario(idFuncionario, tipoDocumento, numeroDocumento,nombre,
                            apellido,cargo,telefono,correo);
                    var modificado = funcionarioDAO.modificarFuncionario(modificarFuncionario);
                    System.out.println("Funcionario modificado: " + modificarFuncionario);
                }
                else{
                    System.out.println("Funcionario No encontrado: " + buscarFuncionario);
                }
            }
            case 5 -> {
                System.out.println("--- Eliminar Funcionario ---");
                System.out.print("Id del funcionario a eliminar: ");
                var idFuncionario = Integer.parseInt(consola.nextLine());
                var buscar = new Funcionario(idFuncionario);
                var encontrado = funcionarioDAO.buscarFuncionarioPorId(buscar);
                if(encontrado){
                    funcionarioDAO.eliminarFuncionario(buscar);
                    System.out.println("Funcionario eliminado: " + buscar);
                }
                else{
                    System.out.println("Funcionario No encontrado: " + buscar);
                }
            }
            case 6 -> {
                System.out.println("Regresando al menù principal...");
                salir = true;
            }
            default -> System.out.println("Opción No reconocida: " + opcion);
        }
        return salir;
    }
}
