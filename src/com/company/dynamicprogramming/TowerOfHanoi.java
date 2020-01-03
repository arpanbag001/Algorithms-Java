package com.company.dynamicprogramming;

public class TowerOfHanoi {

    public static int numberOfOperations;


    //Time complexity: O(2^n)
    //Space complexity: O(2^n)
    public static void towerOfHanoiDynamicProgramming(int numberOfDisks, char startingRod, char auxRod, char finalRod) {

        if (numberOfDisks == 1) {   //If this is the last disk

            System.out.println("Moving disk 1 from rod " + startingRod + " to rod " + finalRod);   //Directly move it to final rod

        } else {      //Otherwise

            //Move (n-1) disks from starting rod to aux rod, via final rod
            towerOfHanoiDynamicProgramming(numberOfDisks - 1, startingRod, finalRod, auxRod);

            //Move last, i.e. n'th disk directly to final rod
            System.out.println("Moving disk " + numberOfDisks + " from rod " + startingRod + " to rod " + finalRod);

            //Move those previously moved (n-1) disks back to final rod from aux rod, via starting rod
            towerOfHanoiDynamicProgramming(numberOfDisks - 1, auxRod, startingRod, finalRod);
        }

        numberOfOperations++;

    }
}
