package gestion_biblioteca.datos;


import gestion_biblioteca.dominio.Evento;

import java.util.List;

public interface IEventoDAO {
    List<Evento> listarEventos();
    boolean buscarEventoPorId(Evento evento);
    boolean agregarEvento(Evento evento);
    boolean modificarEvento(Evento evento);
    boolean eliminarEvento(Evento evento);
}
