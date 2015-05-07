package ru.cinimex.seabattle.model.states;

import ru.cinimex.seabattle.model.Grid;

import java.awt.event.ActionEvent;

/**
 * Created by aapollonin on 07.05.2015.
 */
public abstract class State {
    public abstract void handleCellClick(ActionEvent e, Grid grid);
}
