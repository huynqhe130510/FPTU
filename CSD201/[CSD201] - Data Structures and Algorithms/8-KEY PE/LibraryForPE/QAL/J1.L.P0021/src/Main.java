
import java.util.Scanner;

public class Main {

    public static boolean checkOption(String option) {
        boolean check = false;
        int op;
        if (option.equals("")) {
            check = false;
            System.out.println(" Your input is empty");
        }
        for (int i = 0; i < option.length(); i++) {
            if (Character.isDigit(option.charAt(i))) {
                op = Integer.parseInt(option);
                if (op >= 1 && op <= 5) {
                    check = true;
                } else {
                    check = false;
                    System.out.println("Enter option in the range between 1 and 5");
                    System.out.println("");
                    break;
                }
            } else {
                check = false;
                System.out.println("Enter option in the range between 1 and 5");
                System.out.println("");

            }
        }
        return check;
    }

    public static int enterOption() {
        Scanner in = new Scanner(System.in);
        int op = 0;
        String option = "";
        do {
            System.out.print("Enter option: ");
            option = in.nextLine();
        } while (!checkOption(option));
        op = Integer.parseInt(option);
        return op;
    }

    public static void main(String[] args) {
        MyList m = new MyList();
        do {
            System.out.println("");
            System.out.println("---------------------------------");
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("\t1. Create");
            System.out.println("\t2. Find and Sort");
            System.out.println("\t3. Update/Delete");
            System.out.println("\t4. Report");
            System.out.println("\t5. Exit");
            int op = enterOption();
            switch (op) {
                case 1:
                    m.create();
                    break;
                case 2:
                    m.Find();
                    break;
                case 3:
                    m.UpdateorDelete();
                    break;
                case 4:
                    m.report();
                    break;
            }

        } while (true);

    }

}
