/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Marcas_C;
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
 * @author Jose
 */
public class Marcas_S extends HttpServlet {

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
            try{
            String Marca=request.getParameter("marca");
            if(!"".equals(Marca))
                    {
                        Marcas_C marc= new Marcas_C();
                        
                        marc.setMarca(Marca);
                        
            if(request.getParameter("Ingresar")!=null){
                {
                    try{
                    if(marc.Verificar()==null){
                        marc.ingresar();
                     request.getSession().setAttribute("MSG","Si");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Marcas.jsp");  
                    }
                    else{marc.Modificar();
                     request.getSession().setAttribute("MSG","Si");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Marcas.jsp");  }
                    }catch(Exception e){request.getSession().setAttribute("MSG","No");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Marcas.jsp");}
                }
            }
            else if(request.getParameter("Eliminar")!=null){
                try{
                    marc.Eliminar();
                    request.getSession().setAttribute("MSG","El");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Marcas.jsp");  
                }catch(Exception e){request.getSession().setAttribute("MSG","NoEl");
                    request.getSession().setAttribute("esta","true");
                    response.sendRedirect("Marcas.jsp"); }
            }
            }
            else{
                request.getSession().setAttribute("MSG","Error");
                request.getSession().setAttribute("esta","true");
                response.sendRedirect("Marcas.jsp");  
            }
        }catch(Exception e){
            request.getSession().setAttribute("MSG","Error");
            request.getSession().setAttribute("esta","true");
            response.sendRedirect("Marcas.jsp");  
        }
      }catch(Exception e){
            request.getSession().setAttribute("MSG","Error");
            request.getSession().setAttribute("esta","true");
            response.sendRedirect("Marcas.jsp");} 
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
            Logger.getLogger(Marcas_S.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Marcas_S.class.getName()).log(Level.SEVERE, null, ex);
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
