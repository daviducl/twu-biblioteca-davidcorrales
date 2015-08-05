package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/24/15.
 */
public class CheckOutMovieItem extends AppMenuItem {
    public CheckOutMovieItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    public String menuActions(Biblioteca biblioteca) {
        Movie movie = biblioteca.checkoutMovie(InputReader.readString("Type a title: "));
        if (movie == null)
            return "That movie is not available";
        else
            return "Thank you! Enjoy the movie";
    }

    public String toString() {
        return super.toString();
    }
}
