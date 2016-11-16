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
import java.sql.SQLException;

/**
 *
 * @author Jose
 */
public class Usuarios_C {
    
    private int idUsuario;
    private String Nombre;
    private String Correo;
    private String Contrasena;
    
    Conexion C =new Conexion();
    PreparedStatement parametro;
    
    public void ingresar() {
    try{
         C= new Conexion();
           C.abrirConexion();
           String query;
           query = "INSERT INTO usuario (Nombre,Correo,Contrasena) Values(?,?,?)";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           
           parametro.setString(1, getNombre());
           parametro.setString(2,getCorreo());
           parametro.setString(3,getContrasena());
           parametro.executeUpdate();
           C.cerrarConexion();    
            }
        catch(Exception ex)
            {
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
    
    public void Modificar(){
            try{
           C = new Conexion();
           C.abrirConexion();
           String query;
           query = "update usuario set Correo=? where Nombre like '"+getNombre()+"'";
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           parametro.setString(1,getCorreo());
           parametro.executeUpdate();
           C.cerrarConexion();
            }
        catch(SQLException | HeadlessException ex)
            {
                  C.cerrarConexion();
            }
           
        }

    public void Eliminar() throws SQLException{
        C = new Conexion();
        C.abrirConexion();
           String query;
           query = "delete usuario where Nombre=? " ;                                 
           parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
           parametro.setString(1, getNombre() );
           parametro.executeUpdate();
           C.cerrarConexion();
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
