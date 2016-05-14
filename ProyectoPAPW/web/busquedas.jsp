
<%@page import="Dao.UsuarioDao"%>
<%@page import="Dao.PaginaDao"%>
<%@page import="Beans.Categoria"%>

<%@page import="Beans.Usuario"%>

<%@page import="Dao.ProductoDao"%>
<%@page import="Beans.Producto"%>

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
            var ajaxS;
            function funcionCallbackS()
            {
                // Comprobamos si la peticion se ha completado (estado 4)
                if( ajaxS.readyState == 4 )
                {
                    // Comprobamos si la respuesta ha sido correcta (resultado HTTP 200)
                    if( ajaxS.status == 200 )
                    {
                        // Escribimos el resultado en la pagina HTML mediante DHTML
                        document.all.salidaS.innerHTML = "<b>"+ajaxS.responseText+"</b>";	
                    }
                }
            }
            function recuperaResidenciaS(param, idSubCate)
            {
                // Creamos el control XMLHttpRequest segun el navegador en el que estemos 
                if( window.XMLHttpRequest )
                    ajaxS = new XMLHttpRequest(); // No Internet Explorer
                else
                    ajaxS = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer
                //// Almacenamos en el control al funcion que se invocara cuando la peticion
                // cambie de estado	
                ajaxS.onreadystatechange = funcionCallbackS;

                // Enviamos la peticion
                //ajax.open( "GET", "pag_Categorias.jsp?param="+document.all.entrada.value, true );
                ajaxS.open( "GET", ("pag_ProductoCat.jsp?paramSub="+idSubCate+"&param="+param), true );
                ajaxS.send( "" );
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
            function recuperaResidenciaPc(idCate)
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
                ajaxPc.open( "GET", ("pag_ProductoCat.jsp?param="+idCate), true );
                ajaxPc.send( "" );
            }
            
             
        </script>


