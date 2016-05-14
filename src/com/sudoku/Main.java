package com.sudoku;

public class Main {

    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard();
        for(int iterator = 0; iterator < sudokuBoard.getBoard().size();iterator++){
            System.out.println(sudokuBoard.getBoard().get(iterator));
        }
    }
}
