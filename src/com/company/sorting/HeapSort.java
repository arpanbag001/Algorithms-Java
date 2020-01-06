package com.company.sorting;

public class HeapSort {

    //Time complexity: O(nlog(n)) - As each maxHeapify call takes log(n) time, and we are calling it n times.
    //Space complexity: O(1) - As everything is in-place, without using any additional data structure.
    public static int[] doHeapSort(int[] arr) {

        int lastItemIndex = arr.length - 1;

        //MaxHeapify by starting with mid index, and traversing till start, covering only parent (non-leaf) elements
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            maxHeapify(arr, i, lastItemIndex);

        //Starting with last index, till second index, do the following
        // 1. Remove the largest element i.e. the first array element
        // 2. Move the last array element to first, taking place of the removed largest element
        // 3. Store the removed largest element to last index of the array
        // 4. Move the "last index" pointer to one step left
        // 5. Fix the heap by re-heapifying it
        //P.S. We can do it till first index. However, doing till second index is enough as when we reach first index,
        //the first index element will be the smallest, so the array will already be sorted.

        while (lastItemIndex > 0) {

            //Swap the largest element (first element) with the current last element.
            int currentMaxItem = arr[0];
            arr[0] = arr[lastItemIndex];
            arr[lastItemIndex] = currentMaxItem;

            //Move the last item pointer to left
            lastItemIndex--;

            //Fix(max-heapify) the heap
            maxHeapify(arr, 0, lastItemIndex);
        }

        return arr;
    }

    private static void maxHeapify(int[] arr, int rootIndex, int lastItemIndex) {

        //In any heap, left index = root index * 2 + 1
        int leftIndex = rootIndex * 2 + 1;

        //In any heap, left index = root index * 2 + 2
        int rightIndex = rootIndex * 2 + 2;

        //Initializing max index at root
        int maxItemIndex = rootIndex;

        //Checking if left item is larger than item at max index. Also making sure that we are within array bounds
        if (leftIndex <= lastItemIndex && arr[leftIndex] > arr[maxItemIndex])
            maxItemIndex = leftIndex;

        //Checking if right item is larger than item at max index. Also making sure that we are within array bounds
        if (rightIndex <= lastItemIndex && arr[rightIndex] > arr[maxItemIndex])
            maxItemIndex = rightIndex;

        //If root item is not the max, as is should, according to the property of max-heap
        if (rootIndex != maxItemIndex) {

            //Swap and move max item to root
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[maxItemIndex];
            arr[maxItemIndex] = temp;

            //Recursively maxHeapify the affected subtree
            maxHeapify(arr, maxItemIndex, lastItemIndex);
        }
    }
}
