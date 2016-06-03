package com.algorithm;

import com.sudoku.Cell;
import com.sudoku.SudokuBoard;
import com.utils.TimeManager;

/**
 * This class represent the Backtracking algorithm
 */
public class Backtracking implements Algorithm {
    private SudokuBoard board;
    public double time;
    public TimeManager timeManager =  new TimeManager();

    /**
     * Solve a sudoku board game
     *
     * @param sudokuBoard The sudoku board of cells
     * @return The condition of game result
     */
    @Override
    public Boolean solve(SudokuBoard sudokuBoard) {
        timeManager.start();
        this.board = sudokuBoard;

        if (!this.board.hasAnEmptyCell()) {
            timeManager.stop();
            this.time = timeManager.getSeconds();
            return true;
        }

        Cell cell = this.board.getFirstEmptyCell();

        for (int num = 1; num <= 9; num++) {
            if (isNumSetAsSolution(cell, num)){
                timeManager.stop();
                this.time = timeManager.getSeconds();
                return true;
            }
        }
        return false;
    }

    public double getTime(){
        return this.time;
    }
    /**
     * Verify if a num is set as solution on a cell
     *
     * @param cell A Cell object on the board
     * @param num  A digit number
     * @return Return true if there is a solution
     */
    private boolean isNumSetAsSolution(Cell cell, int num) {
        if (this.board.isSafeSetCell(cell, num)) {
            this.board.setCell(cell, num);
            if (solve(this.board)) {
                return true;
            }
            this.board.clearCell(cell);
        }
        return false;
    }
}
