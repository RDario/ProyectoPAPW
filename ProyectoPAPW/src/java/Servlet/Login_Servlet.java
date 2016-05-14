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

//import Beans.Mandar_Mail;

/**
 *
 * @author Arturo
 */
public class Login_Servlet extends HttpServlet{
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String Log = request.getParameter("Out");
        if("true".equals(Log))
        {
            HttpSession Cierresession = request.getSession();        
            Cierresession.setAttribute("usuario", null);
            request.setAttribute("usuario", null);
            
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
            disp.forward(request, response);
        }
        
        String Email = request.getParameter("Email");//Obtenemos el Valor que tiene el TextBox que se llama 'Email'        
        String password = request.getParameter("Pass");//Obtenemos el Valor que tiene el TextBox que se llama 'Pass'
        
        Usuario usuario;
        usuario = UsuarioDao.Login( Email,password);
        if(usuario != null)//Aqui entra solo si el Usuario EXISTE
        {
            HttpSession sessionUS = request.getSession();
            sessionUS.setAttribute("usuario", usuario);
            
        request.setAttribute("usuario", usuario);
        
        String Pass = usuario.getPass();
        //Se le Asigna el Valor de 'password' a 'Pass'
        
        
        Usuario USR = UsuarioDao.VericarPerfilCompleto(String.valueOf(usuario.getId()));
        //Obtiene el Valor del ID y lo crea un ainstania del objeto USUARIO 'USR'
               
        request.setAttribute("AAA", USR);
        //Se establece el Objeto en el Atributo 'AAA'            
        
        
        boolean Valida = USR.isValidacion();
        //Se obtiene el Valor de 'Validacion' del Objeto USR
        String CodeRDM = USR.getCode();
        //Se obtiene el Valor de 'Code' del Objeto USR
        
        
        //Aqui entra cuando no a COMPLETADO su Perfil y INGRESA con el CODIGO
        if(Valida == false && password.equals(CodeRDM) )
        {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            
            //Te manda a COMPLETAR TU PERFIL
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/perfil.jsp");
            disp.forward(request, response);
        }
        
        //Aqui entra cuando el Correo Existe en la BD, INGRESA con el PASSWORD y Ya ha COMPLETADO u Perfil
        if(usuario != null && password.equals(Pass) && Valida ==true)
        {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            //AQUI VA A IR A DONDE TE VA A MANDAR CUANDO YA HAYAS COMPLETADO TU PERFIL
            //Esto de index es Provicional
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
            disp.forward(request, response);                
        }
        
        
        else
        {
            //Se crea un Atributo con el Email Ingresado por el Usuario
            request.setAttribute("CorreoTemp", Email);
            
            
            if(password == null || "".equals(password))
            {
                request.setAttribute("ColorP", "#FF0000");
                request.setAttribute("MsjP", "Ingresa tu Contraseña");
            }
            
            else
            {
                request.setAttribute("ColorP", "#32D145");
                request.setAttribute("MsjP", "Contraseña Incorrecta");
            }
            
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/login.jsp");
            disp.forward(request, response);
        }
        }
        
        request.setAttribute("CorreoTemp", Email);
        
        request.setAttribute("ColorE", "#FF0000");
        request.setAttribute("MsjE", "Usuario no Existe  Registrate");
        
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/login.jsp");
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
