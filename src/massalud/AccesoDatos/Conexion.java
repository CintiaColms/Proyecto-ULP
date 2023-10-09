/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud.AccesoDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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

        JOptionPane.showMessageDialog(null, "Conectado");

      } catch (ClassNotFoundException ex) {

        JOptionPane.showMessageDialog(null, "Error al cargar el Driver");

      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al conectar");

      }
    }
    return connection;
  }
    
}
