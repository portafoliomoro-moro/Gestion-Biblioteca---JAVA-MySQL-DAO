package gestion_biblioteca.dominio;

import java.util.Objects;

public class Funcionario {
    private int id_funcionario;
    private String tipo_documento;
    private String numero_documento;
    private String nombres;
    private String apellidos;
    private String cargo;
    private String telefono;
    private String correo;

    public Funcionario() {
    }

    public Funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public Funcionario(String tipo_documento, String numero_documento, String nombres,
                       String apellidos, String cargo, String telefono, String correo) {
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Funcionario(int id_funcionario, String tipo_documento, String numero_documento, String nombres,
                       String apellidos, String cargo, String telefono, String correo) {
        this(tipo_documento, numero_documento, nombres, apellidos, cargo, telefono, correo);
        this.id_funcionario = id_funcionario;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id_funcionario=" + id_funcionario +
                ", tipo_documento='" + tipo_documento + '\'' +
                ", numero_documento='" + numero_documento + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cargo='" + cargo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return id_funcionario == that.id_funcionario && Objects.equals(tipo_documento, that.tipo_documento) && Objects.equals(numero_documento, that.numero_documento) && Objects.equals(nombres, that.nombres) && Objects.equals(apellidos, that.apellidos) && Objects.equals(cargo, that.cargo) && Objects.equals(telefono, that.telefono) && Objects.equals(correo, that.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_funcionario, tipo_documento, numero_documento, nombres, apellidos, cargo, telefono, correo);
    }
}