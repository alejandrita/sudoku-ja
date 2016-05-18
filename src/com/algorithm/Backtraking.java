package com.algorithm;

import com.sudoku.SudokuBoard;


/**
 * Created by Alejandra on 17/05/2016.
 */
public class Backtraking implements Algorithm {

    @Override
    public void solve(SudokuBoard sudokuBoard) {
        sudoku(0, 0, sudokuBoard);
    }

    public void sudoku(int i, int j, SudokuBoard sudokuBoard) {
        //sudokuBoard.generateIniSudoku();
        Boolean[][] ini = sudokuBoard.getIniSudoku();
        if (!sudokuBoard.getIniCell(i, j)) {
            for (int k = 1; k <= 9; k++) {
                sudokuBoard.setCell(i, j, k);
                if (isPracticable(i, j, sudokuBoard)) {
                    if (i == 8 && j == 8) {
                        System.out.println(sudokuBoard.toString());
                    } else if (i < 8 && j == 8) {
                        sudoku(i + 1, 0, sudokuBoard);
                    } else if (i <= 8 && j < 8) {
                        sudoku(i, j + 1, sudokuBoard);
                    }
                } else
                sudokuBoard.setCell(i, j, 0);
            }
        } else {
            if (i == 8 && j == 8) {
                System.out.println(sudokuBoard.toString());
            } else if (i < 8 && j == 8) {
                sudoku(i + 1, 0, sudokuBoard);
            } else if (i <= 8 && j < 8) {
                sudoku(i, j + 1, sudokuBoard);
            }
        }
    }

    public Boolean isPracticable(int i, int j, SudokuBoard sudokuBoard) {
        Boolean valid = true;
        Boolean isPracticableInColumn = verifyColumn(i, j, sudokuBoard);
        Boolean isPracticableInRow = verifyRow(i, j, sudokuBoard);
        Boolean isPracticableInSubGrid = verifySubGrid(i, j, sudokuBoard);
        return isPracticableInColumn && isPracticableInRow && isPracticableInSubGrid;
    }

    private boolean verifyColumn(int i, int j, SudokuBoard sudokuBoard) {
        Boolean valid = true;
        for (int k = 0; k < 9 && valid; k++) {
            if (sudokuBoard.getCell(i, j) == sudokuBoard.getCell(k, j) && k != i) {
                valid = false;
            }
        }
        return valid;
    }

    private boolean verifyRow(int i, int j, SudokuBoard sudokuBoard) {
        Boolean valid = true;
        for (int l = 0; l < 9 && valid; l++) {
            if (sudokuBoard.getCell(i, j) == sudokuBoard.getCell(i, l) && l != j) {
                valid = false;
            }
        }
        return valid;
    }

    private boolean verifySubGrid(int i, int j, SudokuBoard sudokuBoard) {
        int initPosX = getInitPositionForSubGrid(i);
        int initPosY = getInitPositionForSubGrid(j);
        Boolean valid = true;
        for (int k = initPosX; k < initPosX + 3 && valid; k++) {
            for (int l = initPosY; l < initPosY + 3 && valid; l++) {
                int value = sudokuBoard.getCell(k, l);
                int valueToCompare = sudokuBoard.getCell(i, j);
                if ((value == valueToCompare && i != k) || (value == valueToCompare && j != l)) {
                    valid = false;
                }
//              System.out.println(sudokuBoard.getCell(k, l) + " ");
            }
        }
        return valid;
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
