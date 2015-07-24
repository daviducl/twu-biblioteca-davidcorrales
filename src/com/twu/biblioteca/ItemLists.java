package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/24/15.
 */
public class ItemLists {
    ArrayList<Book> allBooks = new ArrayList<Book>();
    ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
    ArrayList<Book> availableBooks = new ArrayList<Book>();

    ArrayList<Movie> allMovies = new ArrayList<Movie>();
    ArrayList<Movie> checkedOutMovies = new ArrayList<Movie>();
    ArrayList<Movie> availableMovies = new ArrayList<Movie>();

    public ItemLists() {
        Movie angelsMovie = new Movie("Angels and Demons", "Dan Brown", "2009", "4");
        Movie looperMovie = new Movie("Looper", "Rian Johnson", "2012", "3");
        allMovies.add(angelsMovie);
        allMovies.add(looperMovie);
        availableMovies = allMovies;

        Book infernoBook = new Book("Inferno", "Dan Brown", "2013");
        Book vinciBook = new Book("The Da Vinci Code", "Dan Brown", "2013");
        allBooks.add(infernoBook);
        allBooks.add(vinciBook);
        availableBooks = allBooks;
    }

    public void checkOutMovie(String aTitle) {
        if (checkIfMovieOnList(availableMovies, aTitle)) {
            checkedOutMovies.add(getMovieByTitle(aTitle));
            availableMovies.remove(getMovieByTitle(aTitle));
            System.out.print("Thank you! Enjoy the movie\n");
        } else {
            System.out.print("That movie is not available");
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
        for (Movie movie : theList) {
            if (Movie.getMovieTitle().equals(aTitle)) {
                return true;
            }
        }
        return false;
    }

    public Movie getMovieByTitle(String aTitle) {
        for (Movie movie : allMovies) {
            if (Movie.getMovieTitle().equals(aTitle)) {
                return movie;
            }
        }
        return null;
    }

    public void checkOutBook(String aTitle) {
        if (checkIfBookOnList(availableBooks, aTitle)) {
            checkedOutBooks.add(getBookByTitle(aTitle));
            availableBooks.remove(getBookByTitle(aTitle));
            System.out.print("Thank you! Enjoy the book\n");
        } else {
            System.out.print("That book is not available");
        }
    }

    public void checkInBook(String aTitle) {
        if (checkIfBookOnList(checkedOutBooks, aTitle)) {
            checkedOutBooks.remove(getBookByTitle(aTitle));
            availableBooks.add(getBookByTitle(aTitle));
            System.out.print("Thank you for returning the Book\n");
        } else {
            System.out.print("This is not a valid Book to return\n");
        }
    }

    public boolean checkIfBookOnList(ArrayList<Book> theList, String aTitle){
        for (Book Book : theList) {
            if (Book.getBookTitle().equals(aTitle)) {
                return true;
            }
        }
        return false;
    }

    public Book getBookByTitle(String aTitle) {
        for (Book Book : allBooks) {
            if (Book.getBookTitle().equals(aTitle)) {
                return Book;
            }
        }
        return null;
    }
}
