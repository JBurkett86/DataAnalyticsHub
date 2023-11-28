package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class LoginController
{
   
   public LoginController() {
      
   }
   
   @FXML
   private Button button;
   
 /*  @FXML
   private Button loginbutton;
   
   @FXML
   private Button userRegister;
   
   @FXML
   private Button userExit;
   */
   @FXML
   private Label wrongLogin;
   @FXML
   private TextField username;
   @FXML
   private PasswordField password;
   
   
   
   
   public void userLogin(ActionEvent event) throws IOException {
      checkLogin();

  }
   
   public void userRegister(ActionEvent event) throws IOException {
      //TODO
      checkLogin();

  }
   
   
   public void userExit(ActionEvent event) throws IOException {
      exitApplication();

  }
   
   private void checkLogin() throws IOException {

      Main m = new Main();//Create new object

      if(username.getText().toString().equals("javacoding") && password.getText().toString().equals("123")) {
          wrongLogin.setText("Success!");
          
         m.changeScene("NormalUser.fxml");
      }

      else if(username.getText().isEmpty() && password.getText().isEmpty()) {
         wrongLogin.setText("Please enter your credentials.");
      }


      else {
         wrongLogin.setText("Invalid username or password!");
      }
  }
   
   private void exitApplication() throws IOException {
      System.exit(0);
   }
   

}
