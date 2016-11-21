<%@page import="java.sql.ResultSet"%>
<%@page import="Clases.Conexion"%>
<%String nombre_variable="";
            String estado="false";
            if(session.getAttribute("MSG")!=null)
            {
                if((String)session.getAttribute("MSG")=="Si")
                {
                nombre_variable="La marca se ha ingresado correctamente.";
                } else if((String)session.getAttribute("MSG")=="No") 
                        { nombre_variable="La marca no se ha ingresado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="El") 
                        { nombre_variable="La marca se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoEl") 
                        { nombre_variable="La marca no se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Existe") 
                        { nombre_variable="El nombre de la marca ya existe.";
                        }
                else if((String)session.getAttribute("MSG")=="Error") 
                        { nombre_variable="No se ha podido lleva a cabo la tarea.";
                        }
           }
            if (session.getAttribute("esta")==null)
            {
               estado="false";
            }else{estado="true";}  %>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.Marcas_S"%>
<%@page pageEncoding="UTF-8"%>

 <div id="page-wrapper">
    <div class="container-fluid">
        <form action="Marcas_S" method="POST">  
         <table class="table">
             <tr>
                 <th>Marca</th>
                 <td><input class="form-control" type="text" name="marca" id="marca"/></td>
             </tr>
         </table> 
            <input class="btn btn-success" type="submit" name="Ingresar" value="Ingresar"/>
            <input class="btn btn-danger" type="submit" name="Eliminar" value="Eliminar"/>
            <label visible="<%= estado %>"> <%= nombre_variable%> </label>
            <BR>
            <a href="Productos.jsp" style="font-size:13px;">IR A PRODUCTOS</a>
        </form>
            
            
         <h3>Marcas Actuales</h3>   
                            <%
        Conexion C;
        C = new Conexion();
        C.abrirConexion();

        String query="";
        query = "SELECT marca FROM marcas where Activo like '1' ";

        ResultSet consulta = C.conexionBd.createStatement().executeQuery(query);

        out.println("<table class='table table-hover'>");
        while (consulta.next()) 
            {
                                    
            String marca = consulta.getString("marca");
       
            out.println("<tr>");
                            
            out.println("<td>"+ marca +"</td>");
                           
            out.println("</tr>");
           
            }
         out.println("</table>");
        C.cerrarConexion();
                %>
            
            
</div>
 </div>
        
            <% request.getSession().setAttribute("MSG",null);
            request.getSession().setAttribute("esta","false");%>

