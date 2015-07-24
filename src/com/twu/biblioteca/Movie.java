package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/23/15.
 */
public class Movie {
    private String movieTitle;
    private String movieDirector;
    private String movieYear;
    private String movieRating;

    public Movie(String aTitle, String aDirector, String aYear, String aRating) {
        movieTitle = aTitle;
        movieDirector = aDirector;
        movieYear = aYear;
        movieRating = aRating;
    }

    public String getMovieTitle() { return movieTitle; }

    public String getMovieRating() {
        if (Integer.parseInt(movieRating) == 1) { return movieRating + " star"; }
        else if (Integer.parseInt(movieRating) > 1 || Integer.parseInt(movieRating) <= 10) {
            return movieRating + " stars";
        }
        else { return "No ratings"; }
    }

    public String toString() {
        return "\"" + movieTitle + "\" (" + movieYear + ") by " + movieDirector + ". [" + getMovieRating() + "]\n";
    }

}
