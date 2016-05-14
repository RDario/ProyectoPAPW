

<%@page import="Beans.SubCategoria"%>
<%@page import="Dao.PaginaDao"%>
<%@page import="java.util.List"%>



<%
	// Obtener el parametro con el nombre de la persona
	String param = request.getParameter("param");
        String Cate = request.getParameter("Cate");
        
        if(Cate != null)//EN Texto
        {
        %>
        
            <h1 name="Subajax" ><%= Cate %></h1>
            <%
            List<SubCategoria> ArrSubC = PaginaDao.ObtieneSubCategoria(param);
            if (ArrSubC != null)
            {
                for (SubCategoria stdo : ArrSubC )
                {
                    
            %>
            
                    <h5 value="<%= stdo.getId() %>"><a href="busquedas.jsp?SubC=<%= stdo.getId() %>&param=<%= param %>&Cate=<%= Cate %>"> <%= stdo.getDescripcion() %> </a></h5>
            <%
                }
            }
        }
        else//ComboBox
        {   %>
            <select name="SubCategoria" style="width:155px">    
               
            <% List<SubCategoria> ArrSubCat = PaginaDao.ObtieneSubCategoria(param);
            if (ArrSubCat != null)
            {
                for (SubCategoria subcate : ArrSubCat )
                {
            %>
                    <option value="<%= subcate.getId() %>">   <%= subcate.getDescripcion() %>  </option>
            
            
            <%
                }
            }
        }
            %>
            </select>




       