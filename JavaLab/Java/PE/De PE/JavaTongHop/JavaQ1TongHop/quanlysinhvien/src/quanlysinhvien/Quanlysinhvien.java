/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysinhvien;

//import java.awt.BorderLayout;
import java.util.Scanner;

public class Quanlysinhvien {
    
    private Student student [];
    private int number;
    public void input(){
        Scanner s= new Scanner(System.in);
        System.out.println("Enter number of students: ");
        number = s.nextInt();
        student= new Student[number];
        for(int i= 0; i< number; i++){
            System.out.println("Student " + i+":");
            System.out.println("\tEnter name: " );
            String name = s.next();
            System.out.println("\tEnter ID: " );
            String id = s.next();
            System.out.println("\tEnter age: ");
            int age = s.nextInt();
            this.student[i] = new Student(age,id,name);
            
        }
    }   
    public void show(){
        for(int i = 0 ; i< number; i++){
            this.student[i].view();
        }
    }
    public void sort(){
        
        Student tmp_st;
       
        for(int i = 0; i < this.number-1; i++){
            for(int j = i+1; j < this.number; j++){
                if(this.student[i].getA() > this.student[j].getA()){
                    tmp_st = this.student[i];
                    this.student[i]= this. student[j];
                    this.student[j] = tmp_st;
                }
            }
        }
    }
        public void sortID(){
        
        Student tmp_st;
       
        for(int i = 0; i < this.number-1; i++){
            for(int j = i+1; j < this.number; j++){
                if(this.student[i].getB().charAt(0) > this.student[j].getB().charAt(0)){
                    tmp_st = this.student[i];
                    this.student[i]= this. student[j];
                    this.student[j] = tmp_st;
                }
            }
        }
    }
    public static void main(String[] args) {
        Quanlysinhvien array = new Quanlysinhvien();
        Scanner s = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("1.INPUT: \n");
            System.out.println("2.OUTPUT: \n");
            System.out.println("3.SORT AGE\n");
            System.out.println("4.SORT ID\n");
            System.out.println("\tCHOICE: \n");
            choice = s.nextInt();
            switch(choice){
                case 1:{
                     array.input();
                     break;
                }
                case 2:{
                    array.show();
                    break;
                }
                case 3:{
                array.sort();
                array.show();
                break;
                }
                case 4:{
                array.sortID();
                array.show(); 
                break;
                }
                default:{
                    System.out.println("INPUT FAIL.TRY AGAIN\n");
                    break;
                }
            }
        }
    }
}
