package pages;

import res.Strings;
import dimen.Dimens;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.Button;

import javafx.scene.control.ProgressBar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;

public class SplashActivity extends Application {
	
	private AnchorPane root;
	private Scene scene;
	
	private Button bexit;
	private Button begin;
	
	private final ProgressBar progressbar = new ProgressBar(0);
	
	private void initialize() {
		try {
			root = new AnchorPane();
			scene = new Scene(root, Dimens.width_splash, Dimens.height_splash);
			
			bexit = new Button(Strings.exit);
			begin = new Button(Strings.begin);
			
			progressbar.setMinWidth(460.0);
		} catch(Exception exception) {
			
		}
	}
	
	private void setPosition(Stage stage) {
		AnchorPane.setBottomAnchor(bexit, 10.0);
		AnchorPane.setRightAnchor(bexit, 10.0);
		
		AnchorPane.setLeftAnchor(progressbar, 20.0);
		AnchorPane.setTopAnchor(progressbar, 100.0);
		progressbar.progressProperty().addListener(new ChangeListener<Number>() {  
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                if(t1.doubleValue()==1){
                    HomeActivity home = new HomeActivity();
                    home.start(stage);
                }
            }

        });
		
		AnchorPane.setTopAnchor(begin, 125.0);
		AnchorPane.setLeftAnchor(begin, 230.0);
	}
	
	private void setUpButtons(Stage stage) {
		bexit.setOnAction(e -> stage.close());
		
		begin.setOnAction(e -> {
			begin.setDisable(true);
			
			Task task = taskCreator(3);
            progressbar.progressProperty().unbind();
            progressbar.progressProperty().bind(task.progressProperty());         
            new Thread(task).start();
		});
	}
	
	public void start(Stage stage) {
		initialize();
		setPosition(stage);
		
		setUpButtons(stage);
		
		root.getChildren().addAll(bexit, begin, progressbar);
		
		stage.setScene(scene);
		stage.setTitle(Strings.title_splash);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
	
    private Task taskCreator(int seconds){
        return new Task() {
                   @Override
                   protected Object call() throws Exception {
                       for(int i=0; i<seconds;i++){
                        Thread.sleep(1000);
                        updateProgress(i+1, seconds);
                       
                       }
                       return true;
                   }
               };
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}