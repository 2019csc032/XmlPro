package com.sgic.java.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateConverter {

    public static Date convertStringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Return null if parsing fails
        }
    }

    public static void main(String[] args) {
        // Test the method
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the date");
        String dateString = input.nextLine();
        Date date = convertStringToDate(dateString);
        System.out.println(date); // Output: Wed Feb 14 00:00:00 GMT 2024
    }
}

