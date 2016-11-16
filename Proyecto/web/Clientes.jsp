<%-- 
    Document   : Clientes
    Created on : Oct 24, 2016, 5:37:34 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.Ventas.Cliente_S"%>

    <div id="page-wrapper">
    <div class="container-fluid">
        
      <form action="Cliente" method="post">
          <table class="table">
                 <tr>
                    <th>Id Cliente</th>
                 <td><input class="form-control" type="text" id="idCliente" name="idCliente"></td>
                 <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td> <td> </td>
                </tr>
               
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
                    <td><input class="form-control" type="text" id="Genero" name="Genero"></td>
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
        </form>
    </div>
 </div>

