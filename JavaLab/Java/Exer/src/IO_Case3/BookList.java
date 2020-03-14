package books;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;

public class BookList extends Vector<Book>{
    Scanner sc = new Scanner(System.in);
    public void loadBookFromFile(String fName){
        if(this.size()>0)
            this.clear();
        try{
            File f = new File(fName);
            if(!f.exists()) return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Book b;
            while((b = (Book)(fo.readObject())) != null){
                this.add(b);
            }
            fo.close();
            fi.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void saveToFile(String fName){
        if(this.size()==0){
            System.out.println("Empty list.");
            return;
        }
        try{
            FileOutputStream f = new FileOutputStream(fName);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for(Book b:this) fo.writeObject(b);
            fo.close();
            f.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void addNewBook(){
        String title;
        int price;
        System.out.println("Enter new book details: ");
        System.out.println("   title: ");
        title = sc.nextLine().toUpperCase();
        System.out.println("   price: ");
        price = Integer.parseInt(sc.nextLine());
        this.add(new Book (title, price));
        System.out.println("New book has been added.");
    }
    
    public void print(){
        if(this.size()==0){
            System.out.println("Empty list.");
            return;
        }
        System.out.println("\nNew-item list");
        System.out.println("---------------------");
        for(Book x: this) x.print();
    }
}
