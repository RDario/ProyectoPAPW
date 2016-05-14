
<%@page import="Beans.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

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

</script>




<link rel="stylesheet" type="text/css" media="all" href="css/jquery.dualSlider.0.2.css" />

<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="js/jquery.timers-1.2.js" type="text/javascript"></script>

</head>

    <body>

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
	        <a href="perfilCompleto" style="color:#27A6F5">Mi Cuenta(<%= user%>)</a> | <a href="vender.jsp">Vender</a> | <a href="login?Out=true">Log Out</a>
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
        	<div id="top_shopping_cart">
            	
            </div>
        	<form action="busqueda" method="get">
                    <div id="templatemo_search">             
                  <input type="text" value="Buscar" name="Texto" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
                  <input type="submit" value=" Buscar "  id="searchbutton" class="sub_btn"  />             
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
                        <h4><a href="perfilCompleto" style="color:#2BB537">Perfil</a></h4>
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="miCuentaMENSAJES.jsp"><img src="images/templatemo_image_01.jpg" alt="Image 02" /></a>
                        <h4><a href="miCuentaMENSAJES.jsp">Mensajes</a></h4>
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
            <form name="miCuentaPerfil" action="/AO_LMAD/perfilCom" method="post">
        	<h1>Perfil</h1>
                <%
                /*Usuario US = (Usuario) request.getSession().getAttribute("usuario");
                String ID = US.getEmail();*/
                
                String DATO[] = new String [14];
                for(int i=0; i<14; i++)
                {
                    DATO[i]= (String) request.getAttribute("DatPer"+i);
                }
                %>
		
                <!--<input type="hidden" name="ID" value="" />*/-->
                
                <table>
			
			<tr >
				<td scope="col"  rowspan="2" ><img src="/AO_LMAD/mostrarImagen?param=IMGP&id=<%=  DATO[13] %>" width="250" height="250" alt="Image 01" /></td>
				<td scope="col"><font size= 3>Nickname:</font></td>
				<td><font size= 4 ><%= DATO[0]%></font></td>
			</tr>
			
			<tr>
				<td scope="col"><font size= 3>Email:</font> </td>		
				<td><font size= 4 ><%=DATO[1]%></font></td>
			</tr>
			
			</table>
			
			<table  width="250px" cellspacing="0" cellpadding="5">
			<tr>
				<td><font size= 3>Nombre:</font></td>
				<td><font size= 4 ><%=DATO[2]%></font></td>
			</tr>
             <tr>
				<td><font size= 3>Apellido Paterno:</font></td>
				<td><font size= 4 ><%=DATO[3]%></font></td>
			</tr>
			<tr>
				<td><font size= 3>Apellido Materno:</font></td>
				<td><font size= 4 ><%=DATO[4]%></font></td>
			</tr>
            <tr>
				<td><font size= 3>Fecha de Nacimiento:</font></td>
				<td><font size= 4 ><%=DATO[5]%></font></td>
			</tr>
            <tr>
				<td><font size= 3>Sexo:</font></td>
				<td><font size= 4 ><%=DATO[6]%></font></td>
			</tr>
            <tr>
				<td><font size= 3>Celular (Telefono):</font></td>
				<td><font size= 4 ><%=DATO[7]%></font></td>
			</tr>
            <tr>
				<td><font size= 3>Calle:</font></td>
				<td><font size= 4 ><%=DATO[8]%></font></td>
			</tr>
            <tr>
				<td><font size= 3>N°:</font></td>
				<td><font size= 4 ><%=DATO[9]%></font></td>
			</tr>
            <tr>
				<td><font size= 3>Colonia:</font></td>
				<td><font size= 4 ><%=DATO[10]%></font></td>
			</tr>
            <tr>
				<td><font size= 3>Pais:</font></td>
				<td><font size= 4 ><%=DATO[11]%></font></td>
			</tr>
            <tr>
				<td><font size= 3>Estado:</font></td>
				<td><font size= 4 ><%=DATO[12]%></font></td>
			</tr>
			
			</table>
			<br/><br/><br/><br/>
			
			
			
                   	  	
                    	<a href="perfil" class="more">Editar</a>
                       
                        </form>
					
                    	
                    </div>
            
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
     <div id="templatemo_footer">
    	<p>
			<a href="">Universidad Autonoma de Nuevo León</a> | <a href="">Facultad de Ciencias Fisico Matematicas</a> | <a href="about.html">Licenciado en Multimedia y Animacion Digital</a> 
		</p>

    	Diego Díaz Reyna 1441610 | Jesus Alejandro Lara Elizondo 1485355
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>