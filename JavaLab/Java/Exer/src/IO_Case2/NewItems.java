package IO_Case2;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewItems extends Vector<Item> {

    Scanner sc = new Scanner(System.in);
    Vector<String> storeCodes = new Vector<String>();

    public NewItems() {
        super();
    }

    public void loadStoredCodes(String fName) throws IOException {
        if (storeCodes.size() > 0) {
            storeCodes.clear();
        }
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String code, name, priceStr;
            while ((code = bf.readLine()) != null
                    && (name = bf.readLine()) != null
                    && (priceStr = bf.readLine()) != null) {
                storeCodes.add(code);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean valid(String aCode) {
        int i;
        for (i = 0; i < storeCodes.size(); i++) {
            if (aCode.equals(storeCodes.get(i))) {
                return false;
            }
        }
        for (i = 0; i < this.size(); i++) {
            if (aCode.equals(this.get(i).getCode())) {
                return false;
            }
        }
        return true;
    }

    private int find(String aCode) {
        return 0;
    }

    public void appendToFile(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            boolean append = true;
            File f = new File(fName);
            FileWriter fw = new FileWriter(f, append);
            PrintWriter pw = new PrintWriter(fw);
            for (Item x : this) {
                pw.println(x.getCode());
                pw.println(x.getName());
                pw.println(x.getPrice());
                pw.flush();
            }
            pw.close();
            fw.close();
            this.loadStoredCodes(fName);
            this.clear();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addNewItem() {
        String newCode, newName;
        int price;
        boolean duplicated = false, matched = true;
        System.out.println("Enter New Item Details");
        do {
            System.out.println("   code(format 1000: ");
            newCode = sc.nextLine().toUpperCase();
            duplicated = !valid(newCode);
            matched = newCode.matches("^I\\d(3)$");
            if (duplicated) {
                System.out.println("   The code is duplicate.");
            }
            if (!matched) {
                System.out.println("   The code: I and 3 digits.");
            }
        } while (duplicated || (!matched));
        System.out.print("   name: ");
        newName = sc.nextLine().toUpperCase();
        System.out.println("   price: ");
        price = Integer.parseInt(sc.nextLine());
        this.add(new Item(newCode, newName, price));
        System.out.println("New Item has been added");
    }

    public void removeItem() {

    }

    public void updatePrice() {

    }

    public void print() {

    }
}
