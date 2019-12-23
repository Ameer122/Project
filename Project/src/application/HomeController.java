package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
import java.sql.PreparedStatement;
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
    private TableView<ItemController> table;
    private ObservableList<ItemController> data;
    @FXML
    private TableColumn<ItemController, String> idcol;

    @FXML
    private TableColumn<ItemController, String> namecol;

    @FXML
    private TableColumn<ItemController, String> descol;

    @FXML
    private TableColumn<ItemController, String> pricecol;
private AnchorPane rootpane;
    @FXML
    private TableColumn<ItemController, FileInputStream> piccol;
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
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
    		try {
				Parent root = (Parent)loader.load();
				ItemController ite = loader.getController();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		//ItemController ite = new ItemController ();
    	//
    		//ite.OpenScene();
    		//ite.decider = false;
    }
    	if (event.getSource() == edititem) {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
    	 
			try {
				Parent root = (Parent)loader.load();
				ItemController ite = loader.getController();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();
				ItemController t = table.getSelectionModel().getSelectedItem();
				ite.ID2.setText(t.getId());
				ite.Name2.setText(t.getname());
				ite.Price2.setText(t.getprice());
				ite.Desription2.setText(t.getdescription());
			
			
			
			
			
					
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
    		
    }
    	if(event.getSource() == delitem)
		{
    		oblist.clear();
			DbConnect db = new DbConnect();
	     	
     		try {
				Connection connection = db.getConnection();
				ResultSet rs = connection.createStatement().executeQuery("SELECT * From item");
				while(rs.next())
				{	
					ItemController s = new ItemController();
					s.ItemControllers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
					oblist.add(s);
				}
			} catch (SQLException e) {
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
 
table.setEditable(true);
idcol.setCellFactory(TextFieldTableCell.forTableColumn());
		}
    	
    	}
    	
    	
    
 
    	
    
ObservableList<ItemController> oblist = FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		DbConnect db = new DbConnect();
     	
     		try {
				Connection connection = db.getConnection();
				ResultSet rs = connection.createStatement().executeQuery("SELECT * From item");
				while(rs.next())
				{	
					ItemController s = new ItemController();
					s.ItemControllers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
					oblist.add(s);
				}
			} catch (SQLException e) {
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
 
table.setEditable(true);
idcol.setCellFactory(TextFieldTableCell.forTableColumn());
 
        
    }
	
	
	public void ChangeFirst(CellEditEvent editedCell)
	{
		ItemController item = table.getSelectionModel().getSelectedItem();
		item.setId(editedCell.getNewValue().toString());
	}
	public void ChangeID(CellEditEvent editedCell)
	{
		ItemController item = table.getSelectionModel().getSelectedItem();
		item.setId(editedCell.getNewValue().toString());
				
	}
	public void ChangeD(CellEditEvent editedCell)
	{
		ItemController item = table.getSelectionModel().getSelectedItem();
		item.setdescription(editedCell.getNewValue().toString());
				
	}
	public void Changeprice(CellEditEvent editedCell)
	{
		ItemController item = table.getSelectionModel().getSelectedItem();
		item.setprice(editedCell.getNewValue().toString());
		
				
	}
}
	  
    

