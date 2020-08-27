/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Lenovo
 */
public class Magazine implements Entidad {

    private int id;
    private String Periodicity;
    private String title;
    private String Type;

    public Magazine() {
    }

    public Magazine(int Id, String Periodicity, String title, String Type) {
        this.id = Id;
        this.Periodicity = Periodicity;
        this.title = title;
        this.Type = Type;
    }
    
    @Override
    public ArrayList<String> getArr() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("id");
        arr.add("Periodicity");
        arr.add("Title");
        arr.add("Type");
        return arr;
    }

    public void setColumn(TableView tabla) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("id");
        arr.add("Periodicity");
        arr.add("Title");
        arr.add("Type");
        for (String atributo : arr) {
            TableColumn<Employee, String> columna = new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
        }
    }

    public void getRow(ResultSet s,ObservableList<Entidad> lista)throws SQLException {
        try {
            while (s.next()) {
                Magazine revista = new Magazine(s.getInt(1), s.getString(2), s.getString(3), s.getString(4));
                lista.add(revista);
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodicity() {
        return Periodicity;
    }

    public void setPeriodicity(String Periodicity) {
        this.Periodicity = Periodicity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    @Override
    public String getNameClass() {
        return "Magazine";
    }

    

}
