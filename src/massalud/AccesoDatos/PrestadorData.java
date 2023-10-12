/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package massalud.AccesoDatos;

/**
 *
 * @author Leroom
 */

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import massalud.Entidades.Especialidad;
import massalud.Entidades.Prestador;
import massalud.AccesoDatos.EspecialidadData;

public class PrestadorData {

    private Connection connection=null;
    private EspecialidadData especialidadData;
    public PrestadorData() {
        connection=Conexion.getConexion();
    }
    Prestador prestador = new Prestador();
    
   ////-----------------------------------------------------------------------------------------------------------------------////
    
    public void guardarPrestador(Prestador prestador) {
        try {

            if (prestador.getNombre() == null || prestador.getApellido() == null) {
                return;
            }

            String query = "INSERT INTO prestador (nombre, apellido, institucion, direccion, telefono, email, idespecialidad, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, prestador.getNombre());
                statement.setString(2, prestador.getApellido());
                statement.setString(3, prestador.getInstitucion());
                statement.setString(4, prestador.getDireccion());
                statement.setString(5, prestador.getTelefono());
                statement.setString(6, prestador.getEmail());
                statement.setInt(7, prestador.getEspecialidad().getIdEspecialidad());
                statement.setBoolean(8, prestador.isEstado());
                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    prestador.setIdPrestador(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar el prestador: " + e.getMessage());
        }
   }
   
////-----------------------------------------------------------------------------------------------------------------------////


////METODO ACTUALIZAR QUE MUESTRA SOLO LOS CAMBIOS
public void actualizarPrestador(Prestador prestador) {
    try {
        if (prestador.getIdPrestador() == 0) {
            return;
        }
        String query = "UPDATE prestador SET nombre = ?, apellido = ?, institucion = ?, direccion = ?, telefono = ?, email = ?, idespecialidad = ?, estado = ? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, prestador.getNombre());
            statement.setString(2, prestador.getApellido());
            statement.setString(3, prestador.getInstitucion());
            statement.setString(4, prestador.getDireccion());
            statement.setString(5, prestador.getTelefono());
            statement.setString(6, prestador.getEmail());
            statement.setInt(7, prestador.getEspecialidad().getIdEspecialidad());
            statement.setBoolean(8, prestador.isEstado());
            statement.setInt(9, prestador.getIdPrestador());
            statement.executeUpdate();
            
            String mensaje = "Prestador fue actualizado exitosamente.\n";
            mensaje += "Datos modificados:\n";
            mensaje += "Nombre: " + prestador.getNombre() + "\n";
            mensaje += "Apellido: " + prestador.getApellido() + "\n";
            mensaje += "Institución: " + prestador.getInstitucion() + "\n";
            mensaje += "Dirección: " + prestador.getDireccion() + "\n";
            mensaje += "Teléfono: " + prestador.getTelefono() + "\n";
            mensaje += "Email: " + prestador.getEmail() + "\n";
            mensaje += "Especialidad: " + prestador.getEspecialidad().getNombre() + "\n";
            mensaje += "Estado: " + (prestador.isEstado() ? "Activo" : "Inactivo");

            JOptionPane.showMessageDialog(null, mensaje);
        }
    } catch (SQLException e) {
        System.out.println("Error al actualizar el prestador: " + e.getMessage());
    }
}
    
////METODO ACTUALIZAR QUE MUESTRA POR CONSOLA ANTES Y DESPUES
//public void actualizarPrestador(Prestador prestadorActual, Prestador prestadorAnterior) throws SQLException {
//    if (prestadorActual.getIdPrestador() == 0) {
//        System.out.println("El ID del prestador actual es 0. No se puede actualizar.");
//        return;
//    }
//
//    System.out.println("Datos del prestador antes de la actualización:");
//    System.out.println("Nombre: " + prestadorAnterior.getNombre());
//    System.out.println("Apellido: " + prestadorAnterior.getApellido());
//    System.out.println("Institución: " + prestadorAnterior.getInstitucion());
//    System.out.println("Dirección: " + prestadorAnterior.getDireccion());
//    System.out.println("Teléfono: " + prestadorAnterior.getTelefono());
//    System.out.println("Email: " + prestadorAnterior.getEmail());
//    System.out.println("Especialidad: " + prestadorAnterior.getEspecialidad().getNombre());
//    System.out.println("Estado: " + (prestadorAnterior.isEstado() ? "Activo" : "Inactivo"));
//
//    String query = "UPDATE prestador SET nombre = ?, apellido = ?, institucion = ?, direccion = ?, telefono = ?, email = ?, idespecialidad = ?, estado = ? WHERE id=?";
//    try (PreparedStatement statement = connection.prepareStatement(query)) {
//        statement.setString(1, prestadorActual.getNombre());
//        statement.setString(2, prestadorActual.getApellido());
//        statement.setString(3, prestadorActual.getInstitucion());
//        statement.setString(4, prestadorActual.getDireccion());
//        statement.setString(5, prestadorActual.getTelefono());
//        statement.setString(6, prestadorActual.getEmail());
//        statement.setInt(7, prestadorActual.getEspecialidad().getIdEspecialidad());
//        statement.setBoolean(8, prestadorActual.isEstado());
//        statement.setInt(9, prestadorActual.getIdPrestador());
//        statement.executeUpdate();
//
//        System.out.println("Datos del prestador después de la actualización:");
//        System.out.println("Nombre: " + prestadorActual.getNombre());
//        System.out.println("Apellido: " + prestadorActual.getApellido());
//        System.out.println("Institución: " + prestadorActual.getInstitucion());
//        System.out.println("Dirección: " + prestadorActual.getDireccion());
//        System.out.println("Teléfono: " + prestadorActual.getTelefono());
//        System.out.println("Email: " + prestadorActual.getEmail());
//        System.out.println("Especialidad: " + prestadorActual.getEspecialidad().getNombre());
//        System.out.println("Estado: " + (prestadorActual.isEstado() ? "Activo" : "Inactivo"));
//
//        String mensaje = "Prestador fue actualizado exitosamente.\n";
//        mensaje += "Datos modificados o agregados:\n";
//        mensaje += "Nombre: " + prestadorActual.getNombre() + "\n";
//        mensaje += "Apellido: " + prestadorActual.getApellido() + "\n";
//        mensaje += "Institución: " + prestadorActual.getInstitucion() + "\n";
//        mensaje += "Dirección: " + prestadorActual.getDireccion() + "\n";
//        mensaje += "Teléfono: " + prestadorActual.getTelefono() + "\n";
//        mensaje += "Email: " + prestadorActual.getEmail() + "\n";
//        mensaje += "Especialidad: " + prestadorActual.getEspecialidad().getNombre() + "\n";
//        mensaje += "Estado: " + (prestadorActual.isEstado() ? "Activo" : "Inactivo");
//
//        JOptionPane.showMessageDialog(null, mensaje);
//    } catch (SQLException e) {
//        System.out.println("Error al actualizar el prestador: " + e.getMessage());
//    }
//}


