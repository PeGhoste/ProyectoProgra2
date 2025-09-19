package wsService;

import Modelo.CsEmpresas;
import Modelo.Empresas;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author everm
 */
@WebService(serviceName = "srvEmpresas")
public class srvEmpresas {

    /**
     * This is a sample web service operation
     * @param Nombre
     * @param Descripcion
     * @return 
     */
    @WebMethod(operationName = "insertar")
    public int insertar(@WebParam(name = "Nombre") String Nombre, 
            @WebParam(name="Descripcion") String Descripcion)
    {
        CsEmpresas p = new CsEmpresas();
               
        return p.insertar(Nombre, Descripcion);
    }
    
    @WebMethod(operationName = "actualizacion")
    public int actualizar(@WebParam(name = "Nombre") String Nombre, 
            @WebParam(name="Descripcion") String Descripcion,
            @WebParam(name="idEmpresa") int idEmpresa)
    {
        CsEmpresas p = new CsEmpresas();       
        return p.actualizar(Nombre, Descripcion, idEmpresa);
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name="idEmpresa") int idEmpresa)
    {
        CsEmpresas p = new CsEmpresas();       
        return p.eliminar(idEmpresa);
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList<Empresas> listar()
    {
        CsEmpresas p = new CsEmpresas();       
        return p.listarEmpresas();
    }
    
    @WebMethod(operationName = "listarPorID")
    public Empresas listarPorID(@WebParam(name="idEmpresa") int idEmpresa)
    {
        CsEmpresas p = new CsEmpresas();       
        return p.listarEmpresasPorID(idEmpresa);
    }  
}
