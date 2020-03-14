import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        BST m = new BST();
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
            System.out.println("6.Update price");
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
                    m.insert(new Book(code, name, author, price));
                    break;
                case 3:
                    m.bfs();
                    break;

                case 4:
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("Enter xCode: ");
                    String xcode = sc1.nextLine();
                    m.searchByCode(xcode);
                    break;
//
                case 5:
                    m.bfs();
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("Enter xCode: ");
                    String xcode1 = sc2.nextLine();
                    m.deleteByCopy(xcode1);
                    m.bfs();
                    break;
                case 6:
                    m.bfs();
                    Scanner sc6 = new Scanner(System.in);
                    System.out.print("Enter xCode: ");
                    String xcode6 = sc6.nextLine();
                    System.out.print("Enter new price: ");
                    double xpr = sc6.nextDouble();
                    m.update(xcode6, xpr);
                    m.bfs();
                    break;
            }
        } while (true);
    }

}