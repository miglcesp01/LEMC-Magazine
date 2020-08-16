/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Employee {
    private String DNI;
    private String Nombre;
    private String Apellido;
    private int Age;
    private String BornDate;
    private int AddressH;
    private String IdBranchOffice;
    private static ArrayList<String> arr = new ArrayList<>();
    

    public Employee(String DNI, String nombre, String apellido, int Age,String bornDate,int addressH, String idBranchOffice) {
        this.DNI = DNI;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.BornDate=bornDate;
        this.Age = Age;
        this.AddressH = addressH;
        this.IdBranchOffice = idBranchOffice;
        
    }
    
    public static ArrayList<String> getArr(){
        arr.add("DNI");arr.add("Nombre");arr.add("Apellido");arr.add("Age");arr.add("BornDate");
        arr.add("AddressH");arr.add("IdBranchOffice");
        return Employee.arr;
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
    
    
    
}
