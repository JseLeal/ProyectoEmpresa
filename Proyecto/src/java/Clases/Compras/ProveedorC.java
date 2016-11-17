/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Compras;

import Clases.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ProveedorC {
    
    public int idProveedor;
    public String proveedor;
    public int NIT;
    public String direccion;
    public int telefono;
    PreparedStatement campo;

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public int getNIT() {
        return NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public void Insertar() throws SQLException
    {
    try{    
    Conexion C=new Conexion();
    C.abrirConexion(); 
    String query="";
    
    query="INSERT INTO proveedores (proveedor, NIT, direccion, telefono)" + "VALUES (?,?,?,?)";

    campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
    
    campo.setString(1, getProveedor());
    campo.setInt(2, getNIT());
    campo.setString(3, getDireccion());
    campo.setInt(4, getTelefono());
    
    campo.executeUpdate();
    C.cerrarConexion();
    }
    catch(Exception e){
        throw(e);
    }
    
    }
    
    public void Modificar() throws SQLException
    {
        try{
        Conexion C=new Conexion();
        C.abrirConexion();
        String query="";
           
           query = "update proveedores set  proveedor=?, NIT=?, direccion=?, telefono=?" + "where idProveedor='" + getIdProveedor() + "' and Activo like '1' ";
           
           campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
           
           campo.setString(1, getProveedor());
           campo.setInt(2, getNIT());
           campo.setString(3, getDireccion());
           campo.setInt(4, getTelefono());
                  
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
        
        query = "update proveedores set Activo='0' where idProveedor like '"+getIdProveedor()+"'"; 
        
        campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
           

           campo.executeUpdate();
           C.cerrarConexion();
        }
        catch(Exception e){
        throw(e);
        }
    }
    
     public int ConsultaP() throws SQLException{
    int id=0;
    Conexion C=new Conexion();
    try{ 
    C.abrirConexion(); 
    String query;
    
    query=" select idProveedor from proveedores where proveedor like  '" + getProveedor()+ "' and Activo like '1' ";
    
    campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
    
    ResultSet guardar=campo.executeQuery();
    
    while(guardar.next()){
    id=guardar.getInt("idProveedor");
    }
    return id;           
  }
  catch(Exception ex)
  { }
   C.cerrarConexion();
   return id;
  }
    }
    
