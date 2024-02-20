package com.sgic.java.util;

import java.util.Scanner;

public class StringModifier {

    public static String changeNullToString(String input) {
        if (input == null) {
            return "";
        }
        return input;
    }

    public static void main(String[] args) {
        // Test the method
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the word");
        String str = input.nextLine();


        System.out.println(changeNullToString(str));
    }
}
