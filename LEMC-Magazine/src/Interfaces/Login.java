/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Connection.BDController;
import java.sql.ResultSet;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import Connection.ConectarBD2;
import Entidades.Employee;
import java.sql.SQLException;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import lemc.magazine.LEMCMagazine;
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
    private Label error;
    
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
        error=new Label();
        btnLogin = new Button("Login");
        btnLogin.setOnMouseClicked(e ->{
            if(getAdministers()) {
                Employee empleado = new Employee();
                TableView tabla = BDController.vistaTabla(empleado,"Select * From ");
                SistemaTablas st = new SistemaTablas(tabla,"Employee",empleado);
                LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
            }
        });
        root.getChildren().addAll(lblDescp,txfEmail,txfPswd,btnLogin,error);
    }
    
    public VBox getRoot(){
        return this.root;
    }
    
    private boolean getAdministers(){
        
        try{
            ResultSet conj=ConectarBD2.c.ejecutarQuery("select * from Administrator;");
            while(conj.next()){
                if(txfEmail.getText().equals(conj.getString(1))){
                    if(txfPswd.getText().equals(conj.getString(2))) return true;
                }else{
                    error.setText("El usuario o la contraseña es erroneo");
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }return false;
    }
    
    
}
