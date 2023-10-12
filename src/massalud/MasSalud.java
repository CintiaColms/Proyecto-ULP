/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import massalud.AccesoDatos.AfiliadoData;
//import massalud.AccesoDatos.AfiliadoData;
import massalud.AccesoDatos.Conexion;
import massalud.AccesoDatos.EmpleadoData;
import massalud.AccesoDatos.EspecialidadData;
import massalud.AccesoDatos.OrdenData;
import massalud.AccesoDatos.PrestadorData;
import massalud.Entidades.Afiliado;
import massalud.Entidades.Empleado;
import massalud.Entidades.Especialidad;
import massalud.Entidades.Orden;
//import massalud.Entidades.Prestador;
import massalud.Entidades.Prestador;
//import massalud.AccesoDatos.EspecialidadData;
//import massalud.AccesoDatos.PrestadorData;

/**
 *
 * @author DANILO
 */
public class MasSalud {

  /**
   * @param args the command line arguments
   */
    
  public static void main(String[] args) {

    Connection con = Conexion.getConexion();
  
        

////CLASE PRESTADOR
        EspecialidadData especialidadData = new EspecialidadData();
        PrestadorData prestadorData = new PrestadorData();
        AfiliadoData ad=new AfiliadoData();
//        Prestador p = new Prestador();
//// MOSTRAR LISTA DE PRESTADORES EXISTENTES
//        List<Prestador> prestadores = prestadorData.obtenerPrestadores();
//        prestadores.forEach(p -> {
//            System.out.println(p.getApellido() + ", " + p.getNombre() + ", " + p.getEspecialidad().getNombre() + ", " + p.getInstitucion());
//        });
//  }
//}
////--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------////
////BUSCAR UN PRESTADOR POR ID Y MOSTRAR TODOS SUS DATOS
//        int id = 10;
//        Prestador prestador = (Prestador) prestadorData.buscarPrestador(id);
//        if (prestador == null) {
//            System.out.println("Prestador con ID " + id + " no encontrado.");
//        } else {
//            System.out.println("Prestador encontrado:");
//            System.out.println("ID: " + prestador.getIdPrestador());
//            System.out.println("Nombre: " + prestador.getNombre());
//            System.out.println("Apellido: " + prestador.getApellido());
//            System.out.println("Institución: " + prestador.getInstitucion());
//            System.out.println("Dirección: " + prestador.getDireccion());
//            System.out.println("Telefono: " + prestador.getTelefono());
//            System.out.println("Email: " + prestador.getEmail());
//            if (prestador.isEstado()) {
//                System.out.println("Estado: Activo");
//            } else {
//                System.out.println("Estado: Inactivo");
//            }
//            int idEspecialidad = prestador.getEspecialidad().getIdEspecialidad();
//            String nombreEspecialidad = especialidadData.buscarEspecialidadPorId(idEspecialidad).getNombre();
//            System.out.println("Número de Especialidad: " + idEspecialidad);
//            System.out.println("Nombre de Especialidad: " + nombreEspecialidad);
//        }
//
//  }
//}
////--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------////
////BUSCAR UNA ESPECIALIDAD POR ID
//     Especialidad especialidad = especialidadData.buscarEspecialidadPorId(10);
//     System.out.println("La especialidad es: " + especialidad);
//     String mensaje = "La especialidad " + especialidad ;
//     JOptionPane.showMessageDialog(null, mensaje, "Especialidad Encontrada", JOptionPane.INFORMATION_MESSAGE);
//
//  }
//}
////--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------////
////BUSCAR UN PRESTADOR POR EL NOMBRE DE ESPECIALIDAD
//      String nombreEspecialidadABuscar = "urologia";
//      Prestador prestadorEncontrado = prestadorData.buscarPrestadorPorEspecialidad(nombreEspecialidadABuscar);
//      if (prestadorEncontrado != null) {
//          System.out.println("Prestador encontrado exitosamente:\n"
//                  + "Nombre: " + prestadorEncontrado.getNombre() + "\n"
//                  + "Apellido: " + prestadorEncontrado.getApellido() + "\n"
//                  + "Especialidad: " + prestadorEncontrado.getEspecialidad() + "\n"
//                  + "Institución: " + prestadorEncontrado.getInstitucion() + "\n"
//                  + "Dirección: " + prestadorEncontrado.getDireccion() + "\n"
//                  + "Teléfono: " + prestadorEncontrado.getTelefono() + "\n"
//                  + "Email: " + prestadorEncontrado.getEmail());
//      } else {
//          System.out.println("Prestador no encontrado.");
//      }
//  }
//}
////--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------////
////ACTUALIZAR PRESTADOR QUE MUESTRA SOLO LOS CAMBIOS
//     Especialidad e = new Especialidad(2, "Cardiología", true);
//     Prestador p = new Prestador(1, "Max", "Pérez", "Hospital ABC", "Calle Principal 123", "0303456789", "juan@example.com", e, true);
//     prestadorData.actualizarPrestador(p);
//  }
//}
////ACTUALIZAR PRESTADOR QUE MUESTRA POR CONSOLA EL ANTES Y DESPUES
//     try {
//     Especialidad e = new Especialidad(2, "Cardiología", true);
//     Prestador prestadorAnterior = new Prestador(1, "Max", "Pérez", "Hospital ABC", "Calle Principal 123", "0303456789", "juan@example.com", e, true);
//     Prestador p;
//     p = new Prestador(1, "Hola", "Pérez", "Hospital ABC", "Calle Principal 123", "0303456789", "juan@example.com", e, true);
//     prestadorData.actualizarPrestador(p, prestadorAnterior);
//     } catch (SQLException e) {
//     System.out.println("Error en el método main: " + e.getMessage());
//}
////--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------////    
////ELIMINAR UN PRESTADOR A TRAVES DE SU ID
//        int idAEliminar = 10; // Reemplaza 10 con el ID del prestador que deseas eliminar
//        prestadorData.eliminarPrestador(idAEliminar);
//    }
//}
////--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------////

  
  
  
  
  
//----------------------------------------------------------------------------------
//    Empleado juan = new Empleado(1, "Max", "Power", 12345678, "Maxpower", "contraseña123", 1234567890, "Password123", true);
//    Afiliado a = new Afiliado(1, "Candela", "Romero", 12345678, "Junin 987", 2147483647, juan, true);
//    Especialidad e = new Especialidad(2, "Cardiología", true);
//    Prestador p = new Prestador(1, "Juan", "Pérez", "Hospital ABC", "Calle Principal 123", "123456789", "juan@example.com", e, true);
//        Orden ord=new Orden(LocalDate.of(2023,10,10),"Efvo",500,a,p);
//      OrdenData ordD=new OrdenData();
//     ordD.guardarOrden(ord); 

//--------- Orden con los valores que necisitamos modificar--------
// IDorden= ingresar id de la orden que deseas modificar
//    Orden ordenModificada = new Orden(1, LocalDate.of(2023, 9, 22), "Tarjeta de Débito", 400, a, p);
////     Llama al método modificarOrden para actualizar la orden en la base de datos
//
//
//    ordD.modificarOrden(ordenModificada);
//    int idOrdenAEliminar = 2; // Reemplaza esto con el ID de la orden que deseas eliminar
//    ordD.eliminarOrden(idOrdenAEliminar);
    //----------------------------------------------------------------------
    
//    LocalDate fechaBusqueda = LocalDate.of(2023, 10, 10); // Fecha de búsqueda
//        List<Orden> ordenesEncontradas = ordD.buscarOrdenesPorFecha(fechaBusqueda);
//ord.setAfiliado(a);
//        if (!ordenesEncontradas.isEmpty()) {
//            System.out.println("Órdenes encontradas por fecha:");
//            for (Orden orden : ordenesEncontradas) {
//                System.out.println("ID de Orden: " + orden.getIdOrden());
//                System.out.println("Fecha: " + orden.getFecha());
//                System.out.println("Forma de Pago: " + orden.getFormaDePago());
//                System.out.println("Importe: " + orden.getImporte());
//                // Imprimir otros detalles de la orden según sea necesario
//                System.out.println();
//            }
//        } else {
//            System.out.println("No se encontraron órdenes para la fecha especificada.");
//        }

//         AfiliadoData afiliadoData = new AfiliadoData();
//        PrestadorData prestadorData = new PrestadorData();
//        OrdenData ordenData = new OrdenData();
////
//        LocalDate fechaBusqueda = LocalDate.of(2023, 10, 10); // Fecha de búsqueda
////        List<Orden> ordenesEncontradas = ordenData.buscarOrdenesPorFecha(fechaBusqueda);
//
////        if (!ordenesEncontradas.isEmpty()) {
////            System.out.println("Órdenes encontradas por fecha:");
//            for (Orden orden : ordenData.buscarOrdenesPorFecha(fechaBusqueda)) {
//                System.out.println("ID de Orden: " + orden.getIdOrden());
//                System.out.println("Fecha: " + orden.getFecha());
//                System.out.println("Forma de Pago: " + orden.getFormaDePago());
//                System.out.println("Importe: " + orden.getImporte());              
//                System.out.println("Nombre afiliado: "+orden.getAfiliado().getNombre());
//              System.out.println("Especialidad   System.out.println(\"Nombre afiliado: \"+orden.getAfiliado().getNombre()); prestador: "+orden.getPrestador().getEspecialidad().getNombre());
//            }
////        } else {
////            System.out.println("No se encontraron órdenes para la fecha especificada.");
////        }
////
////        // Cierra la conexión a la base de datos si es necesario
////        try {
////            con.close();Prestador prestador = new Prestador();
////                    EspecialidadData ed=new EspecialidadData();
////            e.printStackTrace();
//        }
//        
//       
//    }
//        
//      
 

        //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- ---//
        
//                        Connection con=Conexion.getConexion();
                //        Empleado juan = new Empleado("Juan", "Fernandez", 42078248, "JuanFer", "juan1234", 155348604, "alfa23", true);
                //        Afiliado a=new Afiliado(1,"Candela","Romero",12345678,"Junin 987",2147483647,juan,true);
                //        Especialidad e=new Especialidad(1,"Cardiología",true);
                //        Prestador p=new Prestador("Juan","Pérez","Hospital ABC","Calle Principal 123",123456789,"juan@example.com",e ,true);
                //        Orden ord=new Orden(LocalDate.of(1999,5,22),"Efvo",20.20,a,p);
                //      OrdenData ordD=new OrdenData();
                //        ordD.guardarOrden(ord); 
                //        
                //        
                //        Empleado fabio = new Empleado("Fabio", "Alvarez", 17890980, "fab23", "pablo123", 155348604, "beta23", true);
                //        EmpleadoData emp = new EmpleadoData();
                // Agregado de Empleado 
                //        emp.guardarEmpleado(fabio);
                // Modificado de Empleado
                //        Empleado fabio = new Empleado(15,"Fabio alan", "Alvarez", 17890980, "fab23", "fabiocap123", 155348604, "beta23", true);
                //        emp.modificarEmpleado(fabio);
                // Eliminar un Empleado
                //        emp.eliminarEmpleado(11);
                // Buscar un Empleado Por DNI
                //        Empleado empxdni = emp.buscarEmpleadoPorDni(42078248);//Dado de Baja
                //        Empleado empxdni = emp.buscarEmpleadoPorDni(23456789);//No dado de Baja
                //          if(empxdni!= null){
                //            System.out.println("DNI: "+empxdni.getDni());
                //            System.out.println("Apellido: "+empxdni.getApellido());
                //            System.out.println("Nombre: "+empxdni.getNombre());
                //            System.out.println("Telefono: "+empxdni.getTel());
                //            System.out.println("Estado: "+empxdni.isEstado());
                //          }
                // Buscar un Empleado por su ID
                //        Empleado empxid = emp.buscarEmpleado(11);//Dado de Baja
                //        Empleado empxid = emp.buscarEmpleado(10);//No dado de Baja
                //          if(empxid!= null){
                //            System.out.println("DNI: "+empxid.getDni());
                //            System.out.println("Apellido: "+empxid.getApellido());
                //            System.out.println("Nombre: "+empxid.getNombre());
                //            System.out.println("Telefono: "+empxid.getTel());
                //            System.out.println("Estado: "+empxid.isEstado());
                //          }
                // Lista de Empleados
                //        for (Empleado empleado : emp.listarEmpleado()) {
                //            System.out.println("ID: " + empleado.getIdEmpleado());
                //            System.out.println("DNI: " + empleado.getDni());
                //            System.out.println("Apellido:" + empleado.getApellido());
                //            System.out.println("Nombre: " + empleado.getNombre());
                //            System.out.println("Telefono: " + empleado.getTel());
                //            System.out.println("Usuario: " + empleado.getUsuario());
                //            System.out.println("Estado:" + empleado.isEstado());
                //            System.out.println("-------------------------------");
                //        }
//                guardar afiliado
                //   AfiliadoData ad=new AfiliadoData();
//                         Empleado e=new Empleado(1,"Max","Power",12345678,"Maxpower","contraseña123", 1234567890,"pasword123", true);
//                        Afiliado a=new Afiliado(15,"Danilo","Garay",98124510,"Riobamba 785",32145689, e ,true);    
                //        ad.guardarAfiliado(a); guardar afiliado
//                modificar afiliado
                //        ad.modificarAfiliado(a); modificar afiliado
//                eliminar afiliado
                //          ad.eliminarAfiliado(15); eliminado logico de afiliado
//                buscar afiliado
                //          Afiliado afi=ad.buscarAfiliado(10);
                //          if(afi!=null){
                //              System.out.println("Nombre "+afi.getNombre());
                //              System.out.println("Apellido "+afi.getApellido());
                //              System.out.println("DNI "+afi.getDni());
                //              Afiliado afi=ad.buscarAfiliadoPorDni(12345678);
                //                if(afi!=null){
                //              System.out.println("Nombre "+afi.getNombre());
                //              System.out.println("Apellido "+afi.getApellido());
                //              System.out.println("DNI "+afi.getDni());
                //          }
//                listar afiliado
                //          for(Afiliado a: ad.listarAfiliado()){
                //          
                //              System.out.println("ID "+a.getIdafiliaado());
                //              System.out.println("Nombre "+a.getNombre());
                //              System.out.println("Apellido "+a.getApellido());
                //              System.out.println("Domicilio "+a.getDomicilio());
//}
//                        buscar afiliado por dni  
                        
//                            Afiliado afiliado=ad.buscarAfiliadoPorDni(76543210);
//                            if(afiliado != null){
//                                 System.out.println("ID "+afiliado.getIdafiliaado());
//                              System.out.println("Nombre "+afiliado.getNombre());
//                              System.out.println("Apellido "+afiliado.getApellido());
//                              System.out.println("Domicilio "+afiliado.getDomicilio());
//                            
                            
//                            }
                               
//                          buscar afiliado por apellido
                            String apellido="Garay";
                            

                                for (Afiliado a : ad.buscarAfiliadoPorApellido(apellido)) {
                                   
                                    System.out.println("Nombre: " + a.getNombre());
                                    System.out.println("DNI: " + a.getDni());
                                    System.out.println("Direccion: " + a.getDomicilio());
                                    System.out.println("Telefono: " + a.getTelefono());
                                   }
                                }
          
      }

  
  