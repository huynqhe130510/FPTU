import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 
public class CalculatorClient {
 static Calculator cal;
 public static void main(String[] args) { 
   try {
     //cal = (Calculator) Naming.lookup("rmi://10.22.114.111/CalculatorServer"); 
     cal = (Calculator) Naming.lookup("rmi://localhost/CalculatorServer"); 
     int a, b;
     a = 9; b = 3;
     System.out.println(); 
     System.out.println(cal.intro()); 
     System.out.println(cal.sub(a,b)); 
     System.out.println(cal.add(a,b)); 
     System.out.println(cal.mul(a,b)); 
     System.out.println(cal.div(a,b)); 
    } 
    catch (MalformedURLException murle) {
      } 
    catch (RemoteException re) {
      } 
    catch (NotBoundException nbe) {
      } 
    catch (java.lang.ArithmeticException ae) {
      } 
  } 
 }

/*
  Gia su may chu co dia chi 10.170.72.229 va khac voi may client khi do lenh
           cal = (Calculator) Naming.lookup("rmi://localhost/CalculatorServer"); 
  phai thay bang lenh:
           cal = (Calculator) Naming.lookup("rmi://10.170.72.229/CalculatorServer"); 
*/