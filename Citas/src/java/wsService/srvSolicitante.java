package wsService;

import Modelo.CsSolicitante;
import Modelo.Solicitante;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author everm
 */
@WebService(serviceName = "srvSolicitante")
public class srvSolicitante {

    /**
     * This is a sample web service operation
     * @param Nombres
     * @param Apellidos
     * @param Correo
     * @param Telefono
     * @return 
     */
    @WebMethod(operationName = "insertarSolicitante")
    public int insertarSolicitante(@WebParam(name = "Nombres") String Nombres, 
            @WebParam(name="Apellidos") String Apellidos,
            @WebParam(name="Correo") String Correo,
            @WebParam(name="Telefono") String Telefono)
            
    {
        CsSolicitante p = new CsSolicitante();
               
        return p.insertarSolicitante(Nombres, Apellidos, Correo, Telefono);
    }
    
    @WebMethod(operationName = "actualizacionSolicitante")
    public int actualizarSolicitante(@WebParam(name = "Nombres") String Nombres, 
            @WebParam(name="Apellidos") String Apellidos,
            @WebParam(name="Correo") String Correo,
            @WebParam(name="Telefono") String Telefono,
            @WebParam(name="idSolicitante") int idSolicitante)
    {
        CsSolicitante p = new CsSolicitante();       
        return p.actualizarSolicitante(Nombres, Apellidos, Correo, Telefono, idSolicitante);
    }
    
    @WebMethod(operationName = "eliminarSolicitante")
    public int eliminarSolicitante(@WebParam(name="idSolicitante") int idSolicitante)
    {
        CsSolicitante p = new CsSolicitante();       
        return p.eliminarSolicitante(idSolicitante);
    }
    
    @WebMethod(operationName = "listarSolicitante")
    public ArrayList<Solicitante> listar()
    {
        CsSolicitante p = new CsSolicitante();       
        return p.listarSolicitantes();
    }
    
    @WebMethod(operationName = "listarPorIDSolicitante")
    public Solicitante listarPorIDSolicitante(@WebParam(name="idSolicitante") int idSolicitante)
    {
        CsSolicitante p = new CsSolicitante();       
        return p.listarSolicitantePorID(idSolicitante);
    }  
}