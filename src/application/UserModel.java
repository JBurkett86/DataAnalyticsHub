package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserModel
{

   private User user;
   private String username;
   private String firstName;
   private String lastName;
   private String userPassword;
   private boolean isVIPUser;
   private boolean isAdmin;
   
   public UserModel() throws UserException{
         this.user = new User(username,  firstName, lastName, 
                              userPassword, isVIPUser,isAdmin );    
   }
   
   public User checkLogin(String username, String password) throws IOException
   {


      try (Connection con = DatabaseConnection.getConnection();
               Statement stmt = con.createStatement();)
      {
         String query = "SELECT * FROM User WHERE Username=\"" +
                        username +
                        "\" AND UserPassword = \"" + password +
                        "\"";
         try (ResultSet resultSet = stmt.executeQuery(query))
         {

            if (resultSet.next())
            {
               try
               {
                  this.user = new User(resultSet.getString("Username"),
                                         resultSet.getString("FirstName"),
                                         resultSet.getString("LastName"),
                                         resultSet.getString("UserPassword"),
                                         resultSet.getBoolean("IsVIPUser"),
                                         resultSet.getBoolean("IsAdmin"));
               }
               catch (UserException e)
               {
                  System.out.println(e);
               }
           
            }
            else
            {
            }

         }
      }
      catch (SQLException e)
      {
         System.out.println(e.getMessage());
      }
      return this.user;
   }
   
   public String getUsername() {
      return user.getUsername();
   }
   
   public boolean isAdmin() {
      return user.isAdmin();
   }
   
   public boolean checkUserExists(String username) throws IOException
   {
      try (Connection con = DatabaseConnection.getConnection();
               Statement stmt = con.createStatement();)
      {
         String query = "SELECT * FROM User WHERE Username=\"" +
                        username +  "\"";
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
   
}
