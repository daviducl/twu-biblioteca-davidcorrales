package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by mcorrales on 7/20/15.
 */
public class InputReader {
    public static int readInteger(String prompt) {
        int inputLine = -1;
        System.out.print(prompt);
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt())
            inputLine = in.nextInt();
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
