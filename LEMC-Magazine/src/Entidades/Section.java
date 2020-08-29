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
public class Section implements Entidad{
    private int IdMagazine;
    private String Title;
    private String Extension;
    private int IdSection;
    private static ArrayList<String> arr;

    public Section(int IdMagazine, String Title, String Extension, int IdSection) {
        this.IdMagazine = IdMagazine;
        this.Title = Title;
        this.Extension = Extension;
        this.IdSection = IdSection;
    }

    public ArrayList<String> getArr() {
        arr = new ArrayList<>();
        arr.add("IdMagazine");arr.add("Title");arr.add("Extension");arr.add("IdSection");
        return arr;
    }

    public static void setArr(ArrayList<String> arr) {
        Section.arr = arr;
    }

    @Override
    public String getNameClass() {
        return "Section";
    }

    @Override
    public void setColumn(TableView tabla) {
        ArrayList<String> arr2=new ArrayList<>();
         arr2.add("IdMagazine");arr2.add("Title");arr2.add("Extension");arr2.add("IdSection");
         for(String atributo:arr2){
             TableColumn<Section, String> columna = new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
         }

    }

    @Override
    public void getRow(ResultSet s, ObservableList<Entidad> lista) throws SQLException {
        try{
        while (s.next()) {
                Section seccion = new Section(s.getInt(1),s.getString(2),s.getString(3),s.getInt(4));
                lista.add(seccion);
            }
        }catch(SQLException ex){
            throw ex;
        }
    }
    public Section(){
        
    }

    @Override
    public ArrayList<Object> getTiposDatos() {
        ArrayList<Object> tiposDatos = new ArrayList<>();
        tiposDatos.add((Integer)3);
        tiposDatos.add(new String());
        tiposDatos.add(new String());
        tiposDatos.add((Integer)3);
        return tiposDatos;
    }
    
    
}
