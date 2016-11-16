/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Ventas;

import Clases.Ventas.MaestroDetalleV_C;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class MaestroDetalleV_S extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MaestroDetalleV_S</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MaestroDetalleV_S at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            int datoC=0;
            int datoE=0;
            String idVenta=request.getParameter("idVenta");
            String nofactura=request.getParameter("nofactura");
            String serie=request.getParameter("serie");
            String fechafactura=request.getParameter("fechafactura");
            String idCliente=request.getParameter("idCliente");
            String idEmpleado=request.getParameter("idEmpleado");
            String fecha_ingreso=request.getParameter("fecha_ingreso");
            String idventa_detalle=request.getParameter("idventa_detalle");
            String idProducto=request.getParameter("idProducto");
            String cantidad=request.getParameter("cantidad");
            String precio_unitario=request.getParameter("precio_unitario");
            datoC=idCliente.indexOf(")");
            datoE=idEmpleado.indexOf(")");
            
            MaestroDetalleV_C maestroventas= new MaestroDetalleV_C();
            
            //insertar
            if(request.getParameter("Insertar")!=null && 
               request.getParameter("Eliminar")==null){
            try{    
            maestroventas.setNofactura(Integer.parseInt(nofactura));
            maestroventas.setSerie((serie));
            maestroventas.setFechafactura(fechafactura);
            maestroventas.setIdCliente((Integer.parseInt(idCliente.substring(0, datoC))));
            maestroventas.setIdEmpleado(Integer.parseInt(idEmpleado.substring(0, datoE)));
            maestroventas.setFecha_ingreso(fecha_ingreso);
            maestroventas.setIdProducto(Integer.parseInt(idProducto));
            maestroventas.setCantidad(cantidad);
            maestroventas.setPrecio_unitario(Integer.parseInt(precio_unitario));
            
            maestroventas.Insertar();
            }
            catch(Exception e){
                String ex=e.getMessage()+e.toString();
                }
            }
            
          //eliminar
            else if(request.getParameter("Insertar")==null && 
                    request.getParameter("Eliminar")!=null){
                
          maestroventas.setIdVenta(Integer.parseInt(idVenta));
          try {
                maestroventas.Eliminar();

               } 
                catch (Exception e) {
                }
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
        } catch (Exception ex) {
            Logger.getLogger(MaestroDetalleV_S.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(MaestroDetalleV_S.class.getName()).log(Level.SEVERE, null, ex);
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
