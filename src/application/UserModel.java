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
   
   // Getter and Setter methods for 'username'
   public String getUsername() {
       return username;
   }

   public void setUsername(String username) {
       this.username = username;
   }

   // Getter and Setter methods for 'firstName'
   public String getFirstName() {
       return firstName;
   }

   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }

   // Getter and Setter methods for 'lastName'
   public String getLastName() {
       return lastName;
   }

   public void setLastName(String lastName) {
       this.lastName = lastName;
   }

   // Getter and Setter methods for 'userPassword'
   public String getUserPassword() {
       return userPassword;
   }

   public void setUserPassword(String userPassword) {
       this.userPassword = userPassword;
   }

   // Getter and Setter methods for 'isVIPUser'
   public boolean isVIPUser() {
       return isVIPUser;
   }

   public void setVIPUser(boolean VIPUser) {
       isVIPUser = VIPUser;
   }

   // Getter and Setter methods for 'isAdmin'
   public boolean isAdmin() {
       return isAdmin;
   }

   public void setAdmin(boolean admin) {
       isAdmin = admin;
   }

   
   public void setUser(User user) throws UserException {
      this.user = new User(this.getUsername(),  this.getFirstName(), this.getLastName(), 
                           this.getUserPassword(), this.isVIPUser(), this.isAdmin() );
 
   }
   
   public User getUser() {
      return user;
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
         }
      }
      catch (SQLException e)
      {
         System.out.println(e.getMessage());
      }
      return this.user;
   }
   
   public void insertNewUser() throws IOException
   {
      try (Connection con = DatabaseConnection.getConnection();
               Statement stmt = con.createStatement();)
      {
         String query = "INSERT INTO User VALUES (\"" + this.getUsername() + "\", " +
                        "\"" + this.getFirstName() + "\", " +
                        "\"" + this.getLastName() + "\", " +
                        "\"" + this.getUserPassword() + "\", " +
                        (this.isAdmin() ? 1 : 0) + ", " +
                        (this.isVIPUser() ? 1 : 0) + ")";
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
   
   public void updateUser(String currentUsername) throws IOException
   {
      try (Connection con = DatabaseConnection.getConnection();
               Statement stmt = con.createStatement();)
      {
         String query = "UPDATE User SET Username = \"" + this.getUsername() + 
                  "\", FirstName = \"" + this.getFirstName() + 
                  "\", LastName = \"" + this.getLastName() + 
                  "\", UserPassword = \"" + this.getUserPassword() + 
                  "\", IsVIPUser = " + (this.isAdmin() ? 1 : 0) + 
                  ", IsAdmin = " + (this.isVIPUser() ? 1 : 0) + 
                  " WHERE Username == \"" + currentUsername +"\"";
         int result = stmt.executeUpdate(query);

         if (result == 1)
         {
            System.out.println("Update table user executed successfully");
            System.out.println(result + " row(s) affected");
         }
      }
      catch (SQLException e)
      {
         System.out.println(e.getMessage());
      }
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
