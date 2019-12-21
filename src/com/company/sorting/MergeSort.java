package com.company.sorting;

import java.util.Arrays;

public class MergeSort {

    //Time Complexity: Best: O(n log(n)), Average: O(n log(n)), Worst: O(n log(n)) [log(n) steps * n comparisons in each step]
    //Space complexity: O(n)

    public static int[] doMergeSort(int[] arrayToSort) {
        return divide(arrayToSort);
    }

    private static int[] divide(int[] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        return sortAndMarge(
                divide(Arrays.copyOfRange(arr, 0, mid)),
                divide(Arrays.copyOfRange(arr, mid, arr.length))
        );
    }

    public static int[] sortAndMarge(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        for (int i = 0, j = 0, m = 0; i < arr1.length || j < arr2.length; ) {
            if (i >= arr1.length) {         //If first array is complete, add from second array
                mergedArray[m] = arr2[j];
                j++;
            } else if (j >= arr2.length) {  //If second array is complete, add from first array
                mergedArray[m] = arr1[i];
                i++;
            } else if (arr1[i] < arr2[j]) { //If first array item is small, add that
                mergedArray[m] = arr1[i];
                i++;
            } else {
                mergedArray[m] = arr2[j];   //Else, add second array item
                j++;
            }
            m++;
        }
        return mergedArray;
    }
}
