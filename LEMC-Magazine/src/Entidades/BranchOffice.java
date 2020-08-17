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
    private static ArrayList<String> arr;

    public BranchOffice(String Id, String Email, int Address) {
        this.Id = Id;
        this.Email = Email;
        this.Address = Address;
    }

    public static ArrayList<String> getArr() {
        arr = new ArrayList<>();
        arr.add("Id");arr.add("Email");arr.add("Address");
        return arr;
    }

    public static void setArr(ArrayList<String> arr) {
        BranchOffice.arr = arr;
    }
    
    
    
    
    
    
}
