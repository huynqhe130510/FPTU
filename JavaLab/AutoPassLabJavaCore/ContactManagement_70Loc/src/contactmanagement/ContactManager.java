/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ニャット
 */
public class ContactManager {

    private ArrayList<Contact> contacts;
    private int idcounter;

    public ContactManager() {
        contacts = new ArrayList<>();
        idcounter = 1;
    }

    public void addContact() {
        System.out.println("-------- Add a Contact --------");
        String fname = InputValidate.getStringByRegex("Enter Name : ", "Please enter character only!", "[A-Za-z ]+");
        fname = InputValidate.normalFormName(fname);
        String group = InputValidate.getStringByRegex("Enter Group : ", "Please enter character only!", "[A-Za-z]+");
        group = String.valueOf(group.charAt(0)).toUpperCase() + group.substring(1);
        String address = InputValidate.getStringByRegex("Enter Address : ", "Please enter character only!", "[A-Za-z]+");
        address = String.valueOf(address.charAt(0)).toUpperCase() + address.substring(1);
        String phoneflow = "Please input Phone flow\n"
                + "• 1234567890\n"
                + "• 123-456-7890\n"
                + "• 123-456-7890 x1234\n"
                + "• 123-456-7890 ext1234\n"
                + "• (123)-456-7890\n"
                + "• 123.456.7890\n"
                + "• 123 456 7890";
        String phoneRegex = "^\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}((x)|(ext)\\d{4})?$";
        String phone = InputValidate.getStringByRegex("Enter Phone : ", phoneflow, phoneRegex);
        Contact con = new Contact(idcounter, fname, group, address, phone);
        contacts.add(con);
        idcounter++;
        System.out.println("Successful");
    }

    public void display() {
        if (contacts.isEmpty()) {
            System.out.println("Database is empty! Please add contact first!");
            return;
        }
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.println("ID    Name          First Name   Last Name    Group   Address    Phone            ");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("%-6d%-14s%-13s%-13s%-8s%-11s%-17s\n", i + 1, 
                contacts.get(i).getFname(), contacts.get(i).fstname, contacts.get(i).getLname(),
                contacts.get(i).getGroup(), contacts.get(i).getAddress(), contacts.get(i).getPhone());
        }
    }

    public void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("Database is empty! Please add contact first!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        int delID = 0;
        try {
            System.out.print("Enter ID : ");
            delID = Integer.parseInt(sc.nextLine());
            if (delID < 1 || delID > contacts.size()) {
                System.out.println("Didnt found ID!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("ID is digit!");
        }
        contacts.remove(delID - 1);
        System.out.println("Successful");
    }

    public void ui() {
        System.out.println("========= Contact program =========");
        System.out.println("1. Add a Contact");
        System.out.println("2. Display all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
    }
}
