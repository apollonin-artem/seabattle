package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.states.SetupState;

import javax.swing.*;

/**
 * Created by aapollonin on 18.05.2015.
 */
public class DirectionRadioButton extends JRadioButton {
    private SetupState.Ship.Direction direction;

    public DirectionRadioButton(String text, SetupState.Ship.Direction direction) {
        super(text);
        this.direction = direction;
    }

    public SetupState.Ship.Direction getDirection() {
        return direction;
    }
}
