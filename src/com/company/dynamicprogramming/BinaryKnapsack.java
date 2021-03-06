package com.company.dynamicprogramming;

public class BinaryKnapsack {

    public static int numberOfOperations;
    private static Integer[][] dynamicProgrammingMemo;

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

    //      ****** Greedy approach ******
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
                numberOfOperations++;
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


    //      ****** Dynamic programming approach, without memoization ******

    // In this approach we consider all the possible conditions and their outcomes. For each item, we check whether we should
    // take it or not, ultimately optimally solving the problem.
    // In this approach, we are guaranteed to get global optima, but it is inefficient, because of huge number of calculations.
    // Time complexity: O(2^n), where n is the number of items, as for each item we have to decide whether to take the item or not. To make the decision, we'll
    // have to do all the calculations for each of the decisions, and then take the decision which leads to a better result (increased value).
    // Space complexity: O(n), as at any given time, in worst case we have to hold all the items in function call stack

    public static int binaryKnapsackDynamicProgramming(int[] values, int[] weights, int capacity) {
        return binaryKnapsackDynamicProgrammingLooper(values, weights, values.length - 1, capacity);  //Starting with last index
    }

    private static int binaryKnapsackDynamicProgrammingLooper(int[] values, int[] weights, int currentItemIndex, int capacity) {
        int totalValue;

        if (currentItemIndex < 0 || capacity == 0) //Base case. If current item index is out of list or capacity is 0, return 0
            return 0;
        else if (weights[currentItemIndex] > capacity)          //If current item weight is more than capacity, we can't take it. So return weight up to previous item
            totalValue = binaryKnapsackDynamicProgrammingLooper(values, weights, currentItemIndex - 1, capacity);
        else {
            //If we can take current item, check whether we should take it. Check which is bigger, if we take the current item, or if we don't

            //If we don't take current item, then total value is equal to value till last item
            int totalValueIfNotTakingCurrentItem = binaryKnapsackDynamicProgrammingLooper(values, weights, currentItemIndex - 1, capacity);

            //If we take current item, then total value is equal to value of current item + value of remaining capacity
            int totalValueIfTakingCurrentItem = values[currentItemIndex] + binaryKnapsackDynamicProgrammingLooper(values, weights, currentItemIndex - 1, capacity - weights[currentItemIndex]);

            //We take the max of the above two values
            totalValue = Math.max(totalValueIfNotTakingCurrentItem, totalValueIfTakingCurrentItem);
        }

        numberOfOperations++;

        return totalValue;
    }


    //      ****** Dynamic programming approach, with memoization ******

    // In this approach we consider all the possible conditions and their outcomes. For each item, we check whether we should
    // take it or not, ultimately optimally solving the problem.
    // In this approach, we are guaranteed to get global optima. It is also kind of efficient, as instead of always doing
    // calculations, we are saving the calculated results, and reusing them later, if needed.
    // Time complexity: Worst case O(n*c), where n is the number of items, and c is the capacity, as we are calculating the values only for each item-capacity combo,
    // if that result is required to find the global maxima.
    // Even though for each item we have to decide whether to take the item or not. To make the decision, we won't
    // have to do all the calculations for each of the decisions, as we can reuse results of older saved calculations,
    // and then take the decision which leads to a better result (increased value).
    // Space complexity: O(n*c), as we are storing the calculation results in the memo.

    public static int binaryKnapsackDynamicProgrammingAndMemoization(int[] values, int[] weights, int capacity) {

        dynamicProgrammingMemo = new Integer[values.length][capacity + 1];  //+1, as array is 0 indexed

        return binaryKnapsackDynamicProgrammingAndMemoizationLooper(values, weights, values.length - 1, capacity);  //Starting with last index
    }

