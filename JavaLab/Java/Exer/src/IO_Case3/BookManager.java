package books;

import java.util.Scanner;

public class BookManager {
    public static void main(String[] args) {
        String filename = "book.dat";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("View books");
        menu.add("Add new book");
        menu.add("Save to file");
        menu.add("Quit");
        int userChoice;
        BookList list = new BookList();
        list.loadBookFromFile(filename);
        do{
            System.out.println("\nBOOK MANAGER");
            userChoice = menu.getUserChoice();
            switch(userChoice){
                case 1: list.print(); break;
                case 2: list.addNewBook(); break;
                case 3: list.saveToFile(filename);
            }
        }
        while(userChoice>0 && userChoice<6);
    }
}
