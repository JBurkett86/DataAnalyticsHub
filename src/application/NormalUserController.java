package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class NormalUserController
{
   @FXML
   private Button logout;
   
   public void userLogOut(ActionEvent event) throws IOException {
      Main m = new Main();
      m.changeScene("Login.fxml");
   }

}