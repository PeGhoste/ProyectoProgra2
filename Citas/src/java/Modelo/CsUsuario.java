package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.CsConexion;

public class CsUsuario {
    
    private Connection con;  // conexión a la base de datos
    private Statement stm;   // para ejecutar consultas
    private ResultSet rs;    // resultados de consultas
    
    public CsUsuario() {
        this.con = null;
        this.stm = null;
    }
    
    // insertar datos
    public int insertarUsuario(String Username, String Pass, int FK_IdEmpleado) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "insert into DBProyectoProgra2.dbo.Usuario (Username, Pass, FK_IdEmpleado) " +
                "values ('" + Username + "', '" + Pass + "', " + FK_IdEmpleado + ")"
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
    public int actualizarUsuario(String Username, String Pass, int FK_IdEmpleado, int IdUsuario) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
            
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "update dbo.Usuario set Username='" + Username + 
                "', Pass='" + Pass + 
                "', FK_IdEmpleado=" + FK_IdEmpleado +
                " where IdUsuario=" + IdUsuario
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
    public int eliminarUsuario(int IdUsuario) {
        int respuesta = 0;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            respuesta = stm.executeUpdate(
                "delete from dbo.Usuario where IdUsuario=" + IdUsuario
            );
            
            c1.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta; 
    }


    // obtener la información del usuario por medio del user y pass
    public Usuario autenticarUsuario(String username, String password) {
        Usuario usuario = null;
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        
        try {
            stm = con.createStatement();
            String query = "SELECT * FROM dbo.Usuario WHERE Username = '" + username + "' AND Pass = '" + password + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("IdUsuario"),
                    rs.getString("Username"),
                    rs.getString("Pass"),
                    rs.getInt("FK_IdEmpleado")
                );
            }
            
            rs.close();
            stm.close();
            c1.desconectar();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return usuario;
    }
   
    // listar todos los registros
    public ArrayList<Usuario> listarUsuario() {
        Usuario u = null; 
        ArrayList<Usuario> lista = new ArrayList<>();
                
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("select * from dbo.Usuario");
            
            while (rs.next()) {
                u = new Usuario(
                        rs.getInt("IdUsuario"),
                        rs.getString("Username"),
                        rs.getString("Pass"),
                        rs.getInt("FK_IdEmpleado")
                );
                lista.add(u);
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
    public Usuario listarUsuarioPorID(int IdUsuario) {
        Usuario u = null; 
                        
        CsConexion c1 = new CsConexion();
        con = c1.conectar();
        rs = null;
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(
                "select * from dbo.Usuario where IdUsuario=" + IdUsuario
            );
            
            while (rs.next()) {
                u = new Usuario(
                        rs.getInt("IdUsuario"),
                        rs.getString("Username"),
                        rs.getString("Pass"),
                        rs.getInt("FK_IdEmpleado")
                );
            }
            
            c1.desconectar();
            stm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;
    }
}
