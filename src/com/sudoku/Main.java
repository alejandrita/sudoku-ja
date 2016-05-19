package com.sudoku;

import com.algorithm.Backtraking;

public class Main {

    public static void main(String[] args) {
//        SudokuBoard sudokuBoard = new SudokuBoard();
//        for(int iterator = 0; iterator < sudokuBoard.getBoard().size();iterator++){
//            System.out.println(sudokuBoard.getBoard().get(iterator));
//        }
//        System.out.println("--------" + sudokuBoard.getBoard().size());
//    }

    int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                    {5, 2, 0, 0, 0, 0, 0, 0, 0},
                    {0, 8, 7, 0, 0, 0, 0, 3, 1},
                    {0, 0, 3, 0, 1, 0, 0, 8, 0},
                    {9, 0, 0, 8, 6, 3, 0, 0, 5},
                    {0, 5, 0, 0, 9, 0, 6, 0, 0},
                    {1, 3, 0, 0, 0, 0, 2, 5, 0},
                    {0, 0, 0, 0, 0, 0, 0, 7, 4},
                    {0, 0, 5, 2, 0, 6, 3, 0, 0}};

    SudokuBoard sudokuBoard = new SudokuBoard(grid);
    Backtraking backtraking = new Backtraking();
    Boolean isSolved = backtraking.solve(sudokuBoard);

    if (isSolved)
            System.out.println(sudokuBoard.toString());
    else
            System.out.println(("No solution exists"));

    }

//    3 1 6 5 7 8 4 9 2
//    5 2 9 1 3 4 7 6 8
//    4 8 7 6 2 9 5 3 1
//    2 6 3 4 1 5 9 8 7
//    9 7 4 8 6 3 1 2 5
//    8 5 1 7 9 2 6 4 3
//    1 3 8 9 4 7 2 5 6
//    6 9 2 3 5 1 8 7 4
//    7 4 5 2 8 6 3 1 9
}
