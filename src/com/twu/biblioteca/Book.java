package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/18/15.
 */
public class Book {
    private String bookTitle;
    private String bookAuthor;
    private String bookYear;

    public Book(String aTitle, String anAuthor, String aYear) {
        bookTitle = aTitle;
        bookAuthor = anAuthor;
        bookYear = aYear;
    }
    public String getBookTitle() { return bookTitle; }

    public String toString() {
        return "\"" + bookTitle + "\" (" + bookYear + ") by " + bookAuthor + "\n";
    }
}
