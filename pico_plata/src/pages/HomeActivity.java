package pages;

import dimen.Dimens;
import res.Strings;

import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;

public class HomeActivity extends Application{
	
	private AnchorPane root;
	private Scene scene;
	
	private Label lblicense;
	private TextField license;
	private Label lblicenseerror;
	
	private Label lbdate;
	private DatePicker date; 
	
	private Label lbtime;
	private final ObservableList<String> items = FXCollections.observableArrayList();
	private final ComboBox<String> combotime = new ComboBox<>(items);
	private TextField time;
	private Label lbtimeerror;
	
	private Button btcalcular;
	
	public HomeActivity() {
		root = new AnchorPane();
		scene = new Scene(root, Dimens.width_home, Dimens.height_home);
		
		lblicense = new Label(Strings.license);
		license = new TextField();
		lblicenseerror = new Label(Strings.license_error);
		lblicenseerror.setVisible(false);
		
		lbdate = new Label(Strings.date);
		date = new DatePicker(LocalDate.now());
		
		lbtime = new Label(Strings.time);
		items.addAll("am", "pm");
		combotime.getSelectionModel().selectFirst();
		time = new TextField();
		lbtimeerror = new Label(Strings.time_error);
		lbtimeerror.setVisible(false);
		
		btcalcular = new Button(Strings.calculate);
	}
	
	public void setUpComponents() {
		AnchorPane.setLeftAnchor(lblicense, 10.0);
		AnchorPane.setTopAnchor(lblicense, 30.0);
		
		AnchorPane.setLeftAnchor(license, 90.0);
		AnchorPane.setTopAnchor(license, 30.0);
		
		AnchorPane.setRightAnchor(lblicenseerror, 10.0);
		AnchorPane.setTopAnchor(lblicenseerror, 30.0);
		
		AnchorPane.setLeftAnchor(lbdate, 10.0);
		AnchorPane.setTopAnchor(lbdate, 70.0);
		
		AnchorPane.setLeftAnchor(date, 90.0);
		AnchorPane.setTopAnchor(date, 65.0);
		
		AnchorPane.setLeftAnchor(lbtime, 10.0);
		AnchorPane.setTopAnchor(lbtime, 110.0);
		
		AnchorPane.setLeftAnchor(time, 90.0);
		AnchorPane.setTopAnchor(time, 110.0);
		
		AnchorPane.setRightAnchor(lbtimeerror, 10.0);
		AnchorPane.setTopAnchor(lbtimeerror, 110.0);
		
		AnchorPane.setLeftAnchor(combotime, 280.0);
		AnchorPane.setTopAnchor(combotime, 110.0);
		
		AnchorPane.setLeftAnchor(btcalcular, 20.0);
		AnchorPane.setTopAnchor(btcalcular, 150.0);
	}
	
	public void start(Stage stage) {
		setUpComponents();
		
		root.getChildren().addAll(lblicense, lbdate, lbtime, combotime, btcalcular, date, 
				license, lblicenseerror, lbtimeerror, time);
		
		stage.setTitle(Strings.title_home);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setResizable(false);
		stage.show();
	}
}
