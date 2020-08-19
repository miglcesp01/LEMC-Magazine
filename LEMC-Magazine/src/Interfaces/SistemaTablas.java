/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import lemc.magazine.LEMCMagazine;

/**
 *
 * @author Lenovo
 */
public class SistemaTablas {
    private BorderPane  root;
    private TableView tabla;
    private String nombreTabla;
    
    public SistemaTablas(TableView tabla,String nombreClase){
     root = new BorderPane();
     this.tabla = tabla;
     this.nombreTabla = nombreClase;
     crearTop();
     crearMain();
     crearBottom();
    }
    
    private void crearTop(){
        Label lbl = new Label("Tabla Monitoreada: "+nombreTabla);
        root.setTop(lbl);
    }
    
    private void crearMain(){
        root.setCenter(tabla);
    }
    
    private void crearBottom(){
        HBox rootBottom = new HBox();
        Button btnInsertInto = new Button("Insertar Tupla");
        Button btnDelete = new Button("Eliminar Tupla");
        Button btnUpdate  = new Button("Actualizar");
        Button btnSalir = new Button("Salir");
        rootBottom.getChildren().addAll(btnSalir,btnDelete,btnUpdate,btnInsertInto);
        rootBottom.setSpacing(40);
        
        root.setBottom(rootBottom);
        
        //Acciones de los botones
        btnSalir.setOnAction(e->{
            ChooseTable ct = new ChooseTable();
            LEMCMagazine.primaryStage.setScene(new Scene(ct.getRoot(),500,500));
        });
        
        btnInsertInto.setOnAction(e->{
           FormularioInsert fi = new FormularioInsert(nombreTabla);
            root.setCenter(fi.getRoot());
           
           //LEMCMagazine.primaryStage.setScene(new Scene(fi.getRoot(),500,500));
        });
    }    
    public BorderPane getRoot(){
        return root;
    }
    
    public void setCentro(Node nodo){
        root.setCenter(nodo);
    }
    
}
