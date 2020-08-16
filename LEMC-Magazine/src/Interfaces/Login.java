/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

/**
 *
 * @author Lenovo
 */
public class Login {
    
    private VBox root;
    private Label lblDescp;
    private TextField txfEmail;
    private TextField txfPswd;
    private Button btnLogin;
    
    public Login(){
        crearLogin();
    }
    
    public void crearLogin(){
        //root principal
        root= new VBox();
        //nodos hijos
        lblDescp = new Label("Login to LEMC System");
        txfEmail=new TextField();
        txfPswd=new TextField();
        btnLogin = new Button("Login");
        
        root.getChildren().addAll(lblDescp,txfEmail,txfPswd,btnLogin);
    }
    
    public VBox getRoot(){
        return this.root;
    }
    
    
}
