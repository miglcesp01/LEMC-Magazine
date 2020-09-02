/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Connection.BDController;
import Connection.ConectarBD2;
import Entidades.Employee;
import Entidades.Entidad;
import java.sql.SQLException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import lemc.magazine.LEMCMagazine;

/**
 *
 * @author Lenovo
 */
public class SistemaTablas {
    private BorderPane  root;
    private TableView tabla;
    private String nombreTabla;
    private Entidad entidad;
    
    public SistemaTablas(TableView tabla,String nombreClase,Entidad entidad){
     root = new BorderPane();
     this.tabla = tabla;
     this.nombreTabla = nombreClase;
     crearTop();
     crearMain();
     crearBottom();
     this.entidad = entidad;
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
            Login f=new Login();
            LEMCMagazine.primaryStage.setScene(new Scene(f.getRoot(),500,500));
        });
        
        btnInsertInto.setOnAction(e->{
           FormularioInsert fi = new FormularioInsert(nombreTabla,entidad);
            root.getChildren().clear();
            crearTop();
            root.setCenter(fi.getRoot());
           //LEMCMagazine.primaryStage.setScene(new Scene(fi.getRoot(),500,500));
        });
        
        /**btnDelete.setOnAction(e->{
            FormularioDelete fd = new FormularioDelete(nombreTabla, entidad);
            root.getChildren().clear();
            crearTop();
            root.setCenter(fd.getRoot());
        });**/
        btnDelete.setOnAction(e -> {

            Employee empleado = (Employee) tabla.getSelectionModel().getSelectedItem();

            if (empleado != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Eliminar persona");
                alert.setContentText("Esta seguro de querer eliminar a esta persona?");
                alert.showAndWait();

                if (alert.getResult().getText().equalsIgnoreCase("ok")) {
                    try {
                        eliminar(empleado);
                    } catch (SQLException ex) {
                        Logger.getLogger(SistemaTablas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });
    }
    
    public BorderPane getRoot(){
        return root;
    }
    
    public void setCentro(Node nodo){
        root.setCenter(nodo);
    }
    private void eliminar(Employee empleado) throws SQLException{
        StringBuilder sb = new StringBuilder();
        String primary = entidad.getArr().get(0);
        sb.append("Delete from "+ empleado.getNameClass()+" where "+primary+"="+empleado.getDNI()+";");
        try{
            System.out.println(ConectarBD2.ejecutarDelete(sb.toString()));
            TableView tabla = BDController.vistaTabla(entidad,"Select * From ");
            SistemaTablas st = new SistemaTablas(tabla,"Employee",entidad);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
}
