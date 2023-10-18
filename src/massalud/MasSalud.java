/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;




import javax.swing.JOptionPane;
import massalud.AccesoDatos.AfiliadoData;
//import massalud.AccesoDatos.AfiliadoData;

import massalud.AccesoDatos.Conexion;
import massalud.AccesoDatos.EspecialidadData;

import massalud.AccesoDatos.OrdenData;
import massalud.AccesoDatos.PrestadorData;

import massalud.Entidades.Afiliado;
import massalud.Entidades.Empleado;
import massalud.Entidades.Especialidad;
import massalud.Entidades.Orden;

import massalud.Entidades.Prestador;


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

   
//--EMPIEZA ORDEN-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ----GUARDAR ORDEN ----------------------------------------------------------------------------------------------------------------  
// 
//    Empleado juan = new Empleado(1, "Max", "Power", 12345678, "Maxpower", "contraseña123", 1234567890, "Password123", true);
//    Afiliado a = new Afiliado(1, "Candela", "Romero", 12345678, "Junin 987", 2147483647, juan, true);

//    Especialidad e = new Especialidad(2, "Cardiología", true);
//    Prestador p = new Prestador(1, "Juan", "Pérez", "Hospital ABC", "Calle Principal 123", "123456789", "juan@example.com", e, true);
//    Orden ord = new Orden(LocalDate.of(2023, 10, 10), "Efvo", 500, a, p);
//    OrdenData ordD = new OrdenData();
//    
//
//     ordD.guardarOrden(ord); 
//
//--MODIFICAR ORDEN: ---------------------------------------------------
//    Orden ordenModificada = new Orden(1, LocalDate.of(2023, 9, 22), "Tarjeta de Débito", 400, a, p);
//    ordD.modificarOrden(ordenModificada);
//--ELIMINA ORDEN------------------------------------------------------------------------------------------------------
//    int idOrdenAEliminar = 2; // 
//    ordD.eliminarOrden(idOrdenAEliminar);
//---BUSCAR ORDEN POR FECHA---------------------------------------------------------------------------------------------------------------------
//    LocalDate fechaBusqueda = LocalDate.of(1999, 5, 22); // Fecha de búsqueda
//    List<Orden> ordenesEncontradas = ordD.buscarOrdenesPorFecha(fechaBusqueda);
//    ord.setAfiliado(a);
//    if (!ordenesEncontradas.isEmpty()) {
//      System.out.println("-----------------------------------------------------------------------");
//
//      System.out.println(" Órdenes encontradas por fecha: ");
//      System.out.println("-----------------------------------------------------------------------\n");
//      for (Orden orden : ordenesEncontradas) {
//        System.out.println("ID de Orden: " + orden.getIdOrden());
//        System.out.println("Fecha: " + orden.getFecha());
//        System.out.println("Forma de Pago: " + orden.getFormaDePago());
//        System.out.println("Importe: " + orden.getImporte());
//        System.out.println("Nombre afiliado: " + orden.getAfiliado().getNombre());
//        System.out.println("Especialidad del prestador: " + orden.getPrestador().getEspecialidad().getNombre());
//        System.out.println("-----------------------------------------------------------------------");
//        // Imprimir otros detalles de la orden según sea necesario
//      }
//    } else {
//      System.out.println("No se encontraron órdenes para la fecha especificada.");
//    }
//----BUSCAR ORDEN POR ID-AFILIADO----------------------------------------------------------------------------------------------------------------------
//  
//
//        int afiliadoIdAfiliado = 5; // Replace with the actual ID of the Afiliado you want to search for.
//
//        List<Orden> ordenesEncontradas = ordD.buscarOrdenesPorAfiliado(afiliadoIdAfiliado);
//
//        if (!ordenesEncontradas.isEmpty()) {
//            System.out.println("-----------------------------------------------------------------------");
//            System.out.println("Órdenes encontradas para el Afiliado ID " + afiliadoIdAfiliado+ ":");
//            System.out.println("-----------------------------------------------------------------------\n");
//            for (Orden orden : ordenesEncontradas) {
//                System.out.println("ID de Orden: " + orden.getIdOrden());
//                System.out.println("Fecha: " + orden.getFecha());
//                System.out.println("Forma de Pago: " + orden.getFormaDePago());
//                System.out.println("Importe: " + orden.getImporte());
//                System.out.println("Nombre afiliado: " + orden.getAfiliado().getNombre());
//                System.out.println("Especialidad del prestador: " + orden.getPrestador().getEspecialidad().getNombre());
//                System.out.println("-----------------------------------------------------------------------");
//                // Print other order details as needed.
//            }
//        } else {
//            System.out.println("No se encontraron órdenes para el Afiliado ID " + afiliadoIdAfiliado + ".");
//        }
//----BUSCAR ORDEN POR ID-PRESTADOR-----------------------------------------------------------------------------------------------------------
//        int idPrestadorABuscar = 6; // Reemplaza con el ID del Prestador que deseas buscar.
//
//        List<Orden> ordenesEncontradas = ordD.buscarOrdenesPorPrestador(idPrestadorABuscar);
//
//        if (!ordenesEncontradas.isEmpty()) {
//            System.out.println("-----------------------------------------------------------------------");
//            System.out.println("Órdenes encontradas para el Prestador con ID " + idPrestadorABuscar + ":");
//            System.out.println("-----------------------------------------------------------------------\n");
//            for (Orden orden : ordenesEncontradas) {
//                System.out.println("ID de Orden: " + orden.getIdOrden());
//                System.out.println("Fecha: " + orden.getFecha());
//                System.out.println("Forma de Pago: " + orden.getFormaDePago());
//                System.out.println("Importe: " + orden.getImporte());
//                System.out.println("Nombre del Afiliado: " + orden.getAfiliado().getNombre());
//                System.out.println("Especialidad del Prestador: " + orden.getPrestador().getEspecialidad().getNombre());
//                System.out.println("-----------------------------------------------------------------------");
//                // Muestra otros detalles de la orden según sea necesario.
//            }
//        } else {
//            System.out.println("No se encontraron órdenes para el Prestador con ID " + idPrestadorABuscar + ".");
//        }  
//----BUSCAR ORDEN POR ID-ORDEN----------------------------------------------------------------------------------------------------------------------
//          int idOrdenABuscar = 25; // Reemplaza con el ID de la orden que deseas buscar.
//
//        Orden ordenEncontrada = ordD.buscarOrdenPorId(idOrdenABuscar);
//
//        if (ordenEncontrada != null) {
//            System.out.println("------------------------------------------------------------------------------------");
//            System.out.println("Detalles de la Orden encontrada (ID " + idOrdenABuscar + "):");
//            System.out.println("------------------------------------------------------------------------------------");
//            System.out.println("ID de Orden: " + ordenEncontrada.getIdOrden()+"                            || Fecha: " + ordenEncontrada.getFecha());
//            System.out.println("Forma de Pago: " + ordenEncontrada.getFormaDePago()+"                        ||Importe: " + ordenEncontrada.getImporte());
//            System.out.println("\nID Afiliado:"+ordenEncontrada.getAfiliado().getIdafiliaado()+"\t\t|| Afiliado: " + ordenEncontrada.getAfiliado().getNombre()+
//                    " "+ordenEncontrada.getAfiliado().getApellido()+"\t\t  ||DNI: "+ordenEncontrada.getAfiliado().getDni()+"\n");
//            System.out.println("Prestador: " + ordenEncontrada.getPrestador().getInstitucion()+
//                    "                    || Direccion: "+ordenEncontrada.getPrestador().getDireccion());            
//            System.out.println("Médico/Especialista: " + ordenEncontrada.getPrestador().getNombre()+
//                    " "+ordenEncontrada.getPrestador().getApellido()+"            || Especialidad:" + ordenEncontrada.getPrestador().getEspecialidad().getNombre());
//            System.out.println("------------------------------------------------------------------------------------");
//            // Puedes imprimir otros detalles de la orden según sea necesario.
//        } else {
//            System.out.println("No se encontró una orden con el ID " + idOrdenABuscar + ".");
//        }

