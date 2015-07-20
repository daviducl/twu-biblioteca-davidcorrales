package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/20/15.
 */
public class CheckInBookItem extends AppMenuItem {
    public CheckInBookItem(String aNumber, String aTitle) {
        super(aNumber, aTitle);
    }

    public String menuActions(BookLists theLists) {
        theLists.checkIn(InputReader.readString("Type a title: "));
        return "\n";
    }

    public String toString() {
        return super.toString();
    }
}
