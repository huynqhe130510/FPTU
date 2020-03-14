// ======= DO NOT EDIT MAIN FUNCTION ============

import java.io.*;
import java.util.*;

public class Main {

    /*public static void OutputList(List<Course> c) {
        for (Course x : c) {
            System.out.println(x.getName());
        }
    }*/
    static void addMany(List<Course>a,String []u,double [] v){
        for(int i=0;i<u.length;i++){
            a.add(new Course (u[i],v[i]));
        }
    }
    static void display(List<Course> a){
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
        System.out.println("");
    }
    public static void main(String args[]) throws Exception {
       /* BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<Course> a = new ArrayList();
        a.add(new Course("PRJ311", 110));
        a.add(new Course("DBI202", 150));
        a.add(new Course("PRF192", 120));
        System.out.print("Add more how many course: ");
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println("");
            System.out.print("Course name: ");
            String name = in.readLine();
            System.out.print("Course fee: ");
            double fee = Double.parseDouble(in.readLine());
            a.add(new Course(name, fee));
        }
        System.out.println("");
        System.out.print("Enter test function (1-f1;2-f2): ");
        int c = Integer.parseInt(in.readLine());
        ICourse i = new MyCourse();
        int st = 0;
        double fee = 0;
        if (c == 2) {
            System.out.print("Enter course fee: ");
            fee = Double.parseDouble(in.readLine());
        } else if (c == 1) {
            System.out.print("Enter st: ");
            st = Integer.parseInt(in.readLine());
        }
        System.out.println("");
        System.out.println("OUTPUT:");
        if (c == 1) {
            i.f1(a, st);
            OutputList(a);
        } else if (c == 2) {
            System.out.println(i.f2(a, fee));
        }*/
       String []u ={"A","B","C","D","E"};
       double []v={9,8,7,5,4};
       double [] w ={3,7,2,8,4};
       ArrayList<Course> a= new ArrayList<Course>();
       MyCourse t =new MyCourse();
       addMany(a,u,v);
       display(a);
       t.f3(a,1,3);
       display(a);
       a.clear();
       addMany(a,u,w);
       display(a);
       t.f4(a, 5);
       display(a);
       t.f5(a);
       display(a);
    }
}
