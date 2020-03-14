/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author huyNguyen
 */
public class Contact {

    public Contact(int id, String firstName, String lastName, Date CreatedDate, String phoneNumber, Group group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.CreatedDate = CreatedDate;
        this.phoneNumber = phoneNumber;
        this.group = group;
    }

    public Contact() {
    }

    int id;
    String firstName;
    String lastName;
    Date CreatedDate;
    String phoneNumber;
    Group group;

    public Contact(int id, String fir, String las, int phone, int group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
