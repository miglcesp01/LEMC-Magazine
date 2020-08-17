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
public class PhoneBranchOffice implements Entidad{
    private int Id;
    private String NoPhone;
    private String IdBranchOffice;
    private static ArrayList<String> arr;

    public PhoneBranchOffice(int Id, String NoPhone, String IdBranchOffice) {
        this.Id = Id;
        this.NoPhone = NoPhone;
        this.IdBranchOffice = IdBranchOffice;
    }
    
    public PhoneBranchOffice(){
        
    }
    
    public static ArrayList<String> getArr(){
        arr = new ArrayList<>();
        arr.add("Id");arr.add("NoPhone");arr.add("IdBranchOffice");
        return arr;
    }

    @Override
    public String getNameClass() {
        return "PhoneBranchOffice";
    }

    @Override
    public void setColumn(TableView tabla) {
        ArrayList<String> arr2=new ArrayList<>();
         arr2.add("Id");arr2.add("NoPhone");arr2.add("IdBranchOffice");
         for(String atributo:arr2){
             TableColumn<PhoneBranchOffice, String> columna = new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
         }
    }

    @Override
    public void getRow(ResultSet s, ObservableList<Entidad> lista) throws SQLException {
        try{
        while (s.next()) {
                PhoneBranchOffice numberOffice = new PhoneBranchOffice(s.getInt(1),s.getString(2),s.getString(3));
                lista.add(numberOffice);
            }
        }catch(SQLException ex){
            throw ex;
        }
    }
}
