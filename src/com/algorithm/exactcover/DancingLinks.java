package com.algorithm.exactcover;

import com.algorithm.exactcover.nodes.ColumnNode;
import com.algorithm.exactcover.nodes.DancingNode;
import com.sudoku.SudokuBoard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represent the dancing node
 *
 */
public class DancingLinks{

    public ColumnNode header;
    private SolutionHandler handler;
    private List<DancingNode> answer;
    private SudokuBoard sudokuBoard;

    // Heart of the algorithm

    /**
     *
     *
     * @param k
     * @return
     */
    private SudokuBoard search(int k){
        if (header.getRight() == header){ // all the columns removed
             sudokuBoard = handler.handleSolution(answer);
        } else{
            ColumnNode columnNode = selectColumnNodeHeuristic();
            columnNode.cover();
            for(DancingNode r = columnNode.getDown(); r != columnNode; r = r.getDown()){
                answer.add(r);
                for(DancingNode j = r.getRight(); j != r; j = j.getRight()){
                    j.getC().cover();
                }
                search(k + 1);
                r = answer.remove(answer.size() - 1);
                columnNode = r.getC();
                for(DancingNode j = r.getLeft(); j != r; j = j.getLeft()){
                    j.getC().uncover();
                }
            }
            columnNode.uncover();
        }
        return sudokuBoard;
    }

    /**
     * Select a column node that accomplish with the dancing link logic
     *
     * @return ret
     */
    private ColumnNode selectColumnNodeHeuristic(){
        int min = Integer.MAX_VALUE;
        ColumnNode ret = null;
        for(ColumnNode c = (ColumnNode) header.getRight(); c != header; c = (ColumnNode) c.getRight()){
            if (c.getSize() < min){
                min = c.getSize();
                ret = c;
            }
        }
        return ret;
    }

    // grid is a grid of 0s and 1s to solve the exact cover for
    // returns the root column header node
    private ColumnNode makeDLXBoard(int[][] grid){
        final int COLS = grid[0].length;
        final int ROWS = grid.length;

        ColumnNode headerNode = new ColumnNode("header");
        ArrayList<ColumnNode> columnNodes = new ArrayList<ColumnNode>();

        for(int i = 0; i < COLS; i++){
            ColumnNode n = new ColumnNode(Integer.toString(i));
            columnNodes.add(n);
            headerNode = (ColumnNode) headerNode.hookRight(n);
        }
        headerNode = headerNode.getRight().getC();

        for(int i = 0; i < ROWS; i++){
            DancingNode prev = null;
            for(int j = 0; j < COLS; j++){
                if (grid[i][j] == 1){
                    ColumnNode col = columnNodes.get(j);
                    DancingNode newNode = new DancingNode(col);
                    if (prev == null)
                        prev = newNode;
                    col.getDown().hookDown(newNode);
                    prev = prev.hookRight(newNode);
                    col.setSize(col.getSize()+1);
                }
            }
        }

        headerNode.setSize(COLS);

        return headerNode;
    }

    // Grid consists solely of 1s and 0s. Undefined behaviour otherwise
    public DancingLinks(int[][] grid, SolutionHandler h){
        header = makeDLXBoard(grid);
        handler = h;
    }

    public SudokuBoard runSolver(){
        answer = new LinkedList<>();
        return search(0);
    }
}