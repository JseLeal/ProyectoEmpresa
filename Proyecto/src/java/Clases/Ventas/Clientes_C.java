/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Ventas;
import Clases.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Usuario
 */
public class Clientes_C {
    
    public int idCliente;
    public String Nombres;
    public String Apellidos;
    public int NIT;
    public int Genero;
    public int Telefono;
    public String CorreoElectronico;
    public String Fechaingreso;
    PreparedStatement campo;

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public int getNIT() {
        return NIT;
    }

    public int getGenero() {
        return Genero;
    }

    public int getTelefono() {
        return Telefono;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public String getFechaingreso() {
        return Fechaingreso;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String Nombre) {
        this.Nombres = Nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public void setGenero(int Genero) {
        this.Genero = Genero;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public void setFechaingreso(String Fechaingreso) {
        this.Fechaingreso = Fechaingreso;
    }

    public void Insertar() throws SQLException
    {
        
    try{
    Conexion C=new Conexion();
    C.abrirConexion(); 
    String query="";
    
    query="INSERT INTO clientes (nombres, apellidos, NIT, genero, telefono, correo_electronico, fechaingreso)" + "VALUES (?,?,?,?,?,?,?)";

    campo=(PreparedStatement) C.conexionBd.prepareStatement(query);

    campo.setString(1, getNombres());
    campo.setString(2, getApellidos());
    campo.setInt(3, getNIT());
    campo.setInt(4, getGenero());
    campo.setInt(5, getTelefono());
    campo.setString(6, getCorreoElectronico());
    campo.setString (7, getFechaingreso());
    campo.executeUpdate();
    C.cerrarConexion();    
    }
        catch(Exception e)
        { 
            String jaja=e.toString();        
    }
 }
    
    public void Modificar() throws SQLException
    {
        try{
        Conexion C=new Conexion();
        C.abrirConexion();
        String query="";
        
           
           query = "UPDATE clientes SET idCliente=?, nombres=?, apellidos=?, NIT=?, genero=?, telefono= ?,correo_electronico=?, fechaingreso=?" +
                                            "where idCliente=?";
           
           campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
           
           campo.setInt(1, getIdCliente());
           campo.setString(2, getNombres());
           campo.setString(3, getApellidos());
           campo.setInt(4, getNIT());
           campo.setInt(5, getGenero());
           campo.setInt(6, getTelefono());
           campo.setString(7, getCorreoElectronico());
           campo.setString(8, getFechaingreso());
                  
         campo.executeUpdate();
           C.cerrarConexion();
        }
        catch(Exception e){
        throw(e);
        }
    }
    
    public void Eliminar() throws SQLException
    {
        try{
        Conexion C=new Conexion();
        C.abrirConexion();
        String query="";
        
        query = "DELETE FROM clientes where idCliente=?"; 
        
        campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
        campo.setString(1, String.valueOf(getIdCliente()));
           

        campo.executeUpdate();
           C.cerrarConexion();
        }
        catch(Exception e){
        throw(e);
    }
}
    }
