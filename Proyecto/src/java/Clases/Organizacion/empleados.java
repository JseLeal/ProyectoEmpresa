/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Organizacion;

import Clases.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class empleados {
  public int idEmpleado;
  public String nombres;
  public String apellidos;
  public String direccion;
  public String telefono;
  public String DPI;
  public int genero;
  public String fecha_nacimiento;
  public int idPuesto;
  public String fecha_inicio_labores;
  public String fechaingreso;
  PreparedStatement campo;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDPI() {
        return DPI;
    }

    public int getGenero() {
        return genero;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public String getFecha_inicio_labores() {
        return fecha_inicio_labores;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public void setFecha_nacimiento(String fnacimiento) {
        this.fecha_nacimiento = fnacimiento;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public void setFecha_inicio_labores(String fecha_inicio_labores) {
        this.fecha_inicio_labores = fecha_inicio_labores;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

     public void Insertar() throws SQLException
    {
        
    try{
    Conexion C=new Conexion();
    C.abrirConexion(); 
    String query=" ";
    
    query="INSERT INTO empleados (nombres, apellidos, direccion, telefono, DPI, genero, fecha_nacimiento, idPuesto, fecha_inicio_labores, fechaingreso, Activo)" 
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    campo=(PreparedStatement) C.conexionBd.prepareStatement(query);

    campo.setString(1,getNombres());
    campo.setString(2, getApellidos());
    campo.setString(3, getDireccion());
    campo.setString(4, getTelefono());
    campo.setString(5, getDPI());
    campo.setInt(6, getGenero());
    campo.setString (7, getFecha_nacimiento());
    campo.setInt (8, getIdPuesto());
    campo.setString (9, getFecha_inicio_labores());
    campo.setString (10, getFechaingreso());
    campo.setInt(11,1);
    campo.executeUpdate();
    C.cerrarConexion();    
    }
        catch(Exception e)
        {      
        }
 }
    
    public void Modificar() throws SQLException
    {
        try{
        Conexion C=new Conexion();
        C.abrirConexion();
        String query="";
        
           
           query = "update empleados set  nombres=?, apellidos=?, direccion=?, telefono=?, DPI=?, genero=?, fecha_nacimiento=?, idPuesto=?, fecha_inicio_labores=?, fechaingreso=?" +
                                            "where idEmpleado='"+getIdEmpleado()+"'and Activo like '1' ";
           
           campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
           
           campo.setString(1,getNombres());
    campo.setString(2, getApellidos());
    campo.setString(3, getDireccion());
    campo.setString(4, getTelefono());
    campo.setString(5, getDPI());
    campo.setInt(6, getGenero());
    campo.setString (7, getFecha_nacimiento());
    campo.setInt (8, getIdPuesto());
    campo.setString (9, getFecha_inicio_labores());
    campo.setString (10, getFechaingreso());
                  
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
        
        query = "update empleados set Activo='0' where idEmpleado like '"+getIdEmpleado()+"'"; 
        
        campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
 
        campo.executeUpdate();
        C.cerrarConexion();
        }
        catch(Exception e){
        throw(e);
    }
}
    
    public int ConsultaEmp() throws SQLException{
    int id=0;
    Conexion C=new Conexion();
    try{ 
    C.abrirConexion(); 
    String query;
    
    query=" select idEmpleado from empleados where nombres like  '" + getNombres()+ "'  and apellidos like'" + getApellidos() + "' and Activo like '1' ";
    
    campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
    
    ResultSet guardar=campo.executeQuery();
    
    while(guardar.next()){
    id=guardar.getInt("idEmpleado");
    }
    return id;           
  }
  catch(Exception ex)
  { }
   C.cerrarConexion();
   return id;
  }
    
    public ArrayList <String> mostrarPuestos(){
  ArrayList<String> lista= new ArrayList<>();
  Conexion C=new Conexion();
        try{
            C.abrirConexion();
            String query;
            query ="SELECT idPuesto,puesto FROM puestos WHERE Activo like '1'" ;
            ResultSet consulta =  C.conexionBd.createStatement().executeQuery(query);
                   while (consulta.next())
                     {            
                       lista.add(consulta.getInt("idPuesto")+")"+consulta.getString("puesto"));
                     }
               C.cerrarConexion();
               return lista;
            } 
         catch(Exception ex)
             {
                   C.cerrarConexion();
             }
            
       return lista;
    }

  
}
