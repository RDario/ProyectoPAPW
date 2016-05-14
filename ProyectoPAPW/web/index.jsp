<%@page import="Dao.PaginaDao"%>
<%@page import="Beans.Categoria"%>
<%@page import="Dao.ProductoDao"%>
<%@page import="Beans.Producto "%>
<%@page import="Beans.Usuario"%>
<%@page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mercadobayzone</title>
<meta name="keywords" content="Mercadobayzone" />
<meta name="description" content="Station Shop Theme, free CSS template provided by templatemo.com" />
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

</script>

<link rel="stylesheet" type="text/css" media="all" href="css/jquery.dualSlider.0.2.css" />

<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="js/jquery.timers-1.2.js" type="text/javascript"></script>
<script src="js/jquery.dualSlider.0.3.min.js" type="text/javascript"></script>
<script type="text/javascript">
    
    $(document).ready(function() {
        $(".carousel").dualSlider({
            auto:true,
            autoDelay: 6000,
            easingCarousel: "swing",
            easingDetails: "easeOutBack",
            durationCarousel: 1000,
            durationDetails: 600
        });
    });
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
<script>
            var ajaxPc;
            function funcionCallbackPc()
            {
                // Comprobamos si la peticion se ha completado (estado 4)
                if( ajaxPc.readyState == 4 )
                {
                    // Comprobamos si la respuesta ha sido correcta (resultado HTTP 200)
                    if( ajaxPc.status == 200 )
                    {
                        // Escribimos el resultado en la pagina HTML mediante DHTML
                        document.all.salidaPc.innerHTML = "<b>"+ajaxPc.responseText+"</b>";	
                    }
                }
            }
            
            function recuperaResidenciaPc(idCate, UsAct)
            {
                // Creamos el control XMLHttpRequest segun el navegador en el que estemos 
                if( window.XMLHttpRequest )
                    ajaxPc = new XMLHttpRequest(); // No Internet Explorer
                else
                    ajaxPc = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer
                //// Almacenamos en el control al funcion que se invocara cuando la peticion
                // cambie de estado	
                ajaxPc.onreadystatechange = funcionCallbackPc;

                // Enviamos la peticion
                //ajax.open( "GET", "pag_Categorias.jsp?param="+document.all.entrada.value, true );
                ajaxPc.open( "GET", ("pag_ProductoCat.jsp?param="+idCate+"&UsAct="+UsAct), true );
                ajaxPc.send( "" );
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
}
</script>



</head>
     <%
        Usuario UsActual = (Usuario) request.getSession().getAttribute("usuario");
        if(UsActual != null){
        %>

    <body onload="recuperaResidenciaPc(0,<%= UsActual.getId() %>)">
        <%}
               else{
        %>
         <body onload="recuperaResidenciaPc(0, 0)">
             <%}%>

<div id="templatemo_wrapper">
	<div id="templatemo_header">
            
            <div id="site_title">
                <h1><img src="images/templatemo_logo.png" height="60px" width="200px"></h1>
        </div>
            
            <%String user = null;
        if(UsActual != null)
        {
            user = UsActual.getNickname();
        }%>    
               
            
                       
       <% if(user != null){
        %>
        <div id="header_right">
	        <a href="perfilCompleto" >Mi Cuenta(<%= user%>)</a> | <a href="vender.jsp">Vender</a> | <a href="login?Out=true">Log Out</a>
        </div>
        <%}
               else{%>
    
        
        <div id="header_right">
	        | <a href="login.jsp">Log In</a>
        </div>
               <%}%>
        
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menu">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="index.jsp" class="selected">Home</a></li>
                
                <%
                if(user != null){
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
                <%}}%>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of ddsmoothmenu -->
        <div id="menu_second_bar">
            
                
                <%  String Mes[] = new String [13];
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
                <form action="busqueda" method="get">
                    <div id="templatemo_search">
                
                    <%
                    if(user != null){
                    %>
                    
                  <input type="text" value="Buscar" name="Texto" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
                  <input type="submit" value=" Buscar "  id="searchbutton" class="sub_btn"  />
                
                    <%
                    }
                    %>
                   </form> 
            </div>
            <div class="cleaner"></div>
    	</div>
    </div> <!-- END of templatemo_menu -->
    
    <div id="templatemo_middle" class="carousel">
    	<div class="panel">
				
				<div class="details_wrapper">
					
					<div class="details">
					
						<div class="detail">
							<h2><a href="#">Mercadobayzone</a></h2>
                            <p>Registrate aqui y encuentra todo lo que estas buscando. </p>
							<a href="registro.jsp" title="Read more" class="more">Registrarse</a>
						</div><!-- /detail -->
						
						<div class="detail">
							<h2><a href="#">Quienes somos?</a></h2>
                            <p>En nuestra pagina puedes encontrar o vender cualquier producto.</p>
							<a href="login.jsp" title="Read more" class="more">Ingresar</a>
						</div><!-- /detail -->
						
						<div class="detail">
							<h2><a href="#">Descuentos</a></h2>
                            <p>Aprovecha este mes con grandes descuentos para esta navidad.</p>
							<a href="registro.jsp" title="Read more" class="more">Registrarse</a>
						</div><!-- /detail -->
						
					</div><!-- /details -->
					
				</div><!-- /details_wrapper -->
				
				<div class="paging">
					<div id="numbers"></div>
					<a href="javascript:void(0);" class="previous" title="Previous" >Previous</a>
					<a href="javascript:void(0);" class="next" title="Next">Next</a>
				</div><!-- /paging -->
				
				<a href="javascript:void(0);" class="play" title="Turn on autoplay">Play</a>
				<a href="javascript:void(0);" class="pause" title="Turn off autoplay">Pause</a>
				
			</div><!-- /panel -->
	
			<div class="backgrounds">
				
				<div class="item item_1">
					<img src="images/slider/02.jpg" alt="Slider 01" />
				</div><!-- /item -->
				
				<div class="item item_2">
					<img src="images/slider/03.jpg" alt="Slider 02" />
				</div><!-- /item -->
				
				<div class="item item_3">
					<img src="images/slider/01.jpg" alt="Slider 03" />
				</div><!-- /item -->
				
			</div><!-- /backgrounds -->
    </div> <!-- END of templatemo_middle -->
    
    <div id="templatemo_main">
   		<div id="sidebar" class="float_l">
        	<div class="sidebar_box"><span class="bottom"></span>
            	<h3>Categorias</h3>               
               
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

                                <li  value="<%= depto.getId() %>"  onclick="selec(this), recuperaResidenciaPc(<%=depto.getId() %>), recuperaResidencia(<%= depto.getId() %>, '<%= depto.getDescripcion() %>')" >   <%= depto.getDescripcion() %>  </li>

                        <%
                            }
                        }   
                        %>
           
                        </ul>
            
                </div>
                    
            </div>
           
        </div>
        <div id="content" class="float_r">
        	
                
                 <span id="salida"></span><br/>
                 
                 <span id="salidaPc"></span><br/>
                 
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	<p>
			<a href="">Universidad Autonoma de Nuevo León</a> | <a href="">Facultad de Ciencias Fisico Matematicas</a> | <a href="about.html">Licenciado en Multimedia y Animacion Digital</a> 
		</p>

    	Diego Armando Escamilla Morado 1441610 | Ruben Dario Valdes Banda 1485355
    </div> <!-- END of templatemo_footer -->
</div> <!-- END of templatemo_wrapper -->
</body>
</html>