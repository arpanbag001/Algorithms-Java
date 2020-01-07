package com.company.backtracking;

public class NQueens {


    /*

    The problem can by solved by this simple steps:
    1. For any row in a column, check if queen can be placed here, by checking previous columns.
    2. If queen can't be placed,keep looping through the next rows, and do all these steps for each of them.
    3. If queen can be placed, place the queen there, and keep solving the problem by placing queens in next columns
        and check whether that leads to the solution.
    4. If it leads to the solution, congrats!
    5. If it doesn't, remove the queen from current position.
    6. Keep looping through the next rows, and do all these steps for each of them.

     */

    public static int numberOfOperations;

    public static int[][] solveNQueens(int n) {

        int[][] board = new int[n][n];

        placeQueenInColumn(board, 0);

        return board;

    }

    //Find a safe place (which will lead to solution) in the column, and place queen there
    public static boolean placeQueenInColumn(int[][] board, int column) {

        //Base case: If column to place queen in is out of the number of columns, it indicates that
        //all the queens are successfully placed. So return true
        if (column == board[0].length)
            return true;

        //Check whether queen can be placed in each row of current column
        for (int row = 0; row < board.length; row++) {

            //Check if it is safe to place queen in current position
            if (checkIfSafeToPlaceQueen(board, row, column)) {

                //Since it is safe to place queen in current position, place the queen
                board[row][column] = 1;

                //Check whether after placing the queen in current position we are able to solve the problem
                //by placing queens in next columns until we place all the queens
                boolean isCurrentPlacementCorrect = placeQueenInColumn(board, column + 1);

                //If by placing queen in current position we are ultimately able to solve the problem,
                //the current position is correct.
                if (isCurrentPlacementCorrect)
                    return true;                    //Return true
                else
                    board[row][column] = 0;         //Otherwise, remove queen from this position, and continue the loop
            }

            numberOfOperations++;
        }

        return false;
    }

    //Check whether queen can be placed
    private static boolean checkIfSafeToPlaceQueen(int[][] board, int rowToCheck, int colToCheck) {

        //Starting with current position, check rows on left side (which are already populated)
        for (int column = colToCheck - 1; column >= 0; column--) {
            numberOfOperations++;

            if (board[rowToCheck][column] == 1)
                return false;
        }

        //Starting with current position, check diagonal: current to top-left
        for (int row = rowToCheck - 1, column = colToCheck - 1; row >= 0 && column >= 0; row--, column--) {
            numberOfOperations++;

            if (board[row][column] == 1)
                return false;
        }

        //Starting with current position, , check diagonal: current to bottom-right
        for (int row = rowToCheck - 1, column = colToCheck - 1; row >= 0 && column >= 0; row++, column--) {
            numberOfOperations++;

            if (board[row][column] == 1)
                return false;
        }

        return true;
    }
}
