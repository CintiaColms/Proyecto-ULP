/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud.AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import massalud.Entidades.Especialidad;

/**
 *
 * @author DANILO
 */
public class EspecialidadData {
    
     private Connection con = null;
     
     public EspecialidadData(){
     
         con=Conexion.getConexion();
     }
     
     public void guardarEspecialidad(Especialidad espe){
         
         String sql="insert into especialidad (nombre, estado) Values(?, ?)";
         
         try {
             PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, espe.getNombre());
             ps.setBoolean(2, espe.isEstado());
             ps.executeUpdate();
             ResultSet rs=ps.getGeneratedKeys();
             if(rs.next()){
                 espe.setIdEspecialidad(rs.getInt("idespecialidad"));
                 JOptionPane.showMessageDialog(null, "Especialidad añadida con exito.");
             }
             ps.close();
             
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Especialidad" + ex.getMessage());
         }
         
     }
     
     public void eliminarEspecialidad(int id){
     
         String sql="update especialidad set estado=0 where idespecialidad= ?";
         try {
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1, id);
             int fila=ps.executeUpdate();             
           
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó la Especialidad con numero de Identificacion: "+id);
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Especialidad");
        }
     
     }
     
     public List<Especialidad> listarEspecialidad(){
         
         String sql="select * from especialidad where estado=1" ;
         
         ArrayList<Especialidad> espe= new ArrayList<>();
          try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                Especialidad e=new Especialidad();
                e.setIdEspecialidad(rs.getInt("idespecialidad"));
                e.setNombre(rs.getString("nombre"));
                e.setEstado(true);
                espe.add(e);
              
            
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Especialidad "+ex.getMessage());
        }
         
         
     return espe;
     
     }
     
     public Especialidad buscarEspecialidadPorId(int id){
         Especialidad e=null;
         String sql="select * from especialidad where idespecialidad=? and estado=1";
         
         try {
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs=ps.executeQuery();
             
             while(rs.next()){
                  e= new Especialidad();
                 e.setIdEspecialidad(id);
                 e.setNombre(rs.getString("nombre"));
                 e.setEstado(rs.getBoolean("estado"));
             
             }
             
             ps.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Especialidad "+ex.getMessage());
         }
         return e;
         
     }
    
      public Especialidad buscarEspecialidadPorNombre(String nombre){
         Especialidad e=null;
         String sql="select * from especialidad where nombre=? and estado=1";
         
         try {
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1, nombre);
             ResultSet rs=ps.executeQuery();
             
             while(rs.next()){
                  e= new Especialidad();
                 e.setIdEspecialidad(rs.getInt("idespecialidad"));
                 e.setNombre(nombre);
                 e.setEstado(rs.getBoolean("estado"));
             
             }
             
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Especialidad "+ex.getMessage());
         }
         return e;
         
     }
}
