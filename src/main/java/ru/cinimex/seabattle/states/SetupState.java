package ru.cinimex.seabattle.states;



import ru.cinimex.seabattle.model.Cell;
import ru.cinimex.seabattle.model.Grid;



/**
 * Created by aapollonin on 07.05.2015.
 */
public class SetupState extends State {

    @Override
    public void handleCellClick(Cell cell, Grid grid) {
        grid.setShip(cell.getX(), cell.getY());
    }
}
