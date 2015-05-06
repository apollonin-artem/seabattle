package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Grid;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {
    Grid myGrid;
    Box finalBox;
    Box box;
    public GameFrame(int width, int design){
        super("Ахуеннейшая игра");
        GridUI ownField = new GridUI(new Grid());
        GridUI enemyField = new GridUI(new Grid());
        ownField.setMaximumSize(new Dimension(400,400));
        enemyField.setMaximumSize(new Dimension(400, 400));
        ownField.setMinimumSize(new Dimension(400, 400));
        enemyField.setMinimumSize(new Dimension(400, 400));
        ownField.setPreferredSize(new Dimension(400, 400));
        enemyField.setPreferredSize(new Dimension(400, 400));
        finalBox = Box.createVerticalBox();

        box = Box.createHorizontalBox();
        box.add(ownField);
        box.add(Box.createHorizontalStrut(10));
        box.add(enemyField);
        box.add(Box.createHorizontalGlue());

        finalBox.add(box);
        setContentPane(finalBox);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, design);

    }

    public void display() {
        setVisible(true);
    }
}
