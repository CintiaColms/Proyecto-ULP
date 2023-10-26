
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import massalud.Entidades.Especialidad;

public class EspecialidadData {

    private Connection con = null;

    public EspecialidadData() {
       con=Conexion.getConexion();
    }

    public void guardarEspecialidad(Especialidad espe) {
        String sql = "insert into especialidad (nombre, estado) Values(?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, espe.getNombre());
            ps.setBoolean(2, espe.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                espe.setIdEspecialidad(rs.getInt(1));
               String mensaje = "Especialidad agregada con exito";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Especialidad agregada", JOptionPane.PLAIN_MESSAGE, icono);
            }
            ps.close();
        } catch (SQLException ex) {
            String mensaje = "Error al acceder a la tabla Especialidad";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
    }
    public void actualizarEspecialidad(Especialidad espe){
        String sql="update especialidad set nombre=?, estado=? where idespecialidad=?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, espe.getNombre());
            ps.setBoolean(2, espe.isEstado());
            ps.setInt(3, espe.getIdEspecialidad());
            int exito=ps.executeUpdate();
            if(exito == 1){
                String mensaje = "Especialidad modificada con exito";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Especialidad modificada", JOptionPane.PLAIN_MESSAGE, icono);            
            }else{
               String mensaje = "Especialidad no pudo ser modificada";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Especialidad sin modificada", JOptionPane.PLAIN_MESSAGE, icono);  
            }
            ps.close();
            
        } catch (SQLException ex) {
           String mensaje = "Error al acceder a la tabla Especialidad";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
        
    
    
    }

    public void eliminarEspecialidad(int id) {
        String sql = "update especialidad set estado=0 where idespecialidad= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                 String mensaje = "Se elimino la Especialidad con ID "+id+" con exito";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Especialidad eliminada", JOptionPane.PLAIN_MESSAGE, icono);
            }
            ps.close();
        } catch (SQLException e) {
            String mensaje = "Error al acceder a laa tabla Especialidad";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }
    }
    

    public List<Especialidad> listarEspecialidad() {
        String sql = "select * from especialidad where estado=1";

        ArrayList<Especialidad> espe = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Especialidad e = new Especialidad();
                e.setIdEspecialidad(rs.getInt("idespecialidad"));
                e.setNombre(rs.getString("nombre"));
                e.setEstado(true);
                espe.add(e);
            }
            ps.close();

        } catch (SQLException ex) {
            String mensaje = "Error al acceder a laa tabla Especialidad";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }

        return espe;
    }

    public Especialidad buscarEspecialidadPorId(int idEspecialidad) {
        Especialidad especialidad = null;
        try {
            String sql = "SELECT * FROM especialidad WHERE idespecialidad = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEspecialidad);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                especialidad = new Especialidad();
                especialidad.setIdEspecialidad(resultSet.getInt("idespecialidad"));
                especialidad.setNombre(resultSet.getString("nombre"));
                especialidad.setEstado(resultSet.getBoolean("estado"));
            }

            ps.close();
        } catch (SQLException e) {
            String mensaje = "Error al acceder a laa tabla Especialidad";
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
            ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.PLAIN_MESSAGE, icono);
        }

        return especialidad;
    }
}
