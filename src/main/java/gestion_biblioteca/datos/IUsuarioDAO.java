package gestion_biblioteca.datos;


import gestion_biblioteca.dominio.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    List<Usuario> listarUsuarios();
    boolean buscarUsuarioPorId(Usuario usuario);
    boolean agregarUdsuario(Usuario usuario);
    boolean modificarUsuario(Usuario usuario);
    boolean eliminarUsuario(Usuario usuario);
}
