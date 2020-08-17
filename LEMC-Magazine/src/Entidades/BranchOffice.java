/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class BranchOffice {
    
    private String Id;
    private String Email;
    private int Address;

    public BranchOffice(String Id, String Email, int Address) {
        this.Id = Id;
        this.Email = Email;
        this.Address = Address;
    }

    public static ArrayList<String> getArr() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Id");arr.add("Email");arr.add("Address");
        return arr;
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
  
    
    
    
    
}
