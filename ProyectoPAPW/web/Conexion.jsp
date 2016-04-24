<%-- 
    Document   : paginaLogin
    Created on : 17/04/2016, 06:53:50 PM
    Author     : Dario
--%>

<%@page import="clasesConexion.Consultas "%>
<%@page import="clasesConexion.ConexionDataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <body>
        <%@page import = "java.sql.*" %>
        <%@page import = "javax.sql.*" %>
        <%
            String nickname = request.getParameter("nombreusuario");
            String pass = request.getParameter("contrasenia");
            ConexionDataBase conexionDataBase = new ConexionDataBase();
            boolean isExisteUsuario = Consultas.autenticarUsuario(nickname, pass);
            if (isExisteUsuario) {
                out.println("CONEXION-------existe-Usuario-----------> ");
            } else {
                out.println("CONEXION------No-existe-Usuario-----------> ");
            }
        %>
    </body>
</body>
</html>
