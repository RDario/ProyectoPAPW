package servlets;

import clasesConexion.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dario
 */
public class RegistrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String usuario = request.getParameter("nickname");
        String nombre = request.getParameter("nombreUsuario");
        String password = request.getParameter("contrasenia");
        String apellidos = request.getParameter("apellidosUsuario");
        String correo = request.getParameter("email");
        String fechaAnio = request.getParameter("listaanios");
        String fechaMes = request.getParameter("listameses");
        String fechaDia = request.getParameter("listadias");
        String genero = request.getParameter("generoUsuario");
        String calle = request.getParameter("domicilioCalle");
        String colonia = request.getParameter("domicilioColonia");
        String municipio = request.getParameter("listaMunicipios");
        String estado = request.getParameter("listaEstados");
        String codigopostal = request.getParameter("codigopostal");
        
        if (Consultas.altaUsuario(
                usuario, 
                nombre, 
                apellidos, 
                correo, 
                password, 
                fechaDia + "/" + fechaMes + "/" + fechaAnio, 
                genero, 
                calle + " " + colonia, 
                municipio, 
                estado, 
                codigopostal)) {
            out.println("REGISTRO-USUARIO-CORRECTO-----------> ");
        } else {
            out.println("REGISTRO-USUARIO-INCORECTO-----------> ");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
