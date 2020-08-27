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
            Employee empleado = new Employee();
            TableView tabla = BDController.vistaTabla(empleado,"Select * From ");
            SistemaTablas st = new SistemaTablas(tabla,"Employee",empleado);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        
        Button btnPhoneEmp = new Button("Phone Employee");
        btnPhoneEmp.setOnAction(e->{
            PhoneEmployee pe = new PhoneEmployee();
            TableView tabla = BDController.vistaTabla(pe,"Select * From ");
            SistemaTablas st = new SistemaTablas(tabla,"Phone Employee",pe);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        Button btnAddress = new Button("Address");
        btnAddress.setOnAction(e->{
            Address a = new Address();
            TableView tabla = BDController.vistaTabla(a,"Select * From ");
            SistemaTablas st = new SistemaTablas(tabla,"Address",a);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        HBox primeraFila = new HBox();
        primeraFila.setSpacing(40);
        primeraFila.getChildren().addAll(btnAddress,btnEmployee,btnPhoneEmp);
        
        //Segunda Fila
        Button btnBranchOffice = new Button("Branch Office");
        btnBranchOffice.setOnAction(e->{
            BranchOffice b = new BranchOffice();
            TableView tabla = BDController.vistaTabla(b,"Select * From ");
            SistemaTablas st = new SistemaTablas(tabla,"BranchOffice",b);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        
        Button btnPublicar = new Button("Publicar");
        btnPublicar.setOnAction(e->{
            Publicar p = new Publicar();
            TableView tabla = BDController.vistaTabla(p,"Select * From ");
            SistemaTablas st = new SistemaTablas(tabla,"Publicar",p);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        Button btnPhoneoffice = new Button("Phone Office");
        btnPhoneoffice.setOnAction(e->{
            PhoneBranchOffice pb = new PhoneBranchOffice();
            TableView tabla = BDController.vistaTabla(pb,"Select * From ");
            SistemaTablas st = new SistemaTablas(tabla,"PhoneBranchOffice",pb);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        HBox segundaFila = new HBox();
        segundaFila.setSpacing(40);
        segundaFila.getChildren().addAll(btnBranchOffice,btnPublicar,btnPhoneoffice);
        
        //Tercera Fila
        Button btnMagazine = new Button("Magazine");
        btnMagazine.setOnAction(e->{
            Magazine m = new Magazine();
            TableView tabla = BDController.vistaTabla(m,"Select * FROM ");
            SistemaTablas st = new SistemaTablas(tabla,"Magazine",m);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        Button btnJournalist = new Button("Journalist"); 
        btnJournalist.setOnAction(e->{
            Journalist  j = new Journalist();
            TableView tabla = BDController.vistaTabla(j,"Select * FROM ");
            SistemaTablas st = new SistemaTablas(tabla,"Journalist",j);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        Button btnRedactar = new Button("Redactar");
        btnRedactar.setOnAction(e->{
            Redactar r = new Redactar();
            TableView tabla = BDController.vistaTabla(r,"Select * FROM ");
            SistemaTablas st = new SistemaTablas(tabla,"Redactar",r);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        HBox terceraFila = new HBox();
        terceraFila.setSpacing(40);
        terceraFila.getChildren().addAll(btnMagazine,btnJournalist,btnRedactar);
        
        //Cuarta Fila
        Button btnPhoneJournalist = new Button("Phone Journalist");
        btnPhoneJournalist.setOnAction(e->{
            PhoneJournalist pj = new PhoneJournalist();
            TableView tabla = BDController.vistaTabla(pj,"Select * FROM ");
            SistemaTablas st = new SistemaTablas(tabla,"PhoneJournalist",pj);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        Button btnSection = new Button("Section");
        btnSection.setOnAction(e->{
            Section s = new Section();
            TableView tabla = BDController.vistaTabla(s,"Select * FROM ");
            SistemaTablas st = new SistemaTablas(tabla,"Section",s);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        });
        Button btnCopy = new Button("Copy");
        btnCopy.setOnAction(e->{
            Copy c = new Copy();
            TableView tabla = BDController.vistaTabla(c,"Select * FROM ");
            SistemaTablas st = new SistemaTablas(tabla,"Copy",c);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
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
