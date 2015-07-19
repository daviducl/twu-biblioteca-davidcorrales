package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public void main(String[] args) {
        ArrayList<BookDetails> bookList = new ArrayList<BookDetails>();
        BookDetails book = new BookDetails("Inferno", "Dan Brown", "2013");
        bookList.add(book);

        System.out.println(displayMenuGreeting());
        System.out.println(displayBookList(bookList));
    }

    String displayMenuGreeting() {
        return "Welcome to the Biblioteca\n\nThese are our books:\n\n";
    }

    String displayBookList(ArrayList<BookDetails> bookList) {
        String books = null;
        for (BookDetails bookDetails : bookList) {
            books += bookDetails.toString() + "\n";
        }
        return books;
    }
}
