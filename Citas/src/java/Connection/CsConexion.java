package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


        public class CsConexion {
    
    public String user,password;
    public String url, driver;
    public Connection cn;
    
    public CsConexion()
    {
        /* Cambiar el usuario y contraseña, también la cadena de conexión, después de // y antes del primer ";" */
        this.user="chepe";
        this.password="123";
        this.url="jdbc:sqlserver://NEWPEGHOSTE\\SQLEXPRESS;databaseName=DBProyectoProgra2;encrypt=true;trustServerCertificate=true;";
        this.driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.cn=null;
    }
    
    public Connection conectar()
    {
        try {
            Class.forName(this.driver);
            cn = DriverManager.getConnection(url, user, password);
            return cn;
            
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    
    public void desconectar() throws SQLException
    {
        cn.close();
    }
      
}