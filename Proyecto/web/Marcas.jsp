<%-- 
    Document   : Marcas
    Created on : 06-nov-2016, 13:47:17
    Author     : Jose
--%>

<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.html"></jsp:include>
<%@page import="Servlets.Marcas_S"%>
<%@page pageEncoding="UTF-8"%>

 <div id="page-wrapper">
    <div class="container-fluid">
        <form action="Marcas_S" method="POST">  
         <table class="table">
             <tr>
                 <th>Producto</th>
                 <td><input class="form-control" type="text" name="producto" id="producto"/></td>
             </tr>
         </table> 
            <input class="btn btn-success" type="submit" name="Ingresar" value="Ingresar"/>
            <input class="btn btn-warning" type="submit" name="Modificar" value="Modificar"/>
            <input class="btn btn-danger" type="submit" name="Eliminar" value="Eliminar"/>
        </form>
</div>
 </div>

