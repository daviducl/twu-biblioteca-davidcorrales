package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/23/15.
 */
public class MovieLists {
    ArrayList<MovieDetails> allMovies = new ArrayList<MovieDetails>();
    ArrayList<MovieDetails> checkedOutMovies = new ArrayList<MovieDetails>();
    ArrayList<MovieDetails> availableMovies = new ArrayList<MovieDetails>();

    public MovieLists() {
        MovieDetails angelsMovie = new MovieDetails("Angels and Demons", "Dan Brown", "2009", "4");
        MovieDetails looperMovie = new MovieDetails("Looper", "Rian Johnson", "2012", "3");
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

    public void checkIn(String aTitle) {
        if (checkIfMovieOnList(checkedOutMovies, aTitle)) {
            checkedOutMovies.remove(getMovieByTitle(aTitle));
            availableMovies.add(getMovieByTitle(aTitle));
            System.out.print("Thank you for returning the Movie\n");
        } else {
            System.out.print("This is not a valid Movie to return\n");
        }
    }

    public boolean checkIfMovieOnList(ArrayList<MovieDetails> theList, String aTitle){
        for (MovieDetails Movie : theList) {
            if (Movie.getMovieTitle().equals(aTitle)) {
                return true;
            }
        }
        return false;
    }

    public MovieDetails getMovieByTitle(String aTitle) {
        for (MovieDetails Movie : allMovies) {
            if (Movie.getMovieTitle().equals(aTitle)) {
                return Movie;
            }
        }
        return null;
    }
}
