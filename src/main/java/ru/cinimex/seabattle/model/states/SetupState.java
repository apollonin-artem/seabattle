package ru.cinimex.seabattle.model.states;

import ru.cinimex.seabattle.model.Game;
import ru.cinimex.seabattle.model.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by aapollonin on 07.05.2015.
 */
public class SetupState extends State {
    @Override
    public void handleCellClick(ActionEvent e, Grid grid) {
        ((JButton) e.getSource()).setBackground(Color.BLUE);

    }
}
