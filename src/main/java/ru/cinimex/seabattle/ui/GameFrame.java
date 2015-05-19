package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Game;
import ru.cinimex.seabattle.states.SetupState;


import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {
    Box horizontalBox;
    Box finalBox;
    Box box;

    public GameFrame(int width, int design, Game game) {
        super("Ахуеннейшая игра");

//        JRadioButton battleship1 = new JRadioButton("1");
//        battleship1.setActionCommand("1");
//        battleship1.setSelected(true);
//        JRadioButton battleship2 = new JRadioButton("2");
//        battleship2.setActionCommand("2");
//        JRadioButton battleship3 = new JRadioButton("3");
//        battleship3.setActionCommand("3");
//        JRadioButton battleship4 = new JRadioButton("4");
//        battleship4.setActionCommand("4");
//        ButtonGroup group = new ButtonGroup();
//        group.add(battleship1);
//        group.add(battleship2);
//        group.add(battleship3);
//        group.add(battleship4);

        final ShipSelector shipSelector = new ShipSelector(game);

        GridUI ownField = new GridUI(game, game.getOwnGrid(), shipSelector) {
            @Override
            protected SetupState.Ship getShipConfiguration() {
                SetupState.Ship ship = new SetupState.Ship();
                ship.setHitPoints(shipSelector.getShipHitpoints());
                ship.setDirection(shipSelector.getShipDirection());
                return ship;
            }
        };

        GridUI enemyField = new GridUI(game, game.getEnemyGrid(), shipSelector);

        // задаем размер кажого поля
        ownField.setMaximumSize(new Dimension(400, 400));
        enemyField.setMaximumSize(new Dimension(400, 400));
        ownField.setMinimumSize(new Dimension(400, 400));
        enemyField.setMinimumSize(new Dimension(400, 400));
        ownField.setPreferredSize(new Dimension(400, 400));
        enemyField.setPreferredSize(new Dimension(400, 400));

        finalBox = Box.createVerticalBox();
        // вешаем наши поля на Layout
        box = Box.createHorizontalBox();
        box.add(ownField);
        box.add(Box.createHorizontalStrut(10));
        box.add(enemyField);
        box.add(Box.createHorizontalGlue());

//        horizontalBox = Box.createHorizontalBox();
//        horizontalBox.add(battleship1);
//        horizontalBox.add(battleship2);
//        horizontalBox.add(battleship3);
//        horizontalBox.add(battleship4);

        finalBox.add(box);
        finalBox.add(Box.createVerticalStrut(10));
        finalBox.add(shipSelector);
        finalBox.add(Box.createVerticalGlue());
        setContentPane(finalBox);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, design);

    }

    public void display() {
        setVisible(true);
    }


}
