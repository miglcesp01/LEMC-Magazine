/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Lenovo
 */
public class PhoneJournalist implements Entidad{
    private int Id;
    private String NoPhone;
    private String DNIJournalist;
    private static ArrayList<String> arr;

    public PhoneJournalist(int Id, String NoPhone, String DNIJournalist) {
        this.Id = Id;
        this.NoPhone = NoPhone;
        this.DNIJournalist = DNIJournalist;
    }
    
    public ArrayList<String> getArr(){
        arr = new ArrayList<>();
        arr.add("Id");arr.add("NoPhone");arr.add("DNIJournalist");
        return arr;
    }

    @Override
    public String getNameClass() {
        return "PhoneJournalist";
        
    }

    @Override
    public void setColumn(TableView tabla) {
        ArrayList<String> arr2=new ArrayList<>();
         arr2.add("Id");arr2.add("NoPhone");arr2.add("DNIJournalist");
         for(String atributo:arr2){
             TableColumn<PhoneJournalist, String> columna = new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
         }
    }

    @Override
    public void getRow(ResultSet s, ObservableList<Entidad> lista) throws SQLException {
         try{
        while (s.next()) {
                PhoneJournalist numberJournalist = new PhoneJournalist(s.getInt(1),s.getString(2),s.getString(3));
                lista.add(numberJournalist);
            }
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    public PhoneJournalist(){
        
    }
    
    
}
