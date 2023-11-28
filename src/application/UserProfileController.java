package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserProfileController
{
   private User currentUser;
   private UserModel userModel;
   
   public UserProfileController() throws UserException
   {
      userModel = new UserModel();
      UserHolder holder = UserHolder.getInstance();
      currentUser = holder.getUser();    
   }
   
   @FXML
   private TextField username;
   @FXML
   private TextField firstname;
   @FXML
   private TextField lastname;
   @FXML
   private PasswordField password;
   @FXML
   private Label invalidUserText;
   @FXML
   private Button logout;
   @FXML
   private Button editprofile;
   
   @FXML
   public void initialize() {
      username.setText(currentUser.getUsername());
      firstname.setText(currentUser.getFirstName()); 
      lastname.setText(currentUser.getLastName()); 
      password.setText(currentUser.getUserPassword()); 
   }
   

   public void userLogOut(ActionEvent event) throws IOException {
      Main m = new Main();
      UserHolder holder = UserHolder.getInstance();
      holder.setUser(currentUser);
      m.changeScene("NormalUser.fxml");
   }
   
   public void updateProfile(ActionEvent event) throws IOException, UserException {
      // Check existing user
      // check fields aren't blank
      if(validUserInput()) {
         
         userModel.setUsername(username.getText().toString());
         userModel.setFirstName(firstname.getText().toString());
         userModel.setLastName(lastname.getText().toString());
         userModel.setUserPassword(password.getText().toString());
         userModel.setAdmin(false);
         userModel.setVIPUser(false);
         userModel.updateUser(currentUser.getUsername());
         userModel.setUser(userModel.getUser());
         currentUser = userModel.getUser();
         invalidUserText.setText("Account updated sucessfully.");
         invalidUserText.setStyle("-fx-text-fill: green;");
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
         invalidUserText.setStyle("-fx-text-fill: red;");
         password.setStyle("-fx-border-color: red;");
         valid = false;
      }
      
      
     if (!(currentUser.getUsername().equals(username.getText().toString())) 
              && (userModel.checkUserExists(username.getText().toString()))) {
        System.out.println("Current user: " + currentUser.getUsername());
        System.out.println("UI user: " + username.getText().toString());
        invalidUserText.setStyle("-fx-text-fill: red;");
        invalidUserText.setText("Username already exists. Try another.");
        valid = false;
     }
     return valid;
   }
}
