package com.company;

import com.company.dynamicprogramming.Fibonacci;
import com.company.utils.PerformanceMeasurer;

public class Main {

    public static void main(String[] args) {


        System.out.println(Fibonacci.fibonacciRecursiveWithDynamicProgramming(25));


        System.out.println("Number of operations: " + Fibonacci.numberOfOperations);

//        PerformanceMeasurer.measurePerformance(() ->
//                        Fibonacci.fibonacciRecursiveWithDynamicProgramming(25),
//                10000
//        );
    }
}
