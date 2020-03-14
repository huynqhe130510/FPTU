  import   java.util.*;  
  import   java.text.*;  
   
  class   CustomerAccount
     {  
       protected   int   accountType;  
       protected   double   balance;  
       public  CustomerAccount(int   type,double   bal) { accountType=type; balance=bal; }  
       public  int  getAccountType()  { return(accountType); }  
       public  double  getBalance()    { return(balance);}  
       public  void  setBalance(double   newbal) { balance=newbal;}  
     }  

  class   TransfersManager   implements   Runnable
     {  
       public  CustomerAccount   fromAccount;  
       public  CustomerAccount   toAccount;  
       protected   int   transfersCount;  
       public  TransfersManager(CustomerAccount   fromacct,CustomerAccount   toacct,int   transfers)
          {  
            fromAccount=fromacct;  
            toAccount=toacct;  
            transfersCount=transfers;  
          }  
   
       public   void   run()  
          {  
            double   balance;  
            double   transfersAmount;  
            for(int   i=0;i<transfersCount;i++)
               { try {Thread.sleep(10);} catch(Exception e) {}; 
                 System.out.println("  " + fromAccount.getAccountType() + " to " + toAccount.getAccountType() + " (" + i + " )");
                 synchronized (fromAccount)
                     {  
                       balance=fromAccount.getBalance();  
                       transfersAmount=(int) balance*Math.random();  
                       balance=balance-transfersAmount;  
                       fromAccount.setBalance(balance);  
                     }  
                 synchronized (toAccount)
                     {  
                       balance=toAccount.getBalance();  
                       balance+=transfersAmount;  
                       toAccount.setBalance(balance);  
                     }  
               }  
          }
     }  


  public   class   Main
     {
       public   static   void   main(String   args[])  
           {  
             int   transfers1=10;  
             int   transfers2=15;  
             int   SAVINGS_ACCOUNT=1; 
             int   CHECKING_ACCOUNT=2;
             CustomerAccount  savings=new  CustomerAccount(SAVINGS_ACCOUNT,1000);  
             CustomerAccount  checking=new   CustomerAccount(CHECKING_ACCOUNT,1000);  
             NumberFormat   f=NumberFormat.getCurrencyInstance(Locale.US);  
             System.out.println("Total   balance   before   transfers:   "+  f.format(savings.getBalance()+checking.getBalance()));  
             TransfersManager   tm1=new   TransfersManager(checking,savings,transfers1);  
             TransfersManager   tm2=new   TransfersManager(savings,checking,transfers2);  
             Thread   t1=new   Thread(tm1);  
             Thread   t2=new   Thread(tm2);  
              t1.start();  
              t2.start();  
              
              try
                  {  
                    t1.join();  
                    t2.join();  
                  }
              catch(Exception   e){  };  
              System.out.println("Total   balance   after   transfers:   "+  f.format(savings.getBalance()+checking.getBalance()));  
            }  
     }   
