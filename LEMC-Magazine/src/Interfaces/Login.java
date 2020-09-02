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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import lemc.magazine.LEMCMagazine;
import javafx.geometry.Insets;

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

    public Login() {
        crearLogin();
    }

    public void crearLogin() {
        //root principal
        root = new VBox();
        //nodos hijos
        root.setPadding(new Insets(10, 20, 10, 20));

        try {
            Image img1 = new Image(new FileInputStream("src/images/pngwave.png"), 100, 50, false, true);
            ImageView imgView = new ImageView();
            imgView.setImage(img1);
            //root.setTop(imgView);
            root.getChildren().add(imgView);
            root.setAlignment(Pos.CENTER);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no existe");;
        }

        GridPane grid = new GridPane();
        VBox group = new VBox();
        Label user = new Label("User: ");
        Label pass = new Label("Pass: ");
        lblDescp = new Label("Login to LEMC System");
        txfEmail = new TextField();
        txfPswd = new TextField();
        error = new Label();
        btnLogin = new Button("Login");
        btnLogin.setOnMouseClicked(e -> {
            if (getAdministers()) {
                Employee empleado = new Employee();
                TableView tabla = BDController.vistaTabla(empleado, "Select * From ");
                SistemaTablas st = new SistemaTablas(tabla, "Employee", empleado);
                LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(), 500, 500));
            }
        });
        //root.getChildren().addAll(lblDescp,txfEmail,txfPswd,btnLogin,error);
        grid.setVgap(5);
        grid.setHgap(5);
        grid.add(user, 0, 0);
        grid.add(txfEmail, 1, 0);
        grid.add(pass, 0, 1);
        grid.add(txfPswd, 1, 1);

        group.getChildren().addAll(lblDescp, grid);
        group.setAlignment(Pos.CENTER);
        //root.setCenter(group);
        btnLogin.setAlignment(Pos.CENTER);
        //root.setBottom(btnLogin);
        root.getChildren().addAll(lblDescp,grid,btnLogin,error);

    }

    public VBox getRoot() {
        return this.root;
    }

    private boolean getAdministers() {

        try {
            ResultSet conj = ConectarBD2.c.ejecutarQuery("select * from Administrator;");
            while (conj.next()) {
                if (txfEmail.getText().equals(conj.getString(1))) {
                    if (txfPswd.getText().equals(conj.getString(2))) {
                        return true;
                    }
                } else {
                    error.setText("El usuario o la contraseña es erroneo");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
