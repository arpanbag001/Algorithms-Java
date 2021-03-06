package com.company.sorting;

public class InsertionSort {

    //Time Complexity: Best: O(n), Average: O(n^2), Worst: O(n^2) [Best, when array is already sorted. Otherwise will always
    //iterate through the whole array for each element, making complexity O(n^2)
    //Space complexity: O(1)

    public static int[] doInsertionSort(int[] arrayToSort) {

        for (int i = 1; i < arrayToSort.length; i++) {
            if (arrayToSort[i] < arrayToSort[i - 1]) {    //If current item is less than previous item
                int valueToInsert = arrayToSort[i];       //We have to insert current item into it's place
                int indexToInsert = i;                    //Starting with current index...
                while (indexToInsert > 0 && arrayToSort[indexToInsert - 1] >= valueToInsert) {      //...we keep going backwards if the previous item is larger than current item...
                    arrayToSort[indexToInsert] = arrayToSort[indexToInsert - 1];                    //...moving items 1 index to right
                    indexToInsert--;
                }
                arrayToSort[indexToInsert] = valueToInsert;                                         //We found the place for the item! INSERT.
            }
        }

        return arrayToSort;
    }
}
