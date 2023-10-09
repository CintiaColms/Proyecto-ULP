/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud.Entidades;

/**
 *
 * @author DANILO
 */
public class Empleado {
    
     private int idEmpleado;
    private String nombre;
    private String apellido;
    private int dni;
    private String usuario;
    private String contra;
    private int tel;
    private String clave;
    private boolean estado;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int dni, String usuario, String contra, int tel, String clave, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.usuario = usuario;
        this.contra = contra;
        this.tel = tel;
        this.clave = clave;
        this.estado = estado;
    }

    public Empleado(int idEmpleado, String nombre, String apellido, int dni, String usuario, String contra, int tel, String clave, boolean estado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.usuario = usuario;
        this.contra = contra;
        this.tel = tel;
        this.clave = clave;
        this.estado = estado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID: " + idEmpleado + ", " + nombre + ", " + apellido + "";
    }
    
    
    
}
