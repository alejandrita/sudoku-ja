package com.algorithm;

import com.sudoku.Cell;
import com.sudoku.SudokuBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class represent the Peter Norvig's algorithm
 */
public class PeterNorvig implements Algorithm {

    private SudokuBoard board;

    @Override
    public Boolean solve(SudokuBoard sudokuBoard) {
        board = sudokuBoard;

        Cell emptyCell = board.getFirstEmptyCell();

        if (board.getFirstEmptyCell() == null) {
            return true;
        }

        int row = emptyCell.getPosX();
        int column = emptyCell.getPosY();

        for (Integer value : getNumbersForCell(row, column)) {
            board.getCell(row, column).setValue(value);
            if (solve(board))
                return true;
        }
        board.clearCell(row, column);
        return false;
    }

    public List<Integer> getNumbersForCell(int row, int column) {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        numbers = deleteNumbersInRow(numbers, row);
        numbers = deleteNumbersInColumn(numbers, column);
        numbers = deleteNumbersInSubGrid(numbers, row, column);
        return numbers;
    }

    private List<Integer> deleteNumbersInSubGrid(List<Integer> digits, int row, int column) {
        int initPosX = SudokuBoard.getIniPosSubGrid(row);
        int initPosY = SudokuBoard.getIniPosSubGrid(column);
        for (int i = initPosX; i < initPosX + 3; i++) {
            for (int j = initPosY; j < initPosY + 3; j++) {
                deleteCell(digits, board.getCell(row, column));
            }
        }
        return digits;
    }

    private void deleteCell(List<Integer> numbers, Cell cell) {
        Integer num = cell.getValue();
        if (!cell.isEmpty() && numbers.contains(num)) {
            numbers.remove(numbers.indexOf(num));
        }
    }

    private List<Integer> deleteNumbersInColumn(List<Integer> numbers, int column) {
        for (int row = 0; row < board.getBoardSize(); row++)
            deleteCell(numbers, board.getCell(row, column));
        return numbers;
    }

    private List<Integer> deleteNumbersInRow(List<Integer> numbers, int row) {
        for (int column = 0; column < board.getBoardSize(); column++)
            deleteCell(numbers, board.getCell(row, column));
        return numbers;
    }
}