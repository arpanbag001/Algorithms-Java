package com.company;

import com.company.dynamicprogramming.BinaryKnapsack;
import com.company.dynamicprogramming.TowerOfHanoi;

public class Main {

    public static void main(String[] args) {


        TowerOfHanoi.towerOfHanoiDynamicProgramming(5, 'A', 'B', 'C');

        System.out.println("Number of operations: " + TowerOfHanoi.numberOfOperations);

//        PerformanceMeasurer.measurePerformance(() ->
//                        Fibonacci.fibonacciRecursiveWithDynamicProgramming(25),
//                10000
//        );
    }
}
