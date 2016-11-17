/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Compras;

import Clases.Compras.ProveedorC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class Proveedores_S extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProveedoresS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProveedoresS at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            String idProveedor = request.getParameter("idProveedor");
            String Proveedor=request.getParameter("Proveedor");
            String NIT=request.getParameter("NIT");
            String Direccion=request.getParameter("Direccion");
            String Telefono=request.getParameter("Telefono");
            
            
            ProveedorC varproveedores=new ProveedorC();
            
           //insertar
            if(request.getParameter("Insertar")!=null && request.getParameter("Modificar")==null && 
               request.getParameter("Eliminar")==null){
             try{     
            varproveedores.setProveedor(Proveedor);
            varproveedores.setNIT(Integer.parseInt(NIT));
            varproveedores.setDireccion(Direccion);
            varproveedores.setTelefono(Integer.parseInt(Telefono)); 
            varproveedores.Insertar();
            request.getSession().setAttribute("MSG","Si");
            request.getSession().setAttribute("esta","true");
            response.sendRedirect("Proveedores.jsp");
            }
            catch (SQLException e) {
                request.getSession().setAttribute("MSG","No");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("Proveedores.jsp");
                }
            }
            
           //modificar
            else if(request.getParameter("Insertar")==null && request.getParameter("Modificar")!=null && 
                    request.getParameter("Eliminar")==null){
            try{
            varproveedores.setProveedor(Proveedor);
            varproveedores.setIdProveedor(varproveedores.ConsultaP());
            varproveedores.setNIT(Integer.parseInt(NIT));
            varproveedores.setDireccion(Direccion);
            varproveedores.setTelefono(Integer.parseInt(Telefono));
            varproveedores.Modificar();
            
            request.getSession().setAttribute("MSG","Mod");
            request.getSession().setAttribute("esta","true");
            response.sendRedirect("Proveedores.jsp");
            }
            catch (SQLException e){
                request.getSession().setAttribute("MSG","NoMod");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("Proveedores.jsp");
            
            }
        }
            
          //eliminar
            else if(request.getParameter("Insertar")==null && request.getParameter("Modificar")==null && 
                    request.getParameter("Eliminar")!=null){
               try {
                varproveedores.setProveedor(Proveedor);
                varproveedores.setIdProveedor(varproveedores.ConsultaP());
                varproveedores.Eliminar();
                request.getSession().setAttribute("MSG","El");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("Proveedores.jsp");
               } 
                catch (SQLException e) {
                  request.getSession().setAttribute("MSG","NoEl");
                  request.getSession().setAttribute("esta","true");
                  response.sendRedirect("Proveedores.jsp");
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
