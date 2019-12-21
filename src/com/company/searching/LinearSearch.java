package com.company.searching;

public class LinearSearch {
    public static int doLinearSearch(int[] arrayToSearchIn, int itemToSearchFor) {
        for (int i = 0; i < arrayToSearchIn.length; i++) {
            if (arrayToSearchIn[i] == itemToSearchFor)
                return i;
        }
        return -1;
    }
}
