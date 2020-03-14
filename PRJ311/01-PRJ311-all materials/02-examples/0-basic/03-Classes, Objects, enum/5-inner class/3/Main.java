class OuterClass
 {int m,n;
   class InnerClass
      {//Can not declare static member in non-static inner class
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
              OuterClass t = new OuterClass();
              OuterClass.InnerClass h = t.new InnerClass();              
              t.chao();
              h.chao();
            }
  }
