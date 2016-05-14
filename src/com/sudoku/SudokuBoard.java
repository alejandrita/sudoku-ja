package com.sudoku;

import java.util.*;

/**
 * This class represent a cell of Sudoku Board
 */
public class SudokuBoard {
    private int boardLimit = 10;
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

    public void setBoard(LinkedList<Cell> board) {
        this.board = board;
    }

    public LinkedList<Cell> getBoard() {
        return board;
    }
}
