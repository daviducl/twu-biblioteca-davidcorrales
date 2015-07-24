package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/19/15.
 */
public class BookLists extends ItemLists {
    ArrayList<Book> allBooks = new ArrayList<Book>();
    ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
    ArrayList<Book> availableBooks = new ArrayList<Book>();

    public BookLists() {
        Book infernoBook = new Book("Inferno", "Dan Brown", "2013");
        Book vinciBook = new Book("The Da Vinci Code", "Dan Brown", "2013");
        allBooks.add(infernoBook);
        allBooks.add(vinciBook);
        availableBooks = allBooks;
    }

    public void checkOut(String aTitle) {
        if (checkIfBookOnList(availableBooks, aTitle)) {
            checkedOutBooks.add(getBookByTitle(aTitle));
            availableBooks.remove(getBookByTitle(aTitle));
            System.out.print("Thank you! Enjoy the book\n");
        } else {
            System.out.print("That book is not available");
        }
    }

    public void checkInMovie(String aTitle) {
        if (checkIfBookOnList(checkedOutBooks, aTitle)) {
            checkedOutBooks.remove(getBookByTitle(aTitle));
            availableBooks.add(getBookByTitle(aTitle));
            System.out.print("Thank you for returning the book\n");
        } else {
            System.out.print("This is not a valid book to return\n");
        }
    }

    public boolean checkIfBookOnList(ArrayList<Book> theList, String aTitle){
        for (Book book : theList) {
            if (book.getBookTitle().equals(aTitle)) {
                return true;
            }
        }
        return false;
    }

    public Book getBookByTitle(String aTitle) {
        for (Book book : allBooks) {
            if (book.getBookTitle().equals(aTitle)) {
                return book;
            }
        }
        return null;
    }
}
