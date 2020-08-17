/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Connection.BDController;
import Entidades.Address;
import Entidades.BranchOffice;
import Entidades.Copy;
import Entidades.Employee;
import Entidades.Journalist;
import Entidades.Magazine;
import Entidades.PhoneBranchOffice;
import Entidades.PhoneEmployee;
import Entidades.PhoneJournalist;
import Entidades.Publicar;
import Entidades.Redactar;
import Entidades.Section;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lemc.magazine.LEMCMagazine;

/**
 *
 * @author Lenovo
 */
public class ChooseTable {
    BorderPane root;
    Label lbl;

    public ChooseTable() {
        crearMenu();
    }
    
    public void crearMenu(){
        root = new BorderPane();
        VBox rootCenter = new VBox();
        rootCenter.setSpacing(40);
        Button btnSalir = new Button("Salir");
        //Top de la pantalla
        lbl = new Label("¿Qué acción desea realizar?");
        //Primera fila
        Button btnEmployee = new Button("Employee");
        btnEmployee.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new Employee(),"Select * From ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        Button btnPhoneEmp = new Button("Phone Employee");
        btnPhoneEmp.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new PhoneEmployee(),"Select * From ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        Button btnAddress = new Button("Address");
        btnAddress.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new Address(),"Select * From ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        HBox primeraFila = new HBox();
        primeraFila.setSpacing(40);
        primeraFila.getChildren().addAll(btnAddress,btnEmployee,btnPhoneEmp);
        
        //Segunda Fila
        Button btnBranchOffice = new Button("Branch Office");
        btnBranchOffice.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new BranchOffice(),"Select * From ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        
        Button btnPublicar = new Button("Publicar");
        btnPublicar.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new Publicar(),"Select * From ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        Button btnPhoneoffice = new Button("Phone Office");
        btnPhoneoffice.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new PhoneBranchOffice(),"Select * From ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        HBox segundaFila = new HBox();
        segundaFila.setSpacing(40);
        segundaFila.getChildren().addAll(btnBranchOffice,btnPublicar,btnPhoneoffice);
        
        //Tercera Fila
        Button btnMagazine = new Button("Magazine");
        btnMagazine.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new Magazine(),"Select * FROM ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        Button btnJournalist = new Button("Journalist"); 
        btnJournalist.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new Journalist(),"Select * FROM ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        Button btnRedactar = new Button("Redactar");
        btnRedactar.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new Redactar(),"Select * FROM ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        HBox terceraFila = new HBox();
        terceraFila.setSpacing(40);
        terceraFila.getChildren().addAll(btnMagazine,btnJournalist,btnRedactar);
        
        //Cuarta Fila
        Button btnPhoneJournalist = new Button("Phone Journalist");
        btnPhoneJournalist.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new PhoneJournalist(),"Select * FROM ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        Button btnSection = new Button("Section");
        btnSection.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new Section(),"Select * FROM ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        Button btnCopy = new Button("Copy");
        btnCopy.setOnAction(e->{
            TableView tabla = BDController.vistaTabla(new Copy(),"Select * FROM ");
            LEMCMagazine.primaryStage.setScene(new Scene(tabla,500,500));
        });
        HBox cuartaFila = new HBox();
        cuartaFila.setSpacing(40);
        cuartaFila.getChildren().addAll(btnPhoneJournalist,btnSection,btnCopy);
        
        //Agregando al root
        rootCenter.getChildren().addAll(primeraFila,segundaFila,terceraFila,cuartaFila);
        root.setTop(lbl);
        root.setCenter(rootCenter);
        root.setBottom(btnSalir);

        rootCenter.setSpacing(20);
        /*Button ing=new Button("Insertar datos");
        Button mod=new Button("Modificar datos");
        Button elm=new Button("Eliminar datos");
        
        
        rootCenter.getChildren().addAll(ing,mod,elm);
*/
        btnSalir.setOnMouseClicked(e->{ 
                Login f=new Login();
                LEMCMagazine.primaryStage.setScene(new Scene(f.getRoot(),500,500));
        });
    }
    
    public BorderPane getRoot(){
        return this.root;
    }
    
    
}
