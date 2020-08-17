/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import lemc.magazine.LEMCMagazine;

/**
 *
 * @author Lenovo
 */
public class SistemaTablas {
    private BorderPane  root;
    private TableView tabla;
    
    public SistemaTablas(TableView tabla,String nombreClase){
     root = new BorderPane();
     this.tabla = tabla;
     crearTop(nombreClase);
     crearMain();
     crearBottom();
    }
    
    private void crearTop(String tabla){
        Label lbl = new Label("Tabla Monitoreada: "+tabla);
        root.setTop(lbl);
    }
    
    private void crearMain(){
        root.setCenter(tabla);
    }
    
    private void crearBottom(){
        Button btnSalir = new Button("Salir");
        root.setBottom(btnSalir);
        
        btnSalir.setOnAction(e->{
            ChooseTable ct = new ChooseTable();
            LEMCMagazine.primaryStage.setScene(new Scene(ct.getRoot(),500,500));
        });
    }    
    public BorderPane getRoot(){
        return root;
    }
    
}
