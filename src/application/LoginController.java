package application;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;


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
      // If user type is Admin go to Admin pages.
      if (currentUser.getUsername() != null) {
         if (currentUser.isAdmin())
         {
            // TODO
            // m.changeScene("AdminUser.fxml");
         }
         else
         {
            UserHolder holder = UserHolder.getInstance();
            holder.setUser(currentUser);
            m.changeScene("NormalUser.fxml");
         }
         
      } else {
         wrongLogin.setText("Invalid username or password!");
      }      
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
