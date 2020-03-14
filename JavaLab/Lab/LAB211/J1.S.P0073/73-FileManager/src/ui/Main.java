package ui;

import business.AddExpense;
import business.DeleteExpense;
import entity.Expenses;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author huyNguyen
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Expenses> le = new ArrayList<>();
        int id = 1;
        while (true) {
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = Validate.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    System.out.print("Enter Date: ");
                    String date = Validate.checkInputDate();
                    System.out.print("Enter Amount: ");
                    double amount = Validate.checkInputDouble();
                    System.out.print("Enter Content: ");
                    String content = Validate.checkInputString();
                    AddExpense.addExpense(le, new Expenses(id++, date, amount, content));

                    break;
                case 2:
                    if (le.size() == 0) {
                        System.err.println("List Expenses empty");
                        return;
                    }
                    double total = 0;
                    System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
                    for (int i = 0; i < le.size(); i++) {
                        System.out.printf("%-7d%-20s%-20.0f%-20s\n", le.get(i).getId(), le.get(i).getDate(),
                                le.get(i).getAmount(), le.get(i).getContent());
                        total += le.get(i).getAmount();
                    }
                    System.out.printf("Total: %-20.0f\n", total);
                    break;
                case 3:
                    System.out.print("Enter id: ");
                    int type = DeleteExpense.deleteExpense(le);
                    switch (type) {
                        case 1:
                            System.out.println("Delete success !");
                            break;
                        case 2:
                            System.err.println("Delete fail !");
                            break;
                    }
                    id--;
                    break;
                case 4:
                    return;
            }
        }
    }
}
