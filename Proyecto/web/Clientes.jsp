<%-- 
    Document   : Clientes
    Created on : Oct 24, 2016, 5:37:34 PM
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
                nombre_variable="El cliente se ha ingresado correctamente.";
                } else if((String)session.getAttribute("MSG")=="No") 
                        { nombre_variable="El cliente no se ha ingresado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Mod") 
                        { nombre_variable="El cliente se ha modificado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoMod") 
                        { nombre_variable="El cliente no se ha modificado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="El") 
                        { nombre_variable="El cliente se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoEl") 
                        { nombre_variable="El cliente no se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Existe") 
                        { nombre_variable="El cliente ya existe.";
                        }
                else if((String)session.getAttribute("MSG")=="Error") 
                        { nombre_variable="No ha se ha podido llevar a cabo la tarea.";
                        }
           }
            if (session.getAttribute("esta")==null)
            {
               estado="false";
            }else{estado="true";}  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.Ventas.Clientes_S"%>

    <div id="page-wrapper">
    <div class="container-fluid">
        
      <form action="Clientes_S" method="POST">
          <table class="table">
               
                <tr>
                    <th>Nombre</th>
                    <td><input class="form-control" type="text" id="Nombre" name="Nombre"></td>
                </tr>
                
                <tr>
                    <th>Apellido</th>
                    <td><input class="form-control" type="text" id="Apellido" name="Apellido"></td>
                </tr>
                
                <tr>
                <th>NIT</th>
                <td><input class="form-control" type="text" id="NIT" name="NIT"></td>
                </tr>
                
                <tr>
                    <th>Genero</th>
                    <td>
                    <select class="form-control" id="Genero" name="Genero">
                        <option>Seleccionar</option>
                        <option>Femenino</option>
                        <option>Masculino</option>
                    </select>
                    </td>
                </tr>
                
                <tr>
                <th>Telefono</th>
                <td><input class="form-control" type="text" id="Telefono" name="Telefono"></td>
                </tr>
                
                <tr>
                <th>Correo Electronico</th>
                <td><input class="form-control" type="text" id="CorreoE" name="CorreoE"></td>
                </tr>
                
                <tr>
                <th>Fecha de Ingreso</th>
                <div class="col-xs-10">
                    <td><input class="form-control" type="date" id="FechaIngreso" name="FechaIngreso"></td>
                </tr>
            </table>
                
                <input class="btn btn-success" type="submit" value="Insertar" name="Insertar" />
                <input class="btn btn-warning" type="submit" value="Modificar" name="Modificar" />
                <input class="btn btn-danger" type="submit" value="Eliminar" name="Eliminar" />
                <label visible="<%= estado %>"> <%= nombre_variable%> </label>
        </form>
        
        <h3>Clientes Actuales</h3>
                <%
        Conexion C;
        C = new Conexion();
        C.abrirConexion();

        String query="";
        query = "SELECT nombres, apellidos,NIT,telefono,correo_electronico FROM clientes where Activo like '1' ";

        ResultSet consulta = C.conexionBd.createStatement().executeQuery(query);

        out.println("<table class='table table-hover'>");
        while (consulta.next()) 
            {
                                    
            String nombres = consulta.getString("nombres");
            String apellidos = consulta.getString("apellidos");
            String NIT = consulta.getString("NIT");
            String telefono = consulta.getString("telefono");
            String correo_electronico = consulta.getString("correo_electronico");
       
            out.println("<tr>");
                            
            out.println("<td>" + nombres + "</td>");
            out.println("<td>" + apellidos + "</td>");
            out.println("<td>" + NIT + "</td>");
            out.println("<td>" + telefono + "</td>");
            out.println("<td>" + correo_electronico + "</td>");
                           
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
