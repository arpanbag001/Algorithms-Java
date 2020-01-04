package com.company;

import com.company.dynamicprogramming.Stairs;

public class Main {

    public static void main(String[] args) {


        System.out.println(Stairs.findNumOfWaysToReachStair(12));

        System.out.println("Number of operations: " + Stairs.numberOfOperations);

//        PerformanceMeasurer.measurePerformance(() ->
//                        Fibonacci.fibonacciRecursiveWithDynamicProgramming(25),
//                10000
//        );
    }
}
