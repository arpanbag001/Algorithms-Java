package com.company.searching;

public class LinearSearch {

    //Time Complexity: O(n) [Goes through all the array elements one by one]
    //Space complexity: O(1)

    public static int doLinearSearch(int[] arrayToSearchIn, int itemToSearchFor) {
        for (int i = 0; i < arrayToSearchIn.length; i++) {
            if (arrayToSearchIn[i] == itemToSearchFor)
                return i;
        }
        return -1;
    }
}