//----LISTA ORDENES-----------------------------------------------------------------------------------------------------------
//List<Orden> ordenes = ordD.listarOrden();
//
//        if (!ordenes.isEmpty()) {
//            System.out.println("-----------------------------------------------------------------------");
//            System.out.println("Lista de Órdenes:");
//            System.out.println("-----------------------------------------------------------------------\n");
//            for (Orden orden : ordenes) {
//                System.out.println("ID de Orden: " + orden.getIdOrden());
//                System.out.println("Fecha: " + orden.getFecha());
//                System.out.println("Forma de Pago: " + orden.getFormaDePago());
//                System.out.println("Importe: " + orden.getImporte());
//                System.out.println("ID Afiliado: " + orden.getAfiliado().getIdafiliaado());
//                System.out.println("ID Prestador: " + orden.getPrestador().getIdPrestador());
//                System.out.println("-----------------------------------------------------------------------");
//                // Puedes imprimir otros detalles de la orden según sea necesario.
//            }
//        } else {
//            System.out.println("No se encontraron órdenes.");
//        }   
//// ----TERMINA ORDEN --------------------------------------------------------------------------------------
//        }
//    }

  
        

////INICIO PRESTADOR////-----------------------------------------------------------------------------------------------////
//    AfiliadoData ad=new AfiliadoData();
//        PrestadorData pData = new PrestadorData();
//        EspecialidadData eData = new EspecialidadData();
//        Especialidad e = new Especialidad();
//        Prestador p = new Prestador();

