/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Producto_C;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose
 */
public class Producto_S extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         
            
            String Producto = request.getParameter("producto");
            String idMarca = request.getParameter("idMarca");
            String Descripcion = request.getParameter("Descripcion");
            String Imagen = request.getParameter("Imagen");
            String Precio_costo = request.getParameter("precio_costo");
            String Precio_venta = request.getParameter("precio_venta");
            String existencia = request.getParameter("existencia");
            String fecha_ingreso = request.getParameter("fecha_ingreso");
            int posc=idMarca.indexOf(')');
            
            Producto_C productonuevo = new Producto_C();
            
            if(request.getParameter("Buscar")!=null){
                 if(!"".equals(Producto))
                {
                productonuevo.setProducto(Producto);
                productonuevo.buscar();
                response.sendRedirect("Productos.jsp");   
                
                request.getSession().setAttribute("producto", productonuevo.getProducto());
                request.getSession().setAttribute("idMarca", productonuevo.getIdMarca());
                request.getSession().setAttribute("Descripcion", productonuevo.getDescripcion());
                request.getSession().setAttribute("Imagen", productonuevo.getImagen());
                request.getSession().setAttribute("precio_costo", productonuevo.getPrecio_costo());
                request.getSession().setAttribute("precio_venta", productonuevo.getPrecio_venta());
                request.getSession().setAttribute("existencia", productonuevo.getExistencia());
                }
                 else{ response.sendRedirect("Productos.jsp");}
            }
            
            
            //Ingresar
            if (request.getParameter("Ingresar")!=null){
                
                try {    
                if(productonuevo.Verificar()==null){
                    
                productonuevo.setProducto(Producto);
                productonuevo.setIdMarca(posc);
                productonuevo.setDescripcion(Descripcion);
                productonuevo.setImagen(Imagen);
                productonuevo.setPrecio_costo(Double.parseDouble(Precio_costo));
                productonuevo.setPrecio_venta(Double.parseDouble(Precio_venta));
                productonuevo.setExistencia(Integer.parseInt(existencia));
                productonuevo.setFecha_ingreso(fecha_ingreso);
              
                    productonuevo.ingresar();
                    request.getSession().setAttribute("MSG","Si");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Productos.jsp");  
                  }
                  else { productonuevo.setProducto(Producto);
                productonuevo.setIdMarca(posc);
                productonuevo.setDescripcion(Descripcion);
                productonuevo.setImagen(Imagen);
                productonuevo.setPrecio_costo(Double.parseDouble(Precio_costo));
                productonuevo.setPrecio_venta(Double.parseDouble(Precio_venta));
                productonuevo.setExistencia(Integer.parseInt(existencia));          
                productonuevo.setFecha_ingreso(fecha_ingreso);
                productonuevo.Modificar2();
                        request.getSession().setAttribute("MSG","Si");
                     request.getSession().setAttribute("esta","true");
                     response.sendRedirect("Productos.jsp");}
               
                } catch (Exception ex) {
                     request.getSession().setAttribute("MSG","No");
                     request.getSession().setAttribute("esta","true");
                     response.sendRedirect("Productos.jsp");   
                    Logger.getLogger(Producto_S.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else if (request.getParameter("Modificar")!=null) {
                
                try{
                if(!"".equals(Producto))
                {
                productonuevo.setProducto(Producto);
                productonuevo.setIdMarca(posc);
                productonuevo.setDescripcion(Descripcion);
                productonuevo.setImagen(Imagen);
                productonuevo.setPrecio_costo(Double.parseDouble(Precio_costo));
                productonuevo.setPrecio_venta(Double.parseDouble(Precio_venta));
                productonuevo.setExistencia(Integer.parseInt(existencia));          
                productonuevo.setFecha_ingreso(fecha_ingreso);
                productonuevo.Modificar();
                request.getSession().setAttribute("MSG","Mod");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("Productos.jsp");   
                }
                else{request.getSession().setAttribute("MSG","NoMod");request.getSession().setAttribute("esta","true");
                response.sendRedirect("Productos.jsp");  }
                }
                catch(NumberFormatException | IOException ex){
                    request.getSession().setAttribute("MSG","NoMod");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Productos.jsp");}
            }
            else if(request.getParameter("Eliminar")!=null){                
                try{
                
                    if(!"".equals(Producto))
                    {
                    productonuevo.setProducto(Producto);
                productonuevo.Eliminar();
                request.getSession().setAttribute("MSG","El");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("Productos.jsp");
                    }else { request.getSession().setAttribute("MSG","NoEl");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Productos.jsp");}
               }catch(NumberFormatException ex){
                    request.getSession().setAttribute("MSG","NoEl");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Productos.jsp");}
           }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Producto_S.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(Producto_S.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
