package wsService;

import Modelo.CsUsuario;
import Modelo.Usuario;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author everm
 */
@WebService(serviceName = "srvUsuarios")
public class srvUsuario {

    // Insertar un nuevo usuario
    @WebMethod(operationName = "insertarUsuario")
    public int insertarUsuario(
            @WebParam(name = "Username") String Username,
            @WebParam(name = "Pass") String Pass,
            @WebParam(name = "FK_IdEmpleado") int FK_IdEmpleado) 
    {
        CsUsuario u = new CsUsuario();
        return u.insertarUsuario(Username, Pass, FK_IdEmpleado);
    }

    // Actualizar un usuario existente
    @WebMethod(operationName = "actualizarUsuario")
    public int actualizarUsuario(
            @WebParam(name = "IdUsuario") int IdUsuario,
            @WebParam(name = "Username") String Username,
            @WebParam(name = "Pass") String Pass,
            @WebParam(name = "FK_IdEmpleado") int FK_IdEmpleado) 
    {
        CsUsuario u = new CsUsuario();
        return u.actualizarUsuario(Username, Pass, FK_IdEmpleado,IdUsuario );
    }

    // Eliminar un usuario
    @WebMethod(operationName = "eliminarUsuario")
    public int eliminarUsuario(@WebParam(name = "IdUsuario") int IdUsuario) 
    {
        CsUsuario u = new CsUsuario();
        return u.eliminarUsuario(IdUsuario);
    }

    // Listar todos los usuarios
    @WebMethod(operationName = "listar")
    public ArrayList<Usuario> listar() 
    {
        CsUsuario u = new CsUsuario();
        return u.listarUsuario();
    }

    // Listar un usuario por ID
    @WebMethod(operationName = "listarUsuarioPorID")
    public Usuario listarUsuarioPorID(@WebParam(name = "IdUsuario") int IdUsuario) 
    {
        CsUsuario u = new CsUsuario();
        return u.listarUsuarioPorID(IdUsuario);
    }
    
    // Autenticar un usuario
    @WebMethod(operationName = "autenticarUsuario")
    public Usuario autenticarUsuario(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password) 
    {
        CsUsuario u = new CsUsuario();
        return u.autenticarUsuario(username, password);
    }
}

