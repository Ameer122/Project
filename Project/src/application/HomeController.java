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

import javafx.scene.input.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.net.ssl.SSLException;

import javafx.scene.input.KeyEvent;

import javafx.scene.control.ComboBox;

import javafx.event.EventHandler;


public class HomeController implements Initializable {
	ObservableList<Orders> OrdersList = FXCollections.observableArrayList(); // Orders Table View
	public User user = new User();
	public User userreg = new User();
    @FXML
    private ResourceBundle resources;
    @FXML
    private Pane userpan;
    @FXML
    private Label labelname2;

    @FXML
    private Pane UserControlpnl;
    @FXML
    private Pane CatControlpnl;

    @FXML
    private Pane catpan;

    @FXML
    private Label labelname4;
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
    private Button tet;
    @FXML
    private Button btnsetting;

    @FXML
    private Button btnworker;

    @FXML
    private Pane pnlCat;
    
    @FXML
    private Pane pnlUsers;
    

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

    @FXML
    private TableColumn<ItemController, String> idcol;

    @FXML
    private TableColumn<ItemController, String> namecol;

    @FXML
    private TableColumn<ItemController, String> descol;
    public ClientConsole client;
    @FXML
    private TableColumn<ItemController, String> pricecol;

    @FXML
    private TableColumn<ItemController, FileInputStream> piccol;
    @FXML
    private Button edituser;
    
    
    //Login panel
    @FXML
    private Button btnlogin;
    @FXML
    private Pane Loginpan;

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField pf_password;

    @FXML
    private Button login;
    //Ends Here
    //SignUp Panel
    

    @FXML
    private Pane Signuppan;

    @FXML
    private TextField tf_usernamesignup;
    @FXML
    private Label labname;
    @FXML
    private PasswordField pf_passwordsignup;

    @FXML
    private TextField tf_emailSignup;

    @FXML
    private TextField tf_IDSignup;

    @FXML
    private TextField tf_firstnameSignup;

    @FXML
    private TextField tf_LastNameSignup;

    @FXML
    private TextField tf_CardSignup;

    @FXML
    private Button signupbtn;
    //Ends Here
    
    //User Table
    @FXML
    private TableView<User> TableUser;

    @FXML
    private TableColumn<User, String> IDUser;

    @FXML
    private TableColumn<User, String> FirstUser;

    @FXML
    private TableColumn<User, String> LastUser;

    @FXML
    private TableColumn<User, String> MailUser;

    @FXML
    private TableColumn<User, String> UsernameUser;

    @FXML
    private TableColumn<User, String> PassUser;

    @FXML
    private TableColumn<User, String> CardUser;

    @FXML
    private TableColumn<User, String> DateUser;

    @FXML
    private TableColumn<User, String> StatusUser;
    //Ends Here
    
     //Orders Panel
    
    @FXML
    private Pane Orderspnl;

    @FXML
    private Label labelname21;

    @FXML
    private TableView<Orders> TableOrder;

    @FXML
    private TableColumn<Orders, String> CustomerName;

    @FXML
    private TableColumn<Orders, String> ProductName;

    @FXML
    private TableColumn<Orders, String> ProductPrice;

    @FXML
    private TableColumn<Orders, String> PurchaseDate;

    @FXML
    private TableColumn<Orders, String> DeliveryDate;

    @FXML
    private TableColumn<Orders, String> CreditCard;

    @FXML
    private TableColumn<Orders, String> Typeofpayment;

