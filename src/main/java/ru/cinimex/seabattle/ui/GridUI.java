package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Cell;
import ru.cinimex.seabattle.model.Game;
import ru.cinimex.seabattle.model.Grid;
import ru.cinimex.seabattle.states.GameState;
import ru.cinimex.seabattle.states.SetupState;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aapollonin on 30.04.2015.
 */
public class GridUI extends JPanel {
    public GridUI(final Game game, final Grid grid, final ShipSelector shipSelector) {
        setLayout(new GridLayout(10, 10, 2, 2));

        for (Cell cell : grid.getCells()) {
            CellUI cellUI = new CellUI(cell);

            cellUI.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Cell cell = ((CellUI) e.getSource()).getCell();

                    if (game.getState() instanceof SetupState) {
                        SetupState state = (SetupState) game.getState();
                        SetupState.Ship ship = getShipConfiguration();

                        if (ship != null && state.handleCellClick(ship, cell, grid)) {
                            if (state.getShipType(ship.getHitPoints()).isComplete()) {
                                if (!shipSelector.setDisableHitPointsRadioButton(ship.getHitPoints())) {
                                    game.setState(new GameState());
                                }
                            }
                        }

                    } else if (game.getState() instanceof GameState) {
                        GameState state = (GameState) game.getState();
                            state.handleCellClick(cell,grid);
                    }

                    GridUI.this.repaint();
                }
            });

            add(cellUI);
        }
    }

    protected SetupState.Ship getShipConfiguration() {
        return null;
    }

    //toDo
    protected void setEnable(JRadioButton jRadioButton) {
        jRadioButton.setEnabled(true);
    }

    protected void setDisable(JRadioButton jRadioButton) {
        jRadioButton.setEnabled(false);
    }
}