////CREAR UN NUEVO PRESTADOR
//    try {
//    Prestador nuevoP = new Prestador();
//    nuevoP.setNombre("Kal");
//    nuevoP.setApellido("Parker");
//    nuevoP.setDni(3326999);
//    nuevoP.setInstitucion("Manantial");
//    nuevoP.setDireccion("Calle Segura 123");
//    nuevoP.setTelefono("033456");
//    nuevoP.setEmail("Kal@example.com");
//    e.setIdEspecialidad(2);
//    nuevoP.setEspecialidad(e);
//    nuevoP.setEstado(true);
//    pData.guardarPrestador(nuevoP);
//    System.out.println("Nuevo Prestador agregado con éxito.");
//    } catch (Exception ex) {
//    System.err.println("Error al guardar el Prestador: " + ex.getMessage());
//    }
//    }
//    }
////MOSTRAR LISTA DE PRESTADORES EXISTENTES--------------------------------------------------------------------////
//       
//     List<Prestador> prestadores = pData.obtenerPrestadores();
//     prestadores.forEach(prestador -> {
//     System.out.println(prestador.getApellido() + ", " + prestador.getNombre() + ", " + prestador.getEspecialidad().getNombre() + ", " + prestador.getInstitucion());
//     });
//     }
//     }
////BUSCAR UN PRESTADOR POR ID Y MOSTRAR TODOS SUS DATOS------------------------------------------------////
//
//     int id = 10;
//     p = (Prestador) pData.buscarPrestador(id);
//     if (p== null) {
//     System.out.println("Prestador con ID " + id + " no encontrado.");
//     } else {
//     System.out.println("Prestador encontrado:");
//     System.out.println("ID: " + p.getIdPrestador());
//     System.out.println("Nombre: " + p.getNombre());
//     System.out.println("Apellido: " + p.getApellido());
//     System.out.println("DNI " + p.getDni());
//     System.out.println("Institución: " + p.getInstitucion());
//     System.out.println("Dirección: " + p.getDireccion());
//     System.out.println("Telefono: " + p.getTelefono());
//     System.out.println("Email: " + p.getEmail());
//     if (p.isEstado()) {
//     System.out.println("Estado: Activo");
//     } else {
//     System.out.println("Estado: Inactivo");
//     }
//     int idEspecialidad = p.getEspecialidad().getIdEspecialidad();
//     String nombreEspecialidad = eData.buscarEspecialidadPorId(idEspecialidad).getNombre();
//     System.out.println("Número de Especialidad: " + idEspecialidad);
//     System.out.println("Nombre de Especialidad: " + nombreEspecialidad);
//     }
//     }
//}
//////BUSCAR UNA ESPECIALIDAD POR ID-------------------------------------------------------------------------------////
//
//     e = eData.buscarEspecialidadPorId(2);
//     System.out.println("La especialidad es: " + e);
//     String mensaje = "La especialidad " + e;
//     JOptionPane.showMessageDialog(null, mensaje, "Especialidad Encontrada", JOptionPane.INFORMATION_MESSAGE);
//     }
//     }
////BUSCAR PRESTADOR POR NOMBRE DE ESPECIALIDAD--------------------------------------------------------------////
//     String nombreEspecialidadABuscar = "ortopedia";
//     List<Prestador> prestadoresEncontrados = pData.buscarPrestadoresPorEspecialidad(nombreEspecialidadABuscar);
//    
//      if (!prestadoresEncontrados.isEmpty()) {
//      System.out.println("Prestadores encontrados con la especialidad '" + nombreEspecialidadABuscar + "':");
//      for (Prestador prestador : prestadoresEncontrados) {
//      System.out.println("Nombre: " + prestador.getNombre());
//      System.out.println("Apellido: " + prestador.getApellido());
//      System.out.println("DNI: " + prestador.getDni());
//      System.out.println("Especialidad: " + prestador.getEspecialidad().getNombre());
//      System.out.println("Institución: " + prestador.getInstitucion());
//      System.out.println("Dirección: " + prestador.getDireccion());
//      System.out.println("Teléfono: " + prestador.getTelefono());
//      System.out.println("Email: " + prestador.getEmail());
//      System.out.println("Estado: " + (prestador.isEstado() ? "Activo" : "Inactivo"));
//      System.out.println("------------------------------");
//      }
//      } else {
//      System.out.println("No se encontraron prestadores con la especialidad '" + nombreEspecialidadABuscar + "'");
//      }
//      }
//      }
//////METODO ACTUALIZAR QUE MUESTRA SOLO LOS CAMBIOS-------------------------------------------------------////
//       // Crear una instancia de Especialidad con el ID correcto
//        e = eData.buscarEspecialidadPorId(6);
//
//        // Configurar los datos del Prestador
//        p.setIdPrestador(22); // ID del prestador a actualizar
//        p.setNombre("Kal");
//        p.setApellido("Parker");
//        p.setDni(9999999);
//        p.setInstitucion("Manantial");
//        p.setDireccion("Calle Segura 123");
//        p.setTelefono("0334567");
//        p.setEmail("Kal@example.com");
//        p.setEspecialidad(e); // Establecer la Especialidad cargada
//        p.setEstado(true);
//
//        // Actualizar el Prestador
//        pData.actualizarPrestador(p);
//    }
//}
////ELIMINAR UN PRESTADOR A TRAVES DE SU ID---------------------------------------------------------------------////
//      int idAEliminar = 22;
//      pData.eliminarPrestador(idAEliminar);
//      }
//      }

