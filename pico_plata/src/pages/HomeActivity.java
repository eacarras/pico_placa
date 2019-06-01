package pages;

import dimen.Dimens;
import res.Strings;
import tda.UserCar;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
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
	private TextField time;
	private Label lbtimeerror;
	
	private Button btcheck;
	private Label lbcheck;
	
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
		time = new TextField();
		lbtimeerror = new Label(Strings.time_error);
		lbtimeerror.setVisible(false);
		
		btcheck = new Button(Strings.check);
		lbcheck = new Label();
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
		
		AnchorPane.setLeftAnchor(btcheck, 20.0);
		AnchorPane.setTopAnchor(btcheck, 150.0);
		
		AnchorPane.setLeftAnchor(lbcheck, 10.0);
		AnchorPane.setBottomAnchor(lbcheck, 10.0);
	}
	
	public void start(Stage stage) {
		setUpComponents();
		setUpButton();
		
		root.getChildren().addAll(lblicense, lbdate, lbtime, btcheck, date, 
				license, lblicenseerror, lbtimeerror, time, lbcheck);
		
		stage.setTitle(Strings.title_home);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setResizable(false);
		stage.show();
	}
	
	private void setUpButton() {
		btcheck.setOnAction(e -> {
			lblicenseerror.setVisible(false);
			lbtimeerror.setVisible(false);
			if(validate_information()) {
				LocalDate information = date.getValue();
				UserCar user = null;
				try {
					user = new UserCar(license.getText(), 
							getDayOfTheWeek(String.valueOf(information.getMonth().getValue()), 
									String.valueOf(information.getDayOfMonth()), 
									String.valueOf(information.getYear())), time.getText());
				} catch (ParseException exception) {
					exception.printStackTrace();
				}
				if(user.can_drive()) lbcheck.setText(Strings.lbcheck_good);
				else lbcheck.setText(Strings.lbcheck_bad);
			}
		});
	}
	
	private boolean validate_information() {
		if(license.getText().isEmpty() || !is_valid_license(license.getText())) {
			lblicenseerror.setVisible(true);
			return false;
		}
		else if(time.getText().isEmpty() || is_number(time.getText()) || time.getText().split(":").length < 2 ||
				time.getText().split(":").length > 2) {
			lbtimeerror.setVisible(true);
			return false;
		}
		
		return true;
	}
	
	public boolean is_number(String time) {
        boolean resultado;

        try {
            Integer.parseInt(time);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
	
	private boolean is_valid_license(String license) {
		String[] sp = license.split("-");
		if(sp.length != 2 || sp[1].length() < 3 || sp[1].length() > 4) return false;
		return true;
	}
	
	private String getDayOfTheWeek(String month, String day, String year) throws ParseException {
        String inputDateStr = String.format("%s/%s/%s", day, month, year);
        Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputDate);
        String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
        
		return dayOfWeek;
	}
}