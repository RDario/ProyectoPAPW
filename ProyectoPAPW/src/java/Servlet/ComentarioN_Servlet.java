/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.ComentarioDao;
import Beans.Comentario;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arturo
 */
public class ComentarioN_Servlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String Usuario = request.getParameter("idUsuarioP");
        //String Usuario = request.getParameter("idUsuarioP");//Obtenemos el Valor que tiene el TextBox que se llama 'Email'        
        String Producto = request.getParameter("idProducto");//Obtenemos el Valor que tiene el TextBox que se llama 'Pass'
        String Comentario = request.getParameter("Comentario");//Obtenemos el Valor que tiene el TextBox que se llama 'Pass'
       
        String idProd = request.getParameter("id");
        
        Comentario comnt = ComentarioDao.CreaComentario(Usuario, Producto, Comentario);
        
            
       
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/producto.jsp");
            disp.forward(request, response);
        
        
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
