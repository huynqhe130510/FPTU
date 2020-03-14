import java.util.*;
 
public class Main {
 
   static public void main(String[] args) {
 
      String language;
      String country;
      Locale currentLocale;
      ResourceBundle messages;
 
     // Default case (English) 
      language = new String("");
      country = new String("");
      currentLocale = new Locale(language, country);
       messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
 
      System.out.println("Default case (English):");
      System.out.println(messages.getString("greetings"));
      System.out.println(messages.getString("inquiry"));
      System.out.println(messages.getString("farewell"));
      System.out.println();


     // American English: en_US 
      language = new String("en");
      country = new String("US");
      currentLocale = new Locale(language, country);
       messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
 
      System.out.println("American English:");
      System.out.println(messages.getString("greetings"));
      System.out.println(messages.getString("inquiry"));
      System.out.println(messages.getString("farewell"));
      System.out.println();

     // Denmark: de_DE 
      language = new String("de");
      country = new String("DE");
      currentLocale = new Locale(language, country);
       messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
 
      System.out.println("Denmark:");
      System.out.println(messages.getString("greetings"));
      System.out.println(messages.getString("inquiry"));
      System.out.println(messages.getString("farewell"));
      System.out.println();

     // France: fr_FR 
      language = new String("fr");
      country = new String("FR");
      currentLocale = new Locale(language, country);
       messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
 
      System.out.println("France:");
      System.out.println(messages.getString("greetings"));
      System.out.println(messages.getString("inquiry"));
      System.out.println(messages.getString("farewell"));
      System.out.println();
   }
}

/*
import java.util.*;
public class Main
 {public static void main(String [] args)
   {
     System.out.println("Hello.");
     System.out.println("How are you?");
     System.out.println("Goodbye.");
     System.out.println();  
   }
 }
*/
