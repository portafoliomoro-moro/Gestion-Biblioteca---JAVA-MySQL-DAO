package gestion_biblioteca.datos;



import gestion_biblioteca.dominio.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static gestion_biblioteca.conexion.Conexion.getConexion;


public class FuncionarioDAO implements IFuncionarioDAO{
    @Override
    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM funcionarios ORDER BY id_funcionario";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var funcionario = new Funcionario();
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setTipo_documento(rs.getString("tipo_documento"));
                funcionario.setNumero_documento(rs.getString("numero_documento"));
                funcionario.setNombres(rs.getString("nombres"));
                funcionario.setApellidos(rs.getString("apellidos"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setTelefono(rs.getString("telefono"));
                funcionario.setCorreo(rs.getString("correo"));
                funcionarios.add(funcionario);
            }
        }catch(Exception e){
            System.out.println("Error al listar los funcionarios: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return funcionarios;
    }

    @Override
    public boolean buscarFuncionarioPorId(Funcionario funcionario) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM funcionarios WHERE id_funcionario=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, funcionario.getId_funcionario());
            rs = ps.executeQuery();
            if(rs.next()){
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setTipo_documento(rs.getString("tipo_documento"));
                funcionario.setNumero_documento(rs.getString("numero_documento"));
                funcionario.setNombres(rs.getString("nombres"));
                funcionario.setApellidos(rs.getString("apellidos"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setTelefono(rs.getString("telefono"));
                funcionario.setCorreo(rs.getString("correo"));
                return true;
            }
        }catch(Exception e){
            System.out.println("Error al buscar el registro: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarFuncionario(Funcionario funcionario) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "INSERT INTO funcionarios (tipo_documento, numero_documento, nombres, apellidos, " +
                "cargo, telefono, correo) VALUE (?,?,?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, funcionario.getTipo_documento());
            ps.setString(2, funcionario.getNumero_documento());
            ps.setString(3, funcionario.getNombres());
            ps.setString(4, funcionario.getApellidos());
            ps.setString(5, funcionario.getCargo());
            ps.setString(6, funcionario.getTelefono());
            ps.setString(7, funcionario.getCorreo());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al agregar registro: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarFuncionario(Funcionario funcionario) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "UPDATE funcionarios SET tipo_documento=?, numero_documento=?, " +
                " nombres=?, apellidos=?, cargo=?, telefono=?, correo=? WHERE id_funcionario=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, funcionario.getTipo_documento());
            ps.setString(2, funcionario.getNumero_documento());
            ps.setString(3, funcionario.getNombres());
            ps.setString(4, funcionario.getApellidos());
            ps.setString(5, funcionario.getCargo());
            ps.setString(6, funcionario.getTelefono());
            ps.setString(7, funcionario.getCorreo());
            ps.setInt(8, funcionario.getId_funcionario());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al modificar registro: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarFuncionario(Funcionario funcionario) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "DELETE FROM funcionarios WHERE id_funcionario=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, funcionario.getId_funcionario());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al eliminar registro: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        IFuncionarioDAO funcionarioDAO = new FuncionarioDAO();
//        System.out.println("*** Listar Funcionarios ***");
//        var listar = funcionarioDAO.listarFuncionarios();
//        listar.forEach(System.out::println);

//        System.out.println("*** Buscar ***");
//        var buscar = new Funcionario(1);
//        var encontrado = funcionarioDAO.buscarFuncionarioPorId(buscar);
//        if(encontrado){
//            System.out.println("Funcionario encontrado: " + buscar);
//        }
//        else{
//            System.out.println("Funcionario No encontrado: " + buscar);
//        }
//        System.out.println("*** Agregar ***");
//        var agregar = new Funcionario("Ti", "654655", "Paul", "Keres", "sin","9565558","keres@mail.com");
//        var agregado = funcionarioDAO.agregarFuncionario(agregar);
//        if(agregado){
//            System.out.println("Funcionario agregado: " + agregar);
//        }
//        else{
//            System.out.println("Funcionario No agregado: " + agregar);
//        }
//        System.out.println("*** Modificar ***");
//        var modificar = new Funcionario(2, "Cc", "6546551", "Paul2", "Keres3", "sin4","95655585","keres@mail.com6");
//        var modificado = funcionarioDAO.modificarFuncionario(modificar);
//        if(modificado){
//            System.out.println("Funcionario modificado: " + modificar);
//        }
//        else{
//            System.out.println("Funcionario No modificado: " + modificar);
//        }
//        System.out.println("*** Eliminar ***");
//        var eliminar = new Funcionario(2);
//        var eliminado = funcionarioDAO.eliminarFuncionario(eliminar);
//        if(eliminado){
//            System.out.println("Funcionario eliminado: " + eliminar);
//        }
//        else{
//            System.out.println("Funcionario No eliminado: " + eliminar);
//        }
//    }
}
