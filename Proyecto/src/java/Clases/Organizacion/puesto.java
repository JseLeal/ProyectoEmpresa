
package Clases.Organizacion;

import Clases.Conexion;
import java.awt.HeadlessException;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class puesto {
    
  private String idpuesto;
  private String puesto;
    Conexion C =new Conexion();
       PreparedStatement parametro;
       
    public String getIdpuesto() {
        return idpuesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setIdpuesto(String idpuesto) {
        this.idpuesto = idpuesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
 
    
      public void ingresar() throws Exception{
            try{
           C= new Conexion();
           C.abrirConexion();
           String query;
           query = "INSERT INTO puestos (puesto,Activo) Values(?,?)";
        
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           parametro.setString(1, getPuesto());
           parametro.setInt(2,1);
           parametro.executeUpdate();
           C.cerrarConexion();    
            }
        catch(Exception ex)
            {
                throw (ex);
            }
        }
      
         public String Verificar(){
     String resultado = null;
     C= new Conexion();
     C.abrirConexion();
     String query;
      try{
     query = "SELECT * FROM dbempresa.puestos WHERE puesto like '"+getPuesto()+"'";
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
         
           public void Modificar(){
            try{
           C = new Conexion();
           C.abrirConexion();
           String query;
           query = "update puestos set Activo=? where puesto like '"+getPuesto()+"'";
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
           query = "update puestos set Activo=? where puesto='"+getPuesto()+"'";
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
            
}
