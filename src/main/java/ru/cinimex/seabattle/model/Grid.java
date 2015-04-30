package ru.cinimex.seabattle.model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aapollonin on 29.04.2015.
 */
public class Grid extends JPanel {
    public static final int FIELD_SIZE = 10;

    private JButton[][] field;
    private boolean[][] isShip;
    private boolean[][] isFree;
    private boolean[][] isShot;

    public Grid() {
        setLayout(new GridLayout(FIELD_SIZE, FIELD_SIZE, 2, 2));
        field = new JButton[FIELD_SIZE][FIELD_SIZE];

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                isFree[i][j] = true;
                isShip[i][j] = false;
                isShot[i][j] = false;
            }
        }
    }

    public void paint(Graphics g){
        super.paint(g);
    }

}
