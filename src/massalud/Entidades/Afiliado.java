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
public class Afiliado {
    
      private int idafiliaado;
    private String nombre;
    private String apellido;
    private int dni;
    private String domicilio;
    private int telefono;
    private Empleado empleado;
    private boolean estado;

    public Afiliado() {
    }

    public Afiliado(String nombre, String apellido, int dni, String domicilio, int telefono, Empleado empleado, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.empleado = empleado;
        this.estado = estado;
    }

    public Afiliado(int idafiliaado, String nombre, String apellido, int dni, String domicilio, int telefono, Empleado empleado, boolean estado) {
        this.idafiliaado = idafiliaado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.empleado = empleado;
        this.estado = estado;
    }

    public int getIdafiliaado() {
        return idafiliaado;
    }

    public void setIdafiliaado(int idafiliaado) {
        this.idafiliaado = idafiliaado;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Afiliado{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + '}';
    }
    
    
}
