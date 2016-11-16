/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jose
 */
public class Login_C {
    
    private String usuario;
    private String contrasena;
    Conexion C =new Conexion();
    PreparedStatement parametro;
    
   public String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    } 
    
   public String Verificar()
    {
        String Resultado= null;
        try{
        C.abrirConexion();
        String query;
        query="SELECT Nombre,Contrasena FROM usuario WHERE Nombre like '"+getUsuario()+"' and Contrasena like '"+getContrasena()+"'";
        parametro = (PreparedStatement) C.conexionBd.prepareStatement(query);
        
        ResultSet R=parametro.executeQuery();
        if(R.next())
        {
        Resultado="Coincide";
        }
        
        }
        catch(Exception e){}
        
    return Resultado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
