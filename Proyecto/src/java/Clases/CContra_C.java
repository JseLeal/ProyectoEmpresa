/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.HeadlessException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jose
 */
public class CContra_C {
     private int idUsuario;
    private String Nombre;
    private String Correo;
    private String Contrasena;
       Conexion C =new Conexion();
    PreparedStatement parametro;
    
       public void Modificar(){
            try{
           C = new Conexion();
           C.abrirConexion();
           String query;
           query = "update usuario set Contrasena=? where Nombre like '"+getNombre()+"'";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           parametro.setString(1,getContrasena());
           parametro.executeUpdate();
           C.cerrarConexion();
            }
        catch(SQLException | HeadlessException ex)
            {
                  C.cerrarConexion();
            }
           
        }

        public String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
        
        public String Verificar(){
     String resultado = null;
     C= new Conexion();
     C.abrirConexion();
     String query;
      try{
     query = "SELECT Contrasena FROM usuario WHERE Nombre like '"+getNombre()+"'";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
        
           ResultSet r = parametro.executeQuery();
       
        while(r.next())
       {
           resultado=r.getString("Contrasena");
       }
       
      }
      catch(Exception ex){
      resultado="Error";}
     return resultado;
     }
        
        
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
}
