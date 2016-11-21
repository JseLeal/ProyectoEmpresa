/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.CContra_C;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
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
public class CContra_S extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.security.NoSuchAlgorithmException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try{
            CContra_C US=new CContra_C();
             String ContrasenaActual=(String) request.getParameter("ContrasenaA");
            String Contrasena=(String) request.getParameter("Contrasena");
            
            US.setNombre((String)request.getSession().getAttribute("US"));
        
          
          if(request.getParameter("Cambiar")!=null){
                if(US.Verificar().equals(US.sha1(ContrasenaActual)))
            {
            
                try{
    
                US.setContrasena(US.sha1(Contrasena));
                US.Modificar();
                request.getSession().setAttribute("MSG","Mod");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("CContra.jsp");  
                }catch(NoSuchAlgorithmException | IOException ex){request.getSession().setAttribute("MSG","NoMod");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("CContra.jsp");  }

             }
            else{request.getSession().setAttribute("MSG","NoCoin");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("CContra.jsp");}
            
            
            }

            }catch(Exception e){
                    request.getSession().setAttribute("MSG","Error");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("CContra.jsp");
            }
      }catch(Exception e){
                    request.getSession().setAttribute("MSG","Error");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("CContra.jsp");
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CContra_S.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CContra_S.class.getName()).log(Level.SEVERE, null, ex);
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
