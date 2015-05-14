package ru.cinimex.seabattle.model;

import ru.cinimex.seabattle.states.SetupState;
import ru.cinimex.seabattle.states.State;

/**
 * Created by aapollonin on 07.05.2015.
 */
public class Game {
    private State state = new SetupState();

    private int battleshipCount = 1;
    private int cruiserCount = 2;
    private int destroyerCount = 3;
    private int submarineCount = 4;

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

    public int getBattleshipCount() {
        return battleshipCount;
    }

    public int getCruiserCount() {
        return cruiserCount;
    }

    public int getDestroyerCount() {
        return destroyerCount;
    }

    public int getSubmarineCount() {
        return submarineCount;
    }
}
