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
public class Cliente_S extends HttpServlet {

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
            
               
            String idCliente = request.getParameter("idCliente");
            String Nombre=request.getParameter("Nombre");
            String Apellido=request.getParameter("Apellido");
            String NIT=request.getParameter("NIT");
            String Genero=request.getParameter("Genero");
            String Telefono=request.getParameter("Telefono");
            String CorreoE=request.getParameter("CorreoE");
            String FechaIngreso=request.getParameter("FechaIngreso");
            
            
            Clientes_C varclientes=new Clientes_C();
            
            //insertar
            if(request.getParameter("Insertar")!=null && request.getParameter("Modificar")==null && 
               request.getParameter("Eliminar")==null){
                
                try{ 
            varclientes.setNombre(Nombre);
            varclientes.setApellidos(Apellido);
            varclientes.setNIT(Integer.parseInt(NIT));
            varclientes.setGenero(Integer.parseInt(Genero));
            varclientes.setTelefono(Integer.parseInt(Telefono));
            varclientes.setCorreoElectronico(CorreoE);        
            varclientes.setFechaingreso(FechaIngreso);
            varclientes.Insertar();
                             
                } 
                catch (SQLException ex) {
                    trhow(ex);
                    Logger.getLogger(Cliente_S.class.getName()).log(Level.SEVERE, null, ex);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>HUBO UN ERROR</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cliente at " + request.getContextPath() + "NO PUDE HACERLO PERDONAME</h1>");
            out.println("</body>");
            out.println("</html>");
                }
            }
            
           //modificar
            else if(request.getParameter("Insertar")==null && request.getParameter("Modificar")!=null && 
                    request.getParameter("Eliminar")==null){
                
            varclientes.setIdCliente(Integer.parseInt(idCliente));
            varclientes.setNombre(Nombre);
            varclientes.setApellidos(Apellido);
            varclientes.setNIT(Integer.parseInt(NIT));
            varclientes.setGenero(Integer.parseInt(Genero));
            varclientes.setTelefono(Integer.parseInt(Telefono));
            varclientes.setCorreoElectronico(CorreoE);
            varclientes.setFechaingreso(FechaIngreso);
           
                try {
                    varclientes.Modificar();
                } 
                catch (SQLException ex) {
                    trhow(ex);
                    Logger.getLogger(Cliente_S.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
          //eliminar
            else if(request.getParameter("Insertar")==null && request.getParameter("Modificar")==null && 
                    request.getParameter("Eliminar")!=null){
                
                varclientes.setIdCliente(Integer.parseInt(idCliente));
                
                try {
                    varclientes.Eliminar();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(Cliente_S.class.getName()).log(Level.SEVERE, null, ex);
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

    private void trhow(SQLException ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
