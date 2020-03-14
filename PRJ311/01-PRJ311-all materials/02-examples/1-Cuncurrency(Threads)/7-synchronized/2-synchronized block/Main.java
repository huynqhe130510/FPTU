
 class TestClass {  
      
   void fun(int n) {//method is synchronized  
     synchronized(this) { 
     for(int i=1;i<=10;i++){  
       System.out.println(Thread.currentThread().getName() + ": " + n*i);  
       try{  
          Thread.sleep(500);  
         }catch(Exception e){System.out.println(e);}  
      }

     }  
      
    }  
   }  
      
 class ThreadA extends Thread {  
   TestClass t;  
   ThreadA(TestClass t){  
     this.t=t;  
    }  
   public void run(){  
    t.fun(6);  
    }  
      
  }  
 class ThreadB extends Thread{  
   TestClass t;  
   ThreadB(TestClass t){  
     this.t=t;  
    }  
   public void run(){  
     t.fun(100);  
    }  
  }  

 class Main {  
   public static void main(String args[]){  
     TestClass t = new TestClass();//only one object  
     ThreadA a = new ThreadA(t);  
     ThreadB b = new ThreadB(t);
     a.setName("Hoa");
     b.setName("La");  
     a.start();  
     b.start();  
   }  
    }  
