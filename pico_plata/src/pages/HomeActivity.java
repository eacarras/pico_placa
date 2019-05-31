package pages;

import dimen.Dimens;
import res.Strings;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;

public class HomeActivity extends Application{
	
	private AnchorPane root;
	private Scene scene;
	
	private Label lblicense;
	private Label lbdate;
	private Label lbtime;
	
	public HomeActivity() {
		root = new AnchorPane();
		scene = new Scene(root, Dimens.width_home, Dimens.height_home);
	}
	
	public void start(Stage stage) {
		stage.setTitle(Strings.title_home);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setResizable(false);
		stage.show();
	}
}
