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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lemc.magazine.LEMCMagazine;

/**
 *
 * @author Lenovo
 */
public class FormularioInsert {
    private Entidad entidad;
    private BorderPane root;
    private VBox contenedorFormulario;
    private GridPane cntDatos;
    private String nombreClase;
    
    public FormularioInsert(String nombreClase,Entidad entidad,BorderPane bord){
        this.entidad = entidad;
        this.nombreClase = nombreClase;
        root=bord;
        contenedorFormulario=new VBox();
        cntDatos= new GridPane();
        crearCenter();
    }
    
    public void crearCenter(){
        cntDatos.setPadding(new Insets(20));
        cntDatos.setHgap(25);
        cntDatos.setVgap(15);
        Label titulo = new Label("Agregar Empleado");
        titulo.setId("titulo");
        for(int i=0;i<entidad.getArr().size();i++){
            Label lbl = new Label(entidad.getArr().get(i));
            TextField txf = new TextField();
            cntDatos.add(lbl, 0, i);
            cntDatos.add(txf, 1, i);
        }
        contenedorFormulario.getChildren().add(titulo);
        contenedorFormulario.getChildren().add(cntDatos);
        Button btnCerrar = new Button("Cerrar");
        Button btnInsertar = new Button("Insertar");
        HBox Botones= new HBox();
        Botones.getChildren().addAll(btnCerrar,btnInsertar);
        contenedorFormulario.getChildren().add(Botones);
        contenedorFormulario.setAlignment(Pos.CENTER);
        btnInsertar.setOnAction(e->{
            insertar(agarrarDatosField());
        });
        btnCerrar.setOnAction(e -> {
            root.setLeft(null);
        });
    }
    
    private void insertar(ArrayList<String> datosField){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO "+nombreClase+" VALUES(");
        for(int i = 0;i<datosField.size();i++){
            if(entidad.getTiposDatos().get(i) instanceof Integer){
                sb.append(datosField.get(i)+",");
                System.out.println(datosField.get(i));
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
        for(int i=1;i<cntDatos.getChildren().size();i=i+2){
            System.out.println(cntDatos.getChildren().getClass());
            TextField txf = (TextField) cntDatos.getChildren().get(i);
            System.out.println(txf.getText());
            arr.add(txf.getText());
        }
        return arr;
    }
    
    public VBox getRoot(){
        return this.contenedorFormulario;
    }    
    
}
