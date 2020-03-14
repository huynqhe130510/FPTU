public class Main {

  public static void main(String [] args)
   {MyList g = new MyList();
    String [] a = {"A1","A2","A3","A4","A5","A6"};
    String [] b = {"Hoa","La","Canh","Cay","Man","Dao"};
    String [] bb = {"Hoa","Lawa","Canh","aLa","Cay","uLa"};
    int [] c = {300,400,200,600,700,200};
    int [] d = {20,25,19,30,20,90};
    int k; String xName,xCode;
    MyList h;
   
    System.out.println("\n1. Test add & traverse");  
    g.clear();
    g.addMany(a,b,c,d);
    g.traverse();
    System.out.println();
  
    System.out.println("\n2. Test add & traverse");  
    g.clear();
    g.addMany(a,b,c,d);
    g.traverse();
    xCode = "A3";
    k = g.searchByCode(xCode);
    if(k>=0)
     System.out.println("Found at index " + k);
      else
      System.out.println("Not found");
   

    System.out.println("\n3. Test search by name to MyList object");  
    xName = "La";
    h = new MyList();
    g.clear();
    g.addMany(a,b,c,d);
    g.searchByName(h,xName);    
    h.traverse();
    System.out.println();


    System.out.println("\n4. Test search by name (relative) to MyList object");  
    xName = "La";
    h.clear();
    g.clear();
    g.addMany(a,b,c,d);
    g.searchByNameRel(h,xName);    
    h.traverse();
    System.out.println();



    System.out.println("\n5. Test delete position i");  
    g.clear();
    g.addMany(a,b,c,d);
    g.traverse();
    k = 2;
    g.dele(k);
    System.out.println("After deleting position " + k);
    g.traverse();
    System.out.println();


    System.out.println("\n6. Test delete name");  
    g.clear();
    g.addMany(a,b,c,d);
    g.traverse();
    xName = "La";
    System.out.println("After deleting name " + xName);
    g.dele(xName);
    g.traverse();
    System.out.println();



    System.out.println("\n7. Test sort by name");  
    g.clear();
    g.addMany(a,b,c,d);
    g.traverse();
    System.out.println("After sorting name");
    g.sortByName();
    g.traverse();
    System.out.println();
    System.out.println();
   }
    
}
