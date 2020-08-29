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
public class Journalist implements Entidad{
    
    private String DNI;
    private String Nombre;
    private String Apellido;
    private int Age;
    private String bornDate;
    private int AddressH;
    private String Speciality;
    private static ArrayList<String> arr;

    public Journalist(String DNI, String Nombre, String Apellido, int Age, String bornDate, int AddressH, String Speciality) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Age = Age;
        this.bornDate = bornDate;
        this.AddressH = AddressH;
        this.Speciality = Speciality;
    }
    
    /**
     *
     * @return
     */
    @Override
    public ArrayList<String> getArr(){
        arr = new ArrayList<>();
        arr.add("DNI");arr.add("Nombre");arr.add("Apellido");arr.add("Age");arr.add("BornDate");
        arr.add("AddressH");arr.add("Speciality");
        return arr;
    }

    @Override
    public String getNameClass() {
        return "Journalist";
    }

    @Override
    public void setColumn(TableView tabla) {
        ArrayList<String> arr2=new ArrayList<>();
         arr2.add("DNI");arr2.add("Nombre");arr2.add("Apellido");arr2.add("Age");arr2.add("BornDate");
        arr2.add("AddressH");arr2.add("Speciality");
         for(String atributo:arr2){
             TableColumn<Journalist, String> columna = new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
         }
    }

    @Override
    public void getRow(ResultSet s, ObservableList<Entidad> lista) throws SQLException {
        try{
        while (s.next()) {
                Journalist periodista = new Journalist(s.getString(1),s.getString(2),s.getString(3),s.getInt(4),s.getString(5),
                        s.getInt(6),s.getString(7));
                lista.add(periodista);
            }
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    public Journalist(){
        
    }

    @Override
    public ArrayList<Object> getTiposDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
