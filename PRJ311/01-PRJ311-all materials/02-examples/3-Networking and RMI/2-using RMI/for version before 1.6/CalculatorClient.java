import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 
public class CalculatorClient
   { public static void main(String[] args)
       { 
         try
           {
            //Calculator c = (Calculator) Naming.lookup("rmi://10.22.114.150/CalculatorServer"); 
            //Calculator c = (Calculator) Naming.lookup("rmi://10.22.114.111/CalculatorServer"); 
            Calculator c = (Calculator) Naming.lookup("rmi://localhost/CalculatorServer"); 
            System.out.println( c.sub(4, 3) ); 
            System.out.println( c.add(4, 5) ); 
            System.out.println( c.mul(3, 6) ); 
            System.out.println( c.div(9, 3) ); 
          } 
        catch (MalformedURLException murle)
          { System.out.println(); 
            System.out.println("MalformedURLException"); 
            System.out.println(murle); 
          } 
        catch (RemoteException re)
          { System.out.println(); 
            System.out.println("RemoteException"); 
            System.out.println(re); 
          } 
        catch (NotBoundException nbe)
          { System.out.println(); 
            System.out.println("NotBoundException"); 
            System.out.println(nbe); 
          } 
        catch (java.lang.ArithmeticException   ae)
          { System.out.println(); 
            System.out.println("ArithmeticException"); 
            System.out.println(ae); 
          } 
      } 
  }

/*
  Gia su may chu co dia chi 10.170.72.229 va khac voi may client khi do lenh
           Calculator c = (Calculator) Naming.lookup("rmi://localhost/CalculatorServer"); 
  phai thay bang lenh:
           Calculator c = (Calculator) Naming.lookup("rmi://10.170.72.229/CalculatorServer"); 
*/