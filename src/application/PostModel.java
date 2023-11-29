package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class PostModel
{
   private Post post;
   private int id; 
   private String content;
   private String author; 
   private int likes; 
   private int shares; 
   private LocalDateTime dateTime; // The format of (DD/MM/YYYY HH:MM)
   private int mainPostID;
   

   public PostModel() throws PostException{
         this.post = new Post(id,  content, author, 
                              likes, shares,dateTime, mainPostID);    
   }
   
   // Getter and Setter methods for 'post'
   public Post getPost() {
       return post;
   }

   public void setPost(Post post) throws PostException {
      this.post = new Post(this.getId(),  this.getContent(), this.getAuthor(), 
                           this.getLikes(), this.getShares(), this.getDateTime()
                           , this.getMainPostID());
   }

   // Getter and Setter methods for 'id'
   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   // Getter and Setter methods for 'content'
   public String getContent() {
       return content;
   }

   public void setContent(String content) {
       this.content = content;
   }

   // Getter and Setter methods for 'author'
   public String getAuthor() {
       return author;
   }

   public void setAuthor(String author) {
       this.author = author;
   }

   // Getter and Setter methods for 'likes'
   public int getLikes() {
       return likes;
   }

   public void setLikes(int likes) {
       this.likes = likes;
   }

   // Getter and Setter methods for 'shares'
   public int getShares() {
       return shares;
   }

   public void setShares(int shares) {
       this.shares = shares;
   }

   // Getter and Setter methods for 'dateTime'
   public LocalDateTime getDateTime() {
       return dateTime;
   }

   public void setDateTime(LocalDateTime dateTime) {
       this.dateTime = dateTime;
   }

   // Getter and Setter methods for 'mainPostID'
   public int getMainPostID() {
       return mainPostID;
   }

   public void setMainPostID(int mainPostID) {
       this.mainPostID = mainPostID;
   }
   
   public boolean checkExistingPost(int postID) throws IOException
   {
      try (Connection con = DatabaseConnection.getConnection();
               Statement stmt = con.createStatement();)
      {
         String query = "SELECT * FROM Post WHERE id=\"" +
                  postID +  "\"";
         try (ResultSet resultSet = stmt.executeQuery(query))
         {
            if (resultSet.next())
            {
               return true;
            }
         }
      }
      catch (SQLException e)
      {
         System.out.println(e.getMessage());
      }
      return false;
   }
   
   public void insertNewPost() throws IOException
   {
      try (Connection con = DatabaseConnection.getConnection();
               Statement stmt = con.createStatement();)
      {
         String query = "INSERT INTO Post VALUES (" + this.getId() + ", " +
                        "\"" + this.getContent() + "\", " +
                        "\"" + this.getAuthor() + "\", " +
                        "" + this.getLikes() + ", " +
                        "" + this.getShares() + ", " +
                        "\"" + this.getDateTime() + "\", " +
                        "" + this.getMainPostID() + ") " ;
         System.out.println(query);
         int result = stmt.executeUpdate(query);

         if (result == 1)
         {
            System.out.println("Insert into table user executed successfully");
            System.out.println(result + " row(s) affected");
         }
      }
      catch (SQLException e)
      {
         System.out.println(e.getMessage());
      }
   }

}
