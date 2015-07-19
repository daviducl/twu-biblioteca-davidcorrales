package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/18/15.
 */
public class BookDetails {
    private String bookTitle;
    private String bookAuthor;
    private String bookYear;

    public BookDetails() {
        bookTitle = bookAuthor = bookYear = null;
    }

    public BookDetails(String aTitle, String anAuthor, String aYear) {
        bookTitle = aTitle;
        bookAuthor = anAuthor;
        bookYear = aYear;
    }
    public void setBookTitle(String aTitle) { bookTitle = aTitle; }
    public void setBookAuthor(String anAuthor) { bookAuthor = anAuthor; }
    public void setBookYear(String aYear) { bookYear = aYear; }

    public String getBookTitle() { return bookTitle; }
    public String getBookAuthor() { return bookAuthor; }
    public String getBookYear() { return bookYear; }

    public String toString() {
        return "\"" + bookTitle + "\" (" + bookYear + ") by " + bookAuthor + "\n\n";
    }

}
