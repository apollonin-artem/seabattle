package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Cell;

import javax.swing.*;
import java.awt.*;


/**
 * Created by aapollonin on 14.05.2015.
 */
public class CellUI extends JButton{
    private Cell cell;

    public CellUI(Cell cell){
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    @Override
    protected void paintComponent(Graphics g) {
        setBackground(cell.getState().getColor());
        super.paintComponent(g);
    }
}
