package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Cell;
import ru.cinimex.seabattle.model.Grid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aapollonin on 30.04.2015.
 */
public class GridUI extends JPanel {
    private Grid grid;
    private JButton[][] field;

    public GridUI(Grid grid) {
        super();
        field = new JButton[grid.getFieldSize()][grid.getFieldSize()];
        this.grid = grid;
        setLayout(new GridLayout(10,10,2,2));

        for(int i=0; i < grid.getFieldSize();i++){
            for (int j = 0; j < grid.getFieldSize(); j++) {
                field[i][j]=new JButton();
                add(field[i][j]);
            }
        }
    }

}
