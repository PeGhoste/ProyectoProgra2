package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import wsService.srvUsuario;
import Modelo.Usuario;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    
    // URL del servicio web
    private static final String WS_URL = "http://localhost:8080/Citas/srvUsuarios?wsdl";
    private static final QName QNAME = new QName("http://wsService/", "srvUsuarios");
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si ya está autenticado, redirigir al dashboard
        if (request.getSession().getAttribute("usuario") != null) {
            response.sendRedirect(request.getContextPath() + "/dashboard");
            return;
        }
        // Limpiar cualquier mensaje de error previo
        request.removeAttribute("error");
        // Mostrar el formulario de login
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Validar credenciales
        Usuario usuario = validarCredenciales(username, password);
        
        if (usuario != null) {
            // Crear sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario.getUsername());
            // Usamos un rol por defecto ya que el modelo Usuario no tiene rol
            session.setAttribute("rol", "usuario");
            // Almacenamos el ID del usuario y del empleado
            session.setAttribute("idUsuario", usuario.getIdUsuario());
            session.setAttribute("idEmpleado", usuario.getFK_IdEmpleado());
            
            // Redirigir al dashboard
            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            // Mostrar error
            request.setAttribute("error", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    
    private Usuario validarCredenciales(String username, String password) {
        try {
            // Crear el servicio web dinámicamente
            URL wsdlURL = new URL(WS_URL);
            Service service = Service.create(wsdlURL, QNAME);
            srvUsuario port = service.getPort(srvUsuario.class);
            
            // Llamar al método de autenticación
            return port.autenticarUsuario(username, password);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al autenticar usuario: " + e.getMessage(), e);
            return null;
        }
    }

}