/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Entidades.BranchOffice;
import Entidades.Employee;
import Entidades.Magazine;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Lenovo
 */
public class BDController {

    public static final BDController c = new BDController();
    public static TableView tabla;

    public static TableView vistaEmployee(String sql) {
        List<Employee> lista = new ArrayList<>();
        ObservableList<Employee> lista2 = FXCollections.observableList(lista);
        sql = sql + " Employee";
        try {
            tabla = new TableView();
            ResultSet s = ConectarBD2.c.ejecutarQuery(sql);
            List<String> campos = null;
            while (s.next()) {
                Employee empleado = new Employee(s.getString(1), s.getString(2), s.getString(3), s.getInt(4), s.getString(5),
                        s.getInt(6), s.getString(7));
                lista2.add(empleado);
            }
            campos = Employee.getArr();
            for (int i = 0; i < campos.size(); i++) {
                String atributo = campos.get(i);
                TableColumn<Employee, String> columna = new TableColumn<>(atributo);
                columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
                tabla.getColumns().add(columna);
            }
            tabla.setItems(lista2);
            ConectarBD2.c.endQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tabla;
    }

    public static TableView vistaBranch(String sql) {
        List<BranchOffice> lista = new ArrayList<>();
        ObservableList<BranchOffice> lista2 = FXCollections.observableList(lista);
        sql = sql + " BranchOffice";
        try {
            tabla = new TableView();
            ResultSet s = ConectarBD2.c.ejecutarQuery(sql);
            List<String> campos = null;
            while (s.next()) {
                BranchOffice oficina = new BranchOffice(s.getString(1), s.getString(2), s.getInt(3));
                System.out.println(oficina);
                lista2.add(oficina);
            }
            campos = BranchOffice.getArr();
            System.out.println(campos);
            for (String atributo:campos) {
                TableColumn<BranchOffice, String> columna = new TableColumn<>(atributo);
                columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
                tabla.getColumns().add(columna);
            }
            System.out.println("add items");
            tabla.setItems(lista2);
            System.out.println("terminados items");
            ConectarBD2.c.endQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tabla;
    }

    public static TableView vistaMagazine(String sql) {
        List<Magazine> lista = new ArrayList<>();
        ObservableList<Magazine> lista2 = FXCollections.observableList(lista);
        sql = sql + " Magazine";
        try {
            tabla = new TableView();
            ResultSet s = ConectarBD2.c.ejecutarQuery(sql);
            List<String> campos = null;
            while (s.next()) {
                Magazine oficina = new Magazine(s.getInt(1), s.getString(2), s.getString(3), s.getString(4));
                lista2.add(oficina);
            }
            campos = Magazine.getArr();
            System.out.println(campos);
            for (int i = 0; i < campos.size(); i++) {
                String atributo = campos.get(i);
                TableColumn<Magazine, String> columna = new TableColumn<>(atributo);
                columna.setCellValueFactory(new PropertyValueFactory<>(atributo));
                tabla.getColumns().add(columna);
            }
            tabla.setItems(lista2);
            ConectarBD2.c.endQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tabla;
    }

}
