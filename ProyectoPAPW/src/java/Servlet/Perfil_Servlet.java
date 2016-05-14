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

import Beans.Mandar_Mail;

/**
 *
 * @author Arturo
 */
public class Perfil_Servlet extends HttpServlet{
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        
        
        boolean BNDRA = false;
        String Editar = request.getParameter("Edita");
        
        
        Usuario USA = (Usuario) request.getSession().getAttribute("usuario");
        
        int idBD = USA.getId();
        
        Usuario US = UsuarioDao.ObtienePerfil(USA.getEmail());//el Email lo Usamos como parametro de 'ObtienePerfil'
        boolean BD = false;     
       
        
       
        
            String cadena[] = new String [13];   
        //cadena[0]=request.getParameter("ID");
        cadena[0]=request.getParameter("Nombre");
        cadena[1]=request.getParameter("ApePat");
        cadena[2]=request.getParameter("ApeMat");
        cadena[3]=request.getParameter("Dia");
        //cadena[5]=request.getParameter("Mes");
        //cadena[6]=request.getParameter("Year");
        cadena[4]=request.getParameter("Sexo");
        cadena[5]=request.getParameter("Telefono");
        cadena[6]=request.getParameter("Calle");
        cadena[7]=request.getParameter("Numero");
        cadena[8]=request.getParameter("Colonia");
        cadena[9]=request.getParameter("Estado");
        
        cadena[10]=request.getParameter("Mes");
        cadena[11]=request.getParameter("Year");
        
        
        
        String ID = request.getParameter("ID");
        String idFOTO = request.getParameter("idFoto");
        

        
        
        
      
        
    
       
        if(cadena[0] == null || "".equals(cadena[0]) ||
           cadena[1] == null || "".equals(cadena[1]) ||
           cadena[2] == null || "".equals(cadena[2]) ||
           //la cadena[3] es el 'Dia'
           cadena[4] == null || "".equals(cadena[4]) ||
           cadena[5] == null || "".equals(cadena[5]) ||
           cadena[6] == null || "".equals(cadena[6]) ||
           cadena[7] == null || "".equals(cadena[7]) ||
           cadena[8] == null || "".equals(cadena[8]))
        {
            
            
            for(int i=0; i<13; i++)
            {
                if(cadena[i] == null || "".equals(cadena[i]))
                {
                    request.setAttribute(("Color"+i), "#FF0000");
                    BNDRA=true;
                    
                    
                
                }
                else
                {
                    request.setAttribute(("Contenido"+i), cadena[i]);                    
                }
                
            }
            
            
            /*RequestDispatcher disp = getServletContext().getRequestDispatcher("/perfil.jsp");
                    disp.forward(request, response);*/
             
        }
        if("0".equals(cadena[3]) || "0".equals(cadena[10]) || "0".equals(cadena[11]))
        {
            request.setAttribute(("Color"), "#FF0000");
            BNDRA=true;
            
            for(int i=0; i<13; i++)
            {
                if(cadena[i] == null || "".equals(cadena[i]))
                {
                    request.setAttribute(("Color"+i), "#FF0000");
                    BNDRA=true;
                    
                    
                
                }
                else
                {
                    request.setAttribute(("Contenido"+i), cadena[i]);                    
                }
                
            }
                
            /*RequestDispatcher disp = getServletContext().getRequestDispatcher("/perfil.jsp");
            disp.forward(request, response);*/
        }
        
