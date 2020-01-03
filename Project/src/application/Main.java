package application;
	
import common.ChatIF;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		
		//	ClientConsole client = new ClientConsole("user","127.0.0.1",5555);
			

			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("LeLaic Company");
		//	primaryStage.initStyle(StageStyle.UNDECORATED);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
