package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/19/15.
 */
public class BookListActions {
    ArrayList<BookDetails> allBooks = new ArrayList<BookDetails>();
    ArrayList<BookDetails> checkedOutBooks = new ArrayList<BookDetails>();
    ArrayList<BookDetails> availableBooks = new ArrayList<BookDetails>();

    public BookListActions() {
        BookDetails infernoBook = new BookDetails("Inferno", "Dan Brown", "2013");
        BookDetails vinciBook = new BookDetails("The Da Vinci Code", "Dan Brown", "2013");
        allBooks.add(infernoBook);
        allBooks.add(vinciBook);

        checkedOutBooks = availableBooks = null;
    }

    public void checkOut(String aTitle) {
        if (checkIfBookOnList(availableBooks, aTitle)) {
            checkedOutBooks.add(getBookByTitle(aTitle));
            availableBooks.remove(getBookByTitle(aTitle));
            System.out.print("Thank you! Enjoy the book");
        } else {
            System.out.print("That book is not available");
        }
    }

    public boolean checkIfBookOnList(ArrayList<BookDetails> theList, String aTitle){
        for (BookDetails book : theList) {
            System.out.print(book.toString());
            if (book.getBookTitle().equals(aTitle)) { return true; }
        }
        return false;
    }

    public BookDetails getBookByTitle(String aTitle) {
        for (BookDetails book : allBooks) {
            if (book.getBookTitle().equals(aTitle)) { return book; }
        }
        return null;
    }
}
