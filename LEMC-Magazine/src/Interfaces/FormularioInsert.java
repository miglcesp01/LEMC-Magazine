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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lemc.magazine.LEMCMagazine;

/**
 *
 * @author Lenovo
 */
public class FormularioInsert {
    private BorderPane root;
    private Entidad entidad;
    private String nombreClase;
    
    public FormularioInsert(String nombreClase,Entidad entidad){
        this.nombreClase = nombreClase;
        this.entidad = entidad;
        root = new BorderPane();
        crearCenter();
    }
    
    public void crearCenter(){
        VBox contenedorFormulario = new VBox();
        for(String s:entidad.getArr()){
            Label lbl = new Label(s);
            TextField txf = new TextField();
            HBox contenedor = new HBox(lbl,txf);
            contenedor.setSpacing(20);
            contenedorFormulario.getChildren().add(contenedor);
        }
        Button btnInsertar = new Button("Insertar");
        contenedorFormulario.getChildren().add(btnInsertar);
        root.setCenter(contenedorFormulario);
        btnInsertar.setOnAction(e->{
            insertar(agarrarDatosField());
            
        });
    }
    
    private void insertar(ArrayList<String> datosField){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO "+nombreClase+" VALUES(");
        for(int i = 0;i<datosField.size();i++){
            if(entidad.getTiposDatos().get(i) instanceof Integer){
                sb.append(datosField.get(i)+",");
            }else{
                sb.append("'"+datosField.get(i)+"',");
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(");");
        try{
            System.out.println(ConectarBD2.ejecutarInsert(sb.toString()));
            TableView tabla = BDController.vistaTabla(entidad,"Select * From ");
            SistemaTablas st = new SistemaTablas(tabla,"Employee",entidad);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        }catch(SQLException h){
            System.out.println(h.getMessage());
        }
    }
    
    private ArrayList<String> agarrarDatosField(){
        ArrayList<String> arr = new ArrayList<>();
        VBox contenedorFormulario = (VBox) root.getCenter();
        for(int i=0;i<contenedorFormulario.getChildren().size()-1;i++){
            HBox contenedor = (HBox)contenedorFormulario.getChildren().get(i);
            TextField txf = (TextField) contenedor.getChildren().get(1);
            arr.add(txf.getText());
        }
        return arr;
    }
    
    
    
    public BorderPane getRoot(){
        return this.root;
    }    
    
}
