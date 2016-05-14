
<%@page import="Beans.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Beans.ArchivoDAO"%>
<%@page import="Beans.Archivo2"%>

<%@page import="Dao.PaginaDao"%>
<%@page import="Beans.Categoria"%>

<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Mercadobayzone - Shopping Cart Page</title>
        <meta name="keywords" content="station shop, cart, free templates, website templates, CSS, HTML" />
        <meta name="description" content="Station Shop, Shopping Cart, free CSS template by templatemo.com" />
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
        
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/ddsmoothmenu.js"></script>
        
        <script language="javascript" type="text/javascript">
            function clearText(field)
            {
                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;
            }
        </script>
        
        <script type="text/javascript">
            ddsmoothmenu.init
            (
            {
                mainmenuid: "top_nav", //menu DIV id           
                orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
                classname: 'ddsmoothmenu', //class added to menu's outer DIV
                //customtheme: ["#1c5a80", "#18374a"],
                contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
             })
             
             function getsupportIMG()
             {
                 document.ImgProd.submit();
             }
             function getsupport()
             {
                 document.Vende.submit();
             }
        </script>
        
        <script>
            var ajax;
            function funcionCallback()
            {
                // Comprobamos si la peticion se ha completado (estado 4)
            
                if( ajax.readyState == 4 )
                {
                    // Comprobamos si la respuesta ha sido correcta (resultado HTTP 200)
                    if( ajax.status == 200 )
                    {
                        // Escribimos el resultado en la pagina HTML mediante DHTML
                        document.all.salida.innerHTML = "<b>"+ajax.responseText+"</b>";	
                    }
                }
            }
    
            function recuperaResidencia()
            {
                // Creamos el control XMLHttpRequest segun el navegador en el que estemos 
                if( window.XMLHttpRequest )
                    ajax = new XMLHttpRequest(); // No Internet Explorer
                else
                    ajax = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer
                //// Almacenamos en el control al funcion que se invocara cuando la peticion
                // cambie de estado	
                ajax.onreadystatechange = funcionCallback;

                // Enviamos la peticion
                //ajax.open( "GET", "pag_Categorias.jsp?param="+document.all.entrada.value, true );
                ajax.open( "GET", ("pag_Categorias.jsp?param="+document.all.entrada.value), true );
                ajax.send( "" );
            }

        </script>

<link rel="stylesheet" type="text/css" media="all" href="css/jquery.dualSlider.0.2.css" />

<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="js/jquery.timers-1.2.js" type="text/javascript"></script>

</head>
    
    <body onload="recuperaResidencia()">
        
        <div id="templatemo_wrapper">
            
            <div id="templatemo_header">
                
                <div id="site_title">
                    <h1><img src="images/templatemo_logo.png"></h1>
                </div>
        <%
        Usuario UsActual = (Usuario) request.getSession().getAttribute("usuario");
        String user = UsActual.getNickname();
        String idUSUARIO= String.valueOf(UsActual.getId());
        %>
        
        <div id="header_right">
	       <a href="perfilCompleto" >Mi Cuenta(<%= user%>)</a> | <a href="vender.jsp" style="color:#27A6F5">Vender</a> | <a href="login?Out=true">Log Out</a>
        </div>
        
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menu">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <%
                    if(UsActual.getTipo_Usuario().equals("1"))
                    {
                    %>
                <li><a href="#">Categorias</a>
                    <ul>
                        <li><a href="adminAGREGAR.jsp">Agregar</a></li>
                        <li><a href="adminMODIFICAR.jsp">Modificar</a></li>
                        <li><a href="adminELIMINAR.jsp">Eliminar</a></li>
                        
                  </ul>
                    </li>
                <li><a href="adminCOMENTARIOS.jsp">Comentarios</a></li>
                <%}%>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of ddsmoothmenu -->
        <div id="menu_second_bar">
        	
        	<div id="templatemo_search">
                <form action="#" method="get">
                  <input type="text" value="Search" name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
                  <input type="submit" name="Search" value=" Search " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
                </form>
                    
                      
                    
            </div>
            <div class="cleaner"></div>
    	</div>
    </div> <!-- END of templatemo_menu -->
    
    <div id="templatemo_main">
   		<div id="sidebar" class="float_l">
        	
                    
            <div class="sidebar_box"><span class="bottom"></span>
            	<h3>Mi Cuenta </h3>   
                <div class="content"> 
                	<div class="bs_box">
                    	<a href="perfilCompleto"><img src="images/templatemo_image_01.jpg" alt="Image 01" /></a>
                        <h4><a href="perfilCompleto">Perfil</a></h4>
                        
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="miCuentaMENSAJES.jsp"><img src="images/templatemo_image_01.jpg" alt="Image 02" /></a>
                        <h4><a href="miCuentaMENSAJES.jsp" >Mensajes</a></h4>
                        
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="miCuentaCOMPRA.jsp"><img src="images/templatemo_image_01.jpg" alt="Image 03" /></a>
                        <h4><a href="miCuentaCOMPRA.jsp">Compras</a></h4>
                      
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="miCuentaPRODUCTOS.jsp"><img src="images/templatemo_image_01.jpg" alt="Image 04" /></a>
                        <h4><a href="miCuentaPRODUCTOS.jsp">Productos</a></h4>
                       
                        <div class="cleaner"></div>
                    </div>
                </div>
            </div>
        </div>
        <div id="content" class="float_r">
            <h1>Vender</h1>
			
			<!--<div id="UpBck" style="position:fixed;width:'+ScreenWidth+';height:100%;top:0px;left:0px;background:#000000;filter:alpha(opacity=60);-moz-opacity:0.6;opacity:0.6;"> -->
                <form name="ImgProd" enctype="multipart/form-data" action="/AO_LMAD/upload?param=INDEX" method="POST">
                    
                    <% String ID = String.valueOf(request.getAttribute("id"));
            if("null".equals(ID))
            {%>
            <img src="images/templatemo_image_01.jpg" width="150" height="150"/>
            <br /><input type="file" name="archivoImagen" size="250" accept="image/png" class="more"/>
                   <a href="javascript:getsupportIMG()" class="more">Subir</a>
            
            <%}
                       else
           {%>
           <img width="150px" height="150px" src="/AO_LMAD/mostrarImagen?param=INDEX&id=<%= request.getAttribute("id") %>" /> 
           <%}%>
                    
                     
                    
                </form>
                        
            <form enctype="multipart/form-data" action="<%=request.getServletContext().getContextPath()%>/upload" method="POST">
            <b>Subir video:</b> 
            <input type="file" name="archivo" size="50">
            <br />
            <b>Descripción:</b> 
            <input type="text" name="descripcion" size="50">
            <br />
            <input type="submit" value="Upload">
      </form>
           
                        
                        
                <form name="Vende" method="post" action="/AO_LMAD/creaProducto">
                    
			<input type="hidden" name="idFoto" value="<%= ID %>" />
           <input type="hidden" name="idUsuario" value="<%= idUSUARIO %>" />
           
           
                    <table width="690px" cellspacing="0" cellpadding="5">
                        <tr>
                            <td>Precio:</td> 
                            <td align="left"><input type="text" name="Precio" value="" size="10px" required="required"></input></td>                               
                        </tr>
                        
                        <tr>
                            <td>Categoria:</td>
                            <td>
                                <select class="sidebar_list" id="entrada" onchange="recuperaResidencia()" style="width:155px">                    
                                <%
                                  List<Categoria> cat = PaginaDao.ObtieneCategoria();
                                  if (cat != null)
                                  {
                                      for (Categoria depto : cat)
                                      {
                                %>       <option value="<%= depto.getId() %>">   <%= depto.getDescripcion() %>  </option>

                                <%
                                      }
                                  }
                                %>
                                </select>
                            </td>
                                <td align="left" >
                                <span id="salida" ></span><br/>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>Titulo:</td> 
                            <td align="left" colspan="2"><input type="text" name="Titulo" value="" size="68px" required="required"/></td>
                        </tr>
					
                        <tr>
                            <td>Descripcion:</td> 
                            <td colspan="2"><textarea rows="4" cols="52" name="Descripcion" required="required"></textarea></td>						
                        </tr>
                    </table>
					
                       <!-- <a href="javascript:getsupport()" class="more">Aceptar</a>-->
                        <input type="submit" />
					
                </form>
                    
			
                        
                        <!--</div>-->
            
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
     <div id="templatemo_footer">
    	<p>
			<a href="">Universidad Autonoma de Nuevo León</a> | <a href="">Facultad de Ciencias Fisico Matematicas</a> | <a href="about.html">Licenciado en Multimedia y Animacion Digital</a> 
		</p>

    	Diego Diaz Reyna 1441610 | Jesus Alejandro Lara Elizondo 1485355
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>