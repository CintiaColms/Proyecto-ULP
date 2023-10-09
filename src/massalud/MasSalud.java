/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud;

import java.sql.Connection;
import massalud.AccesoDatos.AfiliadoData;
import massalud.AccesoDatos.Conexion;

/**
 *
 * @author DANILO
 */
public class MasSalud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



       
        Connection con=Conexion.getConexion();
        
//        Empleado juan = new Empleado("Juan", "Fernandez", 42078248, "JuanFer", "juan1234", 155348604, "alfa23", true);
//        EmpleadoData emp = new EmpleadoData();
        
        // Agregado de Empleado 
//        emp.guardarEmpleado(juan);
        
        // Modificado de Empleado
//        Empleado juan = new Empleado(11,"Juan Antonio", "Fernandez", 42078248, "JuanFer2307", "juan1234", 155348604, "alfa23", true);
//        emp.modificarEmpleado(juan);

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
//            System.out.println("DNI: " + empleado.getDni());
//            System.out.println("Apellido:" + empleado.getApellido());
//            System.out.println("Nombre: " + empleado.getNombre());
//            System.out.println("Telefono: " + empleado.getTel());
//            System.out.println("Estado:" + empleado.isEstado());
//            System.out.println("-------------------------------");
//        }
        AfiliadoData ad=new AfiliadoData();
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
          
          
    
    
    }
    
}
    
    
    

        

