package gestion_biblioteca.datos;


import gestion_biblioteca.dominio.Funcionario;

import java.util.List;

public interface IFuncionarioDAO {
    List<Funcionario> listarFuncionarios();
    boolean buscarFuncionarioPorId(Funcionario funcionario);
    boolean agregarFuncionario(Funcionario funcionario);
    boolean modificarFuncionario(Funcionario funcionario);
    boolean eliminarFuncionario(Funcionario funcionario);
}
