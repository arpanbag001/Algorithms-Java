package com.company.dynamicprogramming;

public class Stairs {

    public static int numberOfOperations;
    private static Integer[] dynamicProgrammingMemo;

    /*
    Problem statement:
    Count ways to reach the n’th stair
    There are n stairs, a person standing at the bottom wants to reach the top.
    The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.
     */


    //Time complexity: Without memoization, O(2^n) and with memoization O(n) where n is stair to reach
    //Space complexity: O(n)
    public static int findNumOfWaysToReachStair(int stairToReach) {

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

        //Number of ways to reach current stair by taking 1 step is same as number of ways to reach (current-1)th stair
        int numOfWaysToReachCurrentStairTaking1StepFromPreviousStair = findNumOfWaysToReachStair(stairToReach - 1);

        //Number of ways to reach current stair by taking 2 steps is same as number of ways to reach (current-2)th stair
        int numOfWaysToReachCurrentStairTaking2StepsFromPreviousStair = findNumOfWaysToReachStair(stairToReach - 2);

        //Number of ways to reach current stair is combination of both the previous ways
        int numOfWaysToReachCurrentStair = numOfWaysToReachCurrentStairTaking1StepFromPreviousStair + numOfWaysToReachCurrentStairTaking2StepsFromPreviousStair;

        dynamicProgrammingMemo[stairToReach] = numOfWaysToReachCurrentStair;      //Memoize

        numberOfOperations++;

        return numOfWaysToReachCurrentStair;
    }
}
