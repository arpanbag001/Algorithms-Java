package com.company.dynamicprogramming;

import java.util.HashMap;

public class TowerOfHanoi {

    public static int numberOfOperations;
    private static HashMap<Character, Integer> rodNumMap;


    //Time complexity: O(2^n)
    //Space complexity: O(2^n)
    public static void towerOfHanoiDynamicProgramming(int numberOfDisks, char startingRod, char auxRod, char finalRod) {

        if (rodNumMap == null) {
            rodNumMap = new HashMap<>();
            rodNumMap.put(startingRod, numberOfDisks);
            rodNumMap.put(auxRod, 0);
            rodNumMap.put(finalRod, 0);
            System.out.println("Initial condition. " + rodNumMap.toString());
        }

        if (numberOfDisks == 1) {   //If this is the last disk

            rodNumMap.put(startingRod, rodNumMap.get(startingRod) - 1);
            rodNumMap.put(finalRod, rodNumMap.get(finalRod) + 1);
            System.out.println("Moving disk 1 from rod " + startingRod + " to rod " + finalRod + ". " + rodNumMap.toString());   //Directly move it to final rod

        } else {      //Otherwise

            //Move (n-1) disks from starting rod to aux rod, via final rod
            towerOfHanoiDynamicProgramming(numberOfDisks - 1, startingRod, finalRod, auxRod);

            //Move last, i.e. n'th disk directly to final rod
            rodNumMap.put(startingRod, rodNumMap.get(startingRod) - 1);
            rodNumMap.put(finalRod, rodNumMap.get(finalRod) + 1);
            System.out.println("Moving disk " + numberOfDisks + " from rod " + startingRod + " to rod " + finalRod + ". " + rodNumMap.toString());

            //Move those previously moved (n-1) disks back to final rod from aux rod, via starting rod
            towerOfHanoiDynamicProgramming(numberOfDisks - 1, auxRod, startingRod, finalRod);
        }

        numberOfOperations++;

    }
}
