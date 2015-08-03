package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mcorrales on 7/20/15.
 */
public class InputReader {
    public static int readInteger(String prompt) {
        int inputLine = -1;
        String regEx = "[0-9]*";
        System.out.print(prompt);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            if (is.readLine().matches(regEx))
                inputLine = Integer.parseInt(is.readLine());
        } catch (IOException e) {
            System.err.println("Select a valid option!");
        }
        return inputLine;
    }

    public static String readString(String prompt) {
        String stringLine = "";
        System.out.print(prompt);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            stringLine = is.readLine();
        } catch (IOException e) {
            System.err.println("Select a valid option!");
        }
        return stringLine;
    }
}
