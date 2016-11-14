/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Compras;

import Clases.Conexion;
import java.sql.PreparedStatement;
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
           
           query = "UPDATE proveedores set idProveedor=?, proveedor=?, NIT=?, direccion=?, telefono= ?" + "where idProveedor=?";
           
           campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
           
           campo.setInt(1, getIdProveedor());
           campo.setString(2, getProveedor());
           campo.setInt(3, getNIT());
           campo.setString(4, getDireccion());
           campo.setInt(6, getTelefono());
                  
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
        
        query = "DELETE FROM proveedores where idProveedor=?"; 
        
        campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
        campo.setInt(1, getIdProveedor());
           

           campo.executeUpdate();
           C.cerrarConexion();
        }
        catch(Exception e){
        throw(e);
        }
    }
    
}
