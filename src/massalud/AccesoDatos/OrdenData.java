/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//<<<<<<< HEAD
package massalud.AccesoDatos;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import massalud.Entidades.Afiliado;
import massalud.Entidades.Orden;
import massalud.Entidades.Prestador;

/**
 *
 * @author Cintia
 */
public class OrdenData {

  private Connection con = null;

  public OrdenData() {
    con = Conexion.getConexion();
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
        JOptionPane.showMessageDialog(null, "ID Orden: " + ord.getIdOrden() + "\n Modificada con éxito");
      } else {
        JOptionPane.showMessageDialog(null, "No se encontró la orden para modificar\n Verificar ID de la Orden");
      }
      ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al modificar la orden: " + ex.getMessage());
    }
  }
 
public void eliminarPorFila(String columna, String valor) {
    String sql = "DELETE FROM orden WHERE " + columna + " = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, valor); // Establece el valor de la columna para identificar la fila
        int filasEliminadas = ps.executeUpdate();
//        if (filasEliminadas > 0) {

String mensaje = "" + columna + ": " + valor + "\n Eliminada con éxito";
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
        UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
        ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
        JOptionPane.showMessageDialog(null, mensaje, "Exito", JOptionPane.PLAIN_MESSAGE, icono);

//            JOptionPane.showMessageDialog(null, "Fila con " + columna + ": " + valor + "\n Eliminada con éxito");
//        } else {
//            JOptionPane.showMessageDialog(null, "No se encontró la fila para eliminar\n Verificar el valor de la columna");
//        }
        ps.close();
    } catch (SQLException ex) {
//      String mensaje = "Error al eliminar la fila: ";
//        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
//        UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
//        ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
//        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
//        JOptionPane.showMessageDialog(null, "Error al eliminar la fila: " + ex.getMessage());
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
      rs.close();
      ps.close();
    } catch (SQLException ex) {
       
      ex.printStackTrace();
    }
    return ordenes;
  }

public List<Orden> buscarOrdenesPorAfiliado(int idAafiliado) {
    List<Orden> ordenes = new ArrayList<>();
    String sql = "SELECT * FROM orden WHERE idafiliado = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAafiliado);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Orden ord = new Orden();
            AfiliadoData afiData = new AfiliadoData();
            PrestadorData presData = new PrestadorData();

            ord.setIdOrden(rs.getInt("idOrden"));
            ord.setFecha(rs.getDate("fecha").toLocalDate());
            ord.setFormaDePago(rs.getString("formaDePago"));
            ord.setImporte(rs.getDouble("importe"));
            Afiliado a = afiData.buscarAfiliado(rs.getInt("idafiliado"));
            ord.setAfiliado(a);
            Prestador p = presData.buscarPrestador(rs.getInt("idprestador"));
            ord.setPrestador(p);
            ordenes.add(ord);
        }
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return ordenes;
}


 public List<Orden> buscarOrdenesPorPrestador(int idPrestador) {
        List<Orden> ordenes = new ArrayList<>();
        String sql = "SELECT * FROM orden WHERE idprestador = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPrestador);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orden ord = new Orden();
                AfiliadoData afiData = new AfiliadoData();
                PrestadorData presData = new PrestadorData();

                ord.setIdOrden(rs.getInt("idOrden"));
                ord.setFecha(rs.getDate("fecha").toLocalDate());
                ord.setFormaDePago(rs.getString("formaDePago"));
                ord.setImporte(rs.getDouble("importe"));
                Afiliado a = afiData.buscarAfiliado(rs.getInt("idafiliado"));
                ord.setAfiliado(a);
                Prestador p = presData.buscarPrestador(rs.getInt("idprestador"));
                ord.setPrestador(p);
                ordenes.add(ord);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }
 public Orden buscarOrdenPorId(int idOrden) {
        Orden orden = null;
        String sql = "SELECT * FROM orden WHERE idOrden = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idOrden);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                orden = new Orden();
                AfiliadoData afiData = new AfiliadoData();
                PrestadorData presData = new PrestadorData();

                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setFecha(rs.getDate("fecha").toLocalDate());
                orden.setFormaDePago(rs.getString("formaDePago"));
                orden.setImporte(rs.getDouble("importe"));
                Afiliado a = afiData.buscarAfiliado(rs.getInt("idafiliado"));
                orden.setAfiliado(a);
                Prestador p = presData.buscarPrestador(rs.getInt("idprestador"));
                orden.setPrestador(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orden;
    }
 
 public List<Orden> listarOrden() {
    String sql = "SELECT idOrden, fecha, formaDePago, importe, idafiliado, idprestador FROM orden";
    List<Orden> ordenes = new ArrayList<>();

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Orden orden = new Orden();
            AfiliadoData afiData = new AfiliadoData();
            PrestadorData presData = new PrestadorData();

            orden.setIdOrden(rs.getInt("idOrden"));
            orden.setFecha(rs.getDate("fecha").toLocalDate());
            orden.setFormaDePago(rs.getString("formaDePago"));
            orden.setImporte(rs.getDouble("importe"));

            Afiliado afiliado = afiData.buscarAfiliado(rs.getInt("idafiliado"));
            orden.setAfiliado(afiliado);

            Prestador prestador = presData.buscarPrestador(rs.getInt("idprestador"));
            orden.setPrestador(prestador);

            ordenes.add(orden);
        }

        rs.close();
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Orden: " + ex.getMessage());
    }

    return ordenes;
}
 
}
