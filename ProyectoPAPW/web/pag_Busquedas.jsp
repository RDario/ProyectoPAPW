

<%@page import="Beans.Producto"%>
<%@page import="Dao.ProductoDao"%>
<%@page import="java.util.List"%>



<%
	// Obtener el parametro con el nombre de la persona
	String pB1 = request.getParameter("B1");
        int Vendedor = Integer.parseInt(pB1);        
        
	String pB2 = request.getParameter("B2");
        int Mes = Integer.parseInt(pB2);
        
	String pB3 = request.getParameter("B3");
        int Año = Integer.parseInt(pB3);
        
	String pB4 = request.getParameter("B4");
        int Precio = Integer.parseInt(pB4);
        
	String pB5 = request.getParameter("B5");
        
        
        
        if(pB1 != null && pB2 != null && pB3 != null && pB4 != null && pB5 != null)
        {
        %>
        
            <%
            List<Producto> prod = ProductoDao.BusquedaProductos(Vendedor, Mes, Año, Precio, pB5);
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
                            </div>
            
            <%
                    }
                }
        }
        %>




       