package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 8/2/15.
 */
public class MockDatabase {
    private ArrayList<Book> allBooks = new ArrayList<Book>();
    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Movie> allMovies = new ArrayList<Movie>();
    private ArrayList<Movie> availableMovies = new ArrayList<Movie>();

    public MockDatabase() {
        Book infernoBook = new Book("Inferno", "Dan Brown", "2013");
        Book vinciBook = new Book("The Da Vinci Code", "Dan Brown", "2009");
        allBooks.add(infernoBook);
        allBooks.add(vinciBook);
        availableBooks.add(infernoBook);
        availableBooks.add(vinciBook);

        Movie angelsMovie = new Movie("Angels and Demons", "Ron Howard", "2009", "4");
        Movie looperMovie = new Movie("Looper", "Rian Johnson", "2012", "3");
        allMovies.add(angelsMovie);
        allMovies.add(looperMovie);
        availableMovies.add(angelsMovie);
        availableMovies.add(looperMovie);
    }
    public Book findAndRemoveBook(String bookTitle) {
        Book book = findAvailableBook(bookTitle);
        availableBooks.remove(book);
        return book;
    }

    private Book findAvailableBook(String bookTitle) {
        for (Book book : this.availableBooks) {
            if (book.getBookTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    private Book findAllBooks(String bookTitle) {
        for (Book book : this.allBooks) {
            if (book.getBookTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book aBook) {
        this.allBooks.add(aBook);
        this.availableBooks.add(aBook);
    }

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public String printBookList() {
        String bookList = "These are our books\n";
        for (Book book : allBooks) {
            bookList += book.toString();
        }
        return bookList;
    }

    public Book findAndReturnBook(String bookTitle) {
        Book book = findAllBooks(bookTitle);
        Book nullBook = findAvailableBook(bookTitle);
        if (book != null && nullBook == null)
            availableBooks.add(book);
        else
            return null;
        return book;
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public String printMovieList() {
        String movieList = "These are our movies\n";
        for (Movie movie : allMovies) {
            movieList += movie.toString();
        }
        return movieList;
    }

    public ArrayList<Movie> getAvailableMovies() {
        return availableMovies;
    }

    public void addMovie(Movie aMovie) {
        this.allMovies.add(aMovie);
        this.availableMovies.add(aMovie);
    }

    public Movie findAndRemoveMovie(String movieTitle) {
        Movie movie = findAvailableMovie(movieTitle);
        availableMovies.remove(movie);
        return movie;    }

    private Movie findAvailableMovie(String movieTitle) {
        for (Movie movie : this.availableMovies) {
            if (movie.getMovieTitle().equals(movieTitle)) {
                return movie;
            }
        }
        return null;
    }

    public ArrayList<Movie> getAllMovies() {
        return allMovies;
    }
}
