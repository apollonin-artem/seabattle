package ru.cinimex.seabattle.states;


import ru.cinimex.seabattle.model.Cell;
import ru.cinimex.seabattle.model.Grid;

/**
 * Created by aapollonin on 07.05.2015.
 */
public class GameState extends State {
    public void handleCellClick(Cell cell, Grid grid) {
        grid.makeShot(cell.getX(),cell.getY());
    }
}
