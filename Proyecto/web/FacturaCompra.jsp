<%-- 
    Document   : FacturaCompra
    Created on : 12-nov-2016, 20:38:32
    Author     : Jose
--%>

<%@page import="Clases.Compras.FacturaCompra_C"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Ventas.MaestroDetalleV_C"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.Compras.FacturaCompra_S"%>

<div id="page-wrapper">
    <div class="container-fluid">
        
        <form action="FacturaCompra_S" method="POST">
            <table class="table">
                <tr>
                <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td>
                </tr>
                
                <tr>
                <th>No. Orden Compra</th>
                <td><input class="form-control" type="text" name="nofactura"></td>
                </tr>
                   
                <tr>
                    <th>Fecha Factura</th>
                    <td><input class="form-control" type="Date" name="fechafactura"></td>
                </tr>
                
                <tr>
                <th>Proveedor</th>
                <td><select class="form-control" type="text" name="idProveedor">
                        <%  FacturaCompra_C c=new FacturaCompra_C();
                                ArrayList <String> List= c.mostrarProveedor();
                                for (String dat:List)
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