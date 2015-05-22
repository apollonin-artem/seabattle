package ru.cinimex.seabattle.model;

import ru.cinimex.seabattle.states.GameState;
import ru.cinimex.seabattle.states.SetupState;
import ru.cinimex.seabattle.states.State;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by aapollonin on 07.05.2015.
 */
public class Game {
    private State state = new SetupState();

    private Grid ownGrid = new Grid();
    private Grid enemyGrid = new Grid();

    public Game() {
        enemyGrid.setHorizontalShip(0,0,1);
        enemyGrid.setHorizontalShip(0,9,4);
        enemyGrid.setHorizontalShip(5,5,2);
        enemyGrid.setHorizontalShip(1,5,2);
    }

    public Grid getOwnGrid() {
        return ownGrid;
    }

    public Grid getEnemyGrid() {
        return enemyGrid;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
