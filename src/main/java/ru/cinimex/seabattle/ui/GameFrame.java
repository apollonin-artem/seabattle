package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Game;
import ru.cinimex.seabattle.model.Grid;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {
    Box horizontzalBox;
    Box finalBox;
    Box box;
    public GameFrame(int width, int design, Game game){
        super("Ахуеннейшая игра");

        GridUI ownField = new GridUI(game, game.getOwnGrid());
        GridUI enemyField = new GridUI(game, game.getEnemyGrid());
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

        // создаем кнопки для выбора корабля который необходимо разместить
        JButton battleshipButton = new JButton("BattleShip");
        JButton cruiserButton = new JButton("Cruiser Ship");
        JButton destroyerButton = new JButton("DestroyerShip");
        JButton submarineButton = new JButton("SubmarineShip");

        //вешаем кнопки на менеджер размещения
        horizontzalBox = Box.createHorizontalBox();
        horizontzalBox.add(battleshipButton);
        horizontzalBox.add(cruiserButton);
        horizontzalBox.add(destroyerButton);
        horizontzalBox.add(submarineButton);


        finalBox.add(box);
        finalBox.add(Box.createVerticalStrut(10));
        finalBox.add(horizontzalBox);
        finalBox.add(Box.createVerticalGlue());
        setContentPane(finalBox);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, design);

    }

    public void display() {
        setVisible(true);
    }
}
