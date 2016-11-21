<%-- 
    Document   : CContra
    Created on : 16-nov-2016, 13:48:33
    Author     : Jose
--%>
<%String nombre_variable="";
            String estado="false";
            if(session.getAttribute("MSG")!=null)
            {
               
               if((String)session.getAttribute("MSG")=="Mod") 
                        { nombre_variable="La contraseña se ha modificado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoMod") 
                        { nombre_variable="La contraseña no se ha modificado correctamente.";
                        }
               else if((String)session.getAttribute("MSG")=="NoCoin") 
                        { nombre_variable="La contraseña Actual es incorrecta.";
                        }
               else if((String)session.getAttribute("MSG")=="Error") 
                        { nombre_variable="No se ha podido llevar a cabo la tarea.";
                        }
           }
            if (session.getAttribute("esta")==null)
            {
               estado="false";
            }else{estado="true";}  %>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.CContra_S"%>
<%@page pageEncoding="UTF-8"%>

 <div id="page-wrapper">
    <div class="container-fluid">
        <form action="CContra_S" method="POST">  
         <table class="table">
             <tr>
                 <th>Contraseña Actual:</th>
                 <td><input class="form-control" type="password" name="ContrasenaA" id="ContrasenaA"/></td>
             </tr>
             <tr>
                 <th>Contraseña:</th>
                 <td><input class="form-control" type="password" name="Contrasena" id="Contrasena"/></td>
             </tr>
             
             
         </table> 
            <input class="btn btn-info" type="submit" name="Cambiar" value="Cambiar Contraseña"/>
            <label visible="<%= estado %>"> <%= nombre_variable%> </label>
        </form>
</div>
 </div>
        
            <% request.getSession().setAttribute("MSG",null);
            request.getSession().setAttribute("esta","false");%>
