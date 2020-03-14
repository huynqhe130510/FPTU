/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bisiness.CheckData;
import entity.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author huyNguyen
 */
public class Main {

    public static void main(String[] args) {
        List<Student> ls = new ArrayList<>();
        Validate v = new Validate();
        int i = 0;
        
        while (true) {
            System.out.print("Name: ");
            String name = v.checkInputString();
            System.out.print("Classes: ");
            String className = v.checkInputString();
            System.out.print("Maths: ");
            double math = v.checkInputMark("Maths");
            System.out.print("Chemistry: ");
            double chemistry = v.checkInputMark("Chemistry");
            System.out.print("Physics: ");
            double physics = v.checkInputMark("Physics");
            double average = (math + chemistry + physics) / 3;
            
            char type;
            if (average > 7.5) {
                type = 'A';
            } else if (average >= 6 && average <= 7.5) {
                type = 'B';
            } else if (average >= 4 && average < 6) {
                type = 'C';
            } else {
                type = 'D';
            }
            ls.add(new Student(name, className, math, physics, chemistry, average, type));
            
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (!v.checkYN()) {
                for (Student l : ls) {
                    System.out.println("------- Student " + (++i) + " info -------");
                    System.out.println("Name: " + l.getStudentName());
                    System.out.println("Classes: " + l.getClassName());
                    System.out.println("AVG: " + l.getAverage());
                    System.out.println("Type: " + l.getType());
                }
                
                HashMap<String, Double> getPercentTypeStudent = CheckData.getPercentTypeStudent(ls);
                System.out.println("------- Classification Info -------");
                for (Map.Entry student : getPercentTypeStudent.entrySet()) {
                    System.out.println(student.getKey() + " :" + student.getValue() + "%");
                }
            }
        }
    }
}
