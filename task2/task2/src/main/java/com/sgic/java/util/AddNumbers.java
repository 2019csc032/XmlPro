package com.sgic.java.util;

import java.util.Scanner;

public class AddNumbers {

    public static <T extends Number> T add(T num1, T num2) {
        if (num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        } else if (num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        } else if (num1 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() + num2.floatValue());
        } else if (num1 instanceof Long) {
            return (T) Long.valueOf(num1.longValue() + num2.longValue());
        } else if (num1 instanceof Short) {
            return (T) Short.valueOf((short) (num1.shortValue() + num2.shortValue()));
        } else if (num1 instanceof Byte) {
            return (T) Byte.valueOf((byte) (num1.byteValue() + num2.byteValue()));
        } else {
            throw new IllegalArgumentException("Unsupported numeric type");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number:");
        double num1 = scanner.nextDouble();
        System.out.println("Enter the second number:");
        double num2 = scanner.nextDouble();
        double sum = add(num1, num2);
        System.out.println("Sum: " + sum);
    }
}

