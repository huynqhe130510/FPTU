/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagement;

/**
 *
 * @author ニャット
 */
public class Contact {

    private int ID;
    private String fname;
    private String group;
    private String address;
    private String phone;
    private String lname;
    String fstname;

    Contact(int ID, String fname, String group, String address, String phone) {
        this.ID = ID;
        this.address = address;
        this.phone = phone;
        this.group = group;
        this.fname = fname;
        int i = 0;
        String[] splited = fname.split("\\s+");
        while (i < splited.length) {
            if (i == 0) {
                this.fstname = splited[i];
            } else {
                this.lname = splited[i];
            }
            if (splited.length == 1) {
                this.lname = "";
            }
            i++;
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFstname() {
        return fstname;
    }

    public void setFstname(String fstname) {
        this.fstname = fstname;
    }
    
}
