package application.view;


import application.ViewProvider;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;



public class BackgroundImageView {
	
	
	@FXML 
	private Group root;
	
	@FXML 
	private ImageView background;
	
	private Image img = null;
	
	private Scene scene = null;
	
	public void initialize() {
		ViewProvider.setView("BackgroundImage", this);
	}
	
	public ImageView getBackground() {
		return background;
	}
	
	public void setBackground(Image img) {
		this.img = img;
		background.setImage(img);
		addListeners();
		centerBackground();
	}
	
	public void setBorderPane(BorderPane borderPane) {
		setScene();
		root.getChildren().add(borderPane);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
	}
	
	public Group getRoot() {
		return root;
	}
	
	public void setScene() {
		if (scene == null) {
			this.scene = root.getScene();
		}
		
	}
	
	private void centerBackground() {
		setScene();
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
	
	public void addListeners() {
		setScene();
		scene.heightProperty().addListener(
	            (ObservableValue<? extends Number> ov, Number t, Number t1) -> {
	            	centerBackground();
	            });
		scene.widthProperty().addListener(
	            (ObservableValue<? extends Number> ov, Number t, Number t1) -> {
	            	centerBackground();
	        	});
	}
	

	

}










