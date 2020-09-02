/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemc.magazine;

import Connection.BDController;
import Connection.ConectarBD2;
import Interfaces.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Connection.ConectarBD2;
import Entidades.Employee;
import Interfaces.Consultar;
import Interfaces.SistemaTablas;
/**
 *
 * @author Lenovo
 */
public class LEMCMagazine extends Application{
    
    public static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Login login = new Login();
        Employee empleado = new Employee();
        TableView tabla = BDController.vistaTabla(empleado,"Select * From ");
        SistemaTablas st = new SistemaTablas(tabla,"Employee",empleado);
        primaryStage = stage;
        Scene sc = new Scene(login.getRoot(), 300, 250);
        sc.getStylesheets().clear();
        sc.getStylesheets().add("css/estilos.css");
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
