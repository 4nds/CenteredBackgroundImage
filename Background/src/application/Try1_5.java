package application;


import java.io.File;

import application.view.BackgroundImageView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class Try1_5 extends Application {
	
	

	
    
    
    
    private Image getImage(File file) {
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
        return img;
    }
    
    /*
	
	private final ChangeListener<Number> windowWidthResized = (ObservableValue<? extends Number> ov, Number t, Number t1) -> {
	    windowResized();
	};
	
	private final ChangeListener<Number> windowHeightResized = (ObservableValue<? extends Number> ov, Number t, Number t1) -> {
	    windowResized();
	};

    private void windowResized(){
        double newHeight = scene.getHeight();
        double newWidth = scene.getWidth();
        centerBackgroundImage(newWidth, newHeight);
    }
    
    
    private void centerBackgroundImage(double width, double height) {	
	    	if (scene.getWidth()/img.getWidth() > scene.getHeight()/img.getHeight()) {
	    		background.setFitWidth(scene.getWidth());
	    		background.setFitHeight(scene.getWidth()/img.getWidth()*img.getHeight()); 		
	    		background.setTranslateX(0);
	    		background.setTranslateY(-(background.getFitHeight()-scene.getHeight())/2);
	    	} else {
	    		background.setFitWidth(scene.getHeight()/img.getHeight()*img.getWidth());
	    		background.setFitHeight(scene.getHeight());
	    		background.setTranslateX(-(background.getFitWidth()-scene.getWidth())/2);
	    		background.setTranslateY(0);
	    	}
    }
    */
    
  

    @Override
    public void start(Stage primaryStage) {
        try {

        	
        	
        	//File(String pathname)
            //https://docs.oracle.com/javase/8/docs/api/java/io/File.html
            File file = new File("./src/application/resourcesa/black_clock.png");
            
            Image img = getImage(file);

            //ImageView background = new ImageView(img);
            //ImageView background = new ImageView();
            
          //Group root = new Group ();
        	//private Group root = (Group) FXMLLoader.load(getClass().getResource("BackgroundImage-view.fxml"));
        	Group root = (Group) FXMLLoader.load(getClass().getResource("view/BackgroundImage-view.fxml"));

        	
        	//jot down the width and height of the scene
            double width = 600;
            double height = 600;
            
            Scene scene = new Scene(root, width, height);
        	
        	
        	BackgroundImageView rootView = (BackgroundImageView) ViewProvider.getView("BackgroundImage");
        	//System.out.println(rootBlank);
        	//ImageView background = rootView.getBackground();
        	
        	
        	//System.out.println(background);
        	//background.setImage(img);
        	rootView.setBackground(img);
        	//rootView.addListeners();
            
        	
        	//System.out.println(rootView.getRoot().getScene());
            
            //root.getChildren().add(background);
        	
            //BorderPane()
            //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
            BorderPane borderPane = new BorderPane();

            

            //..center the background
            //centerBackgroundImage(width, height);

            //Button(String text)
            //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
            Button btn = new Button("Center");

            //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html#setCenter-javafx.scene.Node-
            borderPane.setCenter(btn);

            //make root with BorderPane and background image
            //Group root = new Group (background, borderPane);
            
            
        	
            rootView.setBorderPane(borderPane);
        	
            //root.getChildren().add(borderPane);
            
            //this lines set borderPane's dimensions to be the same as scene
            //borderPane.prefHeightProperty().bind(scene.heightProperty());
            //borderPane.prefWidthProperty().bind(scene.widthProperty());
            
            
          
            
            //add callbacks to handle window resize
            //scene.heightProperty().addListener(windowHeightResized);
            
            /*
            scene.heightProperty().addListener(
	            (ObservableValue<? extends Number> ov, Number t, Number t1) -> {
	                if (scene.getWidth()/img.getWidth() > scene.getHeight()/img.getHeight()) {
	                	
	    	    		background.setFitWidth(scene.getWidth());
	    	    		background.setFitHeight(scene.getWidth()/img.getWidth()*img.getHeight()); 		
	    	    		background.setTranslateX(0);
	    	    		background.setTranslateY(-(background.getFitHeight()-scene.getHeight())/2);
	    	    	} else {
	    	    		background.setFitWidth(scene.getHeight()/img.getHeight()*img.getWidth());
	    	    		background.setFitHeight(scene.getHeight());
	    	    		background.setTranslateX(-(background.getFitWidth()-scene.getWidth())/2);
	    	    		background.setTranslateY(0);
	    	    	}
	            });
            */
            
            
            //scene.widthProperty().addListener(windowWidthResized);        
            /*
            scene.widthProperty().addListener(
	            (ObservableValue<? extends Number> ov, Number t, Number t1) -> {
	                if (scene.getWidth()/img.getWidth() > scene.getHeight()/img.getHeight()) {
	    	    		background.setFitWidth(scene.getWidth());
	    	    		background.setFitHeight(scene.getWidth()/img.getWidth()*img.getHeight()); 		
	    	    		background.setTranslateX(0);
	    	    		background.setTranslateY(-(background.getFitHeight()-scene.getHeight())/2);
	    	    	} else {
	    	    		background.setFitWidth(scene.getHeight()/img.getHeight()*img.getWidth());
	    	    		background.setFitHeight(scene.getHeight());
	    	    		background.setTranslateX(-(background.getFitWidth()-scene.getWidth())/2);
	    	    		background.setTranslateY(0);
	    	    	}
	        	});
            */
            
            
            
            
            
            

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