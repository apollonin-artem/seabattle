package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Grid;

import javax.swing.*;


public class GameFrame extends JFrame {
    Grid myGrid;

    public GameFrame(int width, int design){
        super("Ахуеннейшая игра");

        setContentPane(new GridUI(new Grid()));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, design);
    }

    public void display() {
        setVisible(true);
    }
}
