<%-- 
    Document   : MaestroDetalleV
    Created on : Nov 7, 2016, 1:10:34 AM
    Author     : Usuario
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Ventas.MaestroDetalleV_C"%>

<%
            String nombre_variable="";
            String estado="false";
            if(session.getAttribute("MSG")!=null)
            {
                if((String)session.getAttribute("MSG")=="Si")
                {
                nombre_variable="La factura venta se ha ingresado correctamente.";
                } else if((String)session.getAttribute("MSG")=="No") 
                        { nombre_variable="La factura venta no se ha ingresado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="El") 
                        { nombre_variable="No es posible eliminar las facturas.";
                        }
                else if((String)session.getAttribute("MSG")=="NoEl") 
                        { nombre_variable="La factura venta no se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Existe") 
                        { nombre_variable="La factura venta ya existe.";
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
<%@page import="Servlets.Ventas.MaestroDetalleV_S"%>

<div id="page-wrapper">
    <div class="container-fluid">
        
        <form action="MaestroDetalleV_S" method="POST">
            <table class="table">
                
                <tr>
                <th>No. Factura</th>
                <td><input class="form-control" type="text" name="nofactura"></td>
                </tr>
                
                <tr>
                <th>Serie</th>
                <td><input class="form-control" type="text" name="serie"></td>
                </tr>
                
                <tr>
                    <th>Fecha Factura</th>
                    <td><input class="form-control" type="Date" name="fechafactura"></td>
                </tr>
                
                <tr>
                <th>Clientes</th>
                <td><select class="form-control" type="text" name="idCliente">
                        <%  MaestroDetalleV_C c=new MaestroDetalleV_C();
                                ArrayList <String> List= c.mostrarCliente();
                                for (String dat:List)
                                  { %>
                                <option value="<%=dat%>"><%=dat%></option>
                               <% } %>
                  </select></td>
                </tr>
                
                <tr>
                    <th>Empleado</th>
                    <td><select class="form-control" type="text" name="idEmpleado">
                             <%  MaestroDetalleV_C e=new MaestroDetalleV_C();
                                ArrayList <String> Lista= e.mostrarEmpleados();
                                for (String dat:Lista)
                                  { %>
                                <option value="<%=dat%>"><%=dat%></option>
                               <% } %>
                  </select></td>
                </tr>
                
                <tr>
                <th>Fecha Ingreso</th>
                    <td><input class="form-control" type="Date" name="fecha_ingreso"></td>
                </tr>
                
                <tr>
                <th>Id Producto</th>
                <td><select class="form-control" type="text" name="idProducto">
                <%  MaestroDetalleV_C p=new MaestroDetalleV_C();
                                ArrayList <String> L= p.mostrarProductos();
                                for (String dat:L)
                                  { %>
                                <option value="<%=dat%>"><%=dat%></option>
                               <% } %>        
                <select></td>
                </tr>
                
                <tr>
                <th>Cantidad</th>
                <td><input class="form-control" type="text" name="cantidad"></td>
                </tr>
                
                <tr>
                <th>Precio Unitario</th>
                <td><input class="form-control" type="text" name="precio_unitario"></td>
                </tr>
                
            </table>
            
                <input class="btn btn-success" type="submit" value="Insertar" name="Insertar" />
                <input class="btn btn-danger" type="submit" value="Eliminar" name="Eliminar" />
                <label visible="<%= estado %>"> <%= nombre_variable%> </label>
        </form>
    </div>
</div>
        
        <% request.getSession().setAttribute("MSG",null);
            request.getSession().setAttribute("esta","false");
        %>
