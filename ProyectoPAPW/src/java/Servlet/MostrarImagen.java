/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.ArchivoDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
public class MostrarImagen extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Perfl = request.getParameter("param");

        try {
            String strId = request.getParameter("id");
            int id = 0;
            if (strId != null && !strId.equals("")) {
                id = Integer.parseInt(strId);
            }

            //InputStream archivo = ArchivoDao.obtenerImagen(id);
            if(Perfl.equals("IMGP"))
            {
                InputStream archivo = ArchivoDao.obtenerImagenUSR(id);
                OutputStream out = response.getOutputStream();
            byte[] byteArray = new byte[2000000];
            int tamanio = 0;

            while ((tamanio = archivo.read(byteArray)) != -1) {
                out.write(byteArray, 0, tamanio);
            }
            out.flush();
            out.close();
            }
            if(Perfl.equals("INDEX"))
            {
                InputStream archivo = ArchivoDao.obtenerImagen(id);
                OutputStream out = response.getOutputStream();
            byte[] byteArray = new byte[2000000];
            int tamanio = 0;

            while ((tamanio = archivo.read(byteArray)) != -1) {
                out.write(byteArray, 0, tamanio);
            }
            out.flush();
            out.close();
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
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
