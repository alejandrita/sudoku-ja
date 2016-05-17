package com.sudoku;

import java.util.*;

/**
 * This class represent a cell of Sudoku Board
 */
public class SudokuBoard {
    private int boardLimit = 9;
    private String[][] arrayBoard = new String[boardLimit][boardLimit];
    private LinkedList<Cell> board = new LinkedList<Cell>();

    public SudokuBoard() {
        generateSudoku();
    }

    public void generateSudoku() {
        for (int posX = 0; posX < boardLimit; posX++) {
            for (int posY = 0; posY < boardLimit; posY++) {
                board.add(new Cell(posX, posY, 0));
            }
        }
    }

    public void generateArraySudoku() {
        for (int posX = 0; posX < boardLimit; posX++) {
            for (int posY = 0; posY < boardLimit; posY++) {
                arrayBoard[posX][posY] = "" + posX + posY;
            }
        }
    }

    public void generateEmptyArraySudoku() {
        for (int posX = 0; posX < boardLimit; posX++) {
            for (int posY = 0; posY < boardLimit; posY++) {
                arrayBoard[posX][posY] = "" + 0;
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

    public String getCell(int i, int j) {
        return arrayBoard[i][j];
    }

    private static int getRandomNumber() {
        int minimum = 0;
        int maximum = 9;
        int randomNum;
        randomNum = minimum + (int) (Math.random() * maximum);
        return randomNum;
    }

    public void setBoard(LinkedList<Cell> board) {
        this.board = board;
    }

    public LinkedList<Cell> getBoard() {
        return board;
    }
}
