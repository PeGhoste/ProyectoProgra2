package Modelo;

import Connection.CsConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CsSolicitante {
    
    private Connection con;  // conexión a la base de datos
    private Statement stm;   // para ejecutar consultas
    private ResultSet rs;    // resultados de consultas
    
    public CsSolicitante() {
        this.con = null;
        this.stm = null;
    }
    
    // insertar datos
    public int insertarSolicitante(String Nombres, String Apellidos, String Correo, String Telefono) {
        int respuesta = 0;
        CsConexion c2 = new CsConexion();
        con = c2.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "insert into DBProyectoProgra2.dbo.Solicitantes (Nombres, Apellidos, Correo, Telefono) " +
                "values ('" + Nombres + "', '" + Apellidos + "', '" + Correo + "', '" + Telefono + "')"
            );
            
            c2.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
        return respuesta;
    }    
    
    // actualizar datos
    public int actualizarSolicitante(String Nombres, String Apellidos, String Correo, String Telefono, int idSolicitante) {
        int respuesta = 0;
        CsConexion c2 = new CsConexion();
        con = c2.conectar();
            
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "update dbo.Solicitantes set Nombres='" + Nombres + 
                "', Apellidos='" + Apellidos +
                "', Correo='" + Correo +
                "', Telefono='" + Telefono +        
                "' where idSolicitante=" + idSolicitante
            );
            
            c2.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    // eliminar datos
    public int eliminarSolicitante(int idSolicitante) {
        int respuesta = 0;
        CsConexion c2 = new CsConexion();
        con = c2.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "delete from dbo.Solicitantes where idSolicitante=" + idSolicitante
            );
            
            c2.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta; 
    }
   
    // listar todos los registros
    public ArrayList<Solicitante> listarSolicitantes() {
        Solicitante p = null; 
        ArrayList<Solicitante> lista = new ArrayList<>();
                
        CsConexion c2 = new CsConexion();
        con = c2.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("select * from dbo.Solicitantes");
            
            while (rs.next()) {
                p = new Solicitante(
                        rs.getString("Nombres"),
                        rs.getString("Apelldos"),
                        rs.getString("Correo"),
                        rs.getString("Telefono"),
                        rs.getInt("idSolicitante")
                );
                lista.add(p);
            }
            
            c2.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    // listar por ID
    public Solicitante listarSolicitantePorID(int idSolicitante) {
        Solicitante p = null; 
                        
        CsConexion c2 = new CsConexion();
        con = c2.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(
                "select * from dbo.Solicitantes where idSolicitante=" + idSolicitante
            );
            
            while (rs.next()) {
                p = new Solicitante(
                        rs.getString("Nombres"),
                        rs.getString("Apelldos"),
                        rs.getString("Correo"),
                        rs.getString("Telefono"),
                        rs.getInt("idSolicitante")
                );
            }
            
            c2.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;
    }
}