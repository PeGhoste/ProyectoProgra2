package wsService;

import Modelo.CsEmpleado;
import Modelo.Empleado;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author everm
 */
@WebService(serviceName = "srvEmpleado")
public class srvEmpleado {

    /**
     * This is a sample web service operation
     * @param Nombres
     * @param Apellidos
     * @param Correo
     * @param Telefono
     * @return 
     */
    @WebMethod(operationName = "insertarEmpelado")
    public int insertarEmpleado(@WebParam(name = "Nombres") String Nombres,
            @WebParam(name = "Apellidos") String Apellidos,
            @WebParam(name = "Correo") String Correo,
            @WebParam(name="Telefono") String Telefono)
    {
        CsEmpleado p = new CsEmpleado();
               
        return p.insertarEmpleado(Nombres, Apellidos, Correo, Telefono);
    }
    
    @WebMethod(operationName = "actualizacionEmpleado")
    public int actualizarEmpleado(@WebParam(name = "Nombres") String Nombres, 
            @WebParam(name="Apellido") String Apellido,
            @WebParam(name="Correo") String Correo,
            @WebParam(name="Telefono") String Telefono,
            @WebParam(name="idEmpleado") int idEmpleado)
    {
        CsEmpleado p = new CsEmpleado();       
        return p.actualizarEmpleado(Nombres, Apellido, Correo, Telefono, idEmpleado);
    }
    
    @WebMethod(operationName = "eliminarEmpleado")
    public int eliminarEmpleado(@WebParam(name="idEmpleado") int idEmpleado)
    {
        CsEmpleado p = new CsEmpleado();       
        return p.eliminarEmpleado(idEmpleado);
    }
    
    @WebMethod(operationName = "listarEmpleado")
    public ArrayList<Empleado> listar()
    {
        CsEmpleado p = new CsEmpleado();       
        return p.listarEmpleado();
    }
    
    @WebMethod(operationName = "listarEmpleadoPorID")
    public Empleado listarEmpleadoPorID(@WebParam(name="idEmpleado") int idEmpleado)
    {
        CsEmpleado p = new CsEmpleado();       
        return p.listarEmpleadoPorID(idEmpleado);
    }  
}
