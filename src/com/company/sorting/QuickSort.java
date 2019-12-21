package com.company.sorting;

public class QuickSort {
    public static int[] doQuickSort(int[] arrayToSort) {
        divideAndSort(arrayToSort, 0, arrayToSort.length - 1);
        return arrayToSort;
    }

    private static void divideAndSort(int[] arr, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int partition = sortAndPartition(arr, firstIndex, lastIndex);
            divideAndSort(arr, firstIndex, partition - 1);
            divideAndSort(arr, partition, lastIndex);
        }
    }

    private static int sortAndPartition(int[] arr, int firstIndex, int lastIndex) {
        int pivot = arr[lastIndex];
        while (firstIndex < lastIndex) {
            if (arr[firstIndex] <= pivot) {
                firstIndex++;
            } else if (arr[lastIndex] > pivot) {
                lastIndex--;
            } else {
                //Swap
                int temp = arr[lastIndex];
                arr[lastIndex] = arr[firstIndex];
                arr[firstIndex] = temp;
            }
        }
        return firstIndex;
    }
}
