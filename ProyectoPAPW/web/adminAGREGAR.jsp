
<%@page import="Dao.PaginaDao"%>
<%@page import="Beans.Categoria"%>

<%@page import="Beans.Usuario"%>

<%@page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mercadobayzone</title>
<meta name="keywords" content="Avisos de Ocasion" />
<meta name="description" content="Station Shop Theme, free CSS template provided by templatemo.com" />
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
            function getsupportCS (  )
{
  document.AddCateSub.submit() ;
}

            function getsupportS (  )
{
  document.AddSub.submit() ;
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



</head>

<body>

<div id="templatemo_wrapper">
	<div id="templatemo_header">
            
            <div id="site_title">
                <h1><img src="images/templatemo_logo.png"></h1>
        </div>
            
            <%
        Usuario UsActual = (Usuario) request.getSession().getAttribute("usuario");
        String user = null;
        if(UsActual != null)
        {
            user = UsActual.getNickname();
        }
               
            
               
              
        
        if(user != null){
        %>
        <div id="header_right">
	        <a href="perfilCompleto" >Mi Cuenta(<%= user%>)</a> | <a href="vender.jsp">Vender</a> | <a href="login?Out=true">Log Out</a>
        </div>
        <%}
               else{%>
    
        
        <div id="header_right">
	        <a href="login.jsp">Mi Cuenta</a> | <a href="login.jsp">Log In</a>
        </div>
               <%}%>
        
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
                <li><a href="#" class="selected">Categorias</a>
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
        	<div class="sidebar_box" ><span class="bottom"></span>
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

                                <li  value="<%= depto.getId() %>"  onclick="selec(this), recuperaResidencia(<%= depto.getId() %>, '<%= depto.getDescripcion() %>')" >   <%= depto.getDescripcion() %>  </li>

                        <%
                            }
                        }   
                        %>
           
                        </ul>
            
                </div>
                    
            </div>
           
        </div>
        <div id="content" class="float_r">
                 
                 <h1>Agregar</h1>
				
				<form name="AddCateSub" action="/AO_LMAD/adminAddC?AddS=False" method="post">
				
					<h3>Agregar Categoria y Subcategoria</h3>
				
					<table width="450px" cellspacing="0" cellpadding="5">
						<tr bgcolor="#ddd">
							<th width="80" align="left">Categoria</th>
							<th width="370" align="left">SubCategoria</th>
							<th width="200" align="left"></th>
						</tr>
						
						<tr>
							<td><input type="text" name="Categoria" value="" required="required"></td>
							<td><input type="text" name="SubCategoria" value="" required="required"></td>
                                                        <td><input type="submit" value="Agregar"/></td>
							<!--<td><a href="javascript:getsupportCS()" class="more">Agregar</a></td>-->
						</tr>
					</table>
				</form>
				
				<br/><br/><br/>
				<form name="AddSub" action="/AO_LMAD/adminAddC?AddS=True" method="post">
					
					<h3>Agregar una Subcategoria</h3>
				
					<table width="450px" cellspacing="0" cellpadding="5">
						<tr bgcolor="#ddd">
							<th width="80" align="left">Categoria</th>
							<th width="570" align="left">SubCategoria</th>
							<th width="200" align="left"></th>
						</tr>
						
						<tr>
							<td>
								<!--<select style="width:155px">
									<option value="1">Categoria 1</option>
									<option value="2">Categoria 2</option>
									<option value="3">Categoria 3</option>
								</select>-->
                                                                <select name="Categoria" class="sidebar_list" id="entrada"  onchange="recuperaResidencia()" style="width:155px">                    
                                <%
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
							<td><input type="text" name="SubCategoria" value="" required="required"></td>
							<!--<td><a href="javascript:getsupportS()" class="more">Agregar</a></td>-->
                                                        <td><input type="submit" value="Agregar"/></td>
						</tr>
					</table>
				</form>
                                <br/><br/><br/>
                
            	
             
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