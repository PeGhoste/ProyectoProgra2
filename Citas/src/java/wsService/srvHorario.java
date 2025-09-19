package wsService;

import Modelo.CsHorario;
import Modelo.Horario;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "srvHorario")
public class srvHorario {

    /**
     * @param HoraInicio
     * @param HoraFin
     * @return 
     */
    @WebMethod(operationName = "insertarHorario")
    public int insertarHorario(
            @WebParam(name = "HoraInicio") java.util.Date HoraInicio,
            @WebParam(name = "HoraFin") java.util.Date HoraFin) 
    {
        CsHorario h = new CsHorario();
        return h.insertarHorario(HoraInicio, HoraFin);
    }


    @WebMethod(operationName = "actualizacionHorario")
    public int actualizarHorario(
            @WebParam(name = "HoraInicio") java.util.Date HoraInicio,
            @WebParam(name = "HoraFin") java.util.Date HoraFin,
            @WebParam(name = "IdHorario") int IdHorario) 
    {
        CsHorario h = new CsHorario();
        return h.actualizarHorario(HoraInicio, HoraFin, IdHorario);
    }


    @WebMethod(operationName = "eliminarHorario")
    public int eliminarHorario(@WebParam(name = "IdHorario") int IdHorario) {
        CsHorario h = new CsHorario();
        return h.eliminarHorario(IdHorario);
    }


    @WebMethod(operationName = "listarHorario")
    public ArrayList<Horario> listar() {
        CsHorario h = new CsHorario();
        return h.listarHorario();
    }


    @WebMethod(operationName = "listarHorarioPorID")
    public Horario listarHorarioPorID(@WebParam(name = "IdHorario") int IdHorario) {
        CsHorario h = new CsHorario();
        return h.listarHorarioPorID(IdHorario);
    }
}
