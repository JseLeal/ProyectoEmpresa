/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Compras;

import Clases.Compras.FacturaCompra_C;
import java.io.IOException;
import java.io.PrintWriter;
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
        int datoC=0;
            int datoE=0;
            String idVenta=request.getParameter("idVenta");
            String nofactura=request.getParameter("nofactura");
            String fechafactura=request.getParameter("fechafactura");
            String idProveedor=request.getParameter("idProveedor");
            String fecha_ingreso=request.getParameter("fecha_ingreso");
            String idProducto=request.getParameter("idProducto");
            String cantidad=request.getParameter("cantidad");
            String precio_unitario=request.getParameter("precio_unitario");
            datoC=idProveedor.indexOf(")");
            
            FacturaCompra_C maestroventas= new FacturaCompra_C();
            
            //insertar
            if(request.getParameter("Insertar")!=null && 
               request.getParameter("Eliminar")==null){
            try{    
            maestroventas.setNofactura(Integer.parseInt(nofactura));
            maestroventas.setFechafactura(fechafactura);
            maestroventas.setIdProveedor((Integer.parseInt(idProveedor.substring(0, datoC))));
            maestroventas.setFecha_ingreso(fecha_ingreso);
            maestroventas.setIdProducto(Integer.parseInt(idProducto));
            maestroventas.setCantidad(cantidad);
            maestroventas.setPrecio_unitario(Integer.parseInt(precio_unitario));
            
            maestroventas.Insertar();
            maestroventas.modificarExistencia();
            request.getSession().setAttribute("MSG","Si");
            request.getSession().setAttribute("esta","true");
            response.sendRedirect("MaestroDetalleV.jsp"); 
            
            }
            catch(Exception e){
                String ex=e.getMessage()+e.toString();
                request.getSession().setAttribute("MSG","No");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("MaestroDetalleV.jsp");
                
                }
            }
            
          //eliminar
            else if(request.getParameter("Insertar")==null && 
                    request.getParameter("Eliminar")!=null){
                
          try {
               
                request.getSession().setAttribute("MSG","El");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("MaestroDetalleV.jsp"); 

               } 
                catch (Exception e) {
                }
          }
            
        }catch(Exception e){ response.sendRedirect("MaestroDetalleV.jsp"); }
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
