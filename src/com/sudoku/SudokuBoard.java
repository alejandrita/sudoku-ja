package com.sudoku;

import java.util.*;

/**
 * This class represent a cell of Sudoku Board
 */
public class SudokuBoard {
    private int boardLimit = 9;
    private int[][] arrayBoard = new int[boardLimit][boardLimit];
    private Boolean[][] iniBoard = new Boolean[boardLimit][boardLimit];

    public SudokuBoard() {
        generateEmptyArraySudoku();
    }

    public SudokuBoard(int[][] arrayBoard) {
        this.arrayBoard = arrayBoard;
    }

    public void generateArraySudoku() {
        for (int posX = 0; posX < boardLimit; posX++) {
            for (int posY = 0; posY < boardLimit; posY++) {
                arrayBoard[posX][posY] = Integer.parseInt(String.valueOf(posX)+(String.valueOf(posY)));
            }
        }
    }

    public void generateEmptyArraySudoku() {
        for (int posX = 0; posX < boardLimit; posX++) {
            for (int posY = 0; posY < boardLimit; posY++) {
                arrayBoard[posX][posY] = 0;
            }
        }
    }

    public void generateIniSudoku() {
        for (int posX = 0; posX < boardLimit; posX++) {
            for (int posY = 0; posY < boardLimit; posY++) {
                if (arrayBoard[posX][posY] == 0){
                    iniBoard [posX][posY] = false;
                }
            }
        }
    }

    @Override
    public String toString() {
        String cadena = " ";
        for (int posX = 0; posX < boardLimit; posX++) {
            for (int posY = 0; posY < boardLimit; posY++) {
                cadena = cadena + getCell(posX, posY) + " ";
            }
            cadena =  cadena+ "\n" + " ";
        }
        return cadena;
    }

    public static void main(String[] args) {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.generateArraySudoku();
        System.out.println(sudoku);
        System.out.println(sudoku.getCell(5, 5));
    }

    public int getCell(int i, int j) {
        return arrayBoard[i][j];
    }

    private static int getRandomNumber() {
        int minimum = 0;
        int maximum = 9;
        int randomNum;
        randomNum = minimum + (int) (Math.random() * maximum);
        return randomNum;
    }
}
