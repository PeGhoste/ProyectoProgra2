package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import Connection.CsConexion;

public class CsHorario {
    
    private Connection con;  // conexión a la base de datos
    private Statement stm;   // para ejecutar consultas
    private ResultSet rs;    // resultados de consultas
    
    public CsHorario() {
        this.con = null;
        this.stm = null;
    }
    
    // insertar datos
    public int insertarHorario(java.util.Date HoraInicio, java.util.Date HoraFin) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "insert into DBProyectoProgra2.dbo.Horarios (HoraInicio, HoraFin) " +
                "values ('" + new Timestamp(HoraInicio.getTime()) + 
                "', '" + new Timestamp(HoraFin.getTime()) + "')"
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
    public int actualizarHorario(java.util.Date HoraInicio, java.util.Date HoraFin, int idHorario) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
            
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "update dbo.Horario set HoraInicio='" + new Timestamp(HoraInicio.getTime()) +
                "', HoraFin='" + new Timestamp(HoraFin.getTime()) +
                "' where IdHorario=" + idHorario
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
    public int eliminarHorario(int idHorario) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "delete from dbo.Horario where IdHorario=" + idHorario
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
    public ArrayList<Horario> listarHorario() {
        Horario h = null; 
        ArrayList<Horario> lista = new ArrayList<>();
                
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("select * from dbo.Horario");
            
            while (rs.next()) {
                h = new Horario(
                        rs.getInt("IdHorario"),
                        rs.getTimestamp("HoraInicio"),
                        rs.getTimestamp("HoraFin")
                );
                lista.add(h);
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
    public Horario listarHorarioPorID(int idHorario) {
        Horario h = null; 
                        
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(
                "select * from dbo.Horario where IdHorario=" + idHorario
            );
            
            while (rs.next()) {
                h = new Horario(
                        rs.getInt("IdHorario"),
                        rs.getTimestamp("HoraInicio"),
                        rs.getTimestamp("HoraFin")
                );
            }
            
            c1.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return h;
    }
}
