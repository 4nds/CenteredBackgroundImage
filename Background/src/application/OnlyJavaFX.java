package application;
	

import java.io.File;

import javafx.application.Application;
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


public class OnlyJavaFX extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//BorderPane()
			//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
			BorderPane borderPane = new BorderPane();
			
				    
		    //File(String pathname)
		    //https://docs.oracle.com/javase/8/docs/api/java/io/File.html
		    File file = new File("./src/application/resourcesa/black_clock.png");
		    
		    Image img = null;
		    if(file.exists()) {
		    	//Image(InputStream is)
			    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
			    img = new Image(file.getAbsoluteFile().toURI().toString());
		    } else {
		    	//Image(String url)
			    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
			    img = new Image("https://raw.githubusercontent.com/4nds/CenteredBackgroundImage/master/Background/src/application/resources/black_clock.png");
		    }
		    	
		    //BackgroundSize(double width, double height, boolean widthAsPercentage, boolean heightAsPercentage, boolean contain, boolean cover)
		    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BackgroundSize.html
		    BackgroundSize bgSize = new BackgroundSize(0, 0, false, false, false, true);
		    
		    //public BackgroundImage(Image image, BackgroundRepeat repeatX, BackgroundRepeat repeatY, BackgroundPosition position, BackgroundSize size)
		    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BackgroundImage.html
		    BackgroundImage bgImg = new BackgroundImage(img,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundPosition.CENTER,
		            bgSize);
		    
		    //Background(BackgroundImage... images)
		    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Background.html
		    Background bg = new Background(bgImg);
		
		    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Region.html#setBackground-javafx.scene.layout.Background-
		    borderPane.setBackground(bg);
		
		  
		    //Button(String text)
		    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
		    Button btn = new Button("Center");
		    
		    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html#setCenter-javafx.scene.Node-
		    borderPane.setCenter(btn);
		    
		    
		    Scene scene = new Scene(borderPane, 600, 600);
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
