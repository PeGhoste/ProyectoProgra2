package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.CsConexion;

public class CsEmpleado {
    
    private Connection con;  // conexión a la base de datos
    private Statement stm;   // para ejecutar consultas
    private ResultSet rs;    // resultados de consultas
    
    public CsEmpleado() {
        this.con = null;
        this.stm = null;
    }
    
    // insertar datos
    public int insertarEmpleado(String Nombres, String Apellidos, String Correo, String Telefono) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "insert into DBProyectoProgra2.dbo.Empleado (Nombre, Apellidos, Correo, Telefono) " +
                "values ('" + Nombres + "', '" + Apellidos + "', '" + Correo + "', '" + Telefono + "')"
            );
            
            c1.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
        return respuesta;
    }    
    
    // actualizar datos
    public int actualizarEmpleado(String Nombres, String Apellidos, String Correo, String Telefono, int idEmpleado) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
            
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "update dbo.Empleado set Nombres='" + Nombres + 
                "', Apellidos='" + Apellidos +
                "', Correo='" + Correo +
                "', Correo='" + Telefono +
                "' where idEmpleado=" + idEmpleado
            );
            
            c1.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    // eliminar datos
    public int eliminarEmpleado(int idEmpleado) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "delete from dbo.Empleado where idEmpleado=" + idEmpleado
            );
            
            c1.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta; 
    }
   
    // listar todos los registros
    public ArrayList<Empleado> listarEmpleado() {
        Empleado p = null; 
        ArrayList<Empleado> lista = new ArrayList<>();
                
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("select * from dbo.Empleado");
            
            while (rs.next()) {
                p = new Empleado(
                        rs.getString("Nombres"),
                        rs.getString("Apellidos"),
                        rs.getString("Correo"),
                        rs.getString("Telefono"),
                        rs.getInt("idEmpleado")
                );
                lista.add(p);
            }
            
            c1.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    // listar por ID
    public Empleado listarEmpleadoPorID(int idEmpleado) {
        Empleado p = null; 
                        
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(
                "select * from dbo.Empleado where idEmpleado=" + idEmpleado
            );
            
            while (rs.next()) {
                p = new Empleado(
                        rs.getString("Nombres"),
                        rs.getString("Apellidos"),
                        rs.getString("Correo"),
                        rs.getString("Telefono"),
                        rs.getInt("idEmpleado")
                );
            }
            
            c1.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;
    }
}