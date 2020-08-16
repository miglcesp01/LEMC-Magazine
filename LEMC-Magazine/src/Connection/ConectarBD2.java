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

    private Connection conexion;
    private Statement statement;
    
    //Datos para la conexion con la DB
    private final String servidor = "db-mysql-nyc1-16715-do-user-7889205-0.a.db.ondigitalocean.com";
    private final String puerto = "25060";
    private final String BD = "LEMC";
    private final String usuario = "doadmin";
    private final String clave = "li9j393xzitvjhi3";
    private final String URL = "jdbc:mysql://"+servidor+":"+puerto+"/"+BD;
    private TableView tabla;
    
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
    
    //Esto se ejecuta cuando se quiera entrar a la tabla completa de la base de datos
    //Existe un procedure para cada tabla
    
    public TableView ejecutarSelectEntidad(String sql) throws SQLException{
        List<Employee> lista = new ArrayList<>();
        ObservableList<Employee> lista2 = FXCollections.observableList(lista);
        try{
            tabla = new TableView();
            statement = (Statement) conexion.createStatement();
            ResultSet s = statement.executeQuery(sql);
            
            while(s.next()){
                Employee empleado = new Employee(s.getString(1),s.getString(2),s.getString(3),s.getInt(4),s.getString(5),
                s.getInt(6),s.getString(7));
                lista.add(empleado);
            }
        List<String> campos = Employee.getArr();
        for(int i=0;i<campos.size();i++){
            String atributo = campos.get(i);
            TableColumn<Employee,String> columna=new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
        }
        tabla.setItems(lista2);
        System.out.println(tabla.getItems().size());
        statement.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return tabla;
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
   

    
    

    
}
