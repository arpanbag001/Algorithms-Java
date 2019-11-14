package com.company.recursion;

import java.util.ArrayList;

public class Fibonacci {

    //More readable (understandable) and more robust (returns whole list)
    public static ArrayList<Integer> calculateFibonacci(int numberOfStepsToDo) {
        ArrayList<Integer> fibonacciArrayList = new ArrayList<>();
        if (numberOfStepsToDo > 0)
            fibonacciArrayList.add(0);
        if (numberOfStepsToDo > 1)
            fibonacciArrayList.add(1);

        return fibonacciLooper(fibonacciArrayList, numberOfStepsToDo - 2);
    }

    //More compact, but less understandable
    public static int calculateFibonacciAlternative(int numberOfStepsToDo) {
        if (numberOfStepsToDo < 2)
            return 0;
        else
            return fibonacciAlternativeLooper(numberOfStepsToDo - 2);
    }


    // **** Private looper methods ****


    private static ArrayList<Integer> fibonacciLooper(ArrayList<Integer> fibonacciArrayList, int numberOfStepsToDo) {
        if (numberOfStepsToDo <= 0) {
            return fibonacciArrayList;
        } else {
            int lastIndex = fibonacciArrayList.size() - 1;
            fibonacciArrayList.add(fibonacciArrayList.get(lastIndex) + fibonacciArrayList.get(lastIndex - 1));
            return fibonacciLooper(fibonacciArrayList, numberOfStepsToDo - 1);
        }
    }

    private static int fibonacciAlternativeLooper(int numberOfStepsToDo) {
        if (numberOfStepsToDo <= 2)
            return numberOfStepsToDo;
        else
            return fibonacciAlternativeLooper(numberOfStepsToDo - 2) + fibonacciAlternativeLooper(numberOfStepsToDo - 1);
    }
}