        if(BNDRA == false && US == null)
        {
         //UsuarioDao.CompletaPerfil(ID, Nombre, Apellido_Pat, Apellido_Mat, Dia, Mes, Year, 
           // Sexo, Telefono, Calle, Numero, Colonia, Estado);
            
           UsuarioDao.CompletaPerfil(ID, cadena[0], cadena[1], cadena[2], cadena[3], cadena[10], cadena[11], 
            cadena[4], cadena[5], cadena[6], cadena[7], cadena[8], cadena[9], idFOTO);
         
         
         Usuario USR = (Usuario) request.getSession().getAttribute("usuario");
         String Nick = USR.getNickname();
         String Email = USR.getEmail();
         String Pass = USR.getPass();
         
         
         Mandar_Mail mail = new Mandar_Mail(Email, "Perfil Completado AO_LMAD", "Notificacion",
            "Ha Completado el Perfil !!! "
                 + "\n\nAhora su Password ha sido Restablecida "
                 + "\nAhora podra Entrar al Sitio con: \n\nUsuario: " + Email + " \n\tPassword: " + Pass );
         
         RequestDispatcher disp = getServletContext().getRequestDispatcher("/login.jsp");
            disp.forward(request, response);
        }
        
             if(US != null)
       {            
        String cadenaBD[] = new String [13];    
        cadenaBD[0]= US.getNombre();
        cadenaBD[1]= US.getApellido_Pat();
        cadenaBD[2]= US.getApellido_Mat();
        
        String Dia = US.getNacimiento();               
        int DiaN = Integer.parseInt(Dia.substring(8, 10));
        cadenaBD[3]= String.valueOf(DiaN);
        
        cadenaBD[4]= US.getSexo();
        cadenaBD[5]= US.getTelefono();
        cadenaBD[6]= US.getCalle();
        cadenaBD[7]= US.getNumero();
        cadenaBD[8]= US.getColonia();
        cadenaBD[9]= US.getEstado();
        
        String Mes = US.getNacimiento();                
        int MesN = Integer.parseInt(Mes.substring(5, 7));
        cadenaBD[10]= String.valueOf(MesN);
        
        String Año = US.getNacimiento();                
        int AñoN = Integer.parseInt(Año.substring(0, 4));        
        cadenaBD[11]= String.valueOf(AñoN);
        
        for(int i=0; i<13; i++)
        {
            request.removeAttribute("Color"+i);
            request.setAttribute(("Contenido"+i), cadenaBD[i]);
        }
        
        if(cadenaBD[0] != null && !"".equals(cadenaBD[0]))
        {
            BD = true;
        }
       }
            
        
        if("SI".equals(Editar))
        {
            
            
            cadena[0]=request.getParameter("Nombre");
        cadena[1]=request.getParameter("ApePat");
        cadena[2]=request.getParameter("ApeMat");
        cadena[3]=request.getParameter("Dia");
        //cadena[5]=request.getParameter("Mes");
        //cadena[6]=request.getParameter("Year");
        cadena[4]=request.getParameter("Sexo");
        cadena[5]=request.getParameter("Telefono");
        cadena[6]=request.getParameter("Calle");
        cadena[7]=request.getParameter("Numero");
        cadena[8]=request.getParameter("Colonia");
        cadena[9]=request.getParameter("Estado");
        
        cadena[10]=request.getParameter("Mes");
        cadena[11]=request.getParameter("Year");
        
        String idFOT = request.getParameter("idFoto");
        
        HttpSession session = request.getSession();
            session.setAttribute("usuario", US);  
        
            UsuarioDao.CompletaPerfil(String.valueOf(idBD), cadena[0], cadena[1], cadena[2], cadena[3], cadena[10], cadena[11], 
            cadena[4], cadena[5], cadena[6], cadena[7], cadena[8], cadena[9], idFOT);
            
            for(int i=0; i<13; i++)
            {
                //request.setAttribute(("Color"+i), "#FF0000");
                request.removeAttribute("Color"+i);
                
                    request.setAttribute(("Contenido"+i), cadena[i]);                    
                
                
            }
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/perfilCompleto");
                    disp.forward(request, response);
        }
        
        
        if(US != null  && BD!=false )
        {
            Editar="SI";
            request.setAttribute("Edita", Editar);
            
            
            
        }
       
        
        
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/perfil.jsp");
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
