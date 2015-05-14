package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Cell;
import ru.cinimex.seabattle.model.Game;
import ru.cinimex.seabattle.model.Grid;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by aapollonin on 30.04.2015.
 */
public class GridUI extends JPanel {
    private Grid grid;

    public GridUI(final Game game, final Grid grid) {
        this.grid = grid;
        setLayout(new GridLayout(10, 10, 2, 2));

        for (Cell cell : grid.getCells()) {
            CellUI cellUI = new CellUI(cell);

            cellUI.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Cell cell = ((CellUI) e.getSource()).getCell();
                    game.getState().handleCellClick(cell, grid);

                    GridUI.this.repaint();
                }
            });

            add(cellUI);
        }
    }
}
