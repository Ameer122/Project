package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReportsController {
	
	private int storeNum1 = -1;
	private int storeNum2 = -1;
	private String date1;
	private String date2;
	ObservableList<Orders> OrdersList = FXCollections.observableArrayList();
    @FXML
    private TextField StoreNum1TXT;

    @FXML
    private TextField StoreNum2TXT;

    @FXML
    private TextField date1TXT;

    @FXML
    private TextField date2TXT;

    @FXML
    private MenuButton flowerTypeDD;

    @FXML
    private Button getReportBTN;

    @FXML
    private MenuButton ReportDD;

    @FXML
    private Label storeNum2LBL;

    //@FXML
    //private TableView<?> ReportTable1;

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
    @FXML
    private Label date2LBL;

    @FXML
    private Label errorsLBL;

    @FXML
    private TableView<?> ReportTable2;

    @FXML
    private Button compareBTN;

    @FXML
    void ReportTypeDDM(ActionEvent event) {
    	errorsLBL.setText("passed1");
    	errorsLBL.setVisible(true);
    }

    @FXML
    void date1Change(ActionEvent event) {
    	errorsLBL.setText("passed1");
    }
    
    @FXML
    void GetReport(ActionEvent event) {
    	DbConnect db = new DbConnect();
		Connection con = db.getConnection();
    	try {
	    	storeNum1 = Integer.parseInt(StoreNum1TXT.getText());
	    	date1 = date1TXT.getText();
	    	try {
	    		if(StoreNum2TXT.isVisible() && date2TXT.isVisible()) {
	    			storeNum2 = Integer.parseInt(StoreNum2TXT.getText());
	    			date2 = date2TXT.getText();
	    		}
	    		// add store number check
	    	}catch (Exception e) {
	    		//errorsLBL.setText("store number cannot be empty");
			} 
    	}catch (Exception e) {
    		//errorsLBL.setText("store number cannot be empty");
    	}
    	//errorsLBL.setText(date1+"");
    	try {
			Statement stmt = con.createStatement();
			String query = "Select * from Orders" ;
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			    //Date parsedDate = dateFormat.parse(rs.getString("Purchase Date"));
			    String [] dateParts = rs.getString("Purchase Date").split(" ");
			    String [] orderDate = dateParts[0].split("-");
			    String [] askedDate = date1.split("/");
			    int year = Integer.parseInt(orderDate[0]);
			    int month = Integer.parseInt(orderDate[1]);
			    int askedyear = Integer.parseInt(askedDate[1]);
			    int askedmonth = Integer.parseInt(askedDate[0]);
				if( askedyear == year && askedmonth == month) {
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
			//e.printStackTrace();
		}
    	CustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));

		ProductName.setCellValueFactory(new PropertyValueFactory<>("product"));

		ProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

		PurchaseDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		DeliveryDate.setCellValueFactory(new PropertyValueFactory<>("delivery"));
		CreditCard.setCellValueFactory(new PropertyValueFactory<>("card"));
		Typeofpayment.setCellValueFactory(new PropertyValueFactory<>("type"));
		Numberofinstallments.setCellValueFactory(new PropertyValueFactory<>("installments"));
		TableOrder.setItems(null);
		TableOrder.setItems(OrdersList);
		TableOrder.refresh();
    	
    	if (ReportDD.getText() == "Comparison") {
    		ReportTable2.setVisible(true);
    	}
    	TableOrder.setVisible(true);
    }

    @FXML
    void getStoreNum1(ActionEvent event) {
    			
    }

    @FXML
    void getStoreNum2(ActionEvent event) {
    }
    
    @FXML
    void getMonthlyReport(ActionEvent event) {
    	ReportDD.setText("Monthly report");
    	TableOrder.setVisible(false);
    	ReportTable2.setVisible(false);
    	flowerTypeDD.setVisible(false);
    	date2LBL.setVisible(false);
    	date2TXT.setVisible(false);
    	storeNum2LBL.setVisible(false);
    	StoreNum2TXT.setVisible(false);
    	
    	
    }
    
    @FXML
    void GetOrdersByType(ActionEvent event) {
    	ReportDD.setText("Orders by type");
    	TableOrder.setVisible(false);
    	ReportTable2.setVisible(false);
    	flowerTypeDD.setVisible(true);
    	date2LBL.setVisible(false);
    	date2TXT.setVisible(false);
    	storeNum2LBL.setVisible(false);
    	StoreNum2TXT.setVisible(false);
    }

    @FXML
    void GetComplaints(ActionEvent event) {
    	ReportDD.setText("Complaints");
    	TableOrder.setVisible(false);
    	ReportTable2.setVisible(false);
    	flowerTypeDD.setVisible(false);
    	date2LBL.setVisible(false);
    	date2TXT.setVisible(false);
    	storeNum2LBL.setVisible(false);
    	StoreNum2TXT.setVisible(false);
    }

    @FXML
    void MakeComparison(ActionEvent event) {
    	ReportDD.setText("Comparison");
    	TableOrder.setVisible(false);
    	ReportTable2.setVisible(false);
    	flowerTypeDD.setVisible(false);
    	date2LBL.setVisible(true);
    	date2TXT.setVisible(true);
    	storeNum2LBL.setVisible(true);
    	StoreNum2TXT.setVisible(true);
    }

}
