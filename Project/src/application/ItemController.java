package application;

import java.awt.Event;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.net.ssl.SSLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ItemController {

    @FXML
    private TextField ID;

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

    @FXML
    private Button Attach;
  public  AnchorPane root= null ;
	
	public Stage primaryStage= new Stage();
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
            // pnlcat.setStyle("-fx-background-color : #1620A1");
     	String _name,_Description;
     	String _ID,_price;
     	_name = Name.getText();
     	_Description = Desription.getText();
     	_ID = ID.getText();
     	_price = Price.getText();
     	DbConnect db = new DbConnect();
     	try {
     		Connection connection = db.getConnection();
     		try {
     			String q = "INSERT INTO item(ID,Name,Description,Price,Picture) VALUES(?,?,?,?,?)";
     			
     			//String sql = "INSERT INTO item VALUES('"+_ID+"','"+_name+"','"+_Description+"','"+_price+"', '"+fis+"')";
     			//Statement stmt = connection.createStatement();
     			
     			//stmt.executeUpdate(sql);
     			PreparedStatement stms = connection.prepareStatement(q);
     			stms.setString(1,_ID);
     			stms.setString(2, _name);
stms.setString(3, _Description);    
stms.setString(4, _price);
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
    	if (event.getSource() == Reset)
    	{
    		DbConnect db = new DbConnect();
    		Connection connection = null;
			try {
				connection = db.getConnection();
			} catch (SSLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM item WHERE ID = '"+6+"'");
				if(rs.next())
				{
					byte[] img = rs.getBytes("Picture");
					ImageIcon image = new ImageIcon(img);
					java.awt.Image im = image.getImage();
					java.awt.Image myImg= im;
					ImageIcon newImage = new ImageIcon(myImg);
					//view.setIcon(newImage);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    }
    void OpenScene() {
    	try {
    		
    		this.root = (AnchorPane)FXMLLoader.load(getClass().getResource("Item.fxml"));
    		 Scene scene = new Scene(root);
			this.primaryStage.setTitle("LeLaic Company");
			this.primaryStage.initStyle(StageStyle.UNDECORATED);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    }

