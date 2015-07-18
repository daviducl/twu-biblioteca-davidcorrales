package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void mainMenuDisplays() {
        BibliotecaApp biblioteca = new BibliotecaApp();

        biblioteca.displayMenu();

        assertEquals("Menu not displayed properly", "Welcome to the Biblioteca", biblioteca.displayMenu());
    }
}
