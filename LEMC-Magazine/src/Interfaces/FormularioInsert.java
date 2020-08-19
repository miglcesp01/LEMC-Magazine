/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Entidad;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Lenovo
 */
public class FormularioInsert {
    private BorderPane root;
    
    public FormularioInsert(String nombreClase){
        root = new BorderPane();
        crearMain();
    }
    
    public void crearMain(){
        Label lbl = new Label("Prueba seteando el root");
        root.setCenter(lbl);
    }
    
    
    
    public BorderPane getRoot(){
        return this.root;
    }    
    
}
