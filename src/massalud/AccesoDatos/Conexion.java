/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud.AccesoDatos;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author DANILO
 */
public class Conexion {
    
    private static final String Url="jdbc:mariadb://localhost/";
  private static final String DB="massalud";
  private static final String Usuario="root";
  private static final String Password="";
  private static  Connection connection;
  private Conexion(){}
  public static Connection getConexion() {
    if (connection == null) {
      try {

        Class.forName("org.mariadb.jdbc.Driver");
        connection=DriverManager.getConnection(Url+DB,Usuario,Password);
  String mensajecon = "Conectado" ;
      UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
      UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
       UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 16));

ImageIcon iconom = new ImageIcon(Conexion.class.getResource("/massalud/Recursos/icob.png"));

      JOptionPane.showMessageDialog(null, mensajecon, "Conexión", JOptionPane.PLAIN_MESSAGE, iconom);


      } catch (ClassNotFoundException ex) {

        JOptionPane.showMessageDialog(null, "Error al cargar el Driver");

      } catch (SQLException ex) {
        String mensajecon = "Error al conectar" ;
      UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));
      UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
       UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 16));

ImageIcon iconom = new ImageIcon(Conexion.class.getResource("/massalud/Recursos/icob.png"));

      JOptionPane.showMessageDialog(null, mensajecon, "Conexión", JOptionPane.PLAIN_MESSAGE, iconom);

      }
    }
    return connection;
  }
    
}
