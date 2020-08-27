/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Lenovo
 */
public class Employee implements Entidad{
    private String DNI;
    private String Nombre;
    private String Apellido;
    private int Age;
    private String BornDate;
    private int AddressH;
    private String IdBranchOffice;
    
    public Employee(){
    }
    
    @Override
    public ArrayList<String> getArr(){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("DNI");arr.add("Nombre");arr.add("Apellido");arr.add("BornDate");
        arr.add("Age");arr.add("AddressH");arr.add("IdBranchOffice");
        return arr;
    }
    

    public Employee(String DNI, String nombre, String apellido, int Age,String bornDate,int addressH, String idBranchOffice) {
        this.DNI = DNI;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.BornDate=bornDate;
        this.Age = Age;
        this.AddressH = addressH;
        this.IdBranchOffice = idBranchOffice;
        
    }
    
    public void setColumn(TableView tabla) {
        ArrayList<String> arr=new ArrayList<>();
        arr.add("DNI");arr.add("Nombre");arr.add("Apellido");arr.add("Age");arr.add("BornDate");
        arr.add("AddressH");arr.add("IdBranchOffice");
        for (String atributo:arr) {
            TableColumn<Employee, String> columna = new TableColumn<>(atributo);
            columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
            tabla.getColumns().add(columna);
        }
    }
    
    public void getRow(ResultSet s,ObservableList<Entidad> lista)throws SQLException{
        try{
        while (s.next()) {
                Employee empleado = new Employee(s.getString(1), s.getString(2), s.getString(3), s.getInt(4), s.getString(5),
                        s.getInt(6), s.getString(7));
                lista.add(empleado);
            }
        }catch(SQLException ex){
            throw ex;
        }
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getBornDate() {
        return BornDate;
    }

    public void setBornDate(String bornDate) {
        this.BornDate = bornDate;
    }

    public int getAddressH() {
        return AddressH;
    }

    public void setAddressH(int addressH) {
        this.AddressH = addressH;
    }

    public String getIdBranchOffice() {
        return IdBranchOffice;
    }

    public void setIdBranchOffice(String idBranchOffice) {
        this.IdBranchOffice = idBranchOffice;
    }

    @Override
    public String getNameClass() {
        return "Employee";
    }
    
    
}
