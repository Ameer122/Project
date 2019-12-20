package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btncat;

    @FXML
    private Button btnfee;
    @FXML
    private Button test;
    @FXML
    private Button btnuser;

    @FXML
    private Button btnsetting;

    @FXML
    private Button btnworker;

    @FXML
    private Pane pnlCat;

    @FXML
    private Pane pnlUsers;
    
    @FXML
    private Label labelname;
    @FXML
    private Button additem;

    @FXML
    private Button delitem;

    @FXML
    private Button edititem;
    @FXML
    private Button adduser;

    @FXML
    private Button deluser;

    @FXML
    private Button edituser;
    @FXML
    void handleClicks(ActionEvent event) {
    	if (event.getSource() == btncat) {
           // pnlcat.setStyle("-fx-background-color : #1620A1");
    	
            pnlCat.toFront();
        }
    	if (event.getSource() == btnuser) {
           // pnl.setStyle("-fx-background-color : #1620A1");
    		
            pnlUsers.toFront();
        }
    	if (event.getSource() == additem) {
    		try {
    			
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Item.fxml"));
    			Scene scene = new Scene(root);
    			ItemController item = new ItemController();
    			Stage primaryStage = new Stage();
    			primaryStage.setTitle("LeLaic Company");
    			primaryStage.initStyle(StageStyle.UNDECORATED);
    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			primaryStage.setScene(scene);
    			primaryStage.show();
    			if(event.getSource() == item.Submit)
    			{
    				primaryStage.close();
    			}
    			
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
         
    }

