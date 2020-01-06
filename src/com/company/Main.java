package com.company;

import com.company.dynamicprogramming.Stairs;
import com.company.sorting.HeapSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(HeapSort.doHeapSort(new int[]{11, 2, 9, 13, 57, 25, 17, 1, 90, 3})));

//        System.out.println("Number of operations: " + Stairs.numberOfOperations);

//        PerformanceMeasurer.measurePerformance(() ->
//                        Fibonacci.fibonacciRecursiveWithDynamicProgramming(25),
//                10000
//        );
    }
}
