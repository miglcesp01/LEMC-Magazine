/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;
import java.util.Set;
import javafx.scene.control.TableView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
/**
 *
 * @author Alexis
 */
public interface Entidad {
    String getNameClass();
    void setColumn(TableView tabla);
    void getRow(ResultSet s,ObservableList<Entidad> lista)throws SQLException;
    ArrayList<String> getArr();
}
