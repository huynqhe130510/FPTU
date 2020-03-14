/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author huyNguyen
 */
public class Movie {
    int id;
    String title;
    
    ArrayList<Movie_Type> movie_Types;

    public ArrayList<Movie_Type> getMovie_Types() {
        return movie_Types;
    }

    public void setMovie_Types(ArrayList<Movie_Type> movie_Types) {
        this.movie_Types = movie_Types;
    }

    public Movie() {
    }

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
