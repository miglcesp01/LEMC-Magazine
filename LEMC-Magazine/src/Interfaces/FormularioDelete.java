/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Connection.BDController;
import Connection.ConectarBD2;
import Entidades.Entidad;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FormularioDelete {
    private VBox root;
    private Entidad entidad;
    private String nombreClase;
    
    public FormularioDelete(String nombreClase,Entidad entidad){
        this.nombreClase = nombreClase;
        this.entidad = entidad;
        root = new VBox();
        crearCenter();
    }
    
    private void crearCenter(){
        HBox contenedorFormulario = new HBox();
        Label id = new Label("Inserte La cedula de la persona que desea eliminar");
        TextField txf = new TextField();
        Button btn  = new Button("Eliminar");
        contenedorFormulario.getChildren().addAll(id,txf,btn);
        root.getChildren().add(contenedorFormulario);
         btn.setOnAction(e->{
            try {
                eliminar(txf.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FormularioDelete.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
    }
    
    private void eliminar(String clave) throws SQLException{
        StringBuilder sb = new StringBuilder();
        String primary = entidad.getArr().get(0);
        sb.append("Delete from "+ nombreClase +" where "+primary+"="+clave+";");
        Object primaryDato = entidad.getTiposDatos().get(0);
        if(primaryDato instanceof Integer){
            HBox contenedor = (HBox) root.getChildren().get(0);
            TextField txf = (TextField) contenedor.getChildren().get(1);
            sb.append(txf.getText()+";");
        }
        
        try{
            System.out.println(ConectarBD2.ejecutarDelete(sb.toString()));
            TableView tabla = BDController.vistaTabla(entidad,"Select * From ");
            SistemaTablas st = new SistemaTablas(tabla,"Employee",entidad);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(),500,500));
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public VBox getRoot(){
        return this.root;
    }
}
