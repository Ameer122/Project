package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReportsController {

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

    @FXML
    private TableView<?> ReportTable1;

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
    	if (ReportDD.getText() == "Comparison") {
    		ReportTable2.setVisible(true);
    	}
    	ReportTable1.setVisible(true);
    }

    @FXML
    void getStoreNum1(ActionEvent event) {
    	errorsLBL.setText("passed1");
    }

    @FXML
    void getStoreNum2(ActionEvent event) {
    	errorsLBL.setText("passed1");
    }
    
    @FXML
    void getMonthlyReport(ActionEvent event) {
    	ReportDD.setText("Monthly report");
    	ReportTable1.setVisible(false);
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
    	ReportTable1.setVisible(false);
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
    	ReportTable1.setVisible(false);
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
    	ReportTable1.setVisible(false);
    	ReportTable2.setVisible(false);
    	flowerTypeDD.setVisible(false);
    	date2LBL.setVisible(true);
    	date2TXT.setVisible(true);
    	storeNum2LBL.setVisible(true);
    	StoreNum2TXT.setVisible(true);
    }

}
