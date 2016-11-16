<%-- 
    Document   : Usuarios
    Created on : 16-nov-2016, 1:39:57
    Author     : Jose
--%>
<%String nombre_variable="";
            String estado="false";
            if(session.getAttribute("MSG")!=null)
            {
                if((String)session.getAttribute("MSG")=="Si")
                {
                nombre_variable="El usuario se ha ingresado correctamente.";
                } else if((String)session.getAttribute("MSG")=="No") 
                        { nombre_variable="El usuario no se ha ingresado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="El") 
                        { nombre_variable="El usuario se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoEl") 
                        { nombre_variable="El usuario no se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Existe") 
                        { nombre_variable="El usuario de la marca ya existe.";
                        }
                else if((String)session.getAttribute("MSG")=="Mod") 
                        { nombre_variable="El usuario se ha modificado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoMod") 
                        { nombre_variable="El usuario no se ha modificado correctamente.";
                        }
           }
            if (session.getAttribute("esta")==null)
            {
               estado="false";
            }else{estado="true";}  %>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.Usuarios_S"%>
<%@page pageEncoding="UTF-8"%>

 <div id="page-wrapper">
    <div class="container-fluid">
        <form action="Usuarios_S" method="POST">  
         <table class="table">
             <tr>
                 <th>Usuario:</th>
                 <td><input class="form-control" type="text" name="Usuario" id="Usuario"/></td>
             </tr>
             <tr>
                 <th>Correo Electronico:</th>
                 <td><input class="form-control" type="mail" name="Correo" id="Correo"/></td>
             </tr>
             <tr>
                 <th>Contraseña:</th>
                 <td><input class="form-control" type="password" name="Contrasena" id="Contrasena"/></td>
             </tr>
             
             
         </table> 
            <input class="btn btn-success" type="submit" name="Ingresar" value="Ingresar"/>
            <input class="btn btn-warning" type="submit" name="Modificar" value="Modificar"/>
            <input class="btn btn-danger" type="submit" name="Eliminar" value="Eliminar"/>
            <label visible="<%= estado %>"> <%= nombre_variable%> </label>
        </form>
</div>
 </div>
        
            <% request.getSession().setAttribute("MSG",null);
            request.getSession().setAttribute("esta","false");%>
