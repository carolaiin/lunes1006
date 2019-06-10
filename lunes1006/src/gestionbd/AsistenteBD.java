
package gestionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AsistenteBD {
    
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet  resultados = null;
    String driver = "org.sqlite.JDBC";
    String nombreBD = "empresa.sqlite";//nombre de la empresa
    String url = "jdbc:sqlite:"+nombreBD;
    
    
    public void crearBD(){//craando base de datos.
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Base de datos creada con exito");
      
        }//.
    
    public void crarTabla(){//creando tabla.
    
           try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            
            sentencia = conexion.createStatement();
            String sql = "CREATE TABLE CLIENTE " + 
                    "(ID        INT     PRIMARY KEY NOT NULL, "+
                    "NOMBRE     TEXT    NOT NULL, "+
                    "APELLIDO   TEXT    NOT NULL, "+
                    "EDAD       INT)";
            
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Tabla creada con exito");
    
    }//.
    
    
    public void insertarDatos(int id, String nombre, String apellido, int edad){
            
           try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO CLIENTE " +
                    "(ID,NOMBRE,APELLIDO,EDAD) "+
                    "VALUES('"+id+"', '"+nombre+"','"+apellido+"', '"+edad+"')";
                
                  
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Cliente ingresado con exito");
 
    }//.
    public void mostrarDatos(){
           
           try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            
            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM CLIENTE";
            resultados = sentencia.executeQuery(sql);
            
            
            while(resultados.next()){
            
                int id = resultados.getInt("ID");
                String nombre = resultados.getString("NOMBRE");
                String apellido = resultados.getString("NOMBRE");
                int edad = resultados.getInt("EDAD");
                
                
                System.out.println("\nID: " + id + 
                        "\nNOMBRE: " + nombre +
                        "\nAPELLIDO: " + apellido +
                        "\nEDAD: " + edad);
                }//fin while
            resultados.close();
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Clientes de la Base de Datos");
   }
    
    // realizar el actualizar y el eliminar
 
    public void actualizar(int id , String apellido){
          try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            
            sentencia = conexion.createStatement();
            String sql = "UPDATE CLIENTE " + 
                       "SET apellido = '"+apellido+"'" +
                    "WHERE id = '"+id+"'";
         
                    
                
                  
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Datos Actualizados");
    }
    
    
    public void eliminar(int id){
 
          try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            
            sentencia = conexion.createStatement();
            String sql = "DELETE FROM CLIENTE " + 
                          "WHERE id = '"+id+"'";
                 
         
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Datos eliminados");
    
    
    
    }
    
    
   
}//fin clase.



