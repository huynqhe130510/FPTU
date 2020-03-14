package Exer2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C1 {

    static class Worker {

        String id;
        String name;
        int level;
        double salary;

        public Worker() {
        }

        public Worker(String id, String name, int level, double salary) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.salary = salary;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            if(level >= 1 && level <= 7){
                return level;
            }
            else if(level < 1){
                return 1;
            }
            return 7;
        }

        double Getsalary() {
            double pc = (salary * level * 5 / 100);
            return salary + pc;
        }

        @Override
        public String toString() {
            return id + ":" + name + " " + level + "-" + salary ;
        }
        
    }


    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter worker id: ");
        String id = in.readLine();
        System.out.print("Enter worker name: ");
        String name = in.readLine();
        System.out.print("Enter worker salary: ");
        double salary = Double.parseDouble(in.readLine());
        System.out.print("Enter worker level: ");
        int level = Integer.parseInt(in.readLine());
        System.out.println("OUTPUT:");
        Worker a = new Worker(id, name, (int) salary, level);
        System.out.println(a.Getsalary());
    }
}
