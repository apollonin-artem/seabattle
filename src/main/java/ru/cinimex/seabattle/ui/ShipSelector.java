package ru.cinimex.seabattle.ui;

import ru.cinimex.seabattle.model.Cell;
import ru.cinimex.seabattle.model.Game;
import ru.cinimex.seabattle.states.SetupState;
import ru.cinimex.seabattle.states.State;

import javax.swing.*;
import java.util.Enumeration;

/**
 * Created by aapollonin on 18.05.2015.
 */
public class ShipSelector extends JPanel {
    private ButtonGroup hitPointsGroup;
    private ButtonGroup directionGroup;

    private HitPointsRadioButton[] battleship;

    public ShipSelector(Game game) {
        battleship = new HitPointsRadioButton[4];
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        hitPointsGroup = new ButtonGroup();
        Box firstBox = Box.createVerticalBox();

        for (int i = 0; i < battleship.length; i++) {
            battleship[i] = new HitPointsRadioButton(String.valueOf(i + 1), i + 1);
            hitPointsGroup.add(battleship[i]);
            firstBox.add(battleship[i]);
        }
        battleship[0].setSelected(true);


        DirectionRadioButton horizontal = new DirectionRadioButton("Hotizontal", SetupState.Ship.Direction.HORIZONTAL);
        DirectionRadioButton vertical = new DirectionRadioButton("Vertical", SetupState.Ship.Direction.VERTICAL);
        horizontal.setSelected(true);

        directionGroup = new ButtonGroup();
        directionGroup.add(horizontal);
        directionGroup.add(vertical);

//        Box finalBox = Box.createHorizontalBox();

        Box secondBox = Box.createVerticalBox();


        secondBox.add(horizontal);
        secondBox.add(vertical);

        add(firstBox);
        add(secondBox);
//        finalBox.add(firstBox);
//        finalBox.add(secondBox);
//        finalBox.setVisible(true);


    }

    public boolean setDisableHitPointsRadioButton(int i) {
        boolean flag = false;
        battleship[i - 1].setEnabled(false);
        Enumeration<AbstractButton> choices = hitPointsGroup.getElements();
        while (choices.hasMoreElements()) {
            HitPointsRadioButton choice = (HitPointsRadioButton) choices.nextElement();
            if (!choice.isSelected() && choice.isEnabled()) {
                choice.setSelected(true);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public int getShipHitpoints() {
        Enumeration<AbstractButton> choices = hitPointsGroup.getElements();

        while (choices.hasMoreElements()) {
            HitPointsRadioButton choice = (HitPointsRadioButton) choices.nextElement();

            if (choice.isSelected()) {
                return choice.getHitPoints();
            }
        }

        throw new IllegalStateException();
    }

    public SetupState.Ship.Direction getShipDirection() {
        Enumeration<AbstractButton> choices = directionGroup.getElements();

        while (choices.hasMoreElements()) {
            DirectionRadioButton choice = (DirectionRadioButton) choices.nextElement();

            if (choice.isSelected()) {
                return choice.getDirection();
            }
        }

        throw new IllegalStateException();
    }
}
