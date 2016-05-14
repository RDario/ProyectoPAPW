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
public class Busqueda_Servlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String VendedorS = request.getParameter("Vendedor");
        if(VendedorS == null){VendedorS="0";}
        int Vendedor = Integer.parseInt(VendedorS);
        
        String MesS = request.getParameter("Mes");
        if(MesS == null){MesS="0";}
        int Mes = Integer.parseInt(MesS);
        
        String AñoS = request.getParameter("Year");
        if(AñoS == null){AñoS="0";}
        int Año = Integer.parseInt(AñoS);
        
        String PrecioS = request.getParameter("Precio");
        if(PrecioS == null){PrecioS="0";}
        int Precio = Integer.parseInt(PrecioS);
        
        String Texto = request.getParameter("Texto");
        if(Texto.equals("Buscar")){Texto = "";}
        
        
            
            //ProductoDao.BusquedaProductos(Vendedor, Mes, Año, Precio, Texto);
        
        
                
        
    RequestDispatcher disp = getServletContext().getRequestDispatcher("/busquedas.jsp?B1="+Vendedor+"&B2="+Mes+"&B3="+Año+"&B4="+Precio+"&B5="+Texto);
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
