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
public class Redactar implements Entidad{
    private int IdRedactar;
    private String DNI;
    private int IdMagazine;
    private static ArrayList<String> arr;

    public Redactar(int IdRedactar, String DNI, int IdMagazine) {
        this.IdRedactar = IdRedactar;
        this.DNI = DNI;
        this.IdMagazine = IdMagazine;
    }

    public ArrayList<String> getArr() {
        arr = new ArrayList<>();
        arr.add("IdRedactar");arr.add("DNI");arr.add("IdMagazine");
        return arr;
    }

    public static void setArr(ArrayList<String> arr) {
        Redactar.arr = arr;
    }

    @Override
    public String getNameClass() {
        return "Redactar";
    }

    @Override
    public void setColumn(TableView tabla) {
        ArrayList<String> arr2=new ArrayList<>();
         arr2.add("IdRedactar");arr2.add("DNI");arr2.add("IdMagazine");
         for(String atributo:arr2){
             TableColumn<Redactar, String> columna = new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
         }
    }

    @Override
    public void getRow(ResultSet s, ObservableList<Entidad> lista) throws SQLException {
        try{
        while (s.next()) {
                Redactar redactar = new Redactar(s.getInt(1),s.getString(2),s.getInt(3));
                lista.add(redactar);
            }
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    public Redactar(){
        
    }
    
    
    
}
