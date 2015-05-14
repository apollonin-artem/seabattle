package ru.cinimex.seabattle.states;

import ru.cinimex.seabattle.model.Cell;
import ru.cinimex.seabattle.model.Grid;

/**
 * Created by aapollonin on 07.05.2015.
 */
public abstract class State {
    public abstract void handleCellClick(Cell cell, Grid grid);
}
