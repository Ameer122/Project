package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.net.ssl.SSLException;

import javafx.scene.input.KeyEvent;

import javafx.scene.control.ComboBox;

import javafx.event.EventHandler;


public class HomeController implements Initializable {

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
    private TableView<TableController> table;
    private ObservableList<TableController> data;
    @FXML
    private TableColumn<TableController, String> idcol;

    @FXML
    private TableColumn<TableController, String> namecol;

    @FXML
    private TableColumn<TableController, String> descol;

    @FXML
    private TableColumn<TableController, String> pricecol;

    @FXML
    private TableColumn<TableController, FileInputStream> piccol;
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
    		ItemController ite = new ItemController ();
    		ite.OpenScene();
    		
    	}
    }
 
    	
    
ObservableList<TableController> oblist = FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

    	
    	
    	
		DbConnect db = new DbConnect();
     	
     		try {
				Connection connection = db.getConnection();
				ResultSet rs = connection.createStatement().executeQuery("SELECT * From item");
				while(rs.next())
				{
					
					oblist.add(new TableController(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(3)));
				}
			} catch (SSLException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     		
    
    	
    
    	
    	
    	
    	idcol.setCellValueFactory(  new PropertyValueFactory<>("id"));

    	namecol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
    
    	
    	
    	descol.setCellValueFactory(
                new PropertyValueFactory<>("description"));

    
        
    	
    	pricecol.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        
       table.setItems(null);
 table.setItems(oblist);
        
    }
}
	  
    

