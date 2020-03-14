package IO_Case2;

import java.io.IOException;
import java.util.Scanner;

public class ItemManager {
    public static void main(String[] args) throws IOException {
        String filename = "items.txt";
        Scanner sc =new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("Add new item");
        menu.add("Remove an item");
        menu.add("Update an item's price");
        menu.add("Print the list");
        menu.add("Save to files");
        menu.add("Quit");
        int userChoice;
        NewItems list = new NewItems();
        list.loadStoredCodes(filename);
    }
}
