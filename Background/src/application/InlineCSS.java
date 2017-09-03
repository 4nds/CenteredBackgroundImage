package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class InlineCSS extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//BorderPane()
			//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
			BorderPane borderPane = new BorderPane();
		    
			
			//Button(String text)
		    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
		    Button btn = new Button("Center");
		    
		    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html#setCenter-javafx.scene.Node-
		    borderPane.setCenter(btn);
		    
		    
		    Scene scene = new Scene(borderPane, 600, 600);
		    
		    scene.getStylesheets().add(getClass().getResource("resources/BackgroundStyle.css").toExternalForm());
		    borderPane.setId("background_id");
		    
		    
		    String image = getClass().getResource("resources/black_clock.png").toExternalForm();
		    borderPane.setStyle("-fx-background-image: url('" + image + "'); " +
		               "-fx-background-position: center center; " +
		               "-fx-background-repeat: no-repeat;" +
		               "-fx-background-size: cover");
		    
		    primaryStage.setScene(scene);
		    primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
