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
public class Movie_Type {
    Movie movie;
    Type type;
    ArrayList<Movie> movies;
    ArrayList<Type> types;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Type> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Type> types) {
        this.types = types;
    }

    public Movie_Type(Movie movie, Type type, ArrayList<Movie> movies, ArrayList<Type> types) {
        this.movie = movie;
        this.type = type;
        this.movies = movies;
        this.types = types;
    }

    public Movie_Type() {
    }

    public Movie_Type(Movie movie, Type type) {
        this.movie = movie;
        this.type = type;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
}
