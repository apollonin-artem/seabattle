package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Cell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aapollonin on 14.05.2015.
 */
public class CellUI extends JButton{
    private Cell cell;
    private int indexX;
    private int indexY;

    public CellUI(Cell cell, int x, int y){
        this.cell = cell;
        this.indexX = x;
        this.indexY = y;
    }

    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }
}