   ////-----------------------------------------------------------------------------------------------------------------------////
    
    public void eliminarPrestador(int id) {
        try {
            String query = "DELETE FROM prestador WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    String mensajeConfirmacion = "El prestador con ID " + id + " fue eliminado exitosamente.";
                    JOptionPane.showMessageDialog(null, mensajeConfirmacion, "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    String mensajeError = "Error: No se encontró prestador con ID " + id + " para eliminar.";
                    JOptionPane.showMessageDialog(null, mensajeError, "Error al Eliminar", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            String mensajeError = "Error al eliminar el prestador: " + e.getMessage();
            JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    ////-----------------------------------------------------------------------------------------------------------------------////
    

public List<Prestador> obtenerPrestadores() {
    List<Prestador> prestadores = new ArrayList<>();
    try {
        String sql = "SELECT * FROM prestador";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Prestador prestador = new Prestador();
                prestador.setIdPrestador(resultSet.getInt("id"));
                prestador.setNombre(resultSet.getString("nombre"));
                prestador.setApellido(resultSet.getString("apellido"));
                prestador.setInstitucion(resultSet.getString("institucion"));
                prestador.setDireccion(resultSet.getString("direccion"));
                prestador.setTelefono(resultSet.getString("telefono"));
                prestador.setEmail(resultSet.getString("email"));
                EspecialidadData ed = new EspecialidadData();
                Especialidad especialidad = ed.buscarEspecialidadPorId(resultSet.getInt("idespecialidad"));
                prestador.setEspecialidad(especialidad);
                prestador.setEstado(resultSet.getBoolean("estado"));
                prestadores.add(prestador);
            }

            if (prestadores.isEmpty()) {
                String mensajeError = "Error: No se encontraron prestadores.";
                JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                StringBuilder mensajeExito = new StringBuilder("La lista de prestadores es:\n");
                for (Prestador p : prestadores) {
                    mensajeExito.append("ID: ").append(p.getIdPrestador()).append("\n");
                    mensajeExito.append("Nombre: ").append(p.getNombre()).append("\n");
                    mensajeExito.append("Apellido: ").append(p.getApellido()).append("\n");
                    mensajeExito.append("Institución: ").append(p.getInstitucion()).append("\n");
                    mensajeExito.append("Dirección: ").append(p.getDireccion()).append("\n");
                    mensajeExito.append("Teléfono: ").append(p.getTelefono()).append("\n");
                    mensajeExito.append("Email: ").append(p.getEmail()).append("\n");
                    mensajeExito.append("Especialidad: ").append(p.getEspecialidad().getNombre()).append("\n");
                    mensajeExito.append("Estado: ").append(p.isEstado() ? "Activo" : "Inactivo").append("\n");
                    mensajeExito.append("-------------------------------------------------\n");
                }

                JTextArea textArea = new JTextArea(mensajeExito.toString());
                textArea.setWrapStyleWord(true);
                textArea.setLineWrap(true);
                textArea.setCaretPosition(0);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(600, 400));


                JOptionPane.showMessageDialog(null, scrollPane, "Prestadores Encontrados", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    } catch (SQLException e) {
        // Manejo de errores
    }
    return prestadores;
}
    ////-----------------------------------------------------------------------------------------------------------------------////
 
////BUSCAR UN PRESTADOR POR ID Y MOSTRAR TODOS SUS DATOS
public Prestador buscarPrestador(int idABuscar) {
    Prestador prestador = null;
    try {
        String sql = "SELECT * FROM prestador WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idABuscar);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            EspecialidadData ed = new EspecialidadData();
            prestador = new Prestador();
            prestador.setIdPrestador(resultSet.getInt("id"));
            prestador.setNombre(resultSet.getString("nombre"));
            prestador.setApellido(resultSet.getString("apellido"));
            prestador.setInstitucion(resultSet.getString("institucion"));
            prestador.setDireccion(resultSet.getString("direccion"));
            prestador.setTelefono(resultSet.getString("telefono"));
            prestador.setEmail(resultSet.getString("email"));
            Especialidad especialidad = ed.buscarEspecialidadPorId(resultSet.getInt("idespecialidad"));
            prestador.setEspecialidad(especialidad);
            prestador.setEstado(resultSet.getBoolean("estado"));

            String mensaje = "El prestador fue encontrado exitosamente:\n";
            mensaje += "ID: " + prestador.getIdPrestador() + "\n";
            mensaje += "Nombre: " + prestador.getNombre() + "\n";
            mensaje += "Apellido: " + prestador.getApellido() + "\n";
            mensaje += "Institución: " + prestador.getInstitucion() + "\n";
            mensaje += "Dirección: " + prestador.getDireccion() + "\n";
            mensaje += "Teléfono: " + prestador.getTelefono() + "\n";
            mensaje += "Email: " + prestador.getEmail() + "\n";
            mensaje += "Especialidad: " + prestador.getEspecialidad().getNombre() + "\n";
            mensaje += "Estado: " + (prestador.isEstado() ? "Activo" : "Inactivo");

            JOptionPane.showMessageDialog(null, mensaje, "Prestador Encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException p) {
        String mensaje = "Error al obtener prestador: " + p.getMessage();
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    return prestador;
}
 ////-----------------------------------------------------------------------------------------------------------------------////

////Buscar un prestador por el nombre de la especialidad
public Prestador buscarPrestadorPorEspecialidad(String nombreEspecialidad) {
    Prestador prestador = null;
    try {
        String sql = "SELECT p.* FROM prestador p INNER JOIN especialidad e ON p.idespecialidad = e.idespecialidad WHERE e.nombre = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nombreEspecialidad);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            EspecialidadData ed = new EspecialidadData();
            prestador = new Prestador();
            prestador.setIdPrestador(resultSet.getInt("id"));
            prestador.setNombre(resultSet.getString("nombre"));
            prestador.setApellido(resultSet.getString("apellido"));
            prestador.setInstitucion(resultSet.getString("institucion"));
            prestador.setDireccion(resultSet.getString("direccion"));
            prestador.setTelefono(resultSet.getString("telefono"));
            prestador.setEmail(resultSet.getString("email"));
            Especialidad especialidad = ed.buscarEspecialidadPorId(resultSet.getInt("idespecialidad"));
            prestador.setEspecialidad(especialidad);
            prestador.setEstado(resultSet.getBoolean("estado"));
            String mensaje = "Prestador encontrado exitosamente:\n" +
                "Nombre: " + prestador.getNombre() +  "\n"+
                "Apellido: " + prestador.getApellido() + "\n" +
                "Especialidad: " + prestador.getEspecialidad() + "\n" +
                "Institución: " + prestador.getInstitucion() + "\n" +
                "Dirección: " + prestador.getDireccion() + "\n" +
                "Teléfono: " + prestador.getTelefono() + "\n" +
                "Email: " + prestador.getEmail();
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            String mensajeError = "Error: No se encontró prestador con especialidad '" + nombreEspecialidad + "'";
            JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException p) {
        String mensaje = "Error al obtener prestador: " + p.getMessage();
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    return prestador;
}}