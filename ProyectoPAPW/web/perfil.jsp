<%-- 
    Document   : perfil
    Created on : 11/11/2012, 03:03:56 PM
    Author     : Dario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<%@page import="Beans.Usuario"%>
<%@page import="Beans.Pais"%>
<%@page import="Dao.PaisDao"%>
<%@page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Perfil</title>
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

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})


function getsupport (  )
{
  document.Perfil.submit() ;
}

function getsupportIMG (  )
{
  document.ImgUsu.submit() ;
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
                ajax.open( "GET", "carga_Estados.jsp?persona="+document.all.entrada.value, true );
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
        %>
        <div id="header_right">
	        <a href="/miCuentaPERFIL.jsp" style="color:#27A6F5">Mi Cuenta(<%= user%>)</a> | <a href="vender.jsp">Vender</a> | <a href="login.jsp">Log Out</a>
        </div>
        
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menu">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="index.jsp" >Home</a></li>
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
        	<div id="top_shopping_cart">
            	
            </div>
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
                    	<a href="#"><img src="images/templatemo_image_01.jpg" alt="Image 01" /></a>
                        <h4><a href="#" style="color:#2BB537">Perfil</a></h4>
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="#"><img src="images/templatemo_image_01.jpg" alt="Image 02" /></a>
                        <h4><a href="#">Mensajes</a></h4>
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="#"><img src="images/templatemo_image_01.jpg" alt="Image 03" /></a>
                        <h4><a href="#">Compras</a></h4>
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="#"><img src="images/templatemo_image_01.jpg" alt="Image 04" /></a>
                        <h4><a href="miCuentaPRODUCTOS.jsp">Productos</a></h4>
                        <div class="cleaner"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <div id="content" class="float_r">
            <h1>Perfil</h1>
            
            <form name="ImgUsu" enctype="multipart/form-data" action="/AO_LMAD/upload?param=IMGP" method="POST">
                
                <%
                String IDfoto = String.valueOf(request.getAttribute("id"));
                if("null".equals(IDfoto ))
                {
                %>
                <img src="images/templatemo_image_01.jpg" width="150" height="150"/>
                <br /><input type="file" name="archivoImagen" size="250" accept="image/png" class="more"/>
                <a href="javascript:getsupportIMG()" class="more">Subir</a>
                <%
                }
                else
                {
                %>
                <img width="150px" height="150px" src="/AO_LMAD/mostrarImagen?param=IMGP&id=<%= request.getAttribute("id") %>" />
                <%
                }
                %>
            </form>
            
            
            
            <form name="Perfil" action="/AO_LMAD/perfil?Edita=SI" method="post">
                
                <input type="hidden" name="idFoto" value="<%= IDfoto %>" />
        	
                <%
             //Usuario US = (Usuario) request.getAttribute("usuario");
             Usuario US = (Usuario) request.getSession().getAttribute("usuario");
             //request.getSession().setAttribute("nombre", nombre);
             
            int ID = 0;
            String Nickname = "";
            String Edita = (String) request.getAttribute("Edita");
            
            
            if (US != null) {
                
            
               session.getAttribute("usuario");
               //(String)request.getSession().getAttribute("nombre" );
               ID = US.getId();
                //ID = request.getParameter("ID");
                Nickname = US.getNickname();
                //Nickname = request.getParameter("Nickname"); 
            }
        //Obtiene el Parametro 'email' de la instancia del Objeto 'Usuario' creado        
        %>       
                
    
    <h3> Bienvenido <%= Nickname %> </h3>
    <input type="hidden" name="ID" value="<%= ID %>" />
    <input type="hidden" name="Edita" value="<%= Edita %>" />
    <%
    String color0 = (String) request.getAttribute("Color0");
    String color1 = (String) request.getAttribute("Color1");
    String color2 = (String) request.getAttribute("Color2");
    String color3 = (String) request.getAttribute("Color");
    String color4 = (String) request.getAttribute("Color4");
    String color5 = (String) request.getAttribute("Color5");
    String color6 = (String) request.getAttribute("Color6");
    String color7 = (String) request.getAttribute("Color7");
    String color8 = (String) request.getAttribute("Color8");

    String Cont0 = (String) request.getAttribute("Contenido0");
    String Cont1 = (String) request.getAttribute("Contenido1");
    String Cont2 = (String) request.getAttribute("Contenido2");
    String Cont3 = (String) request.getAttribute("Contenido3");
    String Cont4 = (String) request.getAttribute("Contenido4");
    String Cont5 = (String) request.getAttribute("Contenido5");
    String Cont6 = (String) request.getAttribute("Contenido6");
    String Cont7 = (String) request.getAttribute("Contenido7");
    String Cont8 = (String) request.getAttribute("Contenido8");
    String Cont10 = (String) request.getAttribute("Contenido10");
    String Cont11 = (String) request.getAttribute("Contenido11");
    
     String Mes[] = new String [13];
        Mes[1] = "Enero";
        Mes[2] = "Febrero";
        Mes[3] = "Marzo";
        Mes[4] = "Abril";
        Mes[5] = "Mayo";
        Mes[6] = "Junio";
        Mes[7] = "Julio";
        Mes[8] = "Agosto";
        Mes[9] = "Septiembre";
        Mes[10] = "Octubre";
        Mes[11] = "Noviembre";
        Mes[12] = "Diciembre";
       
    %>
    
    
          
    
    <% 
    if(color0 != null)//Aqui entra cuando tiene el Valor del COlor Asignado
    {    %>
        <br/><div style="color: <%= color0 %>">Nombre:</div>
        <input type="text" name="Nombre" value="" required="required"/><br/>
 <% }
    
    else
    {    %>
        <br/><div>Nombre:</div>
    <%  if(Cont0 != null)//Aqui entra cuando tiene un Valor Asignado
        {   %>
            <input type="text" name="Nombre" value="<%= Cont0 %>" required="required"/><br/>
   <%   }
        else
        {   %>
            <input type="text" name="Nombre" value="" required="required"/><br/>
    <%  }
    }   %>
 
    
    
 
 <% 
    if(color1 != null)//Aqui entra cuando tiene el Valor del COlor Asignado
    {    %>
        <br/><div style="color: <%= color1 %>">Apellido Paterno:</div>
        <input type="text" name="ApePat" value="" required="required"/><br/>
 <% }
    
    else
    {    %>
        <br/><div>Apellido Paterno:</div>
    <%  if(Cont1 != null)//Aqui entra cuando tiene un Valor Asignado
        {   %>
            <input type="text" name="ApePat" value="<%= Cont1 %>" required="required"/><br/>
   <%   }
        else
        {   %>
            <input type="text" name="ApePat" value="" required="required"/><br/>
    <%  }
    }   %>
 
    
    
    
 <% 
    if(color2 != null)//Aqui entra cuando tiene el Valor del COlor Asignado
    {    %>
        <br/><div style="color: <%= color2 %>">Apellido Materno:</div>
        <input type="text" name="ApeMat" value="" required="required"/><br/>
 <% }
    
    else
    {    %>
        <br/><div>Apellido Materno:</div>
    <%  if(Cont2 != null)//Aqui entra cuando tiene un Valor Asignado
        {   %>
            <input type="text" name="ApeMat" value="<%= Cont2 %>" required="required"/><br/>
   <%   }
        else
        {   %>
            <input type="text" name="ApeMat" value="" required="required"/><br/>
    <%  }
    }   %>
    
   
    
    
    
    
    <% 
    if(color3 != null)//Aqui entra cuando tiene el Valor del COlor Asignado
    {    %>
        <br/><div style="color: <%= color3 %>">Dia/Mes/Año:</div>
 <% }
    
    else
          {    %>
        <br/><div>Dia/Mes/Año:</div>
    
    <%}   %>
    
    
            <select name="Dia"  >
                <option value="0">Dia</option>
                <%             
                    for (int i=1; i<32; i++ )
                    {
                        if(String.valueOf(i).equals(Cont3))
                        {%>
                        <option value="<%= i %>" selected><%= i%></option>
                   <% } 
                        else{                                                           
                %>
                <option value="<%= i %>"><%= i%></option>
                <%
                    }}
                %>
            </select>
            <select name="Mes">
                <option value="0">Mes</option>
                
                <%             
                    for (int i=1; i<13; i++ )
                    {
                        if(String.valueOf(i).equals(Cont10))
                        {%>
                        <option value="<%= i %>" selected><%= Mes[i]%></option>
                   <% } 
                        else{                                                           
                %>
                <option value="<%= i %>"><%= Mes[i]%></option>
                <%
                    }}
                %>
                
                               
            </select>
            <select name="Year">
                <option value="0">Año</option>
                <%
                    int año=1994;
                    int valor;
                    
                    
                    for (int j=0; j<40; j++ )
                    {
                        valor = (año-j);
                        if(String.valueOf(valor).equals(Cont11))
                        {   %>
                            <option value="<%= valor %>" selected><%= valor%></option>
                     <% } 
                        else
                        {   %>
                            <option value="<%= valor %>"><%= valor%></option>
                     <% }
                    }   %>
                    
                    
            </select><br/>
            
            
            
            
 <% 
    if(color4 != null)//Aqui entra cuando tiene el Valor del COlor Asignado
    {    %>
        <br/><div style="color: <%= color4 %>">Sexo:</div>
        Hombre<input type="radio" name="Sexo" value="1" required="required"/>
        Mujer<input type="radio" name="Sexo" value="0" required="required"/><br/>
 <% }
    
    else
    {    %>
        <br/><div>Sexo:</div>
    <%  if(Cont4 != null)//Aqui entra cuando tiene un Valor Asignado
        {  
            if("1".equals(Cont4))
            {
    %>
            Hombre<input type="radio" name="Sexo" value="1" checked />
            Mujer<input type="radio" name="Sexo" value="0"  /><br/>
        <%  }
            
            else
            {   %>
                Hombre<input type="radio" name="Sexo" value="1" />
                Mujer<input type="radio" name="Sexo" value="0" checked/><br/>
                       
   <%   }}
        else
        {   %>
            Hombre<input type="radio" name="Sexo" value="1"/>
            Mujer<input type="radio" name="Sexo" value="0" /><br/>
    <%  }
    }   %>
            
 
            
            
 <% 
    if(color5 != null)//Aqui entra cuando tiene el Valor del COlor Asignado
    {    %>
        <br/><div style="color: <%= color5 %>">Telefono:</div>
        <input type="text" name="Telefono" value="" required="required"/><br/>
 <% }
    
    else
    {    %>
        <br/><div>Telefono:</div>
    <%  if(Cont5 != null)//Aqui entra cuando tiene un Valor Asignado
        {   %>
            <input type="text" maxlength="13" name="Telefono" value="<%= Cont5 %>" required="required"/><br/>
   <%   }
        else
        {   %>
            <input type="text" maxlength="13" name="Telefono" value="" required="required"/><br/>
    <%  }
    }   %>
 
 
    
    
    
    
 <% 
    if(color6 != null)//Aqui entra cuando tiene el Valor del COlor Asignado
    {    %>
        <br/><div style="color: <%= color6 %>">Calle:</div>
        <input type="text" name="Calle" value="" required="required"/><br/>
 <% }
    
    else
    {    %>
        <br/><div>Calle:</div>
    <%  if(Cont6 != null)//Aqui entra cuando tiene un Valor Asignado
        {   %>
            <input type="text" name="Calle" value="<%= Cont6 %>" required="required"/><br/>
   <%   }
        else
        {   %>
            <input type="text" name="Calle" value="" required="required"/><br/>
    <%  }
    }   %>
 
 
 
 
            
            
 <% 
    if(color7 != null)//Aqui entra cuando tiene el Valor del COlor Asignado
    {    %>
        <br/><div style="color: <%= color7 %>">Numero:</div>
        <input type="text" name="Numero" value="" required="required"/><br/>
 <% }
    
    else
    {    %>
        <br/><div>Numero:</div>
    <%  if(Cont7 != null)//Aqui entra cuando tiene un Valor Asignado
        {   %>
            <input type="text" name="Numero" value="<%= Cont7 %>" required="required"/><br/>
   <%   }
        else
        {   %>
            <input type="text" name="Numero" value="" required="required"/><br/>
    <%  }
    }   %>
 
 
 
 <% 
    if(color8 != null)//Aqui entra cuando tiene el Valor del COlor Asignado
    {    %>
        <br/><div style="color: <%= color8 %>">Colonia:</div>
        <input type="text" name="Colonia" value="" required="required"/><br/>
 <% }
    
    else
    {    %>
        <br/><div>Colonia:</div>
    <%  if(Cont8 != null)//Aqui entra cuando tiene un Valor Asignado
        {   %>
            <input type="text" name="Colonia" value="<%= Cont8 %>" required="required"/><br/>
   <%   }
        else
        {   %>
            <input type="text" name="Colonia" value="" required="required"/><br/>
    <%  }
    }   %>
 
 
 
    <div>Pais:</div>
<br/>
        <select name="Pais" id="entrada"  onchange="recuperaResidencia()">
            <%
                List<Pais> piss = PaisDao.llenaPais();
                if (piss != null)
                {
                    for (Pais depto : piss)
                    {
            %>
            <option value="<%= depto.getId() %>">   <%= depto.getPais() %>  </option>
            <%
                }
            }
            %>
        </select><br/>
        
        
 
    <div>Estado:</div>
 <br/>
        <%--<input type="text" name="Estado" value="" />--%>
        
        
        <span id="salida"></span><br/>
                
                
                <br/>
                
                <!--<a href="javascript:getsupport()" class="more">Guardar</a>-->
                <input type="submit" value="Enviar">
                                
                        
        </form>
					
                    	
                    </div>
            
         
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
     <div id="templatemo_footer">
    	<p>
			<a href="">Universidad Autonoma de Nuevo León</a> | <a href="">Facultad de Ciencias Fisico Matematicas</a> | <a href="about.html">Licenciado en Multimedia y Animacion Digital</a> 
		</p>

    	Diego Armando Escamilla Morado 1429785 | Ruben Dario Valdes Banda 1497806
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->


