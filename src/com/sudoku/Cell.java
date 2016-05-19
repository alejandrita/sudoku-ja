package com.sudoku;

/**
 * This class represent a cell of Sudoku Board
 */
public class Cell {
    private int value;
    private int posX = 0;
    private int posY = 0;

    public Cell(int x, int y, int value) {
        this.posX = x;
        this.posY = y;
        this.value = value;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "PosX: " + getPosX() + " PosY: " + getPosY() + " Value: " + getValue();
    }
}
