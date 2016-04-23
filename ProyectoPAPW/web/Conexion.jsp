<%-- 
    Document   : paginaLogin
    Created on : 17/04/2016, 06:53:50 PM
    Author     : Dario
--%>

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
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_papw", "root", "");
                String consulta = "SELECT * FROM usuario WHERE nicknameUsuario = ? AND contraseniaUsuario = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, nickname);
                preparedStatement.setString(2, pass);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs != null) {
                    if (rs.next()) {

                    } else {
                        out.println("CONEXION-------no-ejecuto-query-----> " + rs);
                        connection.close();
                    }
                } else {
                    out.println("CONEXION-------resut-null-----> " + rs);
                    connection.close();
                }
            } catch (Exception e) {
                out.println("CONEXION-----------Error-exception---> " + e);
            }
        %>
    </body>
</body>
</html>
