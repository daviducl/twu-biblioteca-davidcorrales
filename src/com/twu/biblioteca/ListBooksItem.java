package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/19/15.
 */
public class ListBooksItem extends AppMenuItem {

    public ListBooksItem(String aNumber, String theText){
        super(aNumber, theText);
    }
    public String menuActions() {
        ArrayList<BookDetails> bookList = new ArrayList<BookDetails>();
        BookDetails book = new BookDetails("Inferno", "Dan Brown", "2013");
        bookList.add(book);
        return displayBookList(bookList);
    }

    public String toString() {
        return super.toString();
    }

    public static String displayBookList(ArrayList<BookDetails> bookList) {
        String books = "These are our books:\n";
        for (BookDetails bookDetails : bookList) {
            books += bookDetails.toString();
        }
        return books;
    }
}
