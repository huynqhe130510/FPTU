/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.CharacterDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author huyNguyen
 */
public class Character {

    String id;
    String name;
    boolean gender;
    String date;
    ArrayList<Skill> s;

    public ArrayList<Skill> getS() {
        CharacterDAO characterDAO = new CharacterDAO();
        s = characterDAO.getSkills(id);
        return s;
    }

    public void setS(ArrayList<Skill> s) {
        this.s = s;
    }

    public Character() {
    }

    public Character(String id, String name, boolean gender, String date) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
