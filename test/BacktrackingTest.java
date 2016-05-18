import static org.junit.Assert.*;

import com.algorithm.Backtraking;
import com.sudoku.SudokuBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BacktrackingTest {

    @Test
    public void test()
    {
        SudokuBoard sudokuBoard = new SudokuBoard();
        System.out.println(sudokuBoard.toString());
        System.out.println(sudokuBoard.iniBoardToString());
        Backtraking backtraking = new Backtraking();
        backtraking.solve(sudokuBoard);

//        sudokuBoard.setCell(5,5,6);
//        System.out.println(sudokuBoard.toString());
//        sudokuBoard.generateIniSudoku();
//        System.out.println(sudokuBoard.iniBoardToString());
    }
    @Test
    public void getInitPositionForSubGridTest()
    {
        // 1 2 3 4 5 6 7 8 9
        Backtraking backtraking = new Backtraking();

        int initPos = backtraking.getInitPositionForSubGrid(0);
        assertEquals(0,initPos);
        initPos = backtraking.getInitPositionForSubGrid(1);
        assertEquals(0,initPos);
        initPos = backtraking.getInitPositionForSubGrid(2);
        assertEquals(0,initPos);

        initPos = backtraking.getInitPositionForSubGrid(3);
        assertEquals(3,initPos);
        initPos = backtraking.getInitPositionForSubGrid(4);
        assertEquals(3,initPos);
        initPos = backtraking.getInitPositionForSubGrid(5);
        assertEquals(3,initPos);

        initPos = backtraking.getInitPositionForSubGrid(6);
        assertEquals(6,initPos);
        initPos = backtraking.getInitPositionForSubGrid(7);
        assertEquals(6,initPos);
        initPos = backtraking.getInitPositionForSubGrid(8);
        assertEquals(6,initPos);

    }
}
