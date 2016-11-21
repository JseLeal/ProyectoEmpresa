<%-- 
    Document   : Proveedores
    Created on : Oct 25, 2016, 11:18:43 PM
    Author     : Usuario
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Clases.Conexion"%>
<%
 String nombre_variable="";
            String estado="false";
            if(session.getAttribute("MSG")!=null)
            {
                if((String)session.getAttribute("MSG")=="Si")
                {
                nombre_variable="El proveedor se ha ingresado correctamente.";
                } else if((String)session.getAttribute("MSG")=="No") 
                        { nombre_variable="El proveedor no se ha ingresado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Mod") 
                        { nombre_variable="El proveedor se ha modificado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoMod") 
                        { nombre_variable="El proveedor no se ha modificado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="El") 
                        { nombre_variable="El proveedor se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoEl") 
                        { nombre_variable="El proveedor no se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Existe") 
                        { nombre_variable="El proveedor ya existe.";
                        }
                else if((String)session.getAttribute("MSG")=="Error") 
                        { nombre_variable="No se ha podido llevar a cabo la tarea.";
                        }
           }
            if (session.getAttribute("esta")==null)
            {
               estado="false";
            }else{estado="true";}  
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.Compras.Proveedores_S"%>

<div id="page-wrapper">
    <div class="container-fluid">
        <form action="Proveedores_S" method="post">
            
            <table class="table">
                 
                <tr>
                <th>Proveedor</th>
                <td><input class="form-control" type="text" name="Proveedor"></td>
                </tr>
                
                <tr>
                <th>NIT</th>
                <td><input class="form-control" type="text" name="NIT"></td>
                </tr>
                
                <tr>
                <th>Direccion</th>
                <td><input class="form-control" type="text" name="Direccion"></td>
                </tr>
                
                <tr>
                <th>Telefono</th>
                <td><input class="form-control" type="text" name="Telefono"></td>
                </tr>
            </table>
            
                <input class="btn btn-success" type="submit" value="Insertar" name="Insertar" />
                <input class="btn btn-warning" type="submit" value="Modificar" name="Modificar" />
                <input class="btn btn-danger" type="submit" value="Eliminar" name="Eliminar" />
                <label visible="<%=estado%>" > <%= nombre_variable%> </label>
        </form>
        
        
        <h3>Proveedores Actuales</h3>
                <%
        Conexion C;
        C = new Conexion();
        C.abrirConexion();

        String query="";
        query = "SELECT proveedor,NIT, direccion FROM proveedores where Activo like '1' ";

        ResultSet consulta = C.conexionBd.createStatement().executeQuery(query);

        out.println("<table class='table table-hover'>");
        while (consulta.next()) 
            {
                                    
            String proveedor = consulta.getString("proveedor");
            String NIT = consulta.getString("NIT");
            String direccion = consulta.getString("direccion");
            
            out.println("<tr>");
          
            out.println("<td>" + proveedor + "</td>");
            out.println("<td>" + NIT + "</td>");
            out.println("<td>" + direccion + "</td>");
                           
            out.println("</tr>");
           
            }
         out.println("</table>");
        C.cerrarConexion();
                %>
        
        
        
    </div>
</div>
<%    request.getSession().setAttribute("MSG",null);
      request.getSession().setAttribute("esta","false");
%>

