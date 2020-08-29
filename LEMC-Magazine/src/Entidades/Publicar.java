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
public class Publicar implements Entidad{
    private int IdMagazine;
    private String IdBranchoffice;
    private static ArrayList<String> arr;

    public Publicar(int IdMagazine, String IdBranchoffice) {
        this.IdMagazine = IdMagazine;
        this.IdBranchoffice = IdBranchoffice;
    }

    public ArrayList<String> getArr() {
        arr = new ArrayList<>();
        arr.add("IdMagazine");arr.add("IdBranchOffice");
        return arr;
    }

    public static void setArr(ArrayList<String> arr) {
        Publicar.arr = arr;
    }

    @Override
    public String getNameClass() {
        return "Publicar";
        
    }

    @Override
    public void setColumn(TableView tabla) {
        ArrayList<String> arr2=new ArrayList<>();
         arr2.add("IdMagazine");arr2.add("IdBranchOffice");
         for(String atributo:arr2){
             TableColumn<Publicar, String> columna = new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
         }
    }

    @Override
    public void getRow(ResultSet s, ObservableList<Entidad> lista) throws SQLException {
        try{
        while (s.next()) {
                Publicar publicar = new Publicar(s.getInt(1),s.getString(2));
                lista.add(publicar);
            }
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    public Publicar(){
        
    }

    @Override
    public ArrayList<Object> getTiposDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
