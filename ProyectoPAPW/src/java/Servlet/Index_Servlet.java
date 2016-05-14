/*
 * 
 * TODO ESTO SE VA A CAMBIAR A EL SERVLET DE REGISTRARSE O NUEVA CUENTA
 * 
 * 
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

import Beans.Mandar_Mail;
import java.lang.Math;

/**
 *
 * @author Arturo
 */
public class Index_Servlet extends HttpServlet{
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {       
        String Nickname = request.getParameter("Nickname");//Obtenemos el Valor que tiene el TextBox que se llama 'Nickname'
        String Email = request.getParameter("Email");//Obtenemos el Valor que tiene el TextBox que se llama 'Email'        
        String password = request.getParameter("Pass");//Obtenemos el Valor que tiene el TextBox que se llama 'Pass'
        
        int pick = (int) Math.round((Math.random()*9999999+1));
        //Se Crea un Numero Random de 9 digitos
        
        String Random = String.valueOf(pick);
        //Se le Asigna el Valor Random(pick) a una variable String (Random)
                
        Usuario Verifica =  UsuarioDao.VericarMail(Email);
        //Verifica que el CORREO que Ingrese el Usuario NO EXISTA
        
        
        if(Verifica == null)//Aqui entra solo :: Si NO EXISTE el Correo en la BD 
        {
            if(password != null && !"".equals(password)){
            /*Usuario usuario = */UsuarioDao.PreRegistro(Nickname, Email,password, Random);
            
            //Se Envia el Mail
            Mandar_Mail mail = new Mandar_Mail(Email, "Registro AO_LMAD", "Activacion",
            "Para Concluir con la Activacion Ingresa al Sitio con: \n\nUsuario: " + Email + " \n\tPassword: " + Random );
            
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/login.jsp");
            disp.forward(request, response);
            
            }
            else
            {
                request.setAttribute("ColorP", "red");
                //Se crea un Atributo(ColorM) con el Valor de un Color(VERDE)
                request.setAttribute("MsjP", "Ingresa tu Contraseña");
                //Se crea un Atributo(MsjrM) con un Mensaje
                
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/registro.jsp");
            disp.forward(request, response);
            }
        }
        
        else//Si el Correo EXISTE en la BD se le Asigna un Mensaje aun Atributo (MsjM)
        {
            request.setAttribute("NickTemp", Nickname);
            //Se crea un Atributo(NickTemp) con el Valor de Nickname
            
            
            request.setAttribute("ColorM", "#32D145");
            //Se crea un Atributo(ColorM) con el Valor de un Color(VERDE)
            request.setAttribute("MsjM", "El Correo le Pertenece a Otro Usuario");
            //Se crea un Atributo(MsjrM) con un Mensaje
            
            
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/registro.jsp");
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
