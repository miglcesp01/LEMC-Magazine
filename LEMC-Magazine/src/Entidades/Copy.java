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
public class Copy implements Entidad{
    
    private int IdMagazine;
    private int PagesNumber;
    private int Sells;
    private String CreationDate;
    private int IdCopy;
    private static ArrayList<String> arr;
    
    public Copy(){
        
    }

    public Copy(int IdMagazine, int PagesNumber, int Sells, String CreationDate, int IdCopy) {
        this.IdMagazine = IdMagazine;
        this.PagesNumber = PagesNumber;
        this.Sells = Sells;
        this.CreationDate = CreationDate;
        this.IdCopy = IdCopy;
    }

    public ArrayList<String> getArr() {
        arr = new ArrayList<>();
        arr.add("IdMagazine");arr.add("PagesNumber");arr.add("Sells");arr.add("CreationDate");
        arr.add("IdCopy");
        return arr;
    }

    public static void setArr(ArrayList<String> arr) {
        Copy.arr = arr;
    }

    @Override
    public String getNameClass() {
        return "Copy";
    }

    @Override
    public void setColumn(TableView tabla) {
        ArrayList<String> arr2=new ArrayList<>();
        arr2.add("IdMagazine");arr2.add("PagesNumber");arr2.add("Sells");arr2.add("CreationDate");
        arr2.add("IdCopy");
         for(String atributo:arr2){
             TableColumn<Copy, String> columna = new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
         }
    }

    @Override
    public void getRow(ResultSet s, ObservableList<Entidad> lista) throws SQLException {
        try{
        while (s.next()) {
                Copy copia = new Copy(s.getInt(1),s.getInt(2),s.getInt(3),s.getString(4),s.getInt(5));
                lista.add(copia);
            }
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    
    
    
    
    
}
