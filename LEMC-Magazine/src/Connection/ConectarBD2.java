/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Lenovo
 */
public class ConectarBD2 {

    private Connection conexion;
    private Statement statement;
    
    //Datos para la conexion con la DB
    private final String servidor = "db-mysql-nyc1-16715-do-user-7889205-0.a.db.ondigitalocean.com";
    private final String puerto = "25060";
    private final String BD = "LEMC";
    private final String usuario = "doadmin";
    private final String clave = "li9j393xzitvjhi3";
    private final String URL = "jdbc:mysql://"+servidor+":"+puerto+"/"+BD;
    
    
    public boolean conectar() throws ClassNotFoundException{
        boolean estado = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try{
                //Establecer conexion con la BD
                conexion = (Connection) DriverManager.getConnection(URL,usuario,clave);
                estado = true;
                
            }catch(Exception e){
                System.out.println(e.getMessage());
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return estado;
    }
    
    public boolean ejecutar(String sql) throws SQLException{
        boolean estado = false;
        try{
            statement = (Statement) conexion.createStatement();
            statement.execute(sql);
            statement.close();
            estado = true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return estado;
    }
    
    public void desconectar() throws SQLException{
        try{
            if(conexion!=null){
                conexion.close();
                conexion = null;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConectarBD2 c = new ConectarBD2();
        c.conectar();
        String sql = "CREATE TABLE prueba2(id int PRIMARY KEY);";
        c.ejecutar(sql);
        c.desconectar();
    }
    
}
