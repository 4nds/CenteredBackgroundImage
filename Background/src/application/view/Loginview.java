package application.view;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class Loginview {
	
	public void initialize() {
		
	}
	
	
	@FXML
	private TextField usernameText;
	
	@FXML
	private PasswordField passwordText;
	
	@FXML
	private void activateLogin() {
		String username = usernameText.getText();
		String password = passwordText.getText();
		System.out.println(username + '\t' + password);
	}
	
}
