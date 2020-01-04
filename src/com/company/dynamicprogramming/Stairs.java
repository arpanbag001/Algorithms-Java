package com.company.dynamicprogramming;

public class Stairs {

    public static int numberOfOperations;
    private static Integer[] dynamicProgrammingMemo;

    /*
    Problem statement:
    Count ways to reach the n’th stair
    There are n stairs, a person standing at the bottom wants to reach the top.
    The person can climb only steps passed in "allowedStepsToTake" at a time. Count the number of ways, the person can reach the top.
     */


    //Time complexity: Without memoization, O(m^n) and with memoization O(n) where m is size of allowedStepsToTake and n is stair to reach
    //Space complexity: O(n)
    public static int findNumOfWaysToReachStair(int stairToReach, int[] allowedStepsToTake) {

        //Initializing memo
        if (dynamicProgrammingMemo == null)
            dynamicProgrammingMemo = new Integer[stairToReach + 1];  //+1, as array is 0 indexed

        if (stairToReach < 0)                               //If stair to reach is negative, number of ways is 0
            return 0;
        else if (stairToReach == 0)                         //If stair to reach is 0, number of ways is 1, by staying there.
            return 1;

        //Check memo
        if (dynamicProgrammingMemo[stairToReach] != null)
            return dynamicProgrammingMemo[stairToReach];

        int numOfWaysToReachCurrentStair = 0;

        //Explore all allowed steps
        for (int x : allowedStepsToTake) {

            //Number of ways to reach current stair by taking x steps is same as number of ways to reach (current - x)th stair
            int numOfWaysToReachCurrentStairByTakingXSteps = findNumOfWaysToReachStair(stairToReach - x, allowedStepsToTake);

            //Number of ways to reach current stair is combination of number of ways for each allowed steps
            numOfWaysToReachCurrentStair += numOfWaysToReachCurrentStairByTakingXSteps;
        }

        dynamicProgrammingMemo[stairToReach] = numOfWaysToReachCurrentStair;      //Memoize

        numberOfOperations++;

        return numOfWaysToReachCurrentStair;
    }
}
