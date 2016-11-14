<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PUESTOS</title>
    </head>
    <body>
        <h1 aling="center">PUESTOS</h1>
        <table border="1" width="400"aling="center">
            <tr>
                <th colspan="">mantenimiento puestos /th>
                <th><img src="iconos/agregar.png"widht="30" height="30"></th>        
            </tr>
            <tr bgcolor="blue">
             <tr>idpuestos</tr><tr>puestos</tr><tr>accion</tr>
            </tr>
            <%
            Connection con=null;
            Statement  sta=null;
            ResultSet res=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection
        ("jdbc:mysql://localhost/dbempresa?user=root&password=");
            sta=con.createStatement();
            res=sta.executeQuery("select * from puestos");
            while (res.next())
            { %>
            <tr> 
                <th><%=res.getString(1)%></th>
                <th><%=res.getString(2)%></th>
                <th><img src="iconos/editar.png"widht="20" height="20">||
                    <img src="iconos/eliminar.png"widht="20" height="20">
                </th>
            </tr>
            <%
            }
sta.close();
res.close();
con.close();
            } catch (Exception e){}
            %>
        </table>
    </body>
</html>
