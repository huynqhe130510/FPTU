/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysinhvien;

/**
 *
 * @author Administrator
 */

public class Student {
  private int age;
  private  String id;
  private String name;

    public Student(int age, String id, String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }


  public void view(){
      System.out.println(name + "  " +id +"  "+  age +"  ");
  }
  public int getA(){
      return this.age;
  }
  public String getB(){
      return this.id;  
  }
  public String getC(){
      return this.name;
  }
  
}
