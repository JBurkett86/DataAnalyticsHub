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
   
  
   @FXML
   private Button logout;
   
   @FXML
   private Button editprofile;
   
   public void userLogOut(ActionEvent event) throws IOException {
      Main m = new Main();
      m.changeScene("Login.fxml");
   }
   
   public void editProfile(ActionEvent event) throws IOException {
      Main m = new Main();
      m.changeScene("UserProfile.fxml");
   }

}
