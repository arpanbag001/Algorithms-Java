package com.company;

import com.company.backtracking.NQueens;
import com.company.dynamicprogramming.Stairs;
import com.company.sorting.HeapSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        for (int[] row : NQueens.solveNQueens(4))
            System.out.println(Arrays.toString(row));

        System.out.println("Number of operations: " + NQueens.numberOfOperations);

//        PerformanceMeasurer.measurePerformance(() ->
//                        Fibonacci.fibonacciRecursiveWithDynamicProgramming(25),
//                10000
//        );
    }
}
