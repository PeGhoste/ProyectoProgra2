package wsService;

import Modelo.CsCitas;
import Modelo.Citas;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * Servicio web para la gestión de Citas
 */
@WebService(serviceName = "srvCitas")
public class srvCitas {

    /**
     * Método para insertar una nueva cita
     * @param fechaCita Fecha de la cita (formato: YYYY-MM-DD)
     * @param horaCita Hora de la cita (formato: HH:MM)
     * @param motivo Motivo de la cita
     * @param idSolicitante ID del solicitante
     * @param idEmpresa ID de la empresa
     * @return 1 si la operación fue exitosa, 0 en caso contrario
     */
    @WebMethod(operationName = "insertarCitas")
    public int insertarCitas(
            @WebParam(name = "fechaCita") String fechaCita, 
            @WebParam(name = "horaCita") String horaCita,
            @WebParam(name = "motivo") String motivo,
            @WebParam(name = "idSolicitante") int idSolicitante,
            @WebParam(name = "idEmpresa") int idEmpresa) {
        
        CsCitas cita = new CsCitas();
        return cita.insertarCita(fechaCita, horaCita, motivo, idSolicitante, idEmpresa);
    }
    
    /**
     * Método para actualizar una cita existente
     * @param fechaCita Nueva fecha de la cita
     * @param horaCita Nueva hora de la cita
     * @param motivo Nuevo motivo de la cita
     * @param idSolicitante Nuevo ID del solicitante
     * @param idEmpresa Nuevo ID de la empresa
     * @param idCita ID de la cita a actualizar
     * @return 1 si la operación fue exitosa, 0 en caso contrario
     */
    @WebMethod(operationName = "actualizarCitas")
    public int actualizarCitas(
            @WebParam(name = "fechaCita") String fechaCita, 
            @WebParam(name = "horaCita") String horaCita,
            @WebParam(name = "motivo") String motivo,
            @WebParam(name = "idSolicitante") int idSolicitante,
            @WebParam(name = "idEmpresa") int idEmpresa,
            @WebParam(name = "idCita") int idCita) {
        
        CsCitas cita = new CsCitas();
        return cita.actualizarCita(fechaCita, horaCita, motivo, idSolicitante, idEmpresa, idCita);
    }
    
    /**
     * Método para eliminar una cita
     * @param idCita ID de la cita a eliminar
     * @return 1 si la operación fue exitosa, 0 en caso contrario
     */
    @WebMethod(operationName = "eliminar")
    public int eliminarCitas(@WebParam(name = "idCita") int idCita) {
        CsCitas cita = new CsCitas();
        return cita.eliminarCita(idCita);
    }
    
    /**
     * Método para listar todas las citas
     * @return Lista de todas las citas
     */
    @WebMethod(operationName = "listarCitas")
    public ArrayList<Citas> listar() {
        CsCitas cita = new CsCitas();
        return cita.listarCitas();
    }
    
    /**
     * Método para obtener una cita por su ID
     * @param idCita ID de la cita a buscar
     * @return Objeto Cita si se encuentra, null en caso contrario
     */
    @WebMethod(operationName = "listarCitasPorID")
    public Citas listarCitasPorID(@WebParam(name = "idCita") int idCita) {
        CsCitas cita = new CsCitas();
        return cita.listarCitasPorID(idCita);
    }
}