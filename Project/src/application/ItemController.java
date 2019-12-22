package application;

import java.awt.Event;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.net.ssl.SSLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ItemController implements Initializable {

    @FXML
    public TextField ID;

    @FXML
    private TextField Name;
public long a;
public long temper = 0;
public int temp = 0;
    @FXML
    private TextField Desription;
public FileInputStream fis;
    @FXML
    private TextField Price;

    @FXML
    private Button Reset;

    @FXML
    public Button Submit;

    @FXML
    private ImageView view;

	private StringProperty id;
	private StringProperty name;
	private StringProperty description;
	private StringProperty price;
	
    @FXML
    private Button Attach;
    
    

    @FXML
   public TextField ID2;

    @FXML
    public TextField Name2;

    @FXML
    public TextField Desription2;

    @FXML
    public TextField Price2;

    @FXML
    public Button Reset2;

    @FXML
    public Button Submit2;

    @FXML
    private TableView<ItemController> tab;

    @FXML
    private TableColumn<ItemController, String> idcol;
    
    public boolean decider = false;

    @FXML
    private TableColumn<ItemController, String> namecol;

    @FXML
    private TableColumn<ItemController,String> descol;

    @FXML
    private TableColumn<ItemController, ?> pricecol;

    ObservableList<ItemController> oblist = FXCollections.observableArrayList();
    
    
    
    
  public  AnchorPane root= null ;
  public  AnchorPane root1= null ;

	public Stage primaryStage= new Stage();
	public Stage primaryStage1= new Stage();

    @FXML
    void AttachPicture(ActionEvent event) {
    	 FileChooser fileChooser = new FileChooser();
         
         //Set extension filter
         FileChooser.ExtensionFilter extFilterJPG = 
                 new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
         FileChooser.ExtensionFilter extFilterjpg = 
                 new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
         FileChooser.ExtensionFilter extFilterPNG = 
                 new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
         FileChooser.ExtensionFilter extFilterpng = 
                 new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
         fileChooser.getExtensionFilters()
                 .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);

         //Show open file dialog
         File file = fileChooser.showOpenDialog(null);
a = file.length();
         
             BufferedImage bufferedImage = null;
			try {
				bufferedImage = ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             Image image = SwingFXUtils.toFXImage(bufferedImage, null);
             view.setImage(image);
         try {
			fis = new FileInputStream(file);
			System.out.println(file.length());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    void handleClicks(ActionEvent event) {
    	if (event.getSource() == Submit) {
          
     	
     	DbConnect db = new DbConnect();
     	try {
     		Connection connection = db.getConnection();
     		try {
     			String q = "INSERT INTO item(ID,Name,Description,Price,Picture) VALUES(?,?,?,?,?)";
     			
     			//String sql = "INSERT INTO item VALUES('"+_ID+"','"+_name+"','"+_Description+"','"+_price+"', '"+fis+"')";
     			//Statement stmt = connection.createStatement();
     			
     			//stmt.executeUpdate(sql);
     			PreparedStatement stms = connection.prepareStatement(q);
     			stms.setString(1,ID.getText());
     			stms.setString(2, Name.getText());
stms.setString(3,  Desription.getText());    
stms.setString(4, Price.getText());
stms.setBinaryStream(5, fis, a);
stms.executeUpdate();
     			
Stage stager = (Stage) Submit.getScene().getWindow();
stager.close();
     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
     		} catch (SSLException e) {
     		// TODO Auto-generated catch block
     		e.printStackTrace();
     	}
         }
    	if (event.getSource() == Submit2)
		{
    		Update();
		}
    	
    }
    void Update()
    {
    	DbConnect db = new DbConnect();
     	try {
     		Connection connection = db.getConnection();
     		try {
     			String temp = ID2.getText();
     			String q = "update  item set ID=?,Name=?,Description=?,Price=? where ID = '"+temp+"'";
     			
     			System.out.println(ID2.getText());
     			PreparedStatement stms = connection.prepareStatement(q);
     			stms.setString(1,ID2.getText());
     			stms.setString(2,Name2.getText());
stms.setString(3,  Desription2.getText());    
stms.setString(4, Price2.getText());
stms.executeUpdate();
     			

     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
     		} catch (SSLException e) {
     		// TODO Auto-generated catch block
     		e.printStackTrace();
     	}
         }
    
    void OpenScene() {
    	try {
    		this.decider = false;
    		this.root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Item.fxml"));
    		 Scene scene = new Scene(root1);
			this.primaryStage.setTitle("LeLaic Company");
			this.primaryStage.initStyle(StageStyle.UNDECORATED);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    void OpenScene2() {
    	try {
    		this.decider = true;
    		this.root = (AnchorPane)FXMLLoader.load(getClass().getResource("EditItem.fxml"));
    		 Scene scene = new Scene(root);
			this.primaryStage1.setTitle("LeLaic Company");
			this.primaryStage1.initStyle(StageStyle.UNDECORATED);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.primaryStage1.setScene(scene);
			this.primaryStage1.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    void ItemControllers(String id, String name, String description, String price)
    {
    	this.id = new SimpleStringProperty(id);
    	this.description = new SimpleStringProperty(description);
    	this.name = new SimpleStringProperty(name);
    	this.price = new SimpleStringProperty(price);
    	
    }
    public String getId()
    {
    	return id.get();
    }
    public String getprice()
    {
    	return price.get();
    }
    public String getname()
    {
    	return name.get();
    }
    public String getdescription()
    {
    	return description.get();
    }
    public void setId(String str)
    {
    	id.set(str);;
    }
    public void setprice(String str)
    {
    	price.set(str);
    }
    public void setname(String str)
    {
    	name.set(str);;
    }
    public void setdescription(String str)
    {
    	description.set(str);
    }
    public void setbar(String str)
    {
    	ID.setText(str);
    }
    public StringProperty nameProperty() {return name;}
    public StringProperty idProperty() {return id;}
    public StringProperty priceProperty() {return price;}
    public StringProperty descriptionProperty() {return description;}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {

	DbConnect db1 = new DbConnect();
 	
 		try {
			Connection connection = db1.getConnection();
			ResultSet rs = connection.createStatement().executeQuery("SELECT * From item");
			while(rs.next())
			{	
				ItemController s = new ItemController();
				s.ItemControllers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(3));
				oblist.add(s);
			}
		} catch (SSLException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		if(decider==false) {
 			idcol.setCellValueFactory(  new PropertyValueFactory<>("id"));

 			namecol.setCellValueFactory(
 		            new PropertyValueFactory<>("name"));

 			descol.setCellValueFactory(
 		            new PropertyValueFactory<>("description"));

 			pricecol.setCellValueFactory(
 		            new PropertyValueFactory<>("price"));
 		    
 		   tab.setItems(null);
 		tab.setItems(oblist);
 		
 		}
	
	
	
//	ID2.setText((String)a.idProperty().get());
	// Name2.setText((String)a.nameProperty().get());
	// Desription2.setText((String)a.descriptionProperty().get());
	// Price2.setText((String)a.priceProperty().get());
	

   




		
		
			
		

	
}

@FXML
void ChangeID(ActionEvent event) {
	ItemController item = tab.getSelectionModel().getSelectedItem();
	ItemControllers(item.getId(),item.getname(),item.getdescription(),item.getprice());
	ID2.setText(item.getId());


	
	DbConnect db = new DbConnect();
	Connection connection;
	try {
		connection = db.getConnection();
		
String test = "Select * From item Where ID = ? ";
		
		PreparedStatement stms = connection.prepareStatement(test);
		
		stms.setString(1, item.getId());
		ResultSet rs = stms.executeQuery();
		while(rs.next())
		{
			ID2.setText(rs.getString(1));
			Name2.setText(rs.getString(2));
			Desription2.setText(rs.getString(3));
			Price2.setText(rs.getString(4));

		}

stms.executeUpdate();
	} catch (SSLException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
}
}

