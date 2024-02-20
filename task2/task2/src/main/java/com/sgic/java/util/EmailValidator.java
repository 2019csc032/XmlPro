package com.sgic.java.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    public static String validateEmail(String email) {
        // Regular expression for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(emailRegex);
        // Create matcher object
        Matcher matcher = pattern.matcher(email);

        // Check if email matches the pattern
        if (matcher.matches()) {
            return "Email is Valid";
        } else {
            return "Email is Invalid";
        }
    }

    public static void main(String[] args) {
        // Test the method
        Scanner input = new Scanner(System.in);
        System.out.println("enter the email");
        String email = input.nextLine();

        System.out.println(validateEmail(email));

    }
}
