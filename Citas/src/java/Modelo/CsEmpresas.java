package Modelo;

import Connection.CsConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CsEmpresas {
    
    private Connection con;  // conexión a la base de datos
    private Statement stm;   // para ejecutar consultas
    private ResultSet rs;    // resultados de consultas
    
    public CsEmpresas() {
        this.con = null;
        this.stm = null;
    }
    
    // insertar datos
    public int insertar(String Nombre, String Descripcion) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "insert into DBProyectoProgra2.dbo.Empresas (Nombre, Descripcion) " +
                "values ('" + Nombre + "', '" + Descripcion + "')"
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
    public int actualizar(String Nombre, String Descripcion, int idEmpresa) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
            
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "update dbo.Empresas set Nombre='" + Nombre + 
                "', Descripcion='" + Descripcion + 
                "' where idEmpresa=" + idEmpresa
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
    public int eliminar(int idEmpresa) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "delete from dbo.Empresas where idEmpresa=" + idEmpresa
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
    public ArrayList<Empresas> listarEmpresas() {
        Empresas p = null; 
        ArrayList<Empresas> lista = new ArrayList<>();
                
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("select * from dbo.Empresas");
            
            while (rs.next()) {
                p = new Empresas(
                        rs.getString("Nombre"),
                        rs.getString("Descripcion"),
                        rs.getInt("idEmpresa")
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
    public Empresas listarEmpresasPorID(int idEmpresa) {
        Empresas p = null; 
                        
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(
                "select * from dbo.Empresas where idEmpresa=" + idEmpresa
            );
            
            while (rs.next()) {
                p = new Empresas(
                        rs.getString("Nombre"),
                        rs.getString("Descripcion"),
                        rs.getInt("idEmpresa")
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