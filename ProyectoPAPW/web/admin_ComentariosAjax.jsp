

<%@page import="Beans.Comentario"%>
<%@page import="Dao.ComentarioDao"%>

<%@page import="Beans.Usuario"%>
<%@page import="Dao.UsuarioDao"%>

<%@page import="Beans.Producto"%>
<%@page import="Dao.ProductoDao"%>

<%@page import="java.util.List"%>



<%

String Texto = request.getParameter("texto");

String ADD = request.getParameter("ADD");



List<Comentario> Comn = ComentarioDao.AdminBComentarios(Texto);
%>

<table width="690px" cellspacing="0" cellpadding="5">
    <tr bgcolor="#ddd">
        <th width="80" align="left">Usuario</th>
        <th width="570" align="left">Comentario</th>
        <th width="200" align="left"></th>
    </tr>
</table>
    <%
    //List<Comentario> Comn = ComentarioDao.ComentariosProducto(idProd);
    if (Comn != null)
    {
        
        int Cont=0;
        for (Comentario stdo : Comn )
        {
            Usuario refUsr = UsuarioDao.ObtieneUsuario(stdo.getUsuario());            
                
    %>   
    
    <!--<form action="miCuentaMENSAJES.jsp?Coment=<%--<%= idProd%>--%>" method="post">-->
    <form name="Resp<%= Cont %>" action="/AO_LMAD/adminDelete?Elimina=<%= stdo.getId() %>"  method="post">
        <table width="690px" cellspacing="0" cellpadding="5">
    <tr>
        <th width="80" align="left"></th>
        <th width="570" align="left"></th>
        <th width="200" align="right"></th>
    </tr>
    <tr>
        <td><%= refUsr.getNickname() %> <%--<%= stdo.getUsuario() %><%= refUsr.getNickname() %>--%></td> 
        <td align="left"><%= stdo.getComentario() %></td>
        <td align="right"><input type="Submit" value="Eliminar" /></td>
    </tr>
    
    </table>
    </form> 
        
    
    <%
            if(stdo.getRespuesta() != null)
            {
    %>     
    <table width="690px" cellspacing="0" cellpadding="5">
    <tr>
        <th width="80" align="left"></th>
        <th width="570" align="left"></th>
        <th width="200" align="right"></th>
    </tr>
            <tr>
                <td></td> 
                <td align="left" style="color:#0FA82E"><%= stdo.getRespuesta() %></td>
                <td align="left"></td>
            </tr>
    </table>
            
    <%
            }
    %>  
    
           
           <%
        }
    }

    %>
    
    
    

    
