package com.algorithm;

import com.sudoku.SudokuBoard;

/**
 * Created by Alejandra on 17/05/2016.
 */
public class Backtraking implements Algorithm{
    @Override
    public void solve(SudokuBoard sudokuBoard){
        sudokuBoard.generateEmptyArraySudoku();
    };
}
