package com.company;

import com.company.dynamicprogramming.BinaryKnapsack;

public class Main {

    public static void main(String[] args) {


        System.out.println(BinaryKnapsack.binaryKnapsackOptimalRecursive(new int[]{60, 100, 120, 124, 345}, new int[]{10, 20, 30, 4, 8}, 55));

        System.out.println("Number of operations: " + BinaryKnapsack.numberOfOperations);

//        PerformanceMeasurer.measurePerformance(() ->
//                        Fibonacci.fibonacciRecursiveWithDynamicProgramming(25),
//                10000
//        );
    }
}
