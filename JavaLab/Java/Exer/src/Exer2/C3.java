package Exer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C3 {

    static class Computer {

        String name;
        String configuration;
        double price;

        public Computer() {
        }

        public Computer(String name, String configuration, double price) {
            this.name = name;
            this.configuration = configuration;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getConfiguration() {
            return configuration;
        }

        public void setConfiguration(String configuration) {
            this.configuration = configuration;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " " + configuration.replace("+", " ") + " " + price;
        }
    }

    static class myComputer implements iComputer {

        @Override
        public void f1(List<Computer> a, double price) {
            for (int i = 0; i < a.size(); i++) {
                double temp = a.get(i).getPrice();
                if (temp < price) {
                    temp = temp + temp * 10 / 100;
                    System.out.println(a.get(i).getName() + " " + temp);
                }
            }
        }

        @Override
        public String f2(List<Computer> a, String configuration) {
            String name = a.get(0).getName();
            int[] x = new int[4];
            int[] y = new int[4];
            deCoding(configuration, x);
            deCoding(a.get(0).getConfiguration(), y);
            boolean update = false;
            int position = 0;
            int minChip = Math.abs(y[0] - x[0]);
            int minRam = Math.abs(y[1] - x[1]);
            int minHDD = Math.abs(y[2] - x[2]);
            int minVga = Math.abs(y[3] - x[3]);
            for (int i = 0; i < a.size(); i++) {
                deCoding(a.get(i).getConfiguration(), y);
                if (Math.abs(y[0] - x[0]) < minChip) {
                    update = true;
                } else if (Math.abs(y[0] - x[0]) == minChip) {
                    if (Math.abs(y[1] - x[1]) < minRam) {
                        update = true;
                    } else if (Math.abs(y[1] - x[1]) == minRam) {
                        if (Math.abs(y[2] - x[2]) < minHDD) {
                            update = true;
                        } else if (Math.abs(y[2] - x[2]) == minHDD) {
                            if (Math.abs(y[3] - x[3]) < minVga) {
                                update = true;
                            } else if (Math.abs(y[3] - x[3]) == minVga) {
                                update = true;// Tim cau hinh cuoi cung trong list gan voi cau hinh dua vao
                            }
                        }
                    }
                }
                if (update) {
                    minChip = Math.abs(y[0] - x[0]);
                    minRam = Math.abs(y[1] - x[1]);
                    minHDD = Math.abs(y[2] - x[2]);
                    minVga = Math.abs(y[3] - x[3]);
                    position = i;
                    name = a.get(i).getName();
                }
            }

            return name;
        }

        private void deCoding(String configuration, int[] x) {
            String[] s1 = configuration.split("\\+");
//            StringTokenizer st = new StringTokenizer(configuration, "+");
            for (int i = 0; i < s1.length; i++) {
                x[i] = Integer.parseInt(s1[i].trim());
            }
        }

    }

    public static void main(String[] args) {
        System.out.print("Enter number of computer: ");
        Scanner sc = new Scanner(System.in);
        ArrayList<Computer> v = new ArrayList();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter configuration: ");
            String configuration = sc.nextLine();
            System.out.print("Enter price: ");
            double price = Double.parseDouble(sc.nextLine());
            v.add(new Computer(name, configuration, price));
        }
        System.out.print("Enter price1");
        double price1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter type: ");
        int c = Integer.parseInt(sc.nextLine());
        iComputer i = new myComputer();
        System.out.print("Enter configuration: ");
        String configuration1 = sc.nextLine();

        if (c == 1) {
            System.out.print("OUTPUT of f1:");
            i.f1(v, price1);

        } else if (c == 2) {
            System.out.print("OUTPUT of f2: ");
            System.out.println(i.f2(v, configuration1));
        }
    }

}
