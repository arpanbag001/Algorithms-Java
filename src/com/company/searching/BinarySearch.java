package com.company.searching;

public class BinarySearch {

    //Needs sorted array
    //Time Complexity: O(log(n)) [Halves the array to search in each iteration (recursive call)]
    //Space complexity: O(1)      

    public static int doBinarySearch(int[] arrayToSearchIn, int itemToSearchFor) {
        return search(arrayToSearchIn, 0, arrayToSearchIn.length - 1, itemToSearchFor);
    }

    private static int search(int[] arrayToSearchIn, int firstIndex, int lastIndex, int itemToSearchFor) {

        if (firstIndex == lastIndex && arrayToSearchIn[firstIndex] != itemToSearchFor)      //Only one item in array, which is not the search key
            return -1;

        //Check in call recursively
        int mid = (firstIndex + lastIndex) / 2;
        if (arrayToSearchIn[mid] == itemToSearchFor)
            return mid;
        else if (arrayToSearchIn[mid] < itemToSearchFor)
            return search(arrayToSearchIn, mid + 1, lastIndex, itemToSearchFor);
        else
            return search(arrayToSearchIn, firstIndex, mid, itemToSearchFor);
    }

}
