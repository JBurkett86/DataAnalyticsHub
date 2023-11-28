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

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController
{
   private User currentUser;
   private UserModel userModel;
   
   public LoginController() throws UserException
   {
      userModel = new UserModel();
   }

  
   @FXML
   private Button button;
   @FXML
   private Label wrongLogin;
   @FXML
   private TextField username;
   @FXML
   private PasswordField password;

   public void userLogin(ActionEvent event) throws IOException
   {
      Main m = new Main();// Create new object  
      currentUser = userModel.checkLogin(username.getText().toString(), password.getText().toString());
      System.out.println(currentUser.getUsername());
      // If user type is Admin go to Admin pages.
      if (currentUser.getUsername() != null) {
         if (currentUser.isAdmin())
         {
            // TODO
            // m.changeScene("AdminUser.fxml");
         }
         else
         {
            m.changeScene("NormalUser.fxml");
         }
         
      } else {
         wrongLogin.setText("Invalid username or password!");
      }
      
      //TODO retrieveUser();
   }

   public void userRegister(ActionEvent event) throws IOException
   {
      registerNewUser();
   }

   public void userExit(ActionEvent event) throws IOException
   {
      exitApplication();
   }

   

   private void registerNewUser() throws IOException
   {
      Main m = new Main();
      m.changeScene("RegisterNewUser.fxml");

   }

   private void exitApplication() throws IOException
   {
      System.exit(0);
   }

}
