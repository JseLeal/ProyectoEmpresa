/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Producto_C;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
     * @throws java.sql.SQLException
     */
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
       String[] Campos = new String[10];
       String[] Datos = new String[10];
       int i=0;
            String url="C:\\Users\\Jose\\Desktop\\Proyecto\\ProyectoEmpresa\\Proyecto\\web\\IMGP";
                  if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    
                    if(!item.isFormField()){
                        String name = (Datos[0]+".JPG");
                        item.write( new File(url + File.separator + name));
                    }
                    else
                    {
                        Campos[i]=item.getFieldName();
                        Datos[i]=item.getString();
                         i++;
                         
                    }
                   
                }
           
            } catch (Exception ex) 
            { 
                ex.toString();
            }   }   


           /*DiskFileItemFactory factory= new DiskFileItemFactory();
                factory.setRepository(new File(url));
                ServletFileUpload upload = new ServletFileUpload(factory);
                try{
                    List<FileItem> partes=upload.parseRequest(request);
                    for(FileItem items:partes){File file=new File(url,items.getName());
                    items.write(file);}
                }catch(Exception ex)
                {
                ex.toString();
                };}*/
                
            String Producto =Datos[0];
            String idMarca = Datos[1];
            String Descripcion =Datos[2];
            String Imagen =""; //request.getParameter("Imagen");
            String Precio_costo = Datos[3];
            String Precio_venta = Datos[4];
            String existencia = Datos[5];
            String fecha_ingreso = Datos[6];
            int posc= idMarca.indexOf(')');
            
            Producto_C productonuevo = new Producto_C();
    
            
            //Ingresar
            if (Datos[7]!=null){
                   
                try {    
                 productonuevo.setProducto(Producto);   
                if(productonuevo.Verificar()==null){
                    
                
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
            
            else if (Datos[8]!=null) {
                
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
            else if(Datos[9]!=null){                
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
