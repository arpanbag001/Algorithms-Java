package com.company;

import com.company.recursion.Factorial;
import com.company.recursion.Fibonacci;
import com.company.recursion.StringReverser;
import com.company.sorting.BubbleSort;
import com.company.sorting.InsertionSort;
import com.company.sorting.MergeSort;
import com.company.sorting.SelectionSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(MergeSort.doMergeSort(new int[]{2, 8, 1, 21, 92, -23, -2, 0, 0, -2})));
        //System.out.println(Arrays.toString(MergeSort.merge(new int[]{2, 8, 1, 1, 92, -23, -2, 0, 0, -2}, 3)));
    }
}
