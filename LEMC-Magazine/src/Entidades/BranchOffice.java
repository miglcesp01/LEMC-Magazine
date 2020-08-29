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
import javafx.print.Collation;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Lenovo
 */
public class BranchOffice implements Entidad {

    private String Id;
    private String Email;
    private int Address;

    public BranchOffice() {
    }

    public BranchOffice(String Id, String Email, int Address) {
        this.Id = Id;
        this.Email = Email;
        this.Address = Address;
    }

    public void setColumn(TableView tabla) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Id");
        arr.add("Email");
        arr.add("Address");
        for (String atributo:arr) {
            TableColumn<Employee, String> columna = new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
        }
    }
    
    @Override
    public ArrayList<String> getArr(){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Id");
        arr.add("Email");
        arr.add("Address");
        return arr;
    }

    @Override
    public void getRow(ResultSet s,ObservableList<Entidad> lista) throws SQLException{
        try{
        while (s.next()) {
                BranchOffice oficina = new BranchOffice(s.getString(1), s.getString(2), s.getInt(3));
                lista.add(oficina);
            }
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getAddress() {
        return Address;
    }

    public void setAddress(int Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "BranchOffice{" + "Id=" + Id + ", Email=" + Email + ", Address=" + Address + '}';
    }

    @Override
    public String getNameClass() {
        return "BranchOffice";
    }

    @Override
    public ArrayList<Object> getTiposDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
