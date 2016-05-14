
package Servlet;

import Beans.Archivo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Dao.ArchivoDao;
import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dario
 */

public class UploadFile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Perfl = request.getParameter("param");
        try {
            // Declaramos como constante el nombre del directorio donde colocaremos los archivos.
            final String directorio = "temp";
            // Declaramos como constante el tamanio maximo del archivo.
            final int tamanioPermitido = 2000000;  //~ 1 MB en bytes 1000000
            // Obtenemos el path completo (en el servidor) en donde se encuentra la carpeta que contendra los archivos subidos.
            String uploadPath = getServletContext().getRealPath("//" + directorio + "//");
            // Verificamos que exista el directorio. En caso de que no, lo creamos.
            File fdir = new File(uploadPath);
            if (!fdir.exists()) {
                fdir.mkdir();
            }
            
            // Construimos un objeto MultipartRequest.
            // Cuando se ejecuta esta linea, los archivos son subidos al servidor.
            MultipartRequest multipartRequest = new MultipartRequest(
                    request, // El request donde vienen los archivos y los campos del formulario. 
                    uploadPath, // En que ubicacion guardare los archivos.
                    tamanioPermitido, // El tamanio maximo de los archivos.
                    "UTF-8", // El encoding
                    new DefaultFileRenamePolicy() // renombrara cualquier archivo con nombre repetido, agregandole un consecutivo.
            );
            
            // Declaramos una variable donde guardaremos los mensajes de error posibles.
            String error = null;
            // Creamos un objeto archivo (clase creada por nosotros) el cual voy a utilizar para insertar a la base de datos la info del archivo.
            Archivo archivo = new Archivo();
            // Obtenemos el archivo en base al nombre del campo del formulario
            String tipo = multipartRequest.getContentType("archivoImagen");
            String nombreArchivo = multipartRequest.getFilesystemName("archivoImagen");
            File archivoSeleccionado = null;
            if (nombreArchivo != null) {
                // Regresamos un objeto File que hace referencia al archivo subido.
                archivoSeleccionado = multipartRequest.getFile("archivoImagen");
                // Verificamos que el tipo sea png
                if (!tipo.equals("image/png")) {
                    // En caso de que no sea el formato esperado, mostraremos un mensaje de error.
                    if (archivoSeleccionado != null) {
                        error = "Archivo con formato incorrecto.";
                    }   
                } else {
                    // Guardamos el objeto file dentro del objeto archivo para posteriormente mandarlo a la BD
                    archivo.setStream(archivoSeleccionado);
                    archivo.setTipo(tipo);
                }
            } else {
                error = "No se seleccionó ningún archivo.";
            }
            // Ya terminamos con el archivo, ahora continuamos con el resto de campos del formulario
            // Los vamos pidiendo campo por campo, tal cual como la haciamos con la instruccion
            // request.getParameter("nombreCampo"), pero ahora a traves del objeto MultipartRequest

            String descripcion = "0001";
            archivo.setDescripcion(descripcion);            
            // Verificamos que no haya ocurrido error y guardamos a la base de datos
            if (error == null) 
            {
                 int id=0;
                if(Perfl.equals("IMGP"))
                {
                    id = ArchivoDao.insertarImagenUSR(archivo);
                }
                if(Perfl.equals("INDEX"))
                {
                    id = ArchivoDao.insertarImagen(archivo);
                }
                request.setAttribute("id", id);
            } else {
                request.setAttribute("error", error);
            }
            
            // Borramos el archivo que subimos de forma temporal
            if (archivoSeleccionado != null && archivoSeleccionado.exists()) {
                archivoSeleccionado.delete();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("error", "Ocurrio un error al subir el archivo.");
        }
        
        if(Perfl.equals("IMGP"))
        {
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/perfil.jsp");
            disp.forward(request, response);
        }
        else
        {       
        // Redireccionamos al jsp que mostrara el video
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/vender.jsp");
        disp.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}