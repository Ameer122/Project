package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.net.ssl.SSLException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
public class LoginController implements Initializable {
	@FXML // fx:id="tf_username"
    private TextField tf_username; // Value injected by FXMLLoader

    @FXML // fx:id="pf_password"
    private PasswordField pf_password; // Value injected by FXMLLoader

    @FXML
    void login(MouseEvent event) {
/*String username,password;
username = tf_username.getText();
password = pf_password.getText();
DbConnect db = new DbConnect();
try {
	Connection connection = db.getConnection();
	try {
		Statement stmt = connection.createStatement();
		String sql = "SELECT * FROM users WHERE username = '"+username+" ' or email = ' "+password+"' AND password = '"+password+"'";
		ResultSet resultset = stmt.executeQuery(sql);
		if(resultset.next())
		{
			try {
				
				Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
			Node node = (Node)event.getSource();
			Stage stage = (Stage)node.getScene().getWindow();
			stage.setScene(new Scene(root));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	} catch (SSLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    }

    @FXML
    void signup(MouseEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
    	Node node = (Node)event.getSource();
    	Stage stage = (Stage)node.getScene().getWindow();
    	stage.setScene(new Scene(root));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		  
	}
	*/
}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
