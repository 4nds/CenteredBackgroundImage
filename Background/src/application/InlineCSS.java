package application;

import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


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
				    
				    URL path = getClass().getResource("resources/black_clock.png");
				    
				    String image = null;
				    if(path != null) {
				    	image = path.toExternalForm();
				    } else {
				    	image = "https://raw.githubusercontent.com/4nds/CenteredBackgroundImage/master/Background/src/application/resources/black_clock.png";
				    }				    
				    
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
