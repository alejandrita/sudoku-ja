import static org.junit.Assert.*;

import com.algorithm.Backtraking;
import com.sudoku.SudokuBoard;
import org.junit.Test;

public class BacktrackingTest {

    @Test
    public void test() {
//        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
//                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
//                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
//                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
//                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
//                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
//                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        int grid[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        SudokuBoard sudokuBoard = new SudokuBoard(grid);
        Backtraking backtraking = new Backtraking();
        Boolean isSolved = backtraking.solve(sudokuBoard);

        if (isSolved)
            System.out.println(sudokuBoard.toString());
        else
            System.out.println(("No solution exists"));
    }

    @Test
    public void isUsedInRowTest() {
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},// row 5
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudokuBoard = new SudokuBoard(grid);
        Backtraking backtraking = new Backtraking();
        Boolean isUsedInRow = backtraking.isUsedInRow(5, sudokuBoard, 6);
        assertTrue(isUsedInRow);
        isUsedInRow = backtraking.isUsedInRow(5, sudokuBoard, 8);
        assertFalse(isUsedInRow);
    }

    @Test
    public void isUsedInSubGridTest() {
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudokuBoard = new SudokuBoard(grid);
        Backtraking backtraking = new Backtraking();
        Boolean isUsedInSubGrid = backtraking.isUsedInSubGrid(2,2, sudokuBoard, 3);
        assertTrue(isUsedInSubGrid);
        isUsedInSubGrid = backtraking.isUsedInSubGrid(1,1, sudokuBoard, 1);
        assertFalse(isUsedInSubGrid);
    }

    @Test
    public void isUsedInColumnTest() {
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        SudokuBoard sudokuBoard = new SudokuBoard(grid);
        Backtraking backtraking = new Backtraking();
        Boolean isUsedInColumn = backtraking.isUsedInColumn(5, sudokuBoard, 3);
        assertTrue(isUsedInColumn);
        isUsedInColumn = backtraking.isUsedInColumn(5, sudokuBoard, 4);
        assertFalse(isUsedInColumn);
    }

    @Test
    public void getInitPositionForSubGridTest() {
        // 1 2 3 4 5 6 7 8 9
        Backtraking backtraking = new Backtraking();

        int initPos = backtraking.getInitPositionForSubGrid(0);
        assertEquals(0, initPos);
        initPos = backtraking.getInitPositionForSubGrid(1);
        assertEquals(0, initPos);
        initPos = backtraking.getInitPositionForSubGrid(2);
        assertEquals(0, initPos);

        initPos = backtraking.getInitPositionForSubGrid(3);
        assertEquals(3, initPos);
        initPos = backtraking.getInitPositionForSubGrid(4);
        assertEquals(3, initPos);
        initPos = backtraking.getInitPositionForSubGrid(5);
        assertEquals(3, initPos);

        initPos = backtraking.getInitPositionForSubGrid(6);
        assertEquals(6, initPos);
        initPos = backtraking.getInitPositionForSubGrid(7);
        assertEquals(6, initPos);
        initPos = backtraking.getInitPositionForSubGrid(8);
        assertEquals(6, initPos);

    }
}
