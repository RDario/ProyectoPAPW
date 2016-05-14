/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.Archivo;
import Beans.ArchivoDAO;
import Beans.Archivo2;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Diego
 */
public class UploadFile2 extends UploadFile {
     private final String directorio = "archivos";
    
    private String extractExtension(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String filename = s.substring(s.indexOf("=") + 2, s.length() - 1);
                return filename.substring(filename.indexOf(".") - 1, filename.length());
            }
        }
        return "";
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uploadPath = request.getSession().getServletContext().getRealPath("/" + directorio + "/");
        System.out.println("PATH: " + uploadPath);
        
        File fdir = new File(uploadPath);
        if (!fdir.exists()) {
            fdir.mkdir();
        }
        
        Archivo archivo = new Archivo();
        String descripcion = request.getParameter("descripcion");
        archivo.setDescripcion(descripcion);
        
        Part filePart = request.getPart("archivo");
        if (filePart != null && filePart.getSize() > 0) {
            String contentType = filePart.getContentType();
            if (!contentType.equals("video/mp4") 
                    && !contentType.equals("image/jpeg")) {
                request.setAttribute("error", "Archivo con formato incorrecto.");
                RequestDispatcher disp = request.getSession().getServletContext().getRequestDispatcher("/desplegar.jsp");
                disp.forward(request, response);
                
            } else {
                archivo.setTipo(contentType);
                String nombreArchivo = String.valueOf(System.currentTimeMillis());
                nombreArchivo += extractExtension(filePart);
                
                if (contentType.equals("video/mp4")) {
                    String path = directorio + "/" + nombreArchivo;
                    archivo.setUbicacion(path);
                    ArchivoDAO.insertarVideo(archivo);
                    filePart.write(uploadPath + "/" + nombreArchivo);
                    request.setAttribute("path", path);
                    
                } else if (contentType.equals("image/jpeg")) {
                    String path = directorio + "/" + nombreArchivo;
                    archivo.setUbicacion(path);
                    ArchivoDAO.insertarImagen(archivo);
                    filePart.write(uploadPath + "/" + nombreArchivo);
                    request.setAttribute("path", path);
                }
            }
        }
        
        RequestDispatcher disp = request.getSession().getServletContext().getRequestDispatcher("/desplegar.jsp");
        disp.forward(request, response);
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
