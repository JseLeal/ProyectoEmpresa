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
             <table>
                <tr>
                <th>Id Proveedor</th>
                <td><input type="text" name="idProveedor"></td>
                </tr>
                <tr>
                <th>Proveedor</th>
                <td><input type="text" name="Proveedor"></td>
                </tr>
                <tr>
                <th>NIT</th>
                <td><input type="text" name="NIT"></td>
                </tr>
                <tr>
                <th>Direccion</th>
                <td><input type="text" name="Direccion"></td>
                </tr>
                <tr>
                <th>Telefono</th>
                <td><input type="text" name="Telefono"></td>
                </tr>
            </table>
            
                <input type="submit" value="Insertar" name="Insertar" />
                <input type="submit" value="Modificar" name="Modificar" />
                <input type="submit" value="Eliminar" name="Eliminar" />
        </form>
    </div>
</div>

