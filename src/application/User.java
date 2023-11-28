package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

/**
 * The User class represents a user with attributes such as
 * names and reflections of user types
 * <p>
 * This class allows for the creation and manipulation of users.
 * </p>
 * 
 * @author John Burkett
 * @version 1.0
 */
public class User
{
   private String username;
   private String firstName;
   private String lastName;
   private String userPassword;
   private boolean isVIPUser;
   private boolean isAdmin;

   /**
    * Constructs a new `Post` object with the specified attributes.
    *
    * @param Username The unique ID associated with the user.
    * @param FirstName The users first name.
    * @param LastName The users last name.
    * @param UserPassword The password for this user to authenticate login.
    * @param IsVIPUser If the user has access to VIP features.
    * @param IsAdmin IF the user is a high authorised account.
    * @throws UserException if username or passwords are blank.
    */
   public User( String Username, String FirstName, String LastName, String UserPassword, 
                boolean IsVIPUser, boolean IsAdmin) throws UserException
   {
      

      if (Username == "" )
      {
         throw new UserException("Username cannot be blank");
      }
      if (UserPassword == "")
      {
         throw new UserException("Password cannot be blank.");
      }

      this.username = Username;
      this.firstName = FirstName;
      this.lastName = LastName;
      this.userPassword = UserPassword;
      this.isVIPUser = IsVIPUser;
      this.isAdmin = IsAdmin;
   }

   public String getUsername() {
       return username;
   }

   public void setUsername(String username) throws UserException {
      if (username == null) 
      {
         throw new UserException("Username cannot be empty");
      }
      else
      
      {
       this.username = username;
      }
   }

   public String getFirstName() {
       return firstName;
   }

   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }

   public String getLastName() {
       return lastName;
   }

   public void setLastName(String lastName) {
       this.lastName = lastName;
   }

   public String getUserPassword() {
       return userPassword;
   }

   public void setUserPassword(String userPassword) throws UserException {
      if (userPassword == null)
      {
         throw new UserException("Password cannot be empty");
      }
      else
      {
         this.userPassword = userPassword;

      }
   }

   public boolean isVIPUser() {
       return isVIPUser;
   }

   public void setVIPUser(boolean VIPUser) {
       isVIPUser = VIPUser;
   }

   public boolean isAdmin() {
       return isAdmin;
   }

   public void setAdmin(boolean admin) {
       isAdmin = admin;
   }
   
   

}
