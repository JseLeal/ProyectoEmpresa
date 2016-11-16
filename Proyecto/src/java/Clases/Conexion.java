package Clases;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;


public class Conexion {
    public Connection conexionBd;
    
    private final String sgdb = "mysql";
    private final String servidor="localhost"; //DESARROLLO,localhost
    private final String puerto=":3306";//:3306
    private final String bd = "dbempresa";
    //private final String urlConexion = "jdbc:"+sgdb +"://"+servidor+puerto+"/"+bd; //mysql
    private final String urlConexion = "jdbc:"+sgdb +"://"+servidor+puerto+"/"+bd;
    private final String usuario = "root";
    private final String contra = "123456";
    private final String jdbc="com.mysql.jdbc.Driver"; // com.microsoft.sqlserver.jdbc.SQLServerDriver,com.mysql.jdbc.Driver
    
    public void abrirConexion()
    {
        
        try
        {
        Class.forName(jdbc);
      // conexionBd = DriverManager.getConnection("jdbc:sqlserver://J-SE\\SQLJSE;databaseName=dbEscuela;user=Jse;password=j123;");
        conexionBd= DriverManager.getConnection(urlConexion,usuario,contra);
        }
        catch(ClassNotFoundException | SQLException ex)
        {
 
        }  
        
    }
    
    
    public void cerrarConexion()
    {
        try {
            conexionBd.close();
            }
            catch(Exception ex)
        {        
                
        }

    }
    }

