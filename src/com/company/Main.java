package com.company;

import com.company.recursion.Factorial;
import com.company.recursion.Fibonacci;
import com.company.recursion.StringReverser;
import com.company.sorting.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(QuickSort.doQuickSort(new int[]{2, 8, 1, 21, 92, -23, 5, -2, 0, 0, -2})));
    }
}
