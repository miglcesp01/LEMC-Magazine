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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import lemc.magazine.LEMCMagazine;
import static lemc.magazine.LEMCMagazine.primaryStage;

/**
 *
 * @author Lenovo
 */
public class SistemaTablas {

    private BorderPane root;
    private TableView tabla;
    private String nombreTabla;
    private Entidad entidad;

    public SistemaTablas(TableView tabla, String nombreClase, Entidad entidad) {
        root = new BorderPane();
        this.tabla = tabla;
        this.nombreTabla = nombreClase;
        crearTop();
        crearMain();
        crearBottom();
        this.entidad = entidad;
    }

    private void crearTop() {
        Label lbl = new Label("Tabla " + nombreTabla);
        lbl.setId("Titulo");
        lbl.setAlignment(Pos.CENTER);
        root.setTop(lbl);
    }

    private void crearMain() {
        root.setCenter(tabla);
    }

    private void crearBottom() {
        HBox rootBottom = new HBox();
        Button btnInsertInto = new Button("Insertar Tupla");
        Button btnDelete = new Button("Eliminar Tupla");
        Button btnUpdate = new Button("Actualizar");
        Button btnSalir = new Button("Salir");
        rootBottom.getChildren().addAll(btnSalir, btnDelete, btnUpdate, btnInsertInto);
        rootBottom.setSpacing(40);

        rootBottom.setAlignment(Pos.CENTER);
        rootBottom.setPadding(new Insets(10, 10, 0, 10));
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setBottom(rootBottom);

        //Acciones de los botones
        btnSalir.setOnAction(e -> {
            Login f = new Login();
            Scene sc = new Scene(f.getRoot(),300,250);
            sc.getStylesheets().clear();
            sc.getStylesheets().add("css/estilos.css");
            primaryStage.setTitle("LEMC Magazine");
            primaryStage.setScene(sc);
            primaryStage.show();
        });

        btnInsertInto.setOnAction(e -> {
            FormularioInsert fi = new FormularioInsert(nombreTabla, entidad);
            root.getChildren().clear();
            crearTop();
            root.setCenter(fi.getRoot());
        });
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
        btnUpdate.setOnAction(e -> {
            try {
                Employee empleado = (Employee) tabla.getSelectionModel().getSelectedItem();
                crearContenidoDerecho(empleado);
            } catch (java.lang.NullPointerException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Edicion de persona");
                alert.setContentText("Seleccione una persona");

                alert.showAndWait();
            }

        });
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setCentro(Node nodo) {
        root.setCenter(nodo);
    }

    private void eliminar(Employee empleado) throws SQLException {
        StringBuilder sb = new StringBuilder();
        String primary = entidad.getArr().get(0);
        sb.append("Delete from " + empleado.getNameClass() + " where " + primary + "=" + empleado.getDNI() + ";");
        try {
            System.out.println(ConectarBD2.ejecutarDelete(sb.toString()));
            TableView tabla = BDController.vistaTabla(entidad, "Select * From ");
            SistemaTablas st = new SistemaTablas(tabla, "Employee", entidad);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(), 500, 500));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void crearContenidoDerecho(Employee empleado) {
        VBox form1 = new VBox(5);
        Label titulo = new Label("Edicion de empleado");
        titulo.setId("titulo");

        GridPane cntDatos = new GridPane();
        cntDatos.setPadding(new Insets(20));
        cntDatos.setHgap(25);
        cntDatos.setVgap(15);

        Label lblCedula = new Label("DNI");
        TextField txtCedula = new TextField(empleado.getDNI());
        txtCedula.setDisable(true);
        cntDatos.add(lblCedula, 0, 0);
        cntDatos.add(txtCedula, 1, 0);

        Label lblNombres = new Label("Nombres");
        TextField txtNombres = new TextField(empleado.getNombre());
        cntDatos.add(lblNombres, 0, 1);
        cntDatos.add(txtNombres, 1, 1);

        Label lblApellidos = new Label("Apellidos");
        TextField txtApellidos = new TextField(empleado.getApellido());
        cntDatos.add(lblApellidos, 0, 2);
        cntDatos.add(txtApellidos, 1, 2);
        cntDatos.setAlignment(Pos.CENTER);

        Label lblBranchOffice = new Label("IdBranchOffice");
        TextField txtBranchOffice = new TextField(empleado.getIdBranchOffice());
        cntDatos.add(lblBranchOffice, 0, 3);
        cntDatos.add(txtBranchOffice, 1, 3);
        cntDatos.setAlignment(Pos.CENTER);

        HBox cntBotones = new HBox(5);
        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            Employee EmpleadoModificado = new Employee(txtCedula.getText(), txtNombres.getText(), txtApellidos.getText(), txtBranchOffice.getText());
            try {
                actualizar(EmpleadoModificado);
                actualizarTableView();
                root.setRight(new VBox());
            } catch (SQLException ex) {
                Logger.getLogger(SistemaTablas.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> {
            root.setRight(null);
        });
        cntBotones.getChildren().addAll(btnGuardar, btnCerrar);
        cntBotones.setAlignment(Pos.CENTER);

        form1.getChildren().addAll(titulo, cntDatos, cntBotones);
        form1.setAlignment(Pos.CENTER);

        root.setRight(form1);

    }

    public void actualizarTableView() {
        TableView tabla = BDController.vistaTabla(entidad, "Select * From ");
        SistemaTablas st = new SistemaTablas(tabla, "Employee", entidad);
        Scene scene = new Scene(st.getRoot(), 550, 650);
        scene.getStylesheets().clear();
        scene.getStylesheets().add("css/estilos.css");
        primaryStage.setTitle("LEMC Magazine");
        primaryStage.setScene(scene);

    }

    private void actualizar(Employee empleado) throws SQLException {
        StringBuilder sb = new StringBuilder();
        String primary = entidad.getArr().get(0);
        String nombre = entidad.getArr().get(1);
        System.out.println(nombre);
        sb.append("Update " + empleado.getNameClass() + " Set nombre = '" + empleado.getNombre() + "' ,apellido = '" + empleado.getApellido() + "' , idBranchOfficeE = '" + empleado.getIdBranchOffice() + "' Where DNI = " + empleado.getDNI() + ";");
        try {
            System.out.println(ConectarBD2.ejecutarDelete(sb.toString()));
            TableView tabla = BDController.vistaTabla(entidad, "Select * From ");
            SistemaTablas st = new SistemaTablas(tabla, "Employee", entidad);
            LEMCMagazine.primaryStage.setScene(new Scene(st.getRoot(), 500, 500));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