<script>
            var ajaxB;
            function funcionCallbackB()
            {
                // Comprobamos si la peticion se ha completado (estado 4)
                if( ajaxB.readyState == 4 )
                {
                    // Comprobamos si la respuesta ha sido correcta (resultado HTTP 200)
                    if( ajaxB.status == 200 )
                    {
                        // Escribimos el resultado en la pagina HTML mediante DHTML
                        document.all.salidaBus.innerHTML = "<b>"+ajaxB.responseText+"</b>";	
                    }
                }
            }
            function recuperaResidenciaB(B1, B2, B3, B4, B5)
            {
                // Creamos el control XMLHttpRequest segun el navegador en el que estemos 
                if( window.XMLHttpRequest )
                    ajaxB = new XMLHttpRequest(); // No Internet Explorer
                else
                    ajaxB = new ActiveXObject("Microsoft.XMLHTTP"); // Internet Explorer
                //// Almacenamos en el control al funcion que se invocara cuando la peticion
                // cambie de estado	
                ajaxB.onreadystatechange = funcionCallbackB;

                // Enviamos la peticion
                //ajax.open( "GET", "pag_Categorias.jsp?param="+document.all.entrada.value, true );
                ajaxB.open( "GET", ("pag_Busquedas.jsp?B1="+B1+"&B2="+B2+"&B3="+B3+"&B4="+B4+"&B5="+B5), true );
                ajaxB.send( "" );
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
    
    

    <%
    String SubC = request.getParameter("SubC");
    String para = request.getParameter("param");
    
    String pB1 = request.getParameter("B1");
    String pB2 = request.getParameter("B2");
    String pB3 = request.getParameter("B3");
    String pB4 = request.getParameter("B4");
    String pB5 = request.getParameter("B5");
    %>
    
    <%
    if(pB1 != null && pB2 != null && pB3 != null && pB4 != null && pB5 != null)
    {
    %>
    <body onload="recuperaResidenciaB(<%= pB1%>, <%= pB2%>, <%= pB3%>, <%= pB4%>, <%= pB5%>)" >
    <%
    }
       else{
    %>
    
    <body onload="recuperaResidenciaS(<%= para %>, <%= SubC %>)" >
        <%}%>

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
                <%}
                                       }%>
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
                    <select name="Vendedor">
                        <option value="0">Vendedor</option>
                        <%
                        List<Usuario> usNick = UsuarioDao.LlenaUsuario();
                        if (usNick != null)
                        {
                            for (Usuario depto : usNick)
                            {

                        %>
                        <option value="<%= depto.getId() %>"><%= depto.getNickname() %></option>
                        <%
                            }
                        }   
                        %>
                    </select>
                    
                    <select name="Mes">
                        <option value="0">Mes</option>
                        <%
                        for (int i=1; i<13; i++ )
                        {
                        %>
                        <option value="<%= i %>"><%= Mes[i]%></option>
                        <%
                        }
                        %>
                    </select>
                    
                    <select name="Year">
                        <option value="0">Año</option>
                        <%
                        int año=2012;
                        int valor;
                        
                        for (int j=0; j<40; j++ )
                        {
                            valor = (año-j);
                        %>
                        <option value="<%= valor %>"><%= valor%></option>
                        <%
                        }
                        %>
                    </select>
                    
                    <select name="Precio" class="txt_field">
                        <option value="0">Precio</option>                        
                        <option value="1">Asc.</option>
                        <option value="2">Desc.</option>                        
                    </select>
                    
                    <div id="templatemo_search">
                
                    
                  <input type="text" value="Buscar" name="Texto" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
                  <input type="submit" value="Buscar" id="searchbutton" class="sub_btn"  />
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

                                <li  value="<%= depto.getId() %>"  onclick="selec(this), recuperaResidenciaS(<%=depto.getId() %>, null), recuperaResidencia(<%= depto.getId() %>, '<%= depto.getDescripcion() %>')" >   <%= depto.getDescripcion() %>  </li>

                        <%
                            }
                        }   
                        %>
           
                        </ul>
            
                </div>
                    
            </div>
           
        </div>
        <div id="content" class="float_r">
        	
            
            <!--<span id="salidaBus"></span><br/>-->
        <%    
            if(pB1 != null && pB2 != null && pB3 != null && pB4 != null && pB5 != null)
            {
                int Vendedor = Integer.parseInt(pB1);        
        
        int Mes2 = Integer.parseInt(pB2);
        
        int Año = Integer.parseInt(pB3);
        
        int Precio = Integer.parseInt(pB4);
        %>
        
            <%
            List<Producto> prod = ProductoDao.BusquedaProductos(Vendedor, Mes2, Año, Precio, pB5);
            if (prod != null)
                {
                    int i=0;
                    int tercer=0;
                    
                    for (Producto proT : prod)
                    {
                        i++;
                        if(i > 9){break;}
                        
                        tercer=((i/3)*3);
                        if(i == tercer )
                        {
            %>
                            <div class="product_box no_margin_right">
            <%
                        }
                        else
                        {
            %>
                                <div class="product_box">
            <%
                        }
            %>
            
                                    <a href="/AO_LMAD/obtieneProductoV?id=<%= proT.getId() %>"><img width="200px" height="150px" src="/AO_LMAD/mostrarImagen?param=INDEX&id=<%= proT.getFoto1() %>" alt="Image 0<%=i%>" /></a>
                                    <h3><%= proT.getTitulo() %></h3>
                                    <p class="product_price">$ <%= proT.getPrecio() %></p>
                                    <a href="shoppingcart.html" class="add_to_card">Comprar</a>
                                    <a href="/AO_LMAD/obtieneProductoV?id=<%= proT.getId() %>" class="detail">Ver</a>
                                </div>
                            
            
            <%
                    }
                }
        }
        %>
        
            
                 <span id="salida"></span><br/>
                 
                 <!--<span id="salidaPc"></span><br/>-->
                 
                 <span id="salidaS"></span><br/>
                 
                 
                 
                 
                
            
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