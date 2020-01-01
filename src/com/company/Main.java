package com.company;

import com.company.dynamicprogramming.BinaryKnapsack;

public class Main {

    public static void main(String[] args) {


        System.out.println(BinaryKnapsack.binaryKnapsackGreedy(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));


//        System.out.println("Number of operations: " + Fibonacci.numberOfOperations);

//        PerformanceMeasurer.measurePerformance(() ->
//                        Fibonacci.fibonacciRecursiveWithDynamicProgramming(25),
//                10000
//        );
    }
}
