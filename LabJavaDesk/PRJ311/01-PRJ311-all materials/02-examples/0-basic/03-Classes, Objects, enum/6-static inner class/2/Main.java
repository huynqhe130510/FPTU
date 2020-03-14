class OuterClass
 {int m,n;
   static class InnerClass
      {
        void chao()
           {System.out.println("\nInner class xin chao");
           }
     }
   void chao()
         {System.out.println("\nOuter class xin chao");
         }
 }
public class Main 
  {
       public static void main(String args[])
            {
              OuterClass.InnerClass t = new OuterClass.InnerClass();// Do not need to create OuterClass object
              t.chao();
            }
  }
