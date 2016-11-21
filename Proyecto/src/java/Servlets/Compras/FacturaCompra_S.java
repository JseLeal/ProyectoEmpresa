/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Compras;

import Clases.Compras.FacturaCompra_C;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose
 */
public class FacturaCompra_S extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try{
            int datoC=0;
            int datoP=0;
            String idVenta=request.getParameter("idVenta");
            String nofactura=request.getParameter("nofactura");
            String fechafactura=request.getParameter("fechafactura");
            String idProveedor=request.getParameter("idProveedor");
            String fecha_ingreso=request.getParameter("fecha_ingreso");
            String idProducto=request.getParameter("idProducto");
            String cantidad=request.getParameter("cantidad");
            String precio_unitario=request.getParameter("precio_unitario");
            datoC=idProveedor.indexOf(")");
            datoP=idProducto.indexOf(")");
            
            FacturaCompra_C maestroventas= new FacturaCompra_C();
            
            //insertar
            if(request.getParameter("Insertar")!=null && 
               request.getParameter("Eliminar")==null){
            try{    
            maestroventas.setNofactura(Integer.parseInt(nofactura));
            maestroventas.setFechafactura(fechafactura);
            maestroventas.setIdProveedor((Integer.parseInt(idProveedor.substring(0, datoC))));
            maestroventas.setFecha_ingreso(fecha_ingreso);
<<<<<<< HEAD
            maestroventas.setIdProducto((Integer.parseInt(idProducto.substring(0, datoP))));
            maestroventas.setCantidad(Integer.parseInt(cantidad));
            maestroventas.setPrecio_unitario(Integer.parseInt(precio_unitario));
=======
            maestroventas.setIdProducto((ArrayList)(request.getSession().getAttribute("ArrayProducto")));
            maestroventas.setCantidad((ArrayList)(request.getSession().getAttribute("ArrayCantidad")));
            maestroventas.setPrecio_unitario((ArrayList)(request.getSession().getAttribute("ArrayPrecios")));
>>>>>>> origin/Union
            
            maestroventas.Insertar();
            maestroventas.modificarExistencia();
            request.getSession().setAttribute("ArrayProducto",null);
             request.getSession().setAttribute("ArrayCantidad",null);
              request.getSession().setAttribute("ArrayPrecios",null);
            request.getSession().setAttribute("MSG","Si");
            request.getSession().setAttribute("esta","true");
            response.sendRedirect("FacturaCompra.jsp"); 
<<<<<<< HEAD
=======
            
>>>>>>> origin/Union
            }
            catch(Exception e){
                String ex=e.getMessage()+e.toString();
                request.getSession().setAttribute("MSG","No");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("FacturaCompra.jsp");
<<<<<<< HEAD
=======
                
>>>>>>> origin/Union
                }
            }
            
          //eliminar
            else if(request.getParameter("Insertar")==null && 
                    request.getParameter("Eliminar")!=null){              
          try {
                maestroventas.setNofactura(Integer.parseInt(nofactura));
                maestroventas.setFechafactura(fechafactura);
                maestroventas.setIdProveedor((Integer.parseInt(idProveedor.substring(0, datoC))));
                maestroventas.setFecha_ingreso(fecha_ingreso);
                maestroventas.setIdProducto((Integer.parseInt(idProducto.substring(0, datoP))));
                maestroventas.setCantidad(Integer.parseInt(cantidad));
                maestroventas.setPrecio_unitario(Integer.parseInt(precio_unitario));
                maestroventas.Eliminar();
                request.getSession().setAttribute("MSG","El");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("FacturaCompra.jsp"); 
<<<<<<< HEAD
=======

>>>>>>> origin/Union
               } 
                catch (Exception e) {
                request.getSession().setAttribute("MSG","NoEl");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("FacturaCompra.jsp");
                }
          }
            
<<<<<<< HEAD
        }catch(Exception e){
            request.getSession().setAttribute("MSG","Error");
            request.getSession().setAttribute("esta","true");
            response.sendRedirect("FacturaCompra.jsp"); }  
      }
=======
        }catch(Exception e){ response.sendRedirect("FacturaCompra.jsp"); }
>>>>>>> origin/Union
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
        processRequest(request, response);
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
        processRequest(request, response);
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
