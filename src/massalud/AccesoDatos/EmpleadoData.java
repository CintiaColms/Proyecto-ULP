/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud.AccesoDatos;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import massalud.Entidades.Empleado;

public class EmpleadoData {
    private Connection con = null; 

    public EmpleadoData() { 
        con = Conexion.getConexion();
    }

    public void guardarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO empleado (nombre, apellido, dni, usuario, contraseña, telefono, claveacceso, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setInt(3, empleado.getDni());
            ps.setString(4, empleado.getUsuario());
            ps.setString(5, empleado.getContra());
            ps.setInt(6, empleado.getTel());
            ps.setString(7, empleado.getClave());
            ps.setBoolean(8, empleado.isEstado()); // if reducido 
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                empleado.setIdEmpleado(rs.getInt(1));
                
                String mensaje = "El Empleado fue Agregado con Exito!! ";
                UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
                UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
                ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
                JOptionPane.showMessageDialog(null, mensaje, "Ingreso Exitoso", JOptionPane.PLAIN_MESSAGE, icono);
            }
            ps.close();

        } catch (SQLException ex) {
           
            String mensaje = "Error al acceder a la tabla Empleados ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
    }

    public void modificarEmpleado(Empleado empleado) {
        String sql = "UPDATE empleado SET nombre = ?, apellido = ?, dni = ?, usuario = ?, contraseña = ?, telefono = ?, claveacceso = ?, estado = ? WHERE idEmpleado = ?"; 
        PreparedStatement ps = null;  
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setInt(3, empleado.getDni());
            ps.setString(4, empleado.getUsuario());
            ps.setString(5, empleado.getContra());
            ps.setInt(6, empleado.getTel());
            ps.setString(7, empleado.getClave());
            ps.setBoolean(8, empleado.isEstado());
            ps.setInt(9, empleado.getIdEmpleado());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                
                String mensaje = "Datos actualizados con Exito!! ";
                UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
                UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
                ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
                JOptionPane.showMessageDialog(null, mensaje, "Datos Actualizados", JOptionPane.PLAIN_MESSAGE, icono);
            } else {
                
                    String mensaje = "Error el Empleado no se encuentra registrado";
                UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
                UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
                ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
                JOptionPane.showMessageDialog(null, mensaje, "Empleado no Existe", JOptionPane.PLAIN_MESSAGE, icono);
            }
        } catch (SQLException ex) {

                       String mensaje = "Error al acceder a la tabla Empleados ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
    }

    public void eliminarEmpleado(int id) {
        String sql = "UPDATE empleado SET estado = 0 WHERE idEmpleado = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                
                    String mensaje = "El empleado ha sido eliminado con exito!! ";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Eliminado exitosamente", JOptionPane.PLAIN_MESSAGE, icono);
            }
            ps.close();
        } catch (SQLException e) {
            
                String mensaje = "Error al acceder a la Tabla de Empleados";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
  }
    
    public Empleado buscarEmpleado(int id) {
        Empleado empleado = null;
        String sql = "SELECT * FROM empleado WHERE idEmpleado = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getBoolean("estado") == true) {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(id);
                    empleado.setDni(rs.getInt("dni"));
                    empleado.setApellido(rs.getString("apellido"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setUsuario(rs.getString("usuario"));
                    empleado.setContra(rs.getString("contraseña"));
                    empleado.setClave(rs.getString("claveacceso"));
                    empleado.setTel(rs.getInt("telefono"));
                    empleado.setEstado(rs.getBoolean("estado"));
                } else {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(id);
                    empleado.setDni(rs.getInt("dni"));
                    empleado.setApellido(rs.getString("apellido"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setUsuario(rs.getString("usuario"));
                    empleado.setContra(rs.getString("contraseña"));
                    empleado.setClave(rs.getString("claveacceso"));
                    empleado.setTel(rs.getInt("telefono"));
                    empleado.setEstado(rs.getBoolean("estado"));
                    
                    
                        String mensaje = "El empleado "+empleado.getApellido()+" "+empleado.getNombre()+ " ha sido dado de baja";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Dado de Baja", JOptionPane.PLAIN_MESSAGE, icono);
                }                
            } else {
               
                    String mensaje = "El empleado que busca no se encuentra registrado";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Empleado inexistente", JOptionPane.PLAIN_MESSAGE, icono);
            }
            ps.close();
        } catch (SQLException ex) {            
            String mensaje = "Error al acceder a la Tabla de Empleados";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);            
        }
        return empleado;
    }
  
    public List<Empleado> listarEmpleado() {
        String sql = "SELECT * FROM empleado WHERE estado = 1";
        PreparedStatement ps = null;
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setDni(rs.getInt("dni"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setTel(rs.getInt("telefono"));
                empleado.setUsuario(rs.getString("usuario"));
                empleado.setClave(rs.getString("claveacceso"));
                empleado.setContra(rs.getString("contraseña"));
                empleado.setEstado(true);
                empleados.add(empleado);
            }
            ps.close();
        } catch (SQLException ex) {
             String mensaje = "Error al acceder a la Tabla de Empleados";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
        return empleados;
    }
    
    public Empleado buscarEmpleadoPorDni(int dni) {
        Empleado empleado = null;
        String sql = "SELECT * FROM empleado WHERE dni = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getBoolean("estado") == true) {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                    empleado.setDni(rs.getInt("dni"));
                    empleado.setApellido(rs.getString("apellido"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setUsuario(rs.getString("usuario"));
                    empleado.setContra(rs.getString("contraseña"));
                    empleado.setClave(rs.getString("claveacceso"));
                    empleado.setTel(rs.getInt("telefono"));
                    empleado.setEstado(rs.getBoolean("estado"));
                } else {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                    empleado.setDni(rs.getInt("dni"));
                    empleado.setApellido(rs.getString("apellido"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setUsuario(rs.getString("usuario"));
                    empleado.setContra(rs.getString("contraseña"));
                    empleado.setClave(rs.getString("claveacceso"));
                    empleado.setTel(rs.getInt("telefono"));
                    empleado.setEstado(rs.getBoolean("estado"));
                    
                       String mensaje = "El empleado "+empleado.getApellido()+" "+empleado.getNombre()+ " ha sido dado de baja";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Dado de Baja", JOptionPane.PLAIN_MESSAGE, icono);
                }
            } else {
                 String mensaje = "El empleado que busca no se encuentra registrado";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Empleado inexistente", JOptionPane.PLAIN_MESSAGE, icono);
            }
            ps.close();
        } catch (SQLException ex) {
            String mensaje = "Error al acceder a la Tabla de Empleados";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
        return empleado;
    }

public Empleado buscarEmpleadoPorUsuario(String usuario) {
        Empleado empleado = null;
        String sql = "SELECT * FROM empleado WHERE dni = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getBoolean("estado") == true) {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                    empleado.setDni(rs.getInt("dni"));
                    empleado.setApellido(rs.getString("apellido"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setUsuario(rs.getString("usuario"));
                    empleado.setContra(rs.getString("contraseña"));
                    empleado.setClave(rs.getString("claveacceso"));
                    empleado.setTel(rs.getInt("telefono"));
                    empleado.setEstado(rs.getBoolean("estado"));
                } else {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                    empleado.setDni(rs.getInt("dni"));
                    empleado.setApellido(rs.getString("apellido"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setUsuario(rs.getString("usuario"));
                    empleado.setContra(rs.getString("contraseña"));
                    empleado.setClave(rs.getString("claveacceso"));
                    empleado.setTel(rs.getInt("telefono"));
                    empleado.setEstado(rs.getBoolean("estado"));
                    
                      String mensaje = "El empleado "+empleado.getApellido()+" "+empleado.getNombre()+ " ha sido dado de baja";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Dado de Baja", JOptionPane.PLAIN_MESSAGE, icono);
                }
            } else {
                  String mensaje = "El empleado que busca no se encuentra registrado";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Empleado inexistente", JOptionPane.PLAIN_MESSAGE, icono);
            }
            ps.close();
        } catch (SQLException ex) {
             String mensaje = "Error al acceder a la Tabla de Empleados";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
        return empleado;
    }
}