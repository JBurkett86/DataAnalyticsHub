package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class AddPostController
{
   private User currentUser;
   private UserModel userModel;
   
   private PostModel postModel;
   private Post newPost;

   
   public AddPostController() throws UserException, PostException
   {
      userModel = new UserModel();
      UserHolder holder = UserHolder.getInstance();
      currentUser = holder.getUser();      
      postModel = new PostModel();
   }
   
   public void setPostModel(PostModel pModel) {
      this.postModel = pModel;
   }
   
   LocalDateTime dateInput = LocalDateTime.now(); // Default time to now.
   DateTimeFormatter df = new DateTimeFormatterBuilder()
            .appendPattern("d/MM/yyyy HH:mm") 
            .toFormatter(Locale.ENGLISH);
    

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
   private TextArea content;
   @FXML
   private TextField likes;
   @FXML
   private TextField shares;
   @FXML
   private TextField datetime;
   @FXML
   private TextField mainpostid;
   
   public void addPost(ActionEvent event) throws IOException, UserException, PostException {
      AddPost();
         
   }
   
   private void AddPost() throws IOException, UserException, PostException
   {
      if(validAddPostInput()) {         
         postModel.setAuthor(currentUser.getUsername());
         postModel.setId(Integer.parseInt(postid.getText().toString()));
         postModel.setContent(content.getText().toString());
         postModel.setLikes(Integer.parseInt(likes.getText().toString()));
         postModel.setShares(Integer.parseInt(shares.getText().toString()));
         postModel.setDateTime(LocalDateTime.parse(datetime.getText().toString(), df));
         postModel.setMainPostID(Integer.parseInt(mainpostid.getText().toString()));
         postModel.insertNewPost();
         postModel.setPost(postModel.getPost());
         newPost = postModel.getPost();
         invalidUserText.setText("Post created sucessfully.");
         invalidUserText.setStyle("-fx-text-fill: green;");
      }
   }
   
   private boolean validAddPostInput() throws IOException
   {
      // Initial field validation.
      boolean valid = true;
      try
      {
         Integer.parseInt(postid.getText().toString());
         if (postid.getText() == null ||(Integer.parseInt(postid.getText().toString()) <= 0))
         {
            postid.setStyle("-fx-text-fill: red;");
            postid.setStyle("-fx-border-color: red;");
            postid.setText("");
            postid.setPromptText("1 or greater required");
            valid = false;
         } else if (postModel.checkExistingPost(Integer.parseInt(postid.getText().toString()))) {
            postid.setStyle("-fx-text-fill: red;");
            postid.setText("Post ID already exists.");
            valid = false;
         }
      }
      catch (NumberFormatException nfe)
      {
         postid.setStyle("-fx-text-fill: red;");
         postid.setStyle("-fx-border-color: red;");
         postid.setText("");
         postid.setPromptText("1 or greater required");
         valid = false;
      }
      
     
      if (content.getText() == null || content.getText().trim().isEmpty()) {
         content.setPromptText("Content required");
         content.setStyle("-fx-text-fill: red;");
         content.setStyle("-fx-border-color: red;");
         valid = false;
      }
      
      try
      {
         Integer.parseInt(likes.getText().toString());
         if (likes.getText() == null ||
             (Integer.parseInt(likes.getText().toString()) < 0))
         {
            likes.setStyle("-fx-text-fill: red;");
            likes.setStyle("-fx-border-color: red;");
            likes.setText("");
            likes.setPromptText("0 or greater required");
            valid = false;
         }

      } catch (NumberFormatException nfe) {
         likes.setStyle("-fx-text-fill: red;");
         likes.setStyle("-fx-border-color: red;");
         likes.setText("");
         likes.setPromptText("0 or greater required");
         valid = false;
      }
      
      try {   
         Integer.parseInt(shares.getText().toString());
         if (shares.getText() == null ||(Integer.parseInt(shares.getText().toString()) < 0)) {
            shares.setStyle("-fx-text-fill: red;");
            shares.setStyle("-fx-border-color: red;");
            shares.setText("");
            shares.setPromptText("0 or greater required");
            valid = false;
         }
      } catch (NumberFormatException nfe) {
            shares.setStyle("-fx-text-fill: red;");
            shares.setStyle("-fx-border-color: red;");
            shares.setText("");
            shares.setPromptText("0 or greater required");

            valid = false;
      }

              
      try {
         dateInput = LocalDateTime.parse(datetime.getText().toString(), df);
         if (dateInput == null) {
            datetime.setStyle("-fx-text-fill: red;");
            datetime.setStyle("-fx-border-color: red;");
            datetime.setText("");
            datetime.setPromptText("DD/MM/YYYY HH:MM required");

            valid = false;
         } 
      } catch (DateTimeParseException exception) {
         datetime.setStyle("-fx-text-fill: red;");
         datetime.setStyle("-fx-border-color: red;");
         datetime.setText("");
         datetime.setPromptText("DD/MM/YYYY HH:MM required");

         valid = false;
      }  
      
      try
      {
         Integer.parseInt(shares.getText().toString());

         if (postid.getText() == null ||
             (Integer.parseInt(postid.getText().toString()) < 0))
         {
            mainpostid.setStyle("-fx-text-fill: red;");
            mainpostid.setText("");
            mainpostid.setPromptText("0 or greater required.");
            valid = false;
         }

         if ((Integer.parseInt(mainpostid.getText().toString()) > 0 &&
              !postModel.checkExistingPost(Integer
                       .parseInt(mainpostid.getText().toString()))))
         {
            mainpostid.setStyle("-fx-text-fill: red;");
            mainpostid.setText("");
            mainpostid.setPromptText("Main Post not found.");
            valid = false;
         }
      }
      catch (NumberFormatException nfe)
      {
         mainpostid.setStyle("-fx-text-fill: red;");
         mainpostid.setText("");
         mainpostid.setPromptText("Number required");
         valid = false;
      }
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
