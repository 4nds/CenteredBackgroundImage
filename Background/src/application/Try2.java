package application;
	

import java.io.File;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

class MyPosition {
	
    private Scene scene;
	private MySize imgSize;

	public MyPosition(Scene scene, MySize imgSize) {
		super();
		this.scene = scene;
		this.imgSize = imgSize;
	}
    
    private DoubleProperty top = new SimpleDoubleProperty();
    private DoubleProperty left = new SimpleDoubleProperty();
    
    public final double getTop(){return top.get();}
    public final double getLeft(){return left.get();}
 
    public final void setTop(double value){top.set(value);}
    public final void setLeft(double value){left.set(value);}
       
    public DoubleProperty topProperty() {
    	if (scene.getWidth() == imgSize.getWidth()) {
    		top.set((imgSize.getHeight()-scene.getHeight())/2);
    	} else {
    		top.set(0);
    	}
    	
    	return top;
    }
    
    public DoubleProperty leftProperty() {
    	if (scene.getWidth() == imgSize.getWidth()) {
    		left.set(0);
    	} else {
    		left.set((imgSize.getWidth()-scene.getWidth())/2);
    	}
    	return left;
    }
    
 
}

class MySize {
	
    private Scene scene;
	private Image img;

	public MySize(Scene scene, Image img) {
		super();
		this.scene = scene;
		this.img = img;
	}
    
    private DoubleProperty width = new SimpleDoubleProperty();
    private DoubleProperty height = new SimpleDoubleProperty();
    
    public final double getWidth(){return width.get();}
    public final double getHeight(){return height.get();}
 
    public final void setWidth(double value){width.set(value);}
    public final void setHeight(double value){height.set(value);}
       
    public DoubleProperty widthProperty() {
    	if (scene.getWidth()/img.getWidth() > scene.getHeight()/img.getHeight()) {
    		//width.set(scene.getWidth());
    		setWidth(scene.getWidth());
    	} else {
    		//width.set(scene.getHeight()/img.getHeight()*img.getWidth());
    		setWidth(scene.getHeight()/img.getHeight()*img.getWidth());
    	}
    	System.out.println(width);
    	return width;
    }
    
    public DoubleProperty heightProperty() {
    	if (scene.getWidth()/img.getWidth() > scene.getHeight()/img.getHeight()) {
    		height.set(scene.getWidth()/img.getWidth()*img.getHeight());
    	} else {
    		height.set(scene.getHeight());
    	}
    	System.out.println(height);
    	return height;
    }
    
 
}

class MyProperty {
	

    private DoubleProperty value = new SimpleDoubleProperty();
    
    public final double getValue(){return value.get();} 
    public final void setValue(double value_){value.set(value_);}
       
    public DoubleProperty valueProperty() {
    	return value;
    }

    
 
}


public class Try2 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			//BorderPane()
	        //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
	        BorderPane borderPane = new BorderPane();

	        //jot down the width and height of the scene
	        double width = 600;
	        double height = 600;
	        
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

	       
	        ImageView background = new ImageView(img);
	        
	        
	        //Button(String text)
	        //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
	        Button btn = new Button("Center");
	        
	        //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html#setCenter-javafx.scene.Node-
	        borderPane.setCenter(btn);
	        
	        //make root with BorderPane and background image
	        Group root = new Group (background, borderPane);
	        //Group root = new Group ();
            //root.getChildren().add(background);
            //root.getChildren().add(borderPane);
	        
	        Scene scene = new Scene(root, width, height);    
	        
	        
	        //MySize imgSize = new MySize(scene, img);
	        //background.fitHeightProperty().bind(imgSize.heightProperty());
	        background.fitHeightProperty().bind(Bindings.when(
	        		scene.widthProperty().divide(img.widthProperty()).greaterThan(scene.heightProperty().divide(img.heightProperty())))
	        		.then(scene.widthProperty().divide(img.widthProperty()).multiply(img.heightProperty()))
	        		.otherwise(scene.heightProperty()));
	        
	        
	        
	        //background.fitWidthProperty().bind(scene.widthProperty());     
	        /*
	        background.fitWidthProperty().bind(Bindings.when(
	        		scene.widthProperty().divide(img.widthProperty()).greaterThan(scene.heightProperty().divide(img.heightProperty())))
	        		.then(scene.widthProperty())
	        		.otherwise(scene.heightProperty().divide(img.heightProperty()).multiply(img.widthProperty())));
	        */
	        
	        //scene.heightProperty().addListener(windowHeightResized);
	        
	        //..center the background
	        background.translateXProperty().bind(background.fitWidthProperty().subtract(scene.widthProperty()).divide(-2));	        
	        background.translateYProperty().bind(background.fitHeightProperty().subtract(scene.heightProperty()).divide(-2));
	        
	        
	        //this lines set borderPane's dimensions to be the same as scene
			borderPane.prefHeightProperty().bind(scene.heightProperty());
			borderPane.prefWidthProperty().bind(scene.widthProperty());
			
			
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
