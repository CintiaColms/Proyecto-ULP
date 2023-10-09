/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud.AccesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import massalud.Entidades.Orden;

/**
 *
 * @author Cintia
 */
public class OrdenData {
  
   private Connection con=null;
//    private AfiliadoData afiData=new AfiliadoData();
//  private PrestadorData presData=new PrestadorData();

    public OrdenData() {
        con=Conexion.getConexion();
    }
    
  public void guardarOrden(Orden ord) {
    String sql = "INSERT INTO orden (fecha,formaDePago,importe,idafiliado, idprestador) "
            + "VALUES (?, ?, ?, ?, ?)";
       try {
           PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setDate(1, Date.valueOf(ord.getFecha()));
           ps.setString(2, ord.getFormaDePago());
           ps.setDouble(3, ord.getImporte());
           ps.setInt(4, ord.getAfiliado().getIdafiliaado());
           ps.setInt(5, ord.getPrestador().getId());
           
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                ord.setIdOrden(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Orden generada a nombre de: "+ ord.getAfiliado().getApellido()+" "+ord.getAfiliado().getNombre());
            
            }     
           ps.close();
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Orden "+ex.getMessage());
            
       }

    

    

  }
          public void actualizarOrden(int idafiliado, int idprestador, LocalDate fecha){
        
        String sql="update inscripcion set fecha=? where idafiliado= ? and idprestador= ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha)); // Convert LocalDate to java.sql.Date          
            ps.setInt(2, idafiliado);
            ps.setInt(3, idprestador);
            int fila=ps.executeUpdate();
            if(fila>0){
                
                 JOptionPane.showMessageDialog(null, "Orden  Actualizada");    
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Orden" + ex.getMessage());
        }
    
    }
//          ps.setDate(1,java.sql.Date.valueOf(ord.getFecha()));
//      ps.setString(2, ord.getFormaDePago());
//      ps.setDouble(3, ord.getImporte());
//      ps.setInt(4, ord.getAfiliado().getIdafiliaado());
//      ps.setInt(5, ord.getPrestador().getId());
//
//      ps.executeUpdate();
//      ResultSet rs = ps.getGeneratedKeys();
//      if (rs.next()) {
//        ord.setIdOrden(rs.getInt(1));
//        JOptionPane.showMessageDialog(null, "Orden generada.");
    
       
    }
    
  
  
