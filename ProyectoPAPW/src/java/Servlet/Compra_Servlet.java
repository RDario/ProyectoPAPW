/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import Dao.ProductoDao;

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
public class Compra_Servlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String USs = request.getParameter("Us");
        if(USs == null){USs="0";}
        int US = Integer.parseInt(USs);
        String Prs = request.getParameter("Pr");
        if(Prs == null){Prs="0";}
        int Pr = Integer.parseInt(Prs);
        
        
            ProductoDao.ProductoCOMPRADO(US, Pr);
       if(US == 0){
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/login.jsp");
            disp.forward(request, response);
       }
       else
       {
           RequestDispatcher disp = getServletContext().getRequestDispatcher("/miCuentaCOMPRA.jsp");
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
