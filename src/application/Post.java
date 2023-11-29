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
public class Post
{
   private int id; 
   private String content;
   private String author; 
   private int likes; 
   private int shares; 
   private LocalDateTime dateTime; // The format of (DD/MM/YYYY HH:MM)
   private int mainPostID; 

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
   public Post(int id, String content, String author, int likes, int shares,
               LocalDateTime dateTime, int mainPostID) throws PostException
   {
      

      if (likes < 0)
      {
         throw new PostException("Likes cannot be a negative value.");
      }
      if (shares < 0)
      {
         throw new PostException("Shares cannot be a negative value.");
      }

      this.id = id;
      this.content = content;
      this.author = author;
      this.likes = likes;
      this.shares = shares;
      this.dateTime = dateTime;
      this.mainPostID = mainPostID;
   }

   public int getID()
   {
      return id;
   }

   public void setID(int ID)
   {
      this.id = ID;
   }

   public String getContent()
   {
      return content;
   }

   public void setContent(String CONT)
   {
      this.content = CONT;
   }

   public String getAuthor()
   {
      return author;
   }

   public void setAuthor(String AUTH)
   {
      this.author = AUTH;
   }

   public int getLikes()
   {
      return likes;
   }

   public void setLikes(int LKS) throws PostException
   {
      if (LKS < 0)
      {
         throw new PostException("Likes cannot be a negative.");
      }
      else
      {
         this.likes = LKS;
      }
   }

   public int getShares()
   {
      return shares;
   }

   public void setShares(int SHR) throws PostException
   {
      if (SHR < 0)
      {
         throw new PostException("Shares cannot be a negative.");
      }
      else
      {
         this.shares = SHR;
      }

   }

   public LocalDateTime getDateTime()
   {
      return dateTime;
   }

   public void setDateTime(LocalDateTime DTM)
   {
      this.dateTime = DTM;
   }

   public int getMainPostID()
   {
      return mainPostID;
   }

   public void setMainPostID(int PSTID)
   {
      this.mainPostID = PSTID;
   }

}
