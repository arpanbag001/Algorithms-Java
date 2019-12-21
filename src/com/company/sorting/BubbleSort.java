package com.company.sorting;

public class BubbleSort {

    //Time Complexity: Best: O(n), Average: O(n^2), Worst: O(n^2) [Best, when array is already sorted. Otherwise will always
    //iterate through the whole array for each element, making complexity O(n^2)
    //Space complexity: O(1)

    public static int[] doBubbleSort(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = 0; j < arrayToSort.length - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int temp = arrayToSort[j + 1];
                    arrayToSort[j + 1] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
        return arrayToSort;
    }
}
