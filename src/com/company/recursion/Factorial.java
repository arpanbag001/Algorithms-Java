package com.company.recursion;

public class Factorial {
    public static int calculateFactorial(int num) {
        if (num <= 2)
            return num;
        else
            return num * calculateFactorial(num - 1);
    }
}
