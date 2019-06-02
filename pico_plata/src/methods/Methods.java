package methods;

import tda.TableTDA;
import res.Strings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;
 
public class Methods {
 
    private static TableView<TableTDA> table = new TableView<TableTDA>();
    private static final ObservableList<TableTDA> data =
        FXCollections.observableArrayList(
            new TableTDA("Lunes", "1 y 2"),
            new TableTDA("Martes", "3 y 4"),
            new TableTDA("Miercoles", "5 y 6"),
            new TableTDA("Jueves", "7 y 8"),
            new TableTDA("Viernes", "9 y 0")
        );
   
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static TableView<TableTDA> getTable() {
        table.setEditable(false);
        table.setPrefHeight(150.0);
        
        TableColumn firstNameCol = new TableColumn("Dia de la Semana");
        firstNameCol.setMinWidth(200);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<TableTDA, String>("day"));
 
        TableColumn lastNameCol = new TableColumn("Digitos que no pueden");
        lastNameCol.setMinWidth(200);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<TableTDA, String>("digits"));
 
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol);
 
        AnchorPane.setRightAnchor(table, 10.0);
        AnchorPane.setBottomAnchor(table, 40.0);
        
        return table;
    }
    
    public static void showAlertDialog(String dialog_content) {
    	Alert alert_exit = new Alert(AlertType.INFORMATION);
		alert_exit.setTitle(Strings.dialog_title);
		alert_exit.setContentText(dialog_content);
		alert_exit.initStyle(StageStyle.UTILITY);
		alert_exit.showAndWait();
    }
} 
