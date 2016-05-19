package com.sudoku;

/**
 * This class represent a cell of Sudoku Board
 */
public class SudokuBoard {
    private int boardLimit = 9;
    private int[][] arrayBoard = new int[boardLimit][boardLimit];

    public SudokuBoard(int[][] arrayBoard) {
        this.arrayBoard = arrayBoard;
    }

    public Boolean isThereAnEmptyCell() {
        for (int i = 0; i < boardLimit; i++) {
            for (int j = 0; j < boardLimit; j++) {
                if (getCell(i, j) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public Cell getAnEmptyCell() {
        for (int i = 0; i < boardLimit; i++) {
            for (int j = 0; j < boardLimit; j++) {
                if (getCell(i, j) == 0) {
                    return new Cell(i,j,0);
                }
            }
        }
        return null;
    }

    public int getEmptyCellX() {
        for (int i = 0; i < boardLimit; i++) {
            for (int j = 0; j < boardLimit; j++) {
                if (getCell(i, j) == 0) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int getEmptyCellY() {
        for (int i = 0; i < boardLimit; i++) {
            for (int j = 0; j < boardLimit; j++) {
                if (getCell(i, j) == 0) {
                    return j;
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String cadena = " ";
        for (int posX = 0; posX < boardLimit; posX++) {
            for (int posY = 0; posY < boardLimit; posY++) {
                cadena = cadena + getCell(posX, posY) + " ";
            }
            cadena = cadena + "\n" + " ";
        }
        return cadena;
    }

    public int getCell(int i, int j) {
        return this.arrayBoard[i][j];
    }

    public void setCell(int i, int j, int value) {
        this.arrayBoard[i][j] = value;
    }

    private static int getRandomNumber(int minimum, int maximum) {
        int randomNum;
        randomNum = minimum + (int) (Math.random() * maximum);
        return randomNum;
    }
}
