package com.algorithm;

import com.sudoku.Cell;
import com.sudoku.SudokuBoard;


/**
 * Created by Alejandra on 17/05/2016.
 */
public class Backtraking implements Algorithm {

    @Override
    public Boolean solve(SudokuBoard sudokuBoard) {
//        int i = sudokuBoard.getEmptyCellX();
//        int j = sudokuBoard.getEmptyCellY();
        int i;
        int j;
        if (!sudokuBoard.isThereAnEmptyCell()) {
            return true;
        } else {
            Cell c = sudokuBoard.getAnEmptyCell();
            i = c.getPosX();
            j = c.getPosY();
        }
        for (int num = 1; num <= 9; num++) {
            if (isPracticable(i, j, sudokuBoard, num)) {
                sudokuBoard.setCell(i, j, num);
                if (solve(sudokuBoard)) {
                    return true;
                }
                sudokuBoard.setCell(i, j, 0);
            }
        }
        return false;
    }

    public Boolean isPracticable(int i, int j, SudokuBoard sudokuBoard, int num) {
        Boolean isPracticableInColumn = !isUsedInColumn(j, sudokuBoard, num);
        Boolean isPracticableInRow = !isUsedInRow(i, sudokuBoard, num);
        Boolean isPracticableInSubGrid = !isUsedInSubGrid(i, j, sudokuBoard, num);
        return isPracticableInColumn && isPracticableInRow && isPracticableInSubGrid;
    }

    public boolean isUsedInColumn(int col, SudokuBoard sudokuBoard, int num) {
        for (int row = 0; row < 9; row++) {
            if (sudokuBoard.getCell(row, col) == num) {
                return true;
            }
        }
        return false;
    }

    public boolean isUsedInRow(int row, SudokuBoard sudokuBoard, int num) {
        for (int col = 0; col < 9; col++) {
            if (sudokuBoard.getCell(row, col) == num) {
                return true;
            }
        }
        return false;
    }

    public boolean isUsedInSubGrid(int i, int j, SudokuBoard sudokuBoard, int num) {
        int initPosX = getInitPositionForSubGrid(i);
        int initPosY = getInitPositionForSubGrid(j);
        for (int k = initPosX; k < initPosX + 3; k++) {
            for (int l = initPosY; l < initPosY + 3; l++) {
                if (sudokuBoard.getCell(k, l) == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getInitPositionForSubGrid(int ini) {
        // 0 1 2 3 4 5 6 7 8
        int i = ini + 1;
        int initPosSubGrid = 0;
        int res;
        int modRes = i % 3;
        if (modRes == 0) {
            res = i / 3;
        } else {
            res = (i - modRes) / 3 + 1;
        }
        switch (res) {
            case 1:
                initPosSubGrid = 0;
                break;
            case 2:
                initPosSubGrid = 3;
                break;
            case 3:
                initPosSubGrid = 6;
                break;
            default:
                break;
        }
        return initPosSubGrid;
    }
}
