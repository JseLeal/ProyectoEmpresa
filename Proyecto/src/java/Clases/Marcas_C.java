/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jose
 */
public class Marcas_C {
    public int idMarca;
    public String Marca;
    Conexion C =new Conexion();
    PreparedStatement parametro;
    
    public void ingresar() throws Exception{
            try{
           C= new Conexion();
           C.abrirConexion();
           String query;
           query = "INSERT INTO marcas (marca,Activo) Values(?,?)";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           
           parametro.setString(1, getMarca());
           parametro.setInt(2,1);
           parametro.executeUpdate();
           C.cerrarConexion();    
            }
        catch(Exception ex)
            {
                throw (ex);
            }
        }
    
    public void Modificar(){
            try{
           C = new Conexion();
           C.abrirConexion();
           String query;
           query = "update marcas set Activo=? where marca like '"+getMarca()+"'";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           
           parametro.setInt(1,1);
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
           query = "update marcas set Activo=? where marca='"+getMarca()+"'";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           
           parametro.setInt(1,0);
           parametro.executeUpdate();
           C.cerrarConexion();  
  
            }
        catch(SQLException | HeadlessException ex)
            {
                  C.cerrarConexion();
            }
           
        }
     
       public String Verificar(){
     String resultado = null;
     C= new Conexion();
     C.abrirConexion();
     String query;
      try{
     query = "SELECT * FROM dbempresa.marcas WHERE marca like '"+getMarca()+"'";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
        
           ResultSet r = parametro.executeQuery();
       
        if(r.next())
       {
           resultado="EL producto ya existe." ;
       }
       
      }
      catch(Exception ex){
          
      resultado="Error"+ex.getMessage();
      }
      
     return resultado;
     }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    
    
    
}
