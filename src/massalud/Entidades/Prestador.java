/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package massalud.Entidades;

/**
 *
 * @author Leroom
 */


public class Prestador {
    private int idPrestador;
    private String nombre;
    private String apellido;
    private int dni;
    private String institucion;
    private String direccion;
    private String telefono;
    private String email;
    private Especialidad especialidad;
    private boolean estado;

  public Prestador() {
  }

  public Prestador(int idPrestador, String nombre, String apellido, int dni, String institucion, String direccion, String telefono, String email, Especialidad especialidad, boolean estado) {
    this.idPrestador = idPrestador;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.institucion = institucion;
    this.direccion = direccion;
    this.telefono = telefono;
    this.email = email;
    this.especialidad = especialidad;
    this.estado = estado;
}

  
    public int getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(int idPrestador) {
        this.idPrestador = idPrestador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String toString() {
    return "Prestador{" +
        "idPrestador=" + idPrestador +
        ", nombre='" + nombre + '\'' +
        ", apellido='" + apellido + '\'' +
        ", dni=" + dni +
        ", institucion='" + institucion + '\'' +
        ", direccion='" + direccion + '\'' +
        ", telefono='" + telefono + '\'' +
        ", email='" + email + '\'' +
        ", especialidad=" + especialidad +
        ", estado=" + estado +
        '}';
}
    
}