////FIN CLASE PRESTADOR////-------------------------------------------------------------------------------------------////


//        Connection con=Conexion.getConexion();
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
//   AfiliadoData ad=new AfiliadoData();
//         Empleado e=new Empleado(1,"Max","Power",12345678,"Maxpower","contraseña123", 1234567890,"pasword123", true);
//        Afiliado a=new Afiliado(15,"Danilo","Garay",98124510,"Riobamba 785",32145689, e ,true);    
//        ad.guardarAfiliado(a); guardar afiliado
//        ad.modificarAfiliado(a); modificar afiliado
//          ad.eliminarAfiliado(15); eliminado logico de afiliado
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
//          for(Afiliado a: ad.listarAfiliado()){
//          
//              System.out.println("ID "+a.getIdafiliaado());
//              System.out.println("Nombre "+a.getNombre());
//              System.out.println("Apellido "+a.getApellido());
//              System.out.println("Domicilio "+a.getDomicilio());
//          
//          }


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
//                            String apellido="Garay";
//                            
//
//                                for (Afiliado a : ad.buscarAfiliadoPorApellido(apellido)) {
//                                   
//                                    System.out.println("Nombre: " + a.getNombre());
//                                    System.out.println("DNI: " + a.getDni());
//                                    System.out.println("Direccion: " + a.getDomicilio());
//                                    System.out.println("Telefono: " + a.getTelefono());
//                                   }
//                                }
//          
//      }
  
  }
}