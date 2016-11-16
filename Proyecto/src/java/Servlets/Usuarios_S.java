/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Usuarios_C;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
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
public class Usuarios_S extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            String nombre=(String) request.getParameter("Usuario");
            String Correo=(String) request.getParameter("Correo");
            String Contrasena=(String) request.getParameter("Contrasena");
            
            Usuarios_C US=new Usuarios_C();
            
            if(request.getParameter("Ingresar")!=null){
            try{
                if(nombre!=null && Contrasena!=null && Correo!=null)
                {
                US.setNombre(nombre);
                US.setCorreo(Correo);
                US.setContrasena(US.sha1(Contrasena));
                US.ingresar();
                   request.getSession().setAttribute("MSG","Si");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Usuarios.jsp");  
                }
                else{request.getSession().setAttribute("MSG","No");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Usuarios.jsp");  }
            }
            catch(NoSuchAlgorithmException | IOException ex){request.getSession().setAttribute("MSG","No");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Usuarios.jsp");  }
            }
            else if(request.getParameter("Modificar")!=null){
                try{
                US.setCorreo(Correo);
                US.Modificar();
                request.getSession().setAttribute("MSG","Mod");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Usuarios.jsp");  
                }catch(Exception ex){request.getSession().setAttribute("MSG","NoMod");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Usuarios.jsp");  }
            }
            else if(request.getParameter("Eliminar")!=null){
                try{
                US.setNombre(nombre);
                US.Eliminar();
                request.getSession().setAttribute("MSG","El");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Usuarios.jsp");  
                }catch(SQLException | IOException e){request.getSession().setAttribute("MSG","NoEL");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Usuarios.jsp");  }
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
            Logger.getLogger(Usuarios_S.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Usuarios_S.class.getName()).log(Level.SEVERE, null, ex);
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
