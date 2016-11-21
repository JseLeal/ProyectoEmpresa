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
import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class FacturaCompra_C {
     //Campos ventas
    private int idCompra;//venta,ventaDetalle
    private int nofactura;
    private String fechafactura;
    private int idProveedor;
    private String fecha_ingreso;
    //Campos VentaDetalle
    private int idCompra_detalle;
    private ArrayList idProducto;
    private ArrayList cantidad;
    private ArrayList precio_unitario;
    public int ids[]; 
    public int cants[]; 
    public double precios[]; 
    PreparedStatement campo,parametro,campo2;
    
        
    public void Insertar () { 
    try{
    Conexion C=new Conexion();
    C.abrirConexion(); 
    String queryVentas="";
    String queryVentasDetalle="";
    int cons;
    
    queryVentas="INSERT INTO compras (no_orden_compra, fecha_orden, idProveedor, fecha_ingreso)" + "VALUES (?,?,?,?)";


    campo=(PreparedStatement) C.conexionBd.prepareStatement(queryVentas);

    campo.setInt(1,getNofactura());
    campo.setString(2, getFechafactura());
    campo.setInt(3, getIdProveedor());
    campo.setString (4, getFecha_ingreso());
    campo.executeUpdate();
    C.cerrarConexion();

    queryVentasDetalle="INSERT INTO compras_detalle (idcompra,idProducto, cantidad, precio_costo_unitario)" + "VALUES (?,?,?,?)";
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
            e.toString();
        }

}
     
  public int Eliminar () throws SQLException {
        
    Conexion C=new Conexion();
    C.abrirConexion(); 
    String query;
    int idE=0;
    
    query=" SELECT  idCompra FROM ventas where nofactura like  '" + getNofactura()+ "'";
    
    campo=(PreparedStatement) C.conexionBd.prepareStatement(query);
    
    ResultSet guardar=campo.executeQuery();
    
    while(guardar.next()){
    idE=guardar.getInt("idVenta");
    }
    return idE;
    
  }
  
  public int Consultar() throws SQLException{
      int id=0;
      Conexion C=new Conexion();
   try{ 
    C.abrirConexion(); 
    String query;
    
    query=" SELECT idcompra FROM compras WHERE no_orden_compra like  '" + getNofactura()+ "'";
    
    parametro=(PreparedStatement) C.conexionBd.prepareStatement(query);
    
    ResultSet guardar=parametro.executeQuery();
    
    while(guardar.next()){
    id=guardar.getInt("idcompra");
    }
    return id;
                 
  }
  catch(Exception ex)
  { }
   C.cerrarConexion();
   return id;
  }
  
  public ArrayList <String> mostrarProveedor(){
  ArrayList<String> lista= new ArrayList<>();
  Conexion C=new Conexion();
        try{
            C.abrirConexion();
            String query;
            query = "SELECT idProveedor,proveedor,nit FROM proveedores" ;
            ResultSet consulta =  C.conexionBd.createStatement().executeQuery(query);
                   while (consulta.next())
                     {            
                       lista.add(consulta.getInt("idProveedor")+")"+consulta.getString("proveedor")+consulta.getString("nit"));
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
 
 
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getNofactura() {
        return nofactura;
    }

    public void setNofactura(int nofactura) {
        this.nofactura = nofactura;
    }

    public String getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(String fechafactura) {
        this.fechafactura = fechafactura;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getIdCompra_detalle() {
        return idCompra_detalle;
    }

    public void setIdCompra_detalle(int idCompra_detalle) {
        this.idCompra_detalle = idCompra_detalle;
    }

    public ArrayList getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ArrayList idProducto) {
        this.idProducto = idProducto;
    }

    public ArrayList getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(ArrayList precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
      
}

    

