package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddPostController
{
   private User newUser;
   private UserModel userModel;
   
   public AddPostController() throws UserException
   {
      userModel = new UserModel();
   }
   

   @FXML
   private Button button;
   @FXML
   private Button logout; 
   @FXML
   private Button cancel; // Back button.
   @FXML
   private Button addpost;
   @FXML
   private Label invalidUserText;
   @FXML
   private TextField postid;
   @FXML
   private TextField content;
   @FXML
   private TextField likes;
   @FXML
   private TextField shares;
   @FXML
   private TextField mainpostid;
   
   public void addPost(ActionEvent event) throws IOException, UserException {
      AddPost();
         
   }
   
   private void AddPost() throws IOException, UserException
   {
      if(validAddPostInput()) {
         /*
         userModel.setUsername(username.getText().toString());
         userModel.setFirstName(firstname.getText().toString());
         userModel.setLastName(lastname.getText().toString());
         userModel.setUserPassword(password.getText().toString());
         userModel.setAdmin(false);
         userModel.setVIPUser(false);
         userModel.setUser(newUser);
         userModel.insertNewUser();
         invalidUserText.setText("Account created sucessfully.");
         invalidUserText.setStyle("-fx-text-fill: green;");
         */
      }
   }
   
   private boolean validAddPostInput() throws IOException
   {
      // Initial field validation.
      boolean valid = true;
      /*
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
      
     if (userModel.checkUserExists(username.getText().toString())) {
        invalidUserText.setStyle("-fx-text-fill: red;");
        invalidUserText.setText("Username already exists. Try another.");
        valid = false;
     }
     */
     return valid;
     
   }
   
   public void cancel(ActionEvent event) throws IOException {
      Main m = new Main();
      m.changeScene("NormalUser.fxml");
   }
   
   public void userLogOut(ActionEvent event) throws IOException {
      Main m = new Main();
      m.changeScene("Login.fxml");
   }
   

}
