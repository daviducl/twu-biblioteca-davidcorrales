package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/19/15.
 */
public class ListMoviesItem extends AppMenuItem {
    public ListMoviesItem(String aNumber, String theText){
        super(aNumber, theText);
    }

    public String menuActions(Biblioteca theLists) {
        return displayMovieList(theLists);
    }

    public String toString() {
        return super.toString();
    }

    public static String displayMovieList(Biblioteca biblioteca) {
        String movies = "These are our movies:\n";
        for (Movie movie : biblioteca.getAvailableMovies()) {
            movies += movie.toString();
        }
        return movies;
    }
}
