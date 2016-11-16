<%-- 
    Document   : MaestroDetalleV
    Created on : Nov 7, 2016, 1:10:34 AM
    Author     : Usuario
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Ventas.MaestroDetalleV_C"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.Ventas.MaestroDetalleV_S"%>

<div id="page-wrapper">
    <div class="container-fluid">
        
        <form action="MaestroDetalleV_S" method="POST">
            <table class="table">
                <tr>
                <th>Id Venta</th>
                <td><input class="form-control" type="text" name="idVenta"></td>
                <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td>
                </tr>
                
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
                <th>CCCClientes</th>
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
                    <th>EEEEmpleado</th>
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
                <th>Id Venta Detalle</th>
                <td><input class="form-control" type="text" name="idventa_detalle"></td>
                </tr>
                
                <tr>
                <th>Id Producto</th>
                <td><input class="form-control" type="text" name="idProducto"></td>
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
        </form>
    </div>
</div>