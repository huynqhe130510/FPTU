package employees;

import java.io.IOException;
import java.util.Scanner;

public class ManagerProgram {

    public static void main(String[] args) throws IOException {
        String fileName = "Employee.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("Add new employee");
        menu.add("Remove an employee");
        menu.add("Promoting the employee's salary");
        menu.add("Print the list");
        menu.add("Save to files");
        menu.add("Quit");
        int userChoice;
        boolean changed = false;
        EmpList List = new EmpList();
        List.AddFromFile(fileName);
        do {
            System.out.println("\nEmployee manager ");
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case 1:
                    List.addNewEmp();
                    changed = true;
                    break;
                case 2:
                    List.removeEmp();
                    changed = true;
                    break;
                case 3:
                    List.promote();
                    changed = true;
                    break;
                case 4:
                    List.print();
                    break;
                case 5:
                    List.saveToFile(fileName);
                    changed = false;
                default:
                    if (changed) {
                        System.out.println("Save changes Y/N ?");
                        String response = sc.nextLine().toUpperCase();
                        if (response.startsWith("Y")) {
                            List.saveToFile(fileName);
                        }
                    }
            }
        } while (userChoice > 0 && userChoice <6);
    }
}
