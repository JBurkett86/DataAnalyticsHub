package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class NormalUserController
{
   private User currentUser;
   private UserModel userModel;
   @FXML
   private Label welcome;
   
   public NormalUserController() throws UserException
   {
      userModel = new UserModel();
      UserHolder holder = UserHolder.getInstance();
      currentUser = holder.getUser();     
   }
   
   public void setModel(UserModel uModel) {
      this.userModel = uModel;
   }
   
   @FXML
   public void initialize() {
      welcome.setText("Welcome " + currentUser.getFirstName()); 
   }
   
   // Header Buttons
   @FXML
   private Button logout;   
   @FXML
   private Button editprofile;
   //Main window buttons
   @FXML
   private Button addpost;   
   @FXML
   private Button retrievepost;
   @FXML
   private Button retrievereplies;   
   @FXML
   private Button removepost;
   @FXML
   private Button retrievetoplikes;   
   @FXML
   private Button retrievetopshares;
   
   public void addPost(ActionEvent event) throws IOException {
      Main m = new Main();
      //m.changeScene("UserProfile.fxml");
   }
   
   public void retrievePost(ActionEvent event) throws IOException {
      // TODO
   }
   
   public void retrieveReplies(ActionEvent event) throws IOException {
   // TODO
   }
   
   public void removePost(ActionEvent event) throws IOException {
   // TODO
   }
   
   public void retrieveTopLikes(ActionEvent event) throws IOException {
   // TODO
   }
   
   public void retrieveTopShares(ActionEvent event) throws IOException {
   // TODO
   }
   
   // Go back to login page and ommit current user.
   public void userLogOut(ActionEvent event) throws IOException {
      Main m = new Main();
      m.changeScene("Login.fxml");
   }
   
   public void editProfile(ActionEvent event) throws IOException {
      Main m = new Main();
      m.changeScene("UserProfile.fxml");
   }

}
