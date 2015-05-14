package ru.cinimex.seabattle.model;

import java.security.PublicKey;

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
                field[i][j] = new Cell();
            }
        }
    }
    public int getFieldSize(){return FIELD_SIZE;}

    public Cell getCell(int x, int y) {
        return field[x][y];
    }




}
