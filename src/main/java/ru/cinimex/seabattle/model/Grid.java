package ru.cinimex.seabattle.model;

import java.awt.*;
import java.util.*;
import java.util.List;

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
                field[i][j] = new Cell(i, j);
            }
        }
    }

    public int getFieldSize() {
        return FIELD_SIZE;
    }

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

    public boolean isAlive(int x, int y, List<Point> checkedCells) {
        for (Cell neigh : getNeighbours(field[x][y])) {
            if (neigh != null && neigh.getState() == Cell.State.SHIP) {
                return true;
            } else if (neigh != null && neigh.getState() == Cell.State.KILLED) {

                Point coord = new Point(neigh.getX(), neigh.getY());
                if (!checkedCells.contains(coord)) {
                    checkedCells.add(coord);
                    if (isAlive(neigh.getX(), neigh.getY(), checkedCells)) {
                        return true;
                    }
                }
            }
        }


        /*for (int dx = -1; dx < 2; dx++) {
            for (int dy = -1; dy < 2; dy++) {
                Cell cell = getCell(x + dx, y + dy);

                if (cell != null && cell.getState() == Cell.State.SHIP) {
                    return true;
                } else if (cell != null && cell.getState() == Cell.State.KILLED) {
                    if (!checkedCells.contains(new Point(x + dx, y + dy))) {
                        checkedCells.add(new Point(x + dx, y + dy));
                        if (isAlive(x + dx, y + dy, checkedCells)) {
                            return true;
                        }
                    }
                }
            }
        }*/
        return false;
    }

    public void makeShot(int x, int y) {
        Cell.State state = field[x][y].getState();
        switch (state) {
            case SHIP:
                field[x][y].setState(Cell.State.KILLED);
                List<Point> checkedPoint = new ArrayList<Point>();
                if (!isAlive(x, y, checkedPoint)) {
                    List<Point> paintedPoint = new ArrayList<Point>();
                    setBorder(x, y, paintedPoint);
                }

                break;
            case FREE:
                field[x][y].setState(Cell.State.MISSED);
            case MISSED:
                break;
            case KILLED:
                break;
            case NEARSHIP:
                field[x][y].setState(Cell.State.MISSED);
                break;
        }
    }

    private void setBorder(int x, int y, List<Point> list) {
        for (int dx = -1; dx < 2; dx++) {
            for (int dy = -1; dy < 2; dy++) {
                Cell cell = getCell(x + dx, y + dy);

                if (cell != null && cell.getState() != Cell.State.KILLED) {
                    cell.setState(Cell.State.MISSED);
                } else {
                    Point coord = new Point(x + dx, y + dy);
                    if (cell != null && !list.contains(coord)) {
                        list.add(coord);
                        setBorder(x + dx, y + dy, list);
                    }
                }
            }
        }
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

    public static class CellNeighboursIterator implements Iterator<Cell> {
        private Cell[][] field;
        private Cell cell;

        private int dx = -1, dy = -1;

        public CellNeighboursIterator(Cell[][] field, Cell cell) {
            this.field = field;
            this.cell = cell;
        }

        @Override
        public boolean hasNext() {
            int x = cell.getX() + dx;
            int y = cell.getY() + dy;

            while (x < 0 || y < 0 || x >= field.length || y >= field.length || (dx == 0 && dy == 0)) {
                nextDeltas();
                x = cell.getX() + dx;
                y = cell.getY() + dy;
                if (dx > 1 || dy > 1) {
                    return false;
                }


            }

            return dy <= 1;
        }

        @Override
        public Cell next() {

            int x = cell.getX() + dx;
            int y = cell.getY() + dy;

            Cell ret = field[x][y];
            System.out.printf("%s %s %s %s%n", dx, dy, x, y);

            nextDeltas();

            return ret;

        }

        private void nextDeltas() {
            dx += 1;
            if (dx > 1) {
                dx = -1;
                dy += 1;
            }
        }
    }

    public Iterable<Cell> getNeighbours(final Cell cell) {
        return new Iterable<Cell>() {

            @Override
            public Iterator<Cell> iterator() {
                return new CellNeighboursIterator(field, cell);
            }
        };
    }

    public Iterable<Cell> getCells() {
        return new Iterable<Cell>() {

            @Override
            public Iterator<Cell> iterator() {
                return new CellIterator(field);
            }
        };
    }
}
