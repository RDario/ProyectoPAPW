
<%@page import="Beans.Estado"%>
<%@page import="Dao.EstadoDao"%>
<%@page import="java.util.List"%>

<%@page import="Beans.Estado"%>
<%@page import="Dao.EstadoDao"%>

<%
	// Obtener el parametro con el nombre de la persona
	String persona = request.getParameter("persona");
        %>

        <select name="Estado">
            
            
            <%          
            //String A = dimePropiedades();
                       
                List<Estado> ArrEstados = EstadoDao.llenaEstado(persona);
                if (ArrEstados != null)
                {
                    for (Estado stdo : ArrEstados)
                    {
            %>
            <option value="<%= stdo.getId() %>">   <%= stdo.getEstado() %>  </option>
            <%
                }
            }
            %>
        </select><br/>
       