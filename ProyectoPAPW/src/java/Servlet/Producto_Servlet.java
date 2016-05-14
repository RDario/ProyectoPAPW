/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.Producto;
import Dao.ProductoDao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import Beans.Mandar_Mail;

/**
 *
 * @author Arturo
 */
public class Producto_Servlet extends HttpServlet{
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String Titulo = request.getParameter("Titulo");//Obtenemos el Valor que tiene el TextBox que se llama 'Email'        
        String Descripcion = request.getParameter("Descripcion");//Obtenemos el Valor que tiene el TextBox que se llama 'Pass'
        String Precio = request.getParameter("Precio");//Obtenemos el Valor que tiene el TextBox que se llama 'Pass'
        String Foto = request.getParameter("idFoto");//Obtenemos el Valor que tiene el TextBox que se llama 'Pass'
        String Usuario = request.getParameter("idUsuario");//Obtenemos el Valor que tiene el TextBox que se llama 'Pass'
        String SubCategoria = request.getParameter("SubCategoria");//Obtenemos el Valor que tiene el TextBox que se llama 'Pass'
        
        Producto prod = ProductoDao.CreaProducto(Titulo, Descripcion, Precio, Foto, Usuario, SubCategoria);
        
            
       
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/miCuentaPRODUCTOS.jsp");
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