    private static int binaryKnapsackDynamicProgrammingAndMemoizationLooper(int[] values, int[] weights, int currentItemIndex, int capacity) {
        int totalValue;

        if (currentItemIndex < 0 || capacity == 0) //Base case. If current item index is out of list or capacity is 0, return 0
            return 0;
        else {
            //Check whether the total value for current item and capacity combo exists. If so, return that instead of again calculating.
            if (dynamicProgrammingMemo[currentItemIndex][capacity] != null)
                return dynamicProgrammingMemo[currentItemIndex][capacity];

            else if (weights[currentItemIndex] > capacity)          //If current item weight is more than capacity, we can't take it. So return value up to previous item
                totalValue = binaryKnapsackDynamicProgrammingAndMemoizationLooper(values, weights, currentItemIndex - 1, capacity);

            else {
                //If we can take current item, check whether we should take it. Check which is bigger, if we take the current item, or if we don't

                //If we don't take current item, then total value is equal to value till last item
                int totalValueIfNotTakingCurrentItem = binaryKnapsackDynamicProgrammingAndMemoizationLooper(values, weights, currentItemIndex - 1, capacity);

                //If we take current item, then total value is equal to value of current item + value of remaining capacity
                int totalValueIfTakingCurrentItem = values[currentItemIndex] + binaryKnapsackDynamicProgrammingAndMemoizationLooper(values, weights, currentItemIndex - 1, capacity - weights[currentItemIndex]);

                //We take the max of the above two values
                totalValue = Math.max(totalValueIfNotTakingCurrentItem, totalValueIfTakingCurrentItem);
            }
        }

        dynamicProgrammingMemo[currentItemIndex][capacity] = totalValue;    //Memoize

        numberOfOperations++;

        return totalValue;
    }


    //      ****** Dynamic programming approach, bottom-up ******

    // In this approach we consider all the possible conditions and their outcomes. For each item, we check whether we should
    // take it or not, ultimately optimally solving the problem.
    // In this approach, we are guaranteed to get global optima. It is also kind of inefficient, as we are solving all
    // the sub-problems (each item-capacity combo), regardless of whether they are needed to solve the main problem (global maxima) or not.
    // Time complexity: O(n*c) in all cases, where n is the number of items, and c is the capacity, as we are calculating the values for each item-capacity combo.
    // Even though for each item we have to decide whether to take the item or not. To make the decision, we won't
    // have to do all the calculations for each of the decisions, as we can reuse results of older saved calculations,
    // and then take the decision which leads to a better result (increased value).
    // Space complexity: O(n*c), as we are storing the calculation results in the memo.

    public static int binaryKnapsackDynamicProgrammingBottomUp(int[] values, int[] weights, int capacity) {

        dynamicProgrammingMemo = new Integer[values.length][capacity + 1];  //+1, as array is 0 indexed
        int totalValue = 0;

        //For each item
        for (int currentItemIndex = 0; currentItemIndex < values.length; currentItemIndex++) {

            //For each capacity
            for (int currentCapacity = 0; currentCapacity <= capacity; currentCapacity++) {

                if (currentCapacity <= 0)   //Base case. If capacity is 0, return 0
                    totalValue = 0;
                else {

                    //In case of first item, if we do not take the item, total value is 0. Otherwise total value is equal to value till previous item
                    int totalValueIfNotTakingCurrentItem = ((currentItemIndex == 0) ? 0 : dynamicProgrammingMemo[currentItemIndex - 1][currentCapacity]);

                    //If current item weight is more than capacity, we can't take it.
                    if (weights[currentItemIndex] > currentCapacity)
                        totalValue = totalValueIfNotTakingCurrentItem;
                    else {
                        //If we can take current item, check whether we should take it. Check which is bigger, if we take the current item, or if we don't

                        //If we take current item, then total value is equal to value of current item + value of remaining capacity
                        int totalValueIfTakingCurrentItem = ((currentItemIndex == 0) ? values[currentItemIndex] : values[currentItemIndex] + dynamicProgrammingMemo[currentItemIndex - 1][currentCapacity - weights[currentItemIndex]]);

                        //We take the max of the above two values
                        totalValue = Math.max(totalValueIfNotTakingCurrentItem, totalValueIfTakingCurrentItem);
                    }
                }

                dynamicProgrammingMemo[currentItemIndex][currentCapacity] = totalValue;     //Memoize

                numberOfOperations++;
            }
        }

        return totalValue;
    }
}
