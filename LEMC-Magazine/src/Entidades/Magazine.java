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

    public Magazine(int Id, String Periodicity, String title, String Type) {
        this.id = Id;
        this.Periodicity = Periodicity;
        this.title = title;
        this.Type = Type;
    }
    
    public static ArrayList<String> getArr(){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("id");arr.add("Periodicity");arr.add("Title");arr.add("Type");
        return arr;
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
    
}
