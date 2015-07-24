package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/19/15.
 */
public class ListMoviesItem extends AppMenuItem {
    public ListMoviesItem(String aNumber, String theText){
        super(aNumber, theText);
    }

    public String menuActions(ItemLists theLists) {
        return displayMovieList(theLists);
    }

    public String toString() {
        return super.toString();
    }

    public static String displayMovieList(ItemLists theLists) {
        String movies = "These are our movies:\n";
        for (Movie movie : theLists.availableMovies) {
            movies += movie.toString();
        }
        return movies;
    }
}
