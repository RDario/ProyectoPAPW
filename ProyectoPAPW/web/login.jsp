
<%@page import="Dao.PaginaDao"%>
<%@page import="Beans.Categoria"%>

<%@page import="Dao.UsuarioDao "%>
<%@page import="Beans.Usuario "%>


<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<meta name="keywords" content="station shop, FAQs, free templates, website templates, CSS, HTML" />
<meta name="description" content="Station Shop Theme, FAQs, free CSS template provided by templatemo.com" />
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




function getsupport (  )
{
  document.Login.submit() ;
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
  document.Login.submit() ;
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
            function recuperaResidencia(id, Cate)
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
                ajax.open( "GET", ("pag_Categorias.jsp?param="+id+"&Cate="+Cate), true );
                ajax.send( "" );
            }
            
             
        </script>


<style type="text/css">
.selected {color:#27A6F5}
</style>

<script type="text/javascript">
var sel = null;
function selec(obj) {
  if (sel!=null) sel.className = '';
  obj.className = 'selected';
  sel=obj;
  
  //recuperaResidencia(obj);
}
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
            <h1><img src="images/templatemo_logo.png"height="60px" width="150px"></h1>
        </div>
        
        <div id="header_right">
	        | <a href="login.jsp" style="color:#27A6F5">Log In</a>
		</div>
        
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menu">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                
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
            	<h3>Categories</h3>   
               <div class="content"> 
                	<!--<ul class="sidebar_list"  id="entrada" >-->
                        <ul class="sidebar_list" id="entrada" >
                            
                            
                            
                             <%
                List<Categoria> cat = PaginaDao.ObtieneCategoria();
                if (cat != null)
                {
                    for (Categoria depto : cat)
                    {
                        
            %>
            <li  value="<%= depto.getId() %>"  onclick="selec(this), recuperaResidencia(<%= depto.getId() %>, '<%= depto.getDescripcion() %>')" ><a href="busqueda.jsp">  <%= depto.getDescripcion() %> </a>  </li>
            
            <%
                }
            }
            %>
           
                        </ul>
            
                </div>
            </div>
            
            
        </div>
        <div id="content" class="faq float_r">
            
            <div id="templatemo_log">
                
                <form name="Login" action="/AO_LMAD/login" method="post">
                    <% 
                       String CTemp = (String) request.getAttribute("CorreoTemp");
                       String color = (String) request.getAttribute("ColorE");
                       String msj = (String) request.getAttribute("MsjE");
                       String color2 = (String) request.getAttribute("ColorP");
                       String msj2 = (String) request.getAttribute("MsjP");
                    %>
                    
                    <h2>Log In</h2>
                    
                    <h3>Correo:</h3>
                    <% if(CTemp != null)
                       {    %>                        
                        
                    <input type="text" value="<%=CTemp%>" size="40" name="Email" id="keyword" title="Correo@ejemplo.com" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
                    
                    <%}
                                             else
                         {%>
                         <input type="text" value="Correo@ejemplo.com" size="40" name="Email" id="keyword"  onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
                    
                         
                        <% }%>
                       
                    <% if(color == null)
                       {    %>
                            <p>Ingresa tu Correo</p>
                    <% }
                       else
                       {    %>
                            <div style="color: <%= color %>"><%= msj %></div>
                    <% }    %>

                    <h3>Password:</h3>
                    <input type="password" value="" size="40" name="Pass" id="keyword" title="" class="txt_field" />                    
                    <%
                    if(color2 == null)
                       {    %>
                            <p>Ingresa tu Contrase�a</p>
                    <% }
                       else
                       {    %>
                            <div style="color: <%= color2 %>"><%= msj2 %></div>
                    <% }    %>

                    </br>
            
                    <a href="javascript:getsupport()" class="more">Ingresar</a>

                    <a href="registro.jsp" class="more" style="margin-left:100px">Registrate</a>
                    
                </form>
        
            </div>
        
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
     <div id="templatemo_footer">
    	<p>
			<a href="">Universidad Autonoma de Nuevo Le�n</a> | <a href="">Facultad de Ciencias Fisico Matematicas</a> | <a href="about.html">Licenciado en Multimedia y Animacion Digital</a> 
		</p>

    	Diego D�az Reyna 1441610 | Jesus Alejandro Lara Elizondo 1485355
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>