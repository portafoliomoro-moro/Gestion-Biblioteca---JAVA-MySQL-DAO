package gestion_biblioteca.datos;


import gestion_biblioteca.dominio.Prestamo;

import java.util.List;

public interface IPrestamoDAO {
    List<Prestamo> listarPrestamos();
    boolean buscarPrestamoPorId(Prestamo prestamo);
    boolean agregarPrestamo(Prestamo prestamo);
    boolean modificarPrestamo(Prestamo prestamo);
    boolean eliminarPrestamo(Prestamo prestamo);
}
