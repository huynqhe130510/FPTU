package W3;

// ======= DO NOT EDIT THIS FILE ============
import java.io.*;
import java.util.ArrayList;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       
        ArrayList<CanBo> a = new ArrayList();
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            System.out.print("Ten Can Bo: ");
            String name = in.readLine();
            System.out.print("Loai Can Bo: ");
            String type = in.readLine();
            a.add(new CanBo(type,name));
        }
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).getTen());
        }
    }}
