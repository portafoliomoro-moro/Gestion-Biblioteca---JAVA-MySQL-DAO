package gestion_biblioteca.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion(){
        Connection conexion = null;

        var baseDatos = "biblioteca_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "tu_usuario_db";
        var password = "tu_contrasena_db";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch(Exception e){
            System.out.println("Error al conectar la bd: " + e.getMessage());
        }
        return conexion;
    }

//    public static void main(String[] args) {
//        var conexion = Conexion.getConexion();
//        if(conexion != null){
//            System.out.println("Conexión exitosa: " + conexion);
//        }
//        else{
//            System.out.println("Error de conexión: " + conexion);
//        }
//    }
}
