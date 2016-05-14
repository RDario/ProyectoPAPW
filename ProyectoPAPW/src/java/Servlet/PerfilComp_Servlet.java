/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.Usuario;
import Dao.UsuarioDao;

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
public class PerfilComp_Servlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        Usuario USR;
        USR = (Usuario) request.getSession().getAttribute("usuario");
            
        Usuario US;
        US = UsuarioDao.ObtienePerfil(USR.getEmail());
        
        
        String DatosPerfil[] = new String [14];
        DatosPerfil[0]= US.getNickname();
        DatosPerfil[1]= US.getEmail();
        DatosPerfil[2]= US.getNombre();
        DatosPerfil[3]= US.getApellido_Pat();
        DatosPerfil[4]= US.getApellido_Mat();
        DatosPerfil[5]= US.getNacimiento();
        
        if("1".equals(US.getSexo()))
        {
            DatosPerfil[6]= "Masculino";            
        }
        else
        {
            DatosPerfil[6]= "Femenino";
        }
        
        DatosPerfil[7]= US.getTelefono();
        DatosPerfil[8]= US.getCalle();
        DatosPerfil[9]= US.getNumero();
        DatosPerfil[10]= US.getColonia();
        DatosPerfil[11]= US.getEstado();
        DatosPerfil[12]= US.getPais();
        DatosPerfil[13]= US.getFoto();
        
        //Se crea un Atributo con el Email Ingresado por el Usuario
        for(int i=0; i<14; i++)
        {
            request.setAttribute(("DatPer"+i), DatosPerfil[i]);
        }
        
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/miCuentaPERFIL.jsp");
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
