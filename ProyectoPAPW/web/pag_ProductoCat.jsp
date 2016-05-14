

<%@page import="Beans.Producto"%>
<%@page import="Dao.ProductoDao"%>


<%@page import="Beans.SubCategoria"%>
<%@page import="Dao.PaginaDao"%>

<%@page import="java.util.List"%>

<%      
        //Para CATEGORIA*
        String Us = request.getParameter("UsAct");
        if(Us == null){Us = "0";}
        String param = request.getParameter("param");
        
        int idCategoria=0;
        if(param != null)
        {
            idCategoria = Integer.parseInt(param);
        }
        
        
        //Para SUBCATEGORIA
        String paramSub = request.getParameter("paramSub");
        if(paramSub != null )
        {
        if(paramSub.equals("null") ){paramSub = null;}}
        String SUBCate = "NO";
        
	if(paramSub != null )
        {
            int SubCat = Integer.parseInt(paramSub);
            
            
            List<SubCategoria> ArrSubC = PaginaDao.ObtieneSubCategoria(param);
            if (ArrSubC != null)
            {
                for (SubCategoria stdo : ArrSubC )
                {
                    if(stdo.getId() == SubCat )
                    {
                        SUBCate = stdo.getDescripcion();
                    }
                    
           
                }
            }%>
            
                <h1 name="Subajax" ><%= SUBCate %></h1>
            
              <%  List<Producto> prod = ProductoDao.ProductosSubCategoria(SubCat);
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
                                    <a href="compra?Us=<%= Us %>&Pr=<%= proT.getId() %>" class="add_to_card">Comprar</a>
                                    <a href="/AO_LMAD/obtieneProductoV?id=<%= proT.getId() %>" class="detail">Ver</a>
                                </div>
                            </div>
            
            <%
                    }
                }
            }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
               else{
        

	
	
        
        request.setAttribute("Seleccion", "TRUE");
        
        %>
        <!--Son los IFs de CATEGORIA-->
            <%
            if(idCategoria != 0)
            {
                List<Producto> prod = ProductoDao.ProductosCategoria(idCategoria);
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
                                    <a href="compra?Us=<%= Us %>&Pr=<%= proT.getId() %>" class="add_to_card">Comprar</a>
                                    <a href="/AO_LMAD/obtieneProductoV?id=<%= proT.getId() %>" class="detail">Ver</a>
                                </div>
                            </div>
            
            <%
                    }
                }
            }
            
            else
            {
                List<Producto> prod = ProductoDao.ProductosTodos();
                
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
                        <% }else{
                        %>
                        <div class="product_box">
                            <%}%>
            	<a href="/AO_LMAD/obtieneProductoV?id=<%= proT.getId() %>"><img width="200px" height="150px" src="/AO_LMAD/mostrarImagen?param=INDEX&id=<%= proT.getFoto1() %>" alt="Image 0<%=i%>" /></a>
                <h3><%= proT.getTitulo() %></h3>
                <p class="product_price">$ <%= proT.getPrecio() %></p>
                <a href="compra?Us=<%= Us %>&Pr=<%= proT.getId() %>" class="add_to_card">Comprar</a>
                <a href="/AO_LMAD/obtieneProductoV?id=<%= proT.getId() %>" class="detail">Ver</a>
            </div>

                                
                        <%
                            }
                        } 
                               }
            
               }
        
            %>
        


       