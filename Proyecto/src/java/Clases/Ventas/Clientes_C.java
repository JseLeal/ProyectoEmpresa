/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Ventas;
import Clases.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        
           
           query = "update clientes set  nombres=?, apellidos=?, NIT=?, genero=?, telefono= ?,correo_electronico=?, fechaingreso=?" +
                                            "where idCliente='"+getIdCliente()+"'and Activo like '1' ";
           
           campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
           
           campo.setString(1, getNombres());
           campo.setString(2, getApellidos());
           campo.setInt(3, getNIT());
           campo.setInt(4, getGenero());
           campo.setInt(5, getTelefono());
           campo.setString(6, getCorreoElectronico());
           campo.setString(7, getFechaingreso());
                  
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
        
        query = "update clientes set Activo='0' where idCliente like '"+getIdCliente()+"'"; 
        
        campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
 
        campo.executeUpdate();
        C.cerrarConexion();
        }
        catch(Exception e){
        throw(e);
    }
}
    
    public int ConsultaC() throws SQLException{
    int id=0;
    Conexion C=new Conexion();
    try{ 
    C.abrirConexion(); 
    String query;
    
    query=" select idCliente from clientes where nombres like  '" + getNombres()+ "'  and apellidos like'" + getApellidos() + "' and Activo like '1' ";
    
    campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
    
    ResultSet guardar=campo.executeQuery();
    
    while(guardar.next()){
    id=guardar.getInt("idCliente");
    }
    return id;           
  }
  catch(Exception ex)
  { }
   C.cerrarConexion();
   return id;
  }
    }
