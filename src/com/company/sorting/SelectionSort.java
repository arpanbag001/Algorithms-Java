package com.company.sorting;

public class SelectionSort {

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
