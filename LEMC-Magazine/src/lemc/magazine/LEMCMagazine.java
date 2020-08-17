/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemc.magazine;

import Connection.ConectarBD2;
import Interfaces.ChooseTable;
import Interfaces.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Connection.ConectarBD2;
import Interfaces.Consultar;
/**
 *
 * @author Lenovo
 */
public class LEMCMagazine extends Application{
    
    public static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        ConectarBD2.c.conectar();
        Login login = new Login();
        ChooseTable ct = new ChooseTable();
        primaryStage = stage;
        Scene sc = new Scene(ct.getRoot(),500,500);
        primaryStage.setTitle("LEMC Magazine");
        primaryStage.setScene(sc);
        primaryStage.show();
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    
    
}
