package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/23/15.
 */
public class MovieLists extends ItemLists {
    ArrayList<Movie> allMovies = new ArrayList<Movie>();
    ArrayList<Movie> checkedOutMovies = new ArrayList<Movie>();
    ArrayList<Movie> availableMovies = new ArrayList<Movie>();

    public MovieLists() {
        Movie angelsMovie = new Movie("Angels and Demons", "Dan Brown", "2009", "4");
        Movie looperMovie = new Movie("Looper", "Rian Johnson", "2012", "3");
        allMovies.add(angelsMovie);
        allMovies.add(looperMovie);
        availableMovies = allMovies;
    }

    public void checkOut(String aTitle) {
        if (checkIfMovieOnList(availableMovies, aTitle)) {
            checkedOutMovies.add(getMovieByTitle(aTitle));
            availableMovies.remove(getMovieByTitle(aTitle));
            System.out.print("Thank you! Enjoy the Movie\n");
        } else {
            System.out.print("That Movie is not available");
        }
    }

    public void checkInMovie(String aTitle) {
        if (checkIfMovieOnList(checkedOutMovies, aTitle)) {
            checkedOutMovies.remove(getMovieByTitle(aTitle));
            availableMovies.add(getMovieByTitle(aTitle));
            System.out.print("Thank you for returning the Movie\n");
        } else {
            System.out.print("This is not a valid Movie to return\n");
        }
    }

    public boolean checkIfMovieOnList(ArrayList<Movie> theList, String aTitle){
        for (com.twu.biblioteca.Movie Movie : theList) {
            if (Movie.getMovieTitle().equals(aTitle)) {
                return true;
            }
        }
        return false;
    }

    public Movie getMovieByTitle(String aTitle) {
        for (com.twu.biblioteca.Movie Movie : allMovies) {
            if (Movie.getMovieTitle().equals(aTitle)) {
                return Movie;
            }
        }
        return null;
    }
}
