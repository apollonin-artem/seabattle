package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Cell;
import ru.cinimex.seabattle.model.Game;
import ru.cinimex.seabattle.model.Grid;
import ru.cinimex.seabattle.model.states.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aapollonin on 30.04.2015.
 */
public class GridUI extends JPanel {
    private CellUI[][] field;

    public GridUI(final Game game, final Grid grid) {
        field = new CellUI[grid.getFieldSize()][grid.getFieldSize()];

        setLayout(new GridLayout(10, 10, 2, 2));

        for (int i = 0; i < grid.getFieldSize(); i++) {
            for (int j = 0; j < grid.getFieldSize(); j++) {
                field[i][j] = new CellUI(grid.getCell(i,j),i,j);

                field[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.getState().handleCellClick(e, grid);
                    }
                });
                add(field[i][j]);
            }
        }
    }
}
