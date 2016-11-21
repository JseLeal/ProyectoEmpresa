/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Ventas;

import Clases.Ventas.Clientes_C;
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
 * @author Usuario
 */
public class Clientes_S extends HttpServlet {

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
            try{
            String idCliente = request.getParameter("idCliente");
            String Nombre=request.getParameter("Nombre");
            String Apellido=request.getParameter("Apellido");
            String NIT=request.getParameter("NIT");
            String Genero=request.getParameter("Genero");
            if ("Femenino".equals(Genero)){
                Genero="1";
            }
            else if("Masculino".equals(Genero)){
            Genero="0";
            }
            
            String Telefono=request.getParameter("Telefono");
            String CorreoE=request.getParameter("CorreoE");
            String FechaIngreso=request.getParameter("FechaIngreso");
            
            
            Clientes_C varclientes=new Clientes_C();
            
            //insertar
            if(request.getParameter("Insertar")!=null && request.getParameter("Modificar")==null && 
               request.getParameter("Eliminar")==null){
                
            try{ 
            varclientes.setNombres(Nombre);
            varclientes.setApellidos(Apellido);
            varclientes.setNIT(Integer.parseInt(NIT));
            varclientes.setGenero(Integer.parseInt(Genero));
            varclientes.setTelefono(Integer.parseInt(Telefono));
            varclientes.setCorreoElectronico(CorreoE);        
            varclientes.setFechaingreso(FechaIngreso);
            varclientes.Insertar();
            
            request.getSession().setAttribute("MSG","Si");
            request.getSession().setAttribute("esta","true");
            response.sendRedirect("Clientes.jsp");                 
               } 
                catch (SQLException ex) {
                request.getSession().setAttribute("MSG","No");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("Clientes.jsp");
                }
            }
            
           //modificar
            else if(request.getParameter("Insertar")==null && request.getParameter("Modificar")!=null && 
                    request.getParameter("Eliminar")==null){
            try {    
            varclientes.setNombres(Nombre);
            varclientes.setApellidos(Apellido);
            varclientes.setIdCliente(varclientes.ConsultaC());
            varclientes.setNIT(Integer.parseInt(NIT));
            varclientes.setGenero(Integer.parseInt(Genero));
            varclientes.setTelefono(Integer.parseInt(Telefono));
            varclientes.setCorreoElectronico(CorreoE);
            varclientes.setFechaingreso(FechaIngreso);
            varclientes.Modificar();
                    request.getSession().setAttribute("MSG","Mod");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Clientes.jsp");
                } 
                catch (SQLException ex) {
                    request.getSession().setAttribute("MSG","NoMod");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Clientes.jsp");
                }
            }
            
          //eliminar
            else if(request.getParameter("Insertar")==null && request.getParameter("Modificar")==null && 
                    request.getParameter("Eliminar")!=null){
                try {
                    if(!"".equals(Nombre)&& !"".equals(Apellido)){
                    varclientes.setNombres(Nombre);
                    varclientes.setApellidos(Apellido);
                    varclientes.setIdCliente(varclientes.ConsultaC());
                    varclientes.Eliminar();
                    request.getSession().setAttribute("MSG","El");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Clientes.jsp");
                    }
                    else{
                    request.getSession().setAttribute("MSG","Error");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Clientes.jsp");
                    }
                } 
                catch (SQLException ex) {
                    request.getSession().setAttribute("MSG","NoEl");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Clientes.jsp");
                }
            }
        }
        catch(Exception e){
            request.getSession().setAttribute("MSG","Error");
            request.getSession().setAttribute("esta","true");
            response.sendRedirect("Clientes.jsp");
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
            Logger.getLogger(Clientes_S.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Clientes_S.class.getName()).log(Level.SEVERE, null, ex);
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
