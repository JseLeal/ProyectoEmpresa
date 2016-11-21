<%-- 
    Document   : FacturaCompra
    Created on : 12-nov-2016, 20:38:32
    Author     : Jose
--%>
<%          ArrayList IdProducto=new ArrayList();
            ArrayList Cantidad= new ArrayList();
            ArrayList Precios=new ArrayList();
            IdProducto=(ArrayList) session.getAttribute("ArrayProducto");
            Cantidad=(ArrayList) session.getAttribute("ArrayCantidad");
            Precios=(ArrayList) session.getAttribute("ArrayPrecios");
            if(IdProducto==null)
            {IdProducto=new ArrayList();}
            if(Cantidad==null)
            {Cantidad=new ArrayList();}
            if(Precios==null)
            {Precios=new ArrayList();}
            
            String nombre_variable="";
            String estado="false";
            if(session.getAttribute("MSG")!=null)
            {
                if((String)session.getAttribute("MSG")=="Si")
                {
                nombre_variable="La factura compra se ha ingresado correctamente.";
                } else if((String)session.getAttribute("MSG")=="No") 
                        { nombre_variable="La factura compra no se ha ingresado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="El") 
                        { nombre_variable="No es posible eliminar las facturas.";
                        }
                else if((String)session.getAttribute("MSG")=="NoEl") 
                        { nombre_variable="La factura compra no se ha eliminado correctamente.";
                        }
                else if((String)session.getAttribute("MSG")=="Existe") 
                        { nombre_variable="La factura compra ya existe.";
                        }
                else if((String)session.getAttribute("MSG")=="Error") 
                        { nombre_variable="No se ha podido llevar a cabo la tarea.";
                        }
           }
            if (session.getAttribute("esta")==null)
            {
               estado="false";
            }else{estado="true";}  
%>
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
            </table>
                <input class="btn btn-success" type="submit" value="Insertar" name="Insertar" />
                <input class="btn btn-danger" type="submit" value="Eliminar" name="Eliminar" />
                 <label visible="<%=estado%>" > <%= nombre_variable%> </label>
        </form>
                
                  
                  <form>
                      <table class="table" style="display: inline-block;">
                       <tr>
                <th>Id Producto</th>
                <td><select class="form-control" type="text" name="idProducto">
                <%  MaestroDetalleV_C p=new MaestroDetalleV_C();
                                ArrayList <String> L= p.mostrarProductos();
                                for (String dat:L)
                                  { %>
                                <option value="<%=dat%>"><%=dat%></option>
                               <% } %>        
                <select></td>
                <td><button type="submit" name="Ag">Agregar</button></td>
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
                <% 
                    try{
                    String probando="";
                    int datoc;
                    if(request.getParameter("Ag")!=null)
                     {
                   probando=request.getParameter("idProducto");
                   
                   datoc = probando.indexOf(")");
                   if(request.getParameter("cantidad")!=null && request.getParameter("precio_unitario")!="")
                   {
                   IdProducto.add(Integer.parseInt(probando.substring(0, datoc)));
                   Cantidad.add(request.getParameter("cantidad"));
                   Precios.add(request.getParameter("precio_unitario"));
                   }
                   else{ IdProducto.add(Integer.parseInt(probando.substring(0, datoc)));
                   Cantidad.add("0");
                   Precios.add("0");}
                   session.setAttribute("ArrayProducto", IdProducto);
                    session.setAttribute("ArrayCantidad", Cantidad);
                     session.setAttribute("ArrayPrecios", Precios);
                     }
                    }
                    catch(Exception ex)
                            {
                            ex.toString();
                            }
                    %> 

               
                  </form>
    </div>
</div>
                 <% request.getSession().setAttribute("MSG",null);
            request.getSession().setAttribute("esta","false");
        %>
