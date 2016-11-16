
<html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Servlets.Login_S"%>
<head>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
 <link href="Estilo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="Estilo/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="Estilo/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="Estilo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <%  String nombre_variable="";
            String estado="false";
            if(session.getAttribute("MSG")!=null)
            {
                if((String)session.getAttribute("MSG")=="Error")
                {
                nombre_variable="Ha ocurrido un error. Intente más tarde";
                } else if((String)session.getAttribute("MSG")=="No") 
                        { nombre_variable="El usuario y/o contraseña son incorrectos.";
                        }             
if (session.getAttribute("esta")==null)
            {
               estado="false";
            }else{estado="true";}
            }
%>
        <div style=" margin: 0 auto; background-color: lightpink; width: 50%; border-radius: 20px;text-align: center; margin-top: 12%;">
       <form action="Login_S" method="POST">
        <table class="table">
            <tr>
                <td>USUARIO:</td>
                <td><input type="text" class="form-control" name="USUARIO" id="USUARIO"></td>
            </tr>
            <tr>
                <td>CONTRASEÑA:</td>
                <td><input type="password" class="form-control" name="Contrasena" id="Contrasena"><td>
            </tr>
        </table>
       <input type="submit" name="Ingresar" id="Ingresar" class="btn btn-info">    
      <label visible="<%= estado %>"> <%= nombre_variable%> </label>
      </form>
      </div>
    
        <script src="Estilo/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="Estilo/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="Estilo/js/plugins/morris/raphael.min.js"></script>
    <script src="Estilo/js/plugins/morris/morris.min.js"></script>
    <script src="Estilo/js/plugins/morris/morris-data.js"></script>

             <% request.getSession().setAttribute("MSG",null);
                request.getSession().setAttribute("esta","false"); %>
            
</body>
</html>
