public class TheClient 
 {public static void main(String[] args) throws Exception
   {ChatClient t = new ChatClient();
     try {t.sendReceiveWithServer(); } catch(Exception e) {}
   }
 }

