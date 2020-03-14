    
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        MyList m = new MyList();
        Scanner in = new Scanner(System.in);
        int input;
        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Book list:");
            System.out.println("1.Load data from file");
            System.out.println("2.Input & add to the end");
            System.out.println("3.Display data");
            System.out.println("4.Search by Name");
            System.out.println("5.Delete by Name");
            System.out.println("6.Sort by Code");
            System.out.println("7.Add after position  k");
            System.out.println("8.Delete the node after the node having code = xCode");
            System.out.print("Enter choose: ");
            input = in.nextInt();
            switch (input) {
                case 1:
                    m.load();
                    break;
                case 2:
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter code: ");
                    String code = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter price: ");
                    Double price = sc.nextDouble();
                    m.addLast(new Book(code, name, author, price));
                    break;
                case 3:
                    m.traversal();
                    break;

                case 4:
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("Enter xName: ");
                    String xname = sc1.nextLine();
                    m.searchByName(xname);
                    break;

                case 5:
                    m.traversal();
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("Enter xName: ");
                    String xname1 = sc2.nextLine();
                    m.remove(m.getByName(xname1));
                    m.traversal();
                    break;

                case 6:
                    m.sortByCode();
                    m.traversal();
                    break;

                case 7:
                    int k;
                    Scanner sc4 = new Scanner(System.in);
                    System.out.print("Enter code: ");
                    String code1 = sc4.nextLine();
                    System.out.print("Enter name: ");
                    String name1 = sc4.nextLine();
                    System.out.print("Enter author: ");
                    String author1 = sc4.nextLine();
                    System.out.print("Enter price: ");
                    Double price1 = sc4.nextDouble();
                    System.out.print("Enter poposition k: ");
                    k = sc4.nextInt();
                    Book b = new Book(code1, name1, author1, price1);
                    m.addAfterPs(k,b);
                    m.traversal();
                    break;
                case 8:
                    m.traversal();
                    Scanner sc3 = new Scanner(System.in);
                    System.out.print("Enter xCode: ");
                    String xcode = sc3.nextLine();
                    if(m.getNode(m.getByCode(xcode)) != null)
                    m.remove(m.getByCode(xcode));
                    m.traversal();
                    break;
                case 9:
                    m.sortByCode3();
                    m.traversal();
                    break;
                case 10:
                    m.traversal();
                    Scanner sc10 = new Scanner(System.in);
                    System.out.print("Enter xPrice: ");
                    double xPrice = sc10.nextDouble();
                    m.remove(m.getByPrice(xPrice));
                    m.traversal();
                    break;
               


            }
        } while (true);
    }

}
