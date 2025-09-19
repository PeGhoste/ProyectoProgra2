package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.CsConexion;

public class CsCitas {
    
    private Connection con;  // conexión a la base de datos
    private Statement stm;   // para ejecutar consultas
    private ResultSet rs;    // resultados de consultas
    
    public CsCitas() {
        this.con = null;
        this.stm = null;
    }
    
    // insertar datos
    public int insertarCita(String fechaCita, String horaCita, String motivo, int idSolicitante, int idEmpresa) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "insert into DBProyectoProgra2.dbo.Citas (fechaCita, horaCita, motivo, idSolicitante, idEmpresa) " +
                "values ('" + fechaCita + "', '" + horaCita + "', '" + motivo + "', " + idSolicitante + ", " + idEmpresa + ")"
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
    public int actualizarCita(String fechaCita, String horaCita, String motivo, int idSolicitante, int idEmpresa, int idCita) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
            
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "update dbo.Citas set fechaCita='" + fechaCita + 
                "', horaCita='" + horaCita +
                "', motivo='" + motivo +
                "', idSolicitante=" + idSolicitante +
                ", idEmpresa=" + idEmpresa +        
                " where idCita=" + idCita
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
    public int eliminarCita(int idCita) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "delete from dbo.Citas where idCita=" + idCita
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
    public ArrayList<Citas> listarCitas() {
        Citas p = null; 
        ArrayList<Citas> lista = new ArrayList<>();
                
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("select * from dbo.Citas");
            
            while (rs.next()) {
                p = new Citas(
                    rs.getInt("idCita"),
                    rs.getString("fechaCita"),
                    rs.getString("horaCita"),
                    rs.getString("motivo"),
                    rs.getInt("idSolicitante"),
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
    public Citas listarCitasPorID(int idCita) {
        Citas p = null; 
                        
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(
                "select * from dbo.Citas where idCita=" + idCita
            );
            
            if (rs.next()) {
                p = new Citas(
                    rs.getInt("idCita"),
                    rs.getString("fechaCita"),
                    rs.getString("horaCita"),
                    rs.getString("motivo"),
                    rs.getInt("idSolicitante"),
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