<%-- 
    Document   : Productos
    Created on : 02-nov-2016, 18:36:36
    Author     : Jose
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Producto_C"%>
<%
    if(request.getSession().getAttribute("producto")==null || request.getSession().getAttribute("producto")=="")
    {
    request.getSession().setAttribute("producto", "");
    }
    if(request.getSession().getAttribute("existencia")==null || request.getSession().getAttribute("existencia")=="0")
    {
    request.getSession().setAttribute("existencia", "");
    }
     if(request.getSession().getAttribute("Descripcion")== null || request.getSession().getAttribute("Descripion")=="")
    {
    request.getSession().setAttribute("Descripion", "-");
    }
      if(request.getSession().getAttribute("precio_costo")==null || request.getSession().getAttribute("precio_costo")=="0")
    {
    request.getSession().setAttribute("precio_costo", "");
    }
       if(request.getSession().getAttribute("precio_venta")==null || request.getSession().getAttribute("precio_venta")=="0")
    {
    request.getSession().setAttribute("precio_venta", "");
    }
        if(request.getSession().getAttribute("Imagen")==null || request.getSession().getAttribute("Imagen")=="0")
    {
    request.getSession().setAttribute("Imagen", "");
    }
            String nombre_variable="";
            String estado="false";
            if(session.getAttribute("MSG")!=null)
            {
                if((String)session.getAttribute("MSG")=="Si")
                {
                nombre_variable="El producto se ha ingresado correctamente.";
                } else if((String)session.getAttribute("MSG")=="No") 
                        { nombre_variable="El producto no se ha ingresado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Mod") 
                        { nombre_variable="El producto se ha modificado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoMod") 
                        { nombre_variable="El producto no se ha modificado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="El") 
                        { nombre_variable="El producto se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="NoEl") 
                        { nombre_variable="El producto no se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Existe") 
                        { nombre_variable="El nombre del producto ya existe.";
                        }
           }
            if (session.getAttribute("esta")==null)
            {
               estado="false";
            }else{estado="true";}  %>
<link href="Estilo/css/sb-admin.css" rel="stylesheet">
<jsp:include page="master.jsp"></jsp:include>
<%@page import="Servlets.Producto_S"%>
<%@page pageEncoding="UTF-8"%>
 <div id="page-wrapper">
    <div class="container-fluid">
        <form action="Producto_S" method="POST" class="form-group">   
         <table class="table" >
             <tr>
                 <th>Producto</th>
                 <td><input class="form-control" type="text" name="producto" id="producto" value='<%=request.getSession().getAttribute("producto")%>'/></td>
                 <td><input class="btn btn-info" type="submit" name="Buscar"  value="Buscar"/></td>
             </tr>
       
             <tr>
                 <th>Marca</th>
                 <td><select class="form-control" type="text" name="idMarca" id="idMarca">
                            <% Producto_C es=new Producto_C();
                               ArrayList<String> List=es.llenarMarca();
                               for (String dat:List)
                                 { %>
                               <option value="<%=dat%>"><%=dat%></option>
                              <% } %>
                 </select></td>
             </tr>
             <tr>
                 <th>Descripcion</th>
                 <td><input class="form-control" type="text" name="Descripcion" id="Descripcion" value='<%=request.getSession().getAttribute("Descripcion")%>'/></td>
             </tr>
             <tr>
                 <th>Imagen</th>
                 <td><input class="form-control" type="text" name="Imagen" id="Imagen" value='<%=request.getSession().getAttribute("Imagen")%>'/></td>
             </tr>
             <tr>
                 <th>Precio Costo</th>
                 <td><input class="form-control" type="text" name="precio_costo" id="precio_costo" value='<%=request.getSession().getAttribute("precio_costo")%>'/></td>
             </tr>
             <tr>
                 <th>Precio Venta</th>
                 <td><input class="form-control" type="text" name="precio_venta" id="precio_venta" value='<%=request.getSession().getAttribute("precio_venta")%>'/></td>
             </tr>
             <tr>
                 <th>Existencia</th>
                 <td><input class="form-control" type="text" name="existencia" id="existencia" value='<%=request.getSession().getAttribute("existencia")%>'/></td>
             </tr>
             <tr>
                 <th>Fecha Ingreso</th>
                 <td><input type="date" name="fecha_ingreso" id="fecha_ingreso" /></td>
             </tr>
         </table> 
            
            <input class="btn btn-success" type="submit" name="Ingresar" value="Ingresar"/>
            <input class="btn btn-warning" type="submit" name="Modificar" value="Modificar"/>
            <input class="btn btn-danger" type="submit" name="Eliminar" value="Eliminar"/>
            <br>
            <a href="Marcas.jsp" style="font-size:13px;">IR A MARCAS</a>
           
            <label visible="<%= estado %>"> <%= nombre_variable%> </label>
            
        </form>
    </div>
 </div>
            <% request.getSession().setAttribute("MSG",null);
            request.getSession().setAttribute("esta","false");
            request.getSession().setAttribute("existencia", "0");
            request.getSession().setAttribute("Descripcion", "");
            request.getSession().setAttribute("precio_costo", "0");
            request.getSession().setAttribute("precio_venta", "0");
            request.getSession().setAttribute("Imagen", "");
            request.getSession().setAttribute("producto", "");
            %>
