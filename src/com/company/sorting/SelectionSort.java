package com.company.sorting;

public class SelectionSort {

    //Time Complexity: Best: O(n^2), Average: O(n^2), Worst: O(n^2) [Will always
    //iterate through the whole array for each element, making complexity O(n^2)
    //Space complexity: O(1)

    public static int[] doSelectionSort(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if (arrayToSort[j] < arrayToSort[minValueIndex])
                    minValueIndex = j;
            }
            int temp = arrayToSort[i];
            arrayToSort[i] = arrayToSort[minValueIndex];
            arrayToSort[minValueIndex] = temp;
        }
        return arrayToSort;
    }
}
