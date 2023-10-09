/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package massalud.Entidades;

import massalud.Entidades.Especialidad;

/**
 *
 * @author Leroom
 */


public class Prestador {
    private int id;
    private String nombre;
    private String apellido;
    private String institucion;
    private String direccion;
    private String telefono;
    private String email;
    private Especialidad especialidad;
    private boolean estado;

    public Prestador(int id, String nombre, String apellido, String institucion, String direccion, String telefono, String email, Especialidad especialidad, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.institucion = institucion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Prestador() {
    }

    public Prestador(String juan, String pérez, String hospital_ABC, String calle_Principal_123, int i, String juanexamplecom, Especialidad e, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getInstitucion() {
        return institucion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

//    public String getEstado() {
//        return estado ? "Activo" : "Inactivo";
//    }
//    public String getEstado() {
//        return estado ? "Inactivo" : "Activo";
//    }
    
//    public String getEstado() {
//    return estado == 1 ? "Activo" : "Inactivo";
//    
//    public String getEstado() {
//    return estado == 1 ? "Activo" : (estado == 0 ? "Inactivo" : "Estado Desconocido");
//}
//public boolean getEstado() {
//        return estado;
//    }
    
//public String getEstado() {
//    return estado ? "Activo" : "Inactivo";
//}
public boolean getEstado() {
    return estado;
}

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean Estado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
