/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//<<<<<<< HEAD
package massalud.AccesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import massalud.Entidades.Afiliado;
import massalud.Entidades.Orden;
import massalud.Entidades.Prestador;

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
      ps.setInt(5, ord.getPrestador().getIdPrestador()
      );

      ps.executeUpdate();
      ResultSet rs = ps.getGeneratedKeys();
      if (rs.next()) {
        ord.setIdOrden(rs.getInt(1));
        JOptionPane.showMessageDialog(null, "Orden generada a nombre de: " + ord.getAfiliado().getApellido() + " " + ord.getAfiliado().getNombre());
      }
      ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al guardar Orden " + ex.getMessage());
    }
  }
  
  
    public void modificarOrden(Orden ord) {
    String sql = "UPDATE orden SET fecha = ?, formaDePago = ?, importe = ?, idafiliado = ?, idprestador = ? WHERE idOrden = ?";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setDate(1, Date.valueOf(ord.getFecha()));
      ps.setString(2, ord.getFormaDePago());
      ps.setDouble(3, ord.getImporte());
      ps.setInt(4, ord.getAfiliado().getIdafiliaado());
      ps.setInt(5, ord.getPrestador().getIdPrestador());
      ps.setInt(6, ord.getIdOrden()); // Identificador de la orden a actualizar
      int filasActualizadas = ps.executeUpdate();
      if (filasActualizadas > 0) {
        JOptionPane.showMessageDialog(null, "ID Orden: "+ord.getIdOrden()+"\n Modificada con éxito");
      } else {
        JOptionPane.showMessageDialog(null, "No se encontró la orden para modificar\n Verificar ID de la Orden");
      }
      ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al modificar la orden: " + ex.getMessage());
    }
  }
    
    
    public void eliminarOrden(int idOrden) {
    String sql = "DELETE FROM orden WHERE idOrden = ?";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, idOrden); // Establece el valor del ID de la orden a eliminar
      int filasEliminadas = ps.executeUpdate();
      if (filasEliminadas > 0) {
        JOptionPane.showMessageDialog(null, "ID Orden: " + idOrden + "\n Eliminada con éxito");
      } else {
        JOptionPane.showMessageDialog(null, "No se encontró la orden para eliminar\n Verificar ID de la Orden");
      }
      ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al eliminar la orden: " + ex.getMessage());
    }
  }



  public List<Orden> buscarOrdenesPorFecha(LocalDate fecha) {
    List<Orden> ordenes = new ArrayList<>();
    String sql = "SELECT * FROM orden WHERE fecha = ?";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setDate(1, Date.valueOf(fecha));
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Orden ord = new Orden();
        AfiliadoData afiData = new AfiliadoData();
        PrestadorData presData = new PrestadorData();

        ord.setIdOrden(rs.getInt("idOrden"));
        ord.setFecha(fecha);
        ord.setFormaDePago(rs.getString("formaDePago"));
        ord.setImporte(rs.getDouble("importe"));
        Afiliado a = afiData.buscarAfiliado(rs.getInt("idafiliado"));
        ord.setAfiliado(a);
        Prestador p = presData.buscarPrestador(rs.getInt("idprestador"));
        ord.setPrestador(p);
        ordenes.add(ord);
      }
//            rs.close();
      ps.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return ordenes;
  }
}
