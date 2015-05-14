package ru.cinimex.seabattle.model;


import java.util.Iterator;

/**
 * Created by aapollonin on 29.04.2015.
 */
public class Grid {
    private static final int FIELD_SIZE = 10;

    private Cell[][] field;

    public Grid() {
        field = new Cell[FIELD_SIZE][FIELD_SIZE];

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = new Cell(i,j);
            }
        }
    }

    public int getFieldSize() {return FIELD_SIZE;}

    public void setShip(int x, int y) {
        field[x][y].setState(Cell.State.SHIP);

        for (int dx = -1; dx < 2; dx++) {
            for (int dy = -1; dy < 2; dy++) {
                Cell cell = getCell(x + dx, y + dy);

                if (cell != null && cell.getState() != Cell.State.SHIP) {
                    cell.setState(Cell.State.NEARSHIP);
                }
            }
        }
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= getFieldSize() || y < 0 || y >= getFieldSize()) {
            return null;
        }

        return field[x][y];
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
