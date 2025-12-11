package gestion_biblioteca.datos;


import gestion_biblioteca.dominio.Libro;

import java.util.List;

public interface ILibroDAO {
    List<Libro> listarLibros();
    boolean buscarLibroPorId(Libro libro);
    boolean agregarLibro(Libro libro);
    boolean modificarLibro(Libro libro);
    boolean eliminarLibro(Libro libro);
}
