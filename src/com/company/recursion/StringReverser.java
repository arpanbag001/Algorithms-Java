package com.company.recursion;

public class StringReverser {

    public static String reverseString(String stringToReverse) {
        return reverseStringLooper(stringToReverse);
    }

    private static String reverseStringLooper(String stringToReverse) {
        if (stringToReverse.length() < 1)
            return "";
        else
            return reverseStringLooper(stringToReverse.substring(1)) + stringToReverse.charAt(0);
    }
}
