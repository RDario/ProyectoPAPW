

<%@page import="Beans.Comentario"%>
<%@page import="Dao.ComentarioDao"%>

<%@page import="Beans.Usuario"%>
<%@page import="Dao.UsuarioDao"%>

<%@page import="Beans.Producto"%>
<%@page import="Dao.ProductoDao"%>

<%@page import="java.util.List"%>



<%

String idPro = request.getParameter("idProd");
int idProd = Integer.parseInt (idPro);

String ADD = request.getParameter("ADD");

if(ADD.equals("true"))
{
    //idUs="+idUs + "&Comentario="+document.all.Comentario.value + "&Contestado="+Contestado + "&ADD="+ADD), true );
    String idUsuario = request.getParameter("idUs");
    String Comentario = request.getParameter("Comentario");
    if(Comentario != null && Comentario != "")
    {
        Comentario comnt = ComentarioDao.CreaComentario(idUsuario, idPro, Comentario);
    }
}


%>

<%
Producto produc = ProductoDao.ObtieneProductoV( Integer.parseInt(idPro));
%>

<img width="50px" height="50px" src="/AO_LMAD/mostrarImagen?param=INDEX&id=<%= produc.getFoto1() %>"/>
<table width="690px" cellspacing="0" cellpadding="5">
    <tr bgcolor="#ddd">
        <th width="80" align="left">Usuario</th>
        <th width="570" align="left">Comentario</th>
        <th width="200" align="left">Hace</th>
        <th width="200" align="right"></th>
    </tr>
    <%
    List<Comentario> Comn = ComentarioDao.ComentariosProducto(idProd);
    if (Comn != null)
    {
        int Cont=0;
        for (Comentario stdo : Comn )
        {
            if(stdo.getRespuesta() == null)
            {
                Usuario refUsr = UsuarioDao.ObtieneUsuario(stdo.getUsuario());            
            
                String TDO;

                int F_D = Integer.parseInt(stdo.getFechaDias());
                String F_Ds = "";
                if(F_D > 0)
                {
                    F_Ds = String.valueOf(F_D) + " Dia ";

                    if(F_D > 1)
                    {
                        F_Ds = String.valueOf(F_D) + " Dias ";
                    }
                }

                int F_H = Integer.parseInt(stdo.getFechaP().substring(0,2));
                String F_Hs = "";
                if(F_H > 0)
                {
                    F_Hs = String.valueOf(F_H) + " hr ";
                    if(F_H > 1)
                    {
                        F_Hs = String.valueOf(F_H) + " hrs ";
                    }
                }
                String F_M = stdo.getFechaP().substring(3, 5) + " min";

                TDO= F_Ds + F_Hs + F_M;
                Cont++;
    
    
    %>
    
    
    <!--<form action="miCuentaMENSAJES.jsp?Coment=<%--<%= idProd%>--%>" method="post">-->
    <form name="Resp<%= Cont %>" action="miCuentaMENSAJES.jsp?Coment=<%= idProd%>&idComen=<%= stdo.getId() %>&idProd=<%= idProd %>" method="post">
    <tr>
        <td><%= refUsr.getNickname() %> <%--<%= stdo.getUsuario() %><%= refUsr.getNickname() %>--%></td> 
        <td align="left"><%= stdo.getComentario() %></td>
        <% %>
        <td align="left"> <%= TDO %></td>
    </tr>
    <tr>
        <td colspan="3"><input name="Answer" size="93" type="text" required="required" ></td>
        <td align="right"><input type="submit" value="Contestar"/></td>
        
    </tr>
    </form>
    <%
       }
        }
    }

    %>

    
</table>