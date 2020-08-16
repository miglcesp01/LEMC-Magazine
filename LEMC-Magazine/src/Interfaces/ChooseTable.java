/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Lenovo
 */
public class ChooseTable {
    BorderPane root;
    Label lbl;

    public ChooseTable() {
    }
    
    public void crearMenu(){
        root = new BorderPane();
        //Top de la pantalla
        lbl = new Label("Elija la tabla que desea monitorear");
        
        //Primera fila
        Button btnEmployee = new Button("Employee");
        Button btnPhoneEmp = new Button("Phone Employee");
        Button btnAddress = new Button("Address");
        HBox primeraFila = new HBox();
        primeraFila.getChildren().addAll(btnAddress,btnEmployee,btnPhoneEmp);
        
        //Segunda Fila
        Button btnBranchOffice = new Button("Branch Office");
        Button btnPublicar = new Button("Publicar");
        Button btnPhoneoffice = new Button("Phone Office");
        HBox segundaFila = new HBox();
        segundaFila.getChildren().addAll(btnBranchOffice,btnPublicar,btnPhoneoffice);
        
        //Tercera Fila
        Button btnMagazine = new Button("Magazine");
        Button btnJournalist = new Button("Journalist"); 
        Button btnRedactar = new Button("Redactar");
        HBox terceraFila = new HBox();
        terceraFila.getChildren().addAll(btnMagazine,btnJournalist,btnRedactar);
        
        //Cuarta Fila
        Button btnPhonJournalist = new Button("Phone Journalist");
        Button btnSection = new Button("Section");
        Button btnCopy = new Button("Copy");
        HBox cuartaFila = new HBox();
        cuartaFila.getChildren().addAll(btnPhonJournalist,btnSection,btnCopy);
        
        //Agregando al root
        root.setTop(lbl);
        
    }
    
    
}
