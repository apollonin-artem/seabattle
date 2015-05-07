package ru.cinimex.seabattle.model;

import ru.cinimex.seabattle.model.states.SetupState;
import ru.cinimex.seabattle.model.states.State;

/**
 * Created by aapollonin on 07.05.2015.
 */
public class Game {
    private State state = new SetupState();

    private Grid ownGrid = new Grid();
    private Grid enemyGrid = new Grid();

    public Grid getOwnGrid() {
        return ownGrid;
    }

    public Grid getEnemyGrid() {
        return enemyGrid;
    }

    public State getState() {
        return state;
    }
}
