package ru.cinimex.seabattle.model;

import ru.cinimex.seabattle.states.SetupState;


import java.util.Iterator;

/**
 * Created by aapollonin on 29.04.2015.
 */
public class Grid {
    private static final int FIELD_SIZE = 10;
    private SetupState.Ship shipSelected;

    private Cell[][] field;

    public Grid() {
        field = new Cell[FIELD_SIZE][FIELD_SIZE];
        shipSelected = new SetupState.Ship();

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

    public int getFieldSize() {
        return FIELD_SIZE;
    }

//    public void setShip(int x, int y) {
//        if (field[x][y].getState() != Cell.State.NEARSHIP) {
//            field[x][y].setState(Cell.State.SHIP);
//
//            for (int dx = -1; dx < 2; dx++) {
//                for (int dy = -1; dy < 2; dy++) {
//                    Cell cell = getCell(x + dx, y + dy);
//
//                    if (cell != null && cell.getState() != Cell.State.SHIP) {
//                        cell.setState(Cell.State.NEARSHIP);
//                    }
//                }
//            }
//        }
//    }

    public boolean setHorizontalShip(int x, int y, int size) {
        if ((getCell(x + size - 1, y) != null) && (field[x + size - 1][y].getState() == Cell.State.FREE) && (field[x][y].getState() == Cell.State.FREE)) {
            for (int i = 0; i < size; i++) {
                field[x + i][y].setState(Cell.State.SHIP);
            }
            for (int dx = -1; dx < size + 1; dx++) {
                for (int dy = -1; dy < 2; dy++) {
                    Cell cell = getCell(x + dx, y + dy);

                    if (cell != null && cell.getState() != Cell.State.SHIP) {
                        cell.setState(Cell.State.NEARSHIP);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean setVerticalShip(int x, int y, int size) {
        if ((getCell(x, y + size - 1) != null) && (field[x][y + size - 1].getState() == Cell.State.FREE) && (field[x][y].getState() == Cell.State.FREE)) {
            for (int i = 0; i < size; i++) {
                field[x][y + i].setState(Cell.State.SHIP);
            }
            for (int dx = -1; dx < 2; dx++) {
                for (int dy = -1; dy < size + 1; dy++) {
                    Cell cell = getCell(x + dx, y + dy);

                    if (cell != null && cell.getState() != Cell.State.SHIP) {
                        cell.setState(Cell.State.NEARSHIP);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= getFieldSize() || y < 0 || y >= getFieldSize()) {
            return null;
        }

        return field[x][y];
    }

    public void setShipSelected(SetupState.Ship shipSelected) {
        this.shipSelected = shipSelected;
    }

    public SetupState.Ship getShipSelected() {
        return shipSelected;
    }

    public Iterable<Cell> getCells() {
        return new Iterable<Cell>() {

            @Override
            public Iterator<Cell> iterator() {
                return new CellIterator(field);
            }
        };
    }

    public static class CellIterator implements Iterator<Cell> {

        private Cell[][] field;
        private int i, j;


        public CellIterator(Cell[][] field) {
            this.field = field;
        }

        @Override
        public boolean hasNext() {
            return i < field.length && j < field[0].length;
        }

        @Override
        public Cell next() {
            Cell cell = field[i][j];

            i += 1;
            if (i >= field.length) {
                i = 0;
                j += 1;
            }

            return cell;
        }
    }
}
