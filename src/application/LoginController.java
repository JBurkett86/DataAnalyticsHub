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
   
   public LoginController() {
      
   }
   
   private User currentUser;
   @FXML
   private Button button;
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
      // Check validation username doesnt exist, then no blanks ,etc.

      validateUserLogin();

  }
   
   
   public void userExit(ActionEvent event) throws IOException {
      exitApplication();

  }
   
   private void checkLogin() throws IOException {

      Main m = new Main();//Create new object
      try (Connection con = DatabaseConnection.getConnection();
               Statement stmt = con.createStatement();) {
            String query = "SELECT * FROM User WHERE Username=\"" + username.getText().toString() + 
            "\" AND UserPassword = \"" + password.getText().toString() + "\"";
            try (ResultSet resultSet = stmt.executeQuery(query)) {
               
               if(resultSet.next()) {
                  try 
                  {
                  currentUser = new User(resultSet.getString("Username"),resultSet.getString("FirstName"), resultSet.getString("LastName"),
                                         resultSet.getString("UserPassword"),resultSet.getBoolean("IsVIPUser"), resultSet.getBoolean("IsAdmin"));
                  }
                  catch (UserException e)
                  {
                     wrongLogin.setText(e.toString());
                  }
                  // If user type is Admin go to Admin pages.
                  if (currentUser.isAdmin()) {
                     //TODO
                     //m.ChangeSecen"AdminUser.fxml");       
                  } else {
                     m.changeScene("NormalUser.fxml");
                  }

               } else {
                  wrongLogin.setText("Invalid username or password!");
               }
            
            } 
         } catch (SQLException e) {
            System.out.println(e.getMessage());
         }
  }
   
   private void validateUserLogin() throws IOException {
      
   }
   
   private void exitApplication() throws IOException {
      System.exit(0);
   }
   

}
