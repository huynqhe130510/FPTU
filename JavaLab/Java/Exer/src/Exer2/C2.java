package Exer2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C2 {

    static class Person {

        String name;
        String id;
        int age;

        public Person() {
        }

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return id + ":" + name + ":" + age;
        }

    }

    static class Employee extends Person {

        double salary;

        public Employee() {
        }

        public Employee(String id, String name, int age, double salary) {
            super(id, name, age);
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        double getsalary() {
            return salary + ((age-20)*0.01);
        }

        @Override
        public String toString() {
            return id + ":" + name + ":" + age + ":" + salary;
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
        System.out.print("Enter worker age: ");
        int age = Integer.parseInt(in.readLine());
        System.out.println("OUTPUT:");
        Employee a = new Employee(id, name, age, salary);
        System.out.println(a.getsalary());
    }
}
