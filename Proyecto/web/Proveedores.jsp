<%-- 
    Document   : Proveedores
    Created on : Oct 25, 2016, 11:18:43 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.Compras.ProveedorS"%>

<div id="page-wrapper">
    <div class="container-fluid">
        <form action="ProveedorS" method="post">
            
            <table class="table">
                 
            <tr>
                <th>Id Proveedor</th>
                <td><input class="form-control" type="text" name="idProveedor"></td>
                <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td>
            </tr>
                
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
        </form>
    </div>
</div>

