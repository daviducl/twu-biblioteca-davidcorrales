package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/19/15.
 */
public class ListBooksItem extends AppMenuItem, ItemLists {
    public ListBooksItem(String aNumber, String theText){
        super(aNumber, theText);
    }

    public String menuActions(MovieLists theMovieLists) {
        return displayBookList(theMovieLists);
    }

    public String toString() {
        return super.toString();
    }

    public static String displayBookList(MovieLists theMovieLists) {
        String movies = "These are our movies:\n";
        for (Movie movie : theMovieLists.availableMovies) {
            movies += movie.toString();
        }
        return movies;
    }
}
