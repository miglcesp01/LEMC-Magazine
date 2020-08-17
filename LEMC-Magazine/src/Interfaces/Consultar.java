/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Connection.ConectarBD2;
import Entidades.Employee;
/**
 *
 * @author Alexis
 */
public class Consultar {
    /*private static TableView tabla;
    
    public static TableView ejecutarSelectEntidad(String sql) throws SQLException{
        tabla=new TableView();
        List<Employee> lista = new ArrayList<>();
        ObservableList<Employee> lista2 = FXCollections.observableList(lista);
        try{
            ResultSet s = ConectarBD2.c.ejecutarQuery(sql);
            
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
        ConectarBD2.c.endQuery();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return tabla;
    }*/
}
