/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Entidades.Employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author Lenovo
 */
public class ConectarBD2 {
    public static final ConectarBD2 c=new ConectarBD2();
    private Connection conexion;
    private Statement statement;
    //Datos para la conexion con la DB
    private final String servidor = "db-mysql-nyc1-16715-do-user-7889205-0.a.db.ondigitalocean.com";
    private final String puerto = "25060";
    private final String BD = "LEMC";
    private final String usuario = "eddo";
    private final String clave = "eddo1";
    private final String URL = "jdbc:mysql://"+servidor+":"+puerto+"/"+BD;
    
    public ConectarBD2(){
        conectar();
    }
    
    private boolean conectar(){
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
    
    //Esto se ejecuta cuando se quiera entrar a la tabla completa de la base de datos
    //Existe un procedure para cada tabla
    
    
    public ResultSet ejecutarQuery(String sql)throws SQLException{
        ResultSet s;
        try{
            statement = (Statement) conexion.createStatement();
            s = statement.executeQuery(sql);
        }catch(SQLException ex){
            throw ex;
        }return s;
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
   
    public void endQuery() throws SQLException{
        try {statement.close();
        }catch(SQLException ex){
            throw ex;
        }
    }
    
}
