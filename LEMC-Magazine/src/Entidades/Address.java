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
public class Address implements Entidad {
    private int Id_Address;
    private String Numero;
    private String Ciudad;
    private String Calle;
    private static ArrayList<String> arr;
    
    public Address(){
        
    }

    public Address(int Id_Address, String Numero, String Ciudad, String Calle) {
        this.Id_Address = Id_Address;
        this.Numero = Numero;
        this.Ciudad = Ciudad;
        this.Calle = Calle;
    }

    public int getId_Address() {
        return Id_Address;
    }

    public void setId_Address(int Id_Address) {
        this.Id_Address = Id_Address;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public ArrayList<String> getArr() {
        arr = new ArrayList<>();
        arr.add("Id_Address");arr.add("Numero");arr.add("Ciudad");arr.add("Calle");
        return Address.arr;
    }

    public static void setArr(ArrayList<String> arr) {
        Address.arr = arr;
    }

    @Override
    public String getNameClass() {
        return "Address";
    }

    @Override
    public void setColumn(TableView tabla) {
        ArrayList<String> arr2=new ArrayList<>();
         arr2.add("Id_Address");arr2.add("Numero");arr2.add("Ciudad");arr2.add("Calle");
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
                Address direccion = new Address(s.getInt(1),s.getString(2),s.getString(3),s.getString(4));
                lista.add(direccion);
            }
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    
}
