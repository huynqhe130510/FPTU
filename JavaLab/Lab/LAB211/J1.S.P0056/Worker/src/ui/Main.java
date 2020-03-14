/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.WorkerManagement;
import entity.SalaryHistory;
import entity.Worker;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author huyNguyen
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Worker> list = new ArrayList<>();
        WorkerManagement wm = new WorkerManagement(list);
        Validate validate = new Validate();
        Worker w = new Worker();
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.println("1. Add worker.");
            System.out.println("2. Increase salary for worker.");
            System.out.println("3. Decrease for worker");
            System.out.println("4. Show adjusted salary worker information");
            System.out.println("5. Exist");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();
            while (true) {
                if (validate.checkIndex(choice)) {
                    break;
                } else {
                    System.out.print("Input again");
                    choice = sc.nextLine();
                }
            }

            int index = Integer.parseInt(choice);

            switch (index) {
                case 1: {
                    System.out.println("===== Add Worker =====");
                    System.out.print("Enter code: ");
                    String code = sc.nextLine();
                    while (true) {
                        if (validate.checkCode(code, wm.getWorkers())) {
                            break;
                        } else {
                            System.out.print("Input code again: ");
                            code = sc.nextLine();
                        }
                    }
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    while (true) {
                        if (validate.checkName(name)) {
                            break;
                        } else {
                            System.out.print("Input name again: ");
                            name = sc.nextLine();
                        }
                    }
                    System.out.print("Enter age: ");
                    String age = sc.nextLine();
                    while (true) {
                        if (validate.checkage(age)) {
                            break;
                        } else {
                            System.out.print("Age must be [18-50]");
                            System.out.print("\nInput age again: ");
                            age = sc.nextLine();
                        }
                    }
                    int ageOfWorker = Integer.parseInt(age);
                    System.out.print("Enter salary: ");
                    String salary = sc.nextLine();
                    while (true) {
                        if (validate.checkSalary(salary)) {
                            break;
                        } else {
                            System.out.print("Input salary again: ");
                            salary = sc.nextLine();
                        }
                    }
                    int salaryOfWorker = Integer.parseInt(salary);
                    System.out.print("Enter location: ");
                    String location = sc.nextLine();
                    while (true) {
                        if (validate.checkLocation(location)) {
                            break;
                        } else {
                            System.out.print("Input location again: ");
                            location = sc.nextLine();
                        }
                    }
                    w = new Worker(code, name, ageOfWorker, location, salaryOfWorker);
                    wm.addWorker(w);
                    count++;
                    break;
                }
                case 2:
                    if (count == 0) {
                        System.err.println("List is empty");
                    } else {
                        System.out.println("===== Up Salary =====");
                        System.out.print("Enter code: ");
                        String code = sc.nextLine();
                        int salaryOfW = 0;
                        while (true) {
                            if (validate.inputCode(code, wm.getWorkers())) {
                                Worker k = wm.searchWorker(code);
                                System.out.print("Enter salary: ");
                                String salary = sc.nextLine();
                                try {
                                    salaryOfW = Integer.parseInt(salary);
                                } catch (Exception e) {
                                }
                                while (!validate.checkSalaryIncrease(k.getCurrentSalary(), salaryOfW)) {
                                    System.out.println("Try agian: ");
                                    salary = sc.nextLine();
                                    try {
                                        salaryOfW = Integer.parseInt(salary);
                                    } catch (Exception e) {
                                    }
                                }
                                wm.increaseSalary(salaryOfW, code);
                                break;
                            } else {
                                System.err.print("Code does not exist .Enter code again: ");
                                code = sc.nextLine();
                            }
                        }
                    }
                    break;
                case 3:
                    if (count == 0) {
                        System.err.println("List is empty");
                    } else {
                        System.out.println("===== Down Salary =====");
                        System.out.print("Enter code: ");
                        String code = sc.nextLine();
                        int salaryOfW = 0;
                        while (true) {
                            if (validate.inputCode(code, wm.getWorkers())) {
                                Worker k = wm.searchWorker(code);
                                System.out.print("Enter salary: ");
                                String salary = sc.nextLine();
                                try {
                                    salaryOfW = Integer.parseInt(salary);
                                } catch (Exception e) {
                                }
                                while (!validate.checkSalaryDecrease(k.getCurrentSalary(), salaryOfW)) {
                                    System.out.println("Try agian: ");
                                    salary = sc.nextLine();
                                    try {
                                        salaryOfW = Integer.parseInt(salary);
                                    } catch (Exception e) {
                                    }
                                }
                                wm.decreaseSalary(salaryOfW, code);
                                break;
                            } else {
                                System.err.print("Code does not exist .Enter code again: ");
                                code = sc.nextLine();
                            }
                        }
                    }
                    break;
                case 4:
                    if (count == 0) {
                        System.err.println("List is empty");
                    } else {
                        System.out.println("===== Display =====");
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
                        for (Worker k : wm.getWorkers()) {
                            List<SalaryHistory> history = k.getHistory();
                            for (SalaryHistory s : history) {
                                System.out.printf("%-20s%-20s%-20d%-20d%-20s%-20s\n", k.getCode(), k.getName(), k.getAge(),
                                        s.getNewSalary(), s.getStatus(), s.getDate());
                            }
                        }
                    }
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Plaese enter choice [1-5]");
                    break;
            }
        }
    }
}
