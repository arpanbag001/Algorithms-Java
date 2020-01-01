package com.company.dynamicprogramming;

public class Fibonacci {

    public static int numberOfOperations;
    private static int[] dynamicProgrammingDataStore;


    //Iterative approach
    public static int fibonacciIterative(int index) {

        //Seed values
        if (index <= 1) return 0;
        else if (index == 2) return 1;

        int leadingNum = 0;
        int trailingNum = 1;
        int currNum = 0;

        for (int i = 2; i <= index; i++) {
            currNum = trailingNum + leadingNum;
            trailingNum = leadingNum;
            leadingNum = currNum;

            numberOfOperations++;   //For complexity analysis
        }

        return currNum;
    }


    //Recursive approach
    public static int fibonacciRecursive(int index) {

        //Seed values
        if (index <= 1) return 0;
        else if (index == 2) return 1;

        numberOfOperations++;   //For complexity analysis

        return fibonacciRecursive(index - 2) + fibonacciRecursive(index - 1);
    }


    //Dynamic programming
    public static int fibonacciRecursiveWithDynamicProgramming(int index) {

        if (dynamicProgrammingDataStore == null)
            dynamicProgrammingDataStore = new int[index + 1];   // Doing +1 coz array is staring with 0 index

        //Seed values
        if (index <= 1) return 0;
        else if (index == 2) return 1;

        if (dynamicProgrammingDataStore[index] != 0)        // 0 denotes uninitialized here.
            return dynamicProgrammingDataStore[index];

        numberOfOperations++;   //For complexity analysis

        int currNum = fibonacciRecursiveWithDynamicProgramming(index - 2) + fibonacciRecursiveWithDynamicProgramming(index - 1);
        dynamicProgrammingDataStore[index] = currNum;
        return currNum;
    }
}
