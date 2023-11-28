package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

/**
 * The Post class represents a social media post with various attributes such as
 * ID, content, author, likes, shares, date and time of posting, and an optional
 * reference to the main post (in the case of replies).
 * <p>
 * This class allows for the creation and manipulation of social media posts.
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
    * @param id The unique ID associated with the post.
    * @param content The content of the social media post.
    * @param author An anonymous ID of the post author.
    * @param likes Number of likes (non-negative) of the post.
    * @param shares Number of users (non-negative) that shared the post.
    * @param dateTime The date and time the post was first posted.
    * @param mainPostID The ID of the main post, if this is a reply; otherwise, set to 0.
    * @throws PostException if likes or shares are negative.
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
