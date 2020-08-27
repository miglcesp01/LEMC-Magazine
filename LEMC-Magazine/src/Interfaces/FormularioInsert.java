/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Connection.ConectarBD2;
import Entidades.Entidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Lenovo
 */
public class FormularioInsert {
    private BorderPane root;
    private Entidad entidad;
    private String nombreClase;
    
    public FormularioInsert(String nombreClase,Entidad entidad){
        this.nombreClase = nombreClase;
        this.entidad = entidad;
        root = new BorderPane();
        crearCenter();
    }
    
    public void crearCenter(){
        VBox contenedorFormulario = new VBox();
        for(String s:entidad.getArr()){
            Label lbl = new Label(s);
            TextField txf = new TextField();
            HBox contenedor = new HBox(lbl,txf);
            contenedor.setSpacing(20);
            contenedorFormulario.getChildren().add(contenedor);
        }
        Button btnInsertar = new Button("Insertar");
        contenedorFormulario.getChildren().add(btnInsertar);
        root.setCenter(contenedorFormulario);
    }
    
    private ArrayList<String> agarrarDatosField(){
        ArrayList<String> arr = new ArrayList<>();
        VBox contenedorFormulario = (VBox) root.getCenter();
        for(Node c : contenedorFormulario.getChildren()){
            HBox contenedor = (HBox)c;
            TextField txf = (TextField) contenedor.getChildren().get(1);
            arr.add(txf.getText());
        }
        return arr;
    }
    
    
    
    public BorderPane getRoot(){
        return this.root;
    }    
    
}
