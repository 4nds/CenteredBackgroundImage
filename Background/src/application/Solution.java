package application;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import application.view.BackgroundImageView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class Solution extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
        	

        	Group root = (Group) FXMLLoader.load(
        			getClass().getResource("view/BackgroundImage-view.fxml"));
 	        	
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			
			Scene scene = new Scene(root,
					screenSize.getWidth() / 2, screenSize.getHeight() / 2);
        	        	
        	BackgroundImageView LoginContainer = (BackgroundImageView) ViewProvider.getView("BackgroundImage");
        	
            File file = new File("./src/application/resources/login-background.jpeg");
            
            Image img = new Image(file.getAbsoluteFile().toURI().toString());
                       	
            BorderPane borderPane = (BorderPane) FXMLLoader.load(
            		getClass().getResource("view/Login-view.fxml"));
            
            LoginContainer.setBackground(img);
            LoginContainer.setBorderPane(borderPane);           
            

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