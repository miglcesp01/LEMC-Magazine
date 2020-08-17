/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Entidades.BranchOffice;
import Entidades.Employee;
import Entidades.Entidad;
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

    public static TableView vistaTabla(Entidad en,String sql) {
        List<Entidad> lista = new ArrayList<>();
        ObservableList<Entidad> lista2 = FXCollections.observableList(lista);
        sql = sql + en.getNameClass();
        try {
            tabla = new TableView();
            ResultSet s = ConectarBD2.c.ejecutarQuery(sql);
            en.getRow(s,lista2);
            en.setColumn(tabla);
            tabla.setItems(lista2);
            ConectarBD2.c.endQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tabla;
    }

    

}
