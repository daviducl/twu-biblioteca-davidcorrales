package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<BookDetails> bookList = new ArrayList<BookDetails>();
        BookDetails book = new BookDetails("Inferno", "Dan Brown", "2013");
        bookList.add(book);
        AppMenuItem menuItem = new AppMenuItem("1", "List Books");

        System.out.println(displayMenuGreeting());
        System.out.print(displayBookList(bookList));
    }

    public static String displayMenuGreeting() {
        return "Welcome to the Biblioteca\nThese are our books:\n";
    }

    public static String displayBookList(ArrayList<BookDetails> bookList) {
        String books = "";
        for (BookDetails bookDetails : bookList) {
            books += bookDetails.toString();
        }
        return books;
    }
}