    @FXML
    private TableColumn<Orders, String> Numberofinstallments;
    // ends here
    @FXML
    void handleClicks(ActionEvent event) {
    	if(event.getSource() == tet)
    	{
    		try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if (event.getSource() == btncat) {
           // pnlcat.setStyle("-fx-background-color : #1620A1");
    	
           CatControlpnl.toFront();
       	Signuppan.setVisible(false);
           Loginpan.setVisible(false);
        }
    	if (event.getSource() == btnlogin) {
            // pnlcat.setStyle("-fx-background-color : #1620A1");
     	
    		
    		
            Loginpan.toFront();
        	Signuppan.setVisible(true);
            Loginpan.setVisible(true);
         }
    	if(event.getSource() == btnfee)
    	{
    		Orderspnl.toFront();
    		Signuppan.setVisible(false);
            Loginpan.setVisible(false);
         
         
    	
    	}
    	
    	
    	//Login to database using an account
    	if(event.getSource() == login)
    	{
    		
    		user.setusername(tf_username.getText());
    		user.setpassword(pf_password.getText());
    		DbConnect db = new DbConnect();
    		Connection connection = db.getConnection();
			try {
				Statement stmt = connection.createStatement();
				String sql = "SELECT * FROM users WHERE username = '"+user.getUsername()+" '  AND password = '"+user.getPassword()+"'";
				ResultSet resultset = stmt.executeQuery(sql);
				if(resultset.next())
				{
					
						client = new ClientConsole(user.getUsername(),"127.0.0.1",5555);
						 CatControlpnl.toFront();
					       	Signuppan.setVisible(false);
					           Loginpan.setVisible(false);
					          labname.setText(user.getUsername());
					         
					          btnlogin.setText(user.getUsername());
					          btnlogin.setDisable(true);
					
					     if(resultset.getString(9).equals("2"))     {
					         	 btnuser.setVisible(true);
					         	 btnworker.setVisible(true);
					         	 btnsetting.setVisible(true);

					          }
				}	
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Order Table View
	         //DbConnect db = new DbConnect();
	          try {
	          	Connection con = db.getConnection();
	          	if(client.name.equals("ameer"))
	          	{
	          		ResultSet rs = con.createStatement().executeQuery("SELECT * From Orders ");
	          
	          	
	          	
	          	while(rs.next())
	          	{	
	          		Orders order = new Orders();
	          		order.setname(rs.getString(1));
	          		order.setproduct(rs.getString(2));
	          order.setprice(rs.getString(3));
	          order.setdate(rs.getString(4));
	          order.setdelivery(rs.getString(5));
	          order.setcard(rs.getString(6));
	          order.settype(rs.getString(7));
	          order.setinstallments(rs.getString(7));
	          		
	          		OrdersList.add(order);
	          	}
	          	}
	          	else
	          	{
	          		ResultSet rs = con.createStatement().executeQuery("SELECT * From Orders WHERE Customer= '" + client.name + "'");
	          	   	while(rs.next())
		          	{	
		          		Orders order = new Orders();
		          		order.setname(rs.getString(1));
		          		order.setproduct(rs.getString(2));
		          order.setprice(rs.getString(3));
		          order.setdate(rs.getString(4));
		          order.setdelivery(rs.getString(5));
		          order.setcard(rs.getString(6));
		          order.settype(rs.getString(7));
		          order.setinstallments(rs.getString(7));
		          		
		          		OrdersList.add(order);
	          	}
	          	}
	          } catch (SQLException e) {
	          	// TODO Auto-generated catch block
	          	e.printStackTrace();
	          }
	          CustomerName.setCellValueFactory(  new PropertyValueFactory<>("name"));

	          ProductName.setCellValueFactory(
	            new PropertyValueFactory<>("product"));

	          ProductPrice.setCellValueFactory(
	            new PropertyValueFactory<>("price"));

	          PurchaseDate.setCellValueFactory(
	            new PropertyValueFactory<>("date"));
	          DeliveryDate.setCellValueFactory(
	          	    new PropertyValueFactory<>("delivery"));
	          CreditCard.setCellValueFactory(
	          	    new PropertyValueFactory<>("card"));
	          Typeofpayment.setCellValueFactory(
	          	    new PropertyValueFactory<>("type"));
	          Numberofinstallments.setCellValueFactory(
	          	    new PropertyValueFactory<>("installments"));
	          TableOrder.setItems(null);
	          TableOrder.setItems(OrdersList);
			 
	          }
    	
			
    	
    	if(event.getSource() == signupbtn)
    	{
    		
    		userreg.setusername(tf_usernamesignup.getText());
    		userreg.setpassword(pf_passwordsignup.getText());
    		userreg.setemail(tf_emailSignup.getText());
    		userreg.setcard(tf_CardSignup.getText());
    		userreg.setfirstname(tf_firstnameSignup.getText());
    		userreg.setlastname(tf_LastNameSignup.getText());
    		userreg.setId(tf_IDSignup.getText());
    		
    		DbConnect db = new DbConnect();
         	Connection connection = db.getConnection();
    		String q = "INSERT INTO users(username,email,password,ID,Firstname,Lastname,CreditCard) VALUES(?,?,?,?,?,?,?)";
			
			
			PreparedStatement stms;
			try {
				
				stms = connection.prepareStatement(q);
				stms.setString(1,userreg.getUsername());
				stms.setString(2, userreg.getEmail());
   stms.setString(3,  userreg.getPassword());    
   stms.setString(4, userreg.getId());
   stms.setString(5,userreg.getFirstname());
   stms.setString(6,userreg.getLastname());
   stms.setString(7,userreg.getCard());
   if(stms.executeUpdate()>0)
   {
    client = new ClientConsole(user.getUsername(),"127.0.0.1",5555);
   CatControlpnl.toFront();
  	Signuppan.setVisible(false);
      Loginpan.setVisible(false);
     labname.setText(user.getUsername());
  
     btnlogin.setVisible(false);
   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    
    	
    	
    	
    	
    	
    	
    	if (event.getSource() == btnuser) {
           
    		UserControlpnl.toFront();
    		Loginpan.setVisible(false);
    		Signuppan.setVisible(false);
       
        }
    	if (event.getSource() == additem) {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
    		try {
				Parent root = (Parent)loader.load();
				ItemController ite = loader.getController();
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();
				ite.received(client);
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
		ite.received(client);

			
			
			
			
					
			
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
    @FXML  	
 public void log(MouseEvent event)
 {
	 Loginpan.toFront();
     Loginpan.setVisible(true);
     Signuppan.setVisible(false);
 }
    
    @FXML  	
    public void signup(MouseEvent event)
    {
   	Signuppan.toFront();
   	Signuppan.setVisible(true);
        Loginpan.setVisible(false);
        
    }
    
 
    	
    ObservableList<User> olist = FXCollections.observableArrayList(); //Users Table View
ObservableList<ItemController> oblist = FXCollections.observableArrayList(); // Catalog Table View

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//Catalog Table View
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
 

//Users Table View
try {
	Connection conn = db.getConnection();
	ResultSet rs = conn.createStatement().executeQuery("SELECT * From users");
	while(rs.next())
	{	
		User user = new User();
		user.setId(rs.getString(1));
		user.setfirstname(rs.getString(2));
		user.setlastname(rs.getString(3));
		user.setemail(rs.getString(4));
		user.setusername(rs.getString(5));
		user.setpassword(rs.getString(6));
		
		
		
		user.setcard(rs.getString(7));
		user.setDate(rs.getString(8));
		user.setStatus(rs.getString(9));
		olist.add(user);
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}









IDUser.setCellValueFactory(  new PropertyValueFactory<>("id"));

FirstUser.setCellValueFactory(
    new PropertyValueFactory<>("firstname"));

LastUser.setCellValueFactory(
    new PropertyValueFactory<>("lastname"));

MailUser.setCellValueFactory(
    new PropertyValueFactory<>("email"));
UsernameUser.setCellValueFactory(
	    new PropertyValueFactory<>("username"));
PassUser.setCellValueFactory(
	    new PropertyValueFactory<>("password"));
CardUser.setCellValueFactory(
	    new PropertyValueFactory<>("card"));
DateUser.setCellValueFactory(
	    new PropertyValueFactory<>("date"));
StatusUser.setCellValueFactory(
	    new PropertyValueFactory<>("status"));

TableUser.setItems(null);
TableUser.setItems(olist);

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
	  
    

