/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class Producto_C {
    
    Conexion C =new Conexion();
    PreparedStatement parametro;
    public String producto;
    public int idMarca;
    public String Descripcion;
    public String Imagen;
    public double Precio_costo;
    public double Precio_venta;
    public int Existencia;
    public String fecha_ingreso;
      
     public void ingresar() throws Exception{
            try{
           C= new Conexion();
           C.abrirConexion();
           String query;
           query = "INSERT INTO productos (producto,idmarca,Descripcion,Imagen,precio_costo,precio_venta,existencia,fecha_ingreso,Activo) " +
                                            "Values(?,?,?,?,?,?,?,?,?)";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           
           parametro.setString(1, getProducto());
           parametro.setInt(2, getIdMarca());
           parametro.setString(3, getDescripcion());
           parametro.setString(4, getImagen());
           parametro.setDouble(5, getPrecio_costo());
           parametro.setDouble(6, getPrecio_venta());
           parametro.setInt(7, getExistencia());
           parametro.setString(8, getFecha_ingreso());
           parametro.setInt(9,1);
           parametro.executeUpdate();
           C.cerrarConexion();
        
            }
        catch(Exception ex)
            {
                throw (ex);
            }
        }
     
      public ArrayList<String> llenarMarca(){
           ArrayList<String> lista= new ArrayList<>();
       try{
         
           C = new Conexion();
           C.abrirConexion();
           String query;
           query = "Select idmarca,marca from marcas where Activo like 1" ;
            ResultSet consulta =  C.conexionBd.createStatement().executeQuery(query);
                  while (consulta.next())
                    {            
                      lista.add(consulta.getString("idmarca")+") "+consulta.getString("marca"));
                    }
              C.cerrarConexion();
              return lista;
           } 
        catch(Exception ex)
            {
                  C.cerrarConexion();
                  JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Query",JOptionPane.ERROR_MESSAGE);
            }
           
      return lista;
   }
      
     public void buscar() throws SQLException{
     C= new Conexion();
     C.abrirConexion();
     String query;
      try{
     query = "SELECT idmarca, Descripcion,Imagen,precio_costo,precio_venta,existencia,fecha_ingreso FROM productos WHERE producto like '"+getProducto()+"' and Activo like '1'";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
        
           ResultSet r = parametro.executeQuery();
        while ( r.next() ){
                setIdMarca(r.getInt("idmarca"));
                setDescripcion(r.getString("Descripcion"));
                setImagen(r.getString("Imagen"));
                setPrecio_costo(r.getInt("precio_costo"));
                setPrecio_venta(r.getInt("precio_venta"));
                setExistencia(r.getInt("existencia"));
                setFecha_ingreso(r.getString("fecha_ingreso"));
            }
      }
      catch(Exception ex){
      }

     }
     
     public void Modificar(){
            try{
           C = new Conexion();
           C.abrirConexion();
           String query;
           query = "update productos set idmarca = ?,Descripcion= ?,Imagen= ?,precio_costo= ?,precio_venta= ?,existencia= ?,fecha_ingreso =? where producto='"+getProducto()+"' and Activo like '1'";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           
           parametro.setInt(1, getIdMarca());
           parametro.setString(2, getDescripcion());
           parametro.setString(3, getImagen());
           parametro.setDouble(4, getPrecio_costo());
           parametro.setDouble(5, getPrecio_venta());
           parametro.setInt(6, getExistencia());
           parametro.setString(7, getFecha_ingreso());
            parametro.executeUpdate();
             C.cerrarConexion();
  
            }
        catch(SQLException | HeadlessException ex)
            {
                  C.cerrarConexion();
            }
           
        }
     
     public void Eliminar(){
            try{
           C = new Conexion();
           C.abrirConexion();
                      String query;
           query = "update productos set Activo='0' where producto ='"+getProducto()+"'";                                 
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           int executar =  parametro.executeUpdate();
           C.cerrarConexion();
         
           JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Eliminado","Conexion Exitosa",JOptionPane.WARNING_MESSAGE);          
            }
        catch(SQLException | HeadlessException ex)
            {
                  C.cerrarConexion();
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en Query",JOptionPane.ERROR_MESSAGE);
            }
        }
     
     public String Verificar(){
     String resultado = null;
     C= new Conexion();
     C.abrirConexion();
     String query;
      try{
     query = "SELECT * FROM productos WHERE producto like '"+getProducto()+"' and Activo like '1'";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
        
           ResultSet r = parametro.executeQuery();
       
           if(r!=null)
       {
           resultado="EL producto ya existe.";
       }
       
      }
      catch(Exception ex){
      resultado="Error";}
     return resultado;
     }
     
 public void Modificar2(){
            try{
           C = new Conexion();
           C.abrirConexion();
           String query;
           query = "update productos set idmarca = ?,Descripcion= ?,Imagen= ?,precio_costo= ?,precio_venta= ?,existencia= ?,fecha_ingreso =?, Activo=? where producto='"+getProducto()+"'";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           
           parametro.setInt(1, getIdMarca());
           parametro.setString(2, getDescripcion());
           parametro.setString(3, getImagen());
           parametro.setDouble(4, getPrecio_costo());
           parametro.setDouble(5, getPrecio_venta());
           parametro.setInt(6, getExistencia());
           parametro.setString(7, getFecha_ingreso());
           parametro.setInt(8,1);
            parametro.executeUpdate();
             C.cerrarConexion();
  
            }
        catch(SQLException | HeadlessException ex)
            {
                  C.cerrarConexion();
            }
           
        }
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public double getPrecio_costo() {
        return Precio_costo;
    }

    public void setPrecio_costo(double Precio_costo) {
        this.Precio_costo = Precio_costo;
    }

    public double getPrecio_venta() {
        return Precio_venta;
    }

    public void setPrecio_venta(double Precio_venta) {
        this.Precio_venta = Precio_venta;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
   
}
