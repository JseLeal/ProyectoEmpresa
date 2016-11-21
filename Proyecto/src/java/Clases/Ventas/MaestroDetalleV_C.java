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
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MaestroDetalleV_C {
    //Campos ventas
    public int idVenta;//venta,ventaDetalle
    public int nofactura;
    public String Serie;
    public String fechafactura;
    public int idCliente;
    public int idEmpleado;
    public String fecha_ingreso;
    //Campos VentaDetalle
    public int idVenta_detalle;
    private ArrayList idProducto;
    private ArrayList cantidad;
    private ArrayList precio_unitario;
    public int ids[]; 
    public int cants[]; 
    public double precios[]; 

    PreparedStatement campo,parametro,campo2;
    
    
    public int getIdVenta() {
        return idVenta;
    }

    public int getNofactura() {
        return nofactura;
    }

    public String getSerie() {
        return Serie;
    }

    public String getFechafactura() {
        return fechafactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public int getIdVenta_detalle() {
        return idVenta_detalle;
    }

    public ArrayList getIdProducto() {
        return idProducto;
    }

    public ArrayList getCantidad() {
        return cantidad;
    }

    public ArrayList getPrecio_unitario() {
        return precio_unitario;
    }
    
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setNofactura(int nofactura) {
        this.nofactura = nofactura;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public void setFechafactura(String fechafactura) {
        this.fechafactura = fechafactura;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setIdVenta_detalle(int idVenta_detalle) {
        this.idVenta_detalle = idVenta_detalle;
    }

    public void setIdProducto(ArrayList idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(ArrayList cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio_unitario(ArrayList precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    
    
    public void Insertar () {
        
    try{
    Conexion C=new Conexion();
    C.abrirConexion(); 
    String queryVentas="";
    String queryVentasDetalle="";
    int cons;
    
    queryVentas="INSERT INTO ventas (nofactura, serie, fechafactura, idCliente, idEmpleado, fecha_ingreso)" + "VALUES (?,?,?,?,?,?)";


    campo=(PreparedStatement) C.conexionBd.prepareStatement(queryVentas);

    campo.setInt(1,getNofactura());
    campo.setString(2, getSerie());
    campo.setString(3, getFechafactura());
    campo.setInt(4, getIdCliente());
    campo.setInt(5, getIdEmpleado());
    campo.setString (6, getFecha_ingreso());
    campo.executeUpdate();
    C.cerrarConexion();

    queryVentasDetalle="INSERT INTO ventas_detalle (idVenta, idProducto, cantidad, precio_unitario)" + "VALUES (?,?,?,?)";
    cons=Consultar(); 
    
    if(cons!=0){ 
    C.abrirConexion();
    campo2=(PreparedStatement) C.conexionBd.prepareStatement(queryVentasDetalle);
   ids=new int[(getIdProducto().size())];
    int i=0;
    for(Object a: getIdProducto())
    {
        ids[i] =   (int) a;
        i++;
    }   
    
    cants=new int[(getCantidad().size())];
    i=0;
    for(Object g: getCantidad())
    {
        cants[i] = Integer.parseInt((String) g);
        i++;
    } 
    precios=new double[(getPrecio_unitario().size())];
    i=0;
    for(Object t: getPrecio_unitario())
    {
        precios[i] =  Double.parseDouble((String) t);
        i++;
    } 
    
    for(int z=0;z<i;z++)
    {
    campo2.setInt(1,cons);
    campo2.setInt(2, ids[z]);
    campo2.setInt(3, cants[z]);
    campo2.setDouble(4, precios[z]);
    campo2.executeUpdate();
    }
    C.cerrarConexion();
        }
    }
        catch(Exception e)
        {         
        }

}
     
  public int Eliminar () throws SQLException {
        
    Conexion C=new Conexion();
    C.abrirConexion(); 
    String query;
    int idE=0;
    
    query=" SELECT  idVenta FROM ventas where nofactura like  '" + getNofactura()+ "'  and serie like'" + getSerie() + "' ";
    
    campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
    
    ResultSet guardar=campo.executeQuery();
    
    while(guardar.next()){
    idE=guardar.getInt(idVenta);
    }
    return idE;
    
  }
  
  public int Consultar() throws SQLException{
      int id=0;
      Conexion C=new Conexion();
   try{ 
    C.abrirConexion(); 
    String query;
    
    query=" SELECT idVenta FROM ventas WHERE nofactura like  '" + getNofactura()+ "'  and serie like'" + getSerie() + "'";
    
    parametro=(PreparedStatement) C.conexionBd.prepareStatement(query);
    
    ResultSet guardar=parametro.executeQuery();
    
    while(guardar.next()){
    id=guardar.getInt("idVenta");
    }
    return id;
                 
  }
  catch(Exception ex)
  { }
   C.cerrarConexion();
   return id;
  }
  
  public ArrayList <String> mostrarCliente(){
  ArrayList<String> lista= new ArrayList<>();
  Conexion C=new Conexion();
        try{
            C.abrirConexion();
            String query;
            query = "SELECT idCliente,nombres,NIT FROM clientes" ;
            ResultSet consulta =  C.conexionBd.createStatement().executeQuery(query);
                   while (consulta.next())
                     {            
                       lista.add(consulta.getInt("idCliente")+")"+consulta.getString("nombres")+consulta.getString("NIT"));
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
  
  public ArrayList <String> mostrarEmpleados(){
  ArrayList<String> lista= new ArrayList<>();
  Conexion C=new Conexion();
        try{
            C.abrirConexion();
            String query;
            query = "SELECT idEmpleado,nombres FROM empleados" ;
            ResultSet consulta =  C.conexionBd.createStatement().executeQuery(query);
                   while (consulta.next())
                     {            
                       lista.add(consulta.getInt("idEmpleado")+")"+consulta.getString("nombres"));
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
  
  public ArrayList <String> mostrarProductos(){
  ArrayList<String> lista= new ArrayList<>();
  Conexion C=new Conexion();
        try{
            C.abrirConexion();
            String query;
            query = "SELECT idProducto,producto FROM productos" ;
            ResultSet consulta =  C.conexionBd.createStatement().executeQuery(query);
                   while (consulta.next())
                     {            
                       lista.add(consulta.getInt("idProducto")+")"+consulta.getString("producto"));
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
  
  public void modificarExistencia() throws SQLException{
      Conexion C=new Conexion();
      C.abrirConexion();
      String queryE;
      String query;
      int existencia=0;
      
    
      for(int u=0;u< getIdProducto().size();u++)
      {
    queryE=" SELECT existencia FROM productos WHERE idProducto like '" + ids[u] + "'  and Activo like '1'";
 
    parametro=(PreparedStatement) C.conexionBd.prepareStatement(queryE);
    
    ResultSet exis=parametro.executeQuery();
    
    while(exis.next()){
    existencia=exis.getInt("existencia");
    }
       
     query = "update productos set existencia = ? where idProducto='"+ids[u]+"'";
      
      parametro=(PreparedStatement) C.conexionBd.prepareStatement(query); 
      
      parametro.setInt(1, (existencia+  (cants[u] ) ) );      
      parametro.executeUpdate();
      }
      C.cerrarConexion();
  }   
}
