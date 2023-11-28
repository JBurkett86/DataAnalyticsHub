package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterNewUserController
{
   private User newUser;
   private UserModel userModel;
   
   public RegisterNewUserController() throws UserException
   {
      userModel = new UserModel();
   }

   @FXML
   private Button button;
   @FXML
   private Button logout; // Back button.
   @FXML
   private Button register;
   @FXML
   private Label invalidUserText;
   @FXML
   private TextField username;
   @FXML
   private TextField firstname;
   @FXML
   private TextField lastname;
   @FXML
   private PasswordField password;
   
   public void registerUser(ActionEvent event) throws IOException {
      registerNewUser();
         
   }
   
   private void registerNewUser() throws IOException
   {
      if(validUserInput()) {
         userModel.setUsername(username.getText().toString());
         userModel.setFirstName(firstname.getText().toString());
         userModel.setLastName(lastname.getText().toString());
         userModel.setUserPassword(password.getText().toString());
         userModel.setAdmin(false);
         userModel.setVIPUser(false);
         userModel.setUser(newUser);
         userModel.insertNewUser();
      }
   }
   
   private boolean validUserInput() throws IOException
   {
      // Initial field validation.
      boolean valid = true;
      
      if (username.getText() == null || username.getText().trim().isEmpty()) {
         username.setPromptText("Username required");
         username.setStyle("-fx-text-fill: red;");
         username.setStyle("-fx-border-color: red;");
         valid = false;
      }
      
      if (firstname.getText() == null || firstname.getText().trim().isEmpty()) {
         firstname.setPromptText("First Name required");
         firstname.setStyle("-fx-text-fill: red;");
         firstname.setStyle("-fx-border-color: red;");
         valid = false;
      }
      
      if (lastname.getText() == null || lastname.getText().trim().isEmpty()) {
         lastname.setPromptText("Last Name required");
         lastname.setStyle("-fx-text-fill: red;");
         lastname.setStyle("-fx-border-color: red;");
         valid = false;
      }  
      
      if (password.getText() == null || password.getText().trim().isEmpty()) {
         invalidUserText.setText("A password is required!");
         password.setStyle("-fx-border-color: red;");
         valid = false;
      }
      
     if (userModel.checkUserExists(username.getText().toString())) {
        invalidUserText.setText("Username already exists. Try another.");
        valid = false;
     }
     return valid;
   }
   
   
   public void userLogOut(ActionEvent event) throws IOException {
      Main m = new Main();
      m.changeScene("Login.fxml");
   }

}
