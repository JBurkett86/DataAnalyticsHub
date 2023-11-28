package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
   
   private static Stage stage;
   
   
	@Override
	public void start(Stage primaryStage) {
		try {
		   stage = primaryStage;
		   primaryStage.setResizable(false);
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			

			
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Data Analytics Hub");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

   public void changeScene(String fxml) throws IOException {
       Parent pane = FXMLLoader.load(getClass().getResource(fxml));       
       stage.getScene().setRoot(pane);
   }
	
	public static void main(String[] args) {
		launch(args);
	}
}
