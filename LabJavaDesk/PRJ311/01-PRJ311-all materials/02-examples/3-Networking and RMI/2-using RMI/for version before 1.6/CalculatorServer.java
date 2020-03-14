import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
public class CalculatorServer
  { public CalculatorServer()
       {
         try
           { Calculator c = new CalculatorImpl();
             LocateRegistry.createRegistry(1099);
             Naming.rebind("rmi://localhost:1099/CalculatorServer", c);
             System.out.println("Remote methods are ready to be used...");
           } catch (Exception e) { System.out.println("Trouble: " + e); }
       }
    public static void main(String args[])
       { new CalculatorServer();
       }
  }

/*
  Gia su may chu co dia chi 10.170.72.229, khi do lenh
             Naming.rebind("rmi://localhost:1099/CalculatorServer", c);
  co the thay bang lenh
             Naming.rebind("rmi://10.170.72.229:1099/CalculatorServer", c);
  Thuc chat 2 lenh tren la nhu nhau vi chuong trinh dang chay tren may chu
*/