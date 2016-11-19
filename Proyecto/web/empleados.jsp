<%-- 
    Document   : empleados
    Created on : 16-nov-2016, 18:19:35
    Author     : Jose
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Organizacion.empleados"%>
<%
 String nombre_variable="";
            String estado="false";
            if(session.getAttribute("MSG")!=null)
            {
                if((String)session.getAttribute("MSG")=="Si")
                {
                nombre_variable="El empleado se ha ingresado correctamente.";
                } else if((String)session.getAttribute("MSG")=="No") 
                        { nombre_variable="El empleado no se ha ingresado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Mod") 
                        { nombre_variable="El empleado se ha modificado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoMod") 
                        { nombre_variable="El empleado no se ha modificado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="El") 
                        { nombre_variable="El empleado se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoEl") 
                        { nombre_variable="El empleado no se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Existe") 
                        { nombre_variable="El empleado ya existe.";
                        }
           }
            if (session.getAttribute("esta")==null)
            {
               estado="false";
            }else{estado="true";}  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.Organizacion.EmpleadosS"%>

    <div id="page-wrapper">
    <div class="container-fluid">
        
      <form action="EmpleadosS" method="POST">
          <table class="table">
               
                <tr>
                    <th>Nombre</th>
                    <td><input class="form-control" type="text" id="Nombres" name="Nombres"></td>
                </tr>
                
                <tr>
                    <th>Apellido</th>
                    <td><input class="form-control" type="text" id="Apellidos" name="Apellidos"></td>
                </tr>
                
                <tr>
                <th>Direccion</th>
                <td><input class="form-control" type="text" id="Direccion" name="Direccion"></td>
                </tr>
                
                <tr>
                <th>Telefono</th>
                <td><input class="form-control" type="text" id="Telefono" name="Telefono"></td>
                </tr>
                
                <tr>
                <th>DPI</th>
                <td><input class="form-control" type="text" id="DPI" name="DPI"></td>
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
                <th>Fecha de Nacimiento</th>
                <div class="col-xs-10">
                    <td><input class="form-control" type="date" id="Fecha_nacimiento" name="Fecha_nacimiento"></td>
                </tr>
                
                <tr> 
                    <th>Puestos</th>
                <td><select class="form-control" type="text" name="idPuesto">
                <%  empleados e=new empleados();
                                ArrayList <String> L= e.mostrarPuestos();
                                for (String dat:L)
                                  { %>
                                <option value="<%=dat%>"><%=dat%></option>
                               <% } %>        
                <select></td>
                </tr>
                
                <tr>
                <th>Fecha Inicio de Labores</th>
                <div class="col-xs-10">
                    <td><input class="form-control" type="date" id="Fecha_inicio_labores" name="Fecha_inicio_labores"></td>
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
    </div>
 </div>
<%    request.getSession().setAttribute("MSG",null);
      request.getSession().setAttribute("esta","false");
%>
