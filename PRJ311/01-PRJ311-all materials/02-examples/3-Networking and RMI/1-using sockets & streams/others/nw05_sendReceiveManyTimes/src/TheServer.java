public class TheServer 
 {public static void main(String[] args) throws Exception
   {ChatServer t = new ChatServer();
     try {t.sendReceiveWithClient(); } catch(Exception e) {}
   }
 }

