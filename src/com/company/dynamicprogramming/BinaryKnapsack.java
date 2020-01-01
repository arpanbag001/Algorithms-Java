package com.company.dynamicprogramming;

public class BinaryKnapsack {
    /*
    Fractional knapsack problem can be solved optimally with greedy approach. No need of dynamic programming there, as
    local optima will lead to global optima.
    But in case of binary ( 0 - 1 ) knapsack, we need to find the global optima analyzing all the elements. Using dynamic
    programming there will improve the performance from O(2^n) to O(n)
    */


    // Greedy approach (NOT dynamic programming). Time complexity is around O(n^2 + n). O(n^2) is because of Bubble sort.
    // Can decrease it using better sorting algorithms.
    // Space complexity is O(1) as everything happened in-place, without any additional data structure
    // but this method doesn't lead to global optima. Eg. for inputs: values[60, 100, 120], weights[10, 20, 30], capacity 50,
    // this method gets total value of 160, filling knapsack with items of values 60 and 100,
    // when we can actually get total value of 220 filling knapsack with items of values 100 and 120.
    public static int binaryKnapsackGreedy(int[] values, int[] weights, int capacity) {
        int totalValue = 0;

        //Bubble sorting
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 1; j++) {
                float valueOfUnitWeightCurrent = (float) values[j] / weights[j];
                float valueOfUnitWeightNext = (float) values[j + 1] / weights[j + 1];
                if (valueOfUnitWeightCurrent < valueOfUnitWeightNext) {

                    //Swap values
                    int currValue = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = currValue;

                    //Swap weights
                    int currWeight = weights[j];
                    weights[j] = weights[j + 1];
                    weights[j + 1] = currWeight;
                }
            }
        }

        //Fill knapsack
        for (int i = 0; i < values.length; i++) {
            if (capacity < weights[i])
                break;
            else {
                totalValue += values[i];
                capacity -= weights[i];
            }
        }

        return totalValue;
    }
}
