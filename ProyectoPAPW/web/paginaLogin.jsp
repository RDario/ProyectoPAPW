<%-- 
    Document   : paginaLogin
    Created on : 22/04/2016, 02:19:40 PM
    Author     : Dario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Galaxy Login</title>
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <h1><a href="#">Galaxy Music</a></h1>
                </div>

                <div id="miPerfil">
                    <a href="paginaLogin.jsp"> Iniciar sesión </a>
                    <a href="paginaCrearCuenta.jsp"> Crear Cuenta </a>
                    <a href="pagCarritoDeCompras.html"> Mi Carrito </a>
                </div>

                <div id="search">
                    <form method="get" action="">
                        <fieldset>
                            <input type="text" name="s" id="search-text" size="15" placeholder="Buscar..." />
                            <input type="submit" id="search-submit" value="buscar" />
                        </fieldset>
                    </form>
                </div>
            </div>
            <div id="menu">
                <ul>
                    <li class="current_page_item"><a href="index.html">Inicio</a></li>
                    <li><a href="#">Música</a></li>
                    <li><a href="#">Audio libros</a></li>
                    <li><a href="#">Listas de reproducción</a></li>
                    <li><a href="#">Contacto</a></li>
                </ul>
            </div>
            <div id="page">
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="content">
                            <div class="post">
                                <h2 class="title"><a href="#">Inicia sesion</a></h2>
                                <a href="registro.html"> o registrate</a>
                                <div class="entry">
                                    <p><img src="images/Logo.jpg" width="143" height="143" alt="" class="alignleft border" />Sed lacus. Donec lectus. Nullam pretium nibh ut turpis. Nam bibendum. In nulla tortor, elementum vel, tempor at, varius non, purus. Mauris vitae nisl nec metus placerat consectetuer. Donec ipsum. Proin imperdiet est. Pellentesque ornare, orci in consectetuer hendrerit, urna elit eleifend nunc.</p>
                                </div>

                                <div id="contenedorDatosPersonales">
                                    <form name="login" method="POST" action="servletPrueba">
                                        <p><label><br>Correo<br></label>
                                            <input name="nombreusuario" type="text" id="lblNickname" placeholder="Nickname" autofocus=""></p>

                                        <p><label>Contraseña<br></label>
                                            <input name="contrasenia" type="text" id="lblUsuario" autofocus=""><br><br></p>

                                        <button type="submit" >Iniciar sesion</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="sidebar">
                        </div>
                        <div style="clear: both;">&nbsp;</div>
                    </div>
                </div>
            </div>
        </div>
        <div id="footer">
            <p><a href="#">Rubén Darío Valdés Banda</a></p>
            <p><a href="#">Diego Armando Escamilla Morado</a></p>
            <p><a href="#">Programación para Aplicaciones de la Web</a></p>
        </div>
    </body>
</html>
