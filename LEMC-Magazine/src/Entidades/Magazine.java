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
public class Magazine {
    private int id;
    private String Periodicity;
    private String title;   
    private String Type;
    private static ArrayList<String> arr;

    public Magazine(int Id, String Periodicity, String title, String Type) {
        this.id = Id;
        this.Periodicity = Periodicity;
        this.title = title;
        this.Type = Type;
    }
    
    public static ArrayList<String> getArr(){
        arr = new ArrayList<>();
        arr.add("id");arr.add("Periodicity");arr.add("Title");arr.add("Type");
        return arr;
    }
    
}
