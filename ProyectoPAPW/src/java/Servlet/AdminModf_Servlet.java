/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import Dao.CategoriaDao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arturo
 */
public class AdminModf_Servlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String Modf = request.getParameter("Modf");
        
        if(Modf.equals("Categoria"))
        {
            String idCategoriaS = request.getParameter("Categoria");
            int idCategoria = Integer.parseInt(idCategoriaS);
            String Descripcion = request.getParameter("NCategoria");
            
            CategoriaDao.ModificarC(idCategoria, Descripcion);
        }
        if(Modf.equals("SubCategoria"))
        {
            String idSubCategoriaS = request.getParameter("SubCategoria");
            int idSubCategoria = Integer.parseInt(idSubCategoriaS);
            String Descripcion = request.getParameter("NSubCategoria");
            
            CategoriaDao.ModificarS(idSubCategoria, Descripcion);
        }
                
        
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/adminMODIFICAR.jsp");
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
