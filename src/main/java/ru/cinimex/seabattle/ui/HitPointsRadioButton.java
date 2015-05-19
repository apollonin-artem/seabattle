package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.ShipType;
import ru.cinimex.seabattle.states.SetupState;
import ru.cinimex.seabattle.states.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aapollonin on 18.05.2015.
 */
public class HitPointsRadioButton extends JRadioButton {
    //private ShipType shipType;
    private int hitPoints;

    public HitPointsRadioButton(String text, int hitPoints /*final SetupState state*/) {
        super(text);
        this.hitPoints = hitPoints;
        //shipType = state.getShipType(hitPoints);


    }

    public int getHitPoints() {
        return hitPoints;
    }
}
