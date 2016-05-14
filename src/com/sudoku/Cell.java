package com.sudoku;

/**
 * This class represent a cell of Sudoku Board
 */
public class Cell {
    private int elementValue;
    private int posX = 0;
    private int posY = 0;

    public Cell(int x, int y, int value) {
        this.posX = x;
        this.posY = y;
        this.elementValue = value;
    }

    public Cell() {
        this.elementValue = 0;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setElementValue(int elementValue) {
        this.elementValue = elementValue;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public int getElementValue() {
        return this.elementValue;
    }

    @Override
    public String toString() {
        return "PosX: " + getPosX() + " PosY: " + getPosY() + " Value: " + getElementValue();
    }
}
