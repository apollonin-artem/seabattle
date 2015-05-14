package ru.cinimex.seabattle.model;

import java.awt.*;

public class Cell {
    private State state = State.FREE;

    private int x;
    private int y;

    public Cell (int x, int y){
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


    public enum State {
        SHIP(Color.GRAY),
        FREE(Color.CYAN),
        MISSED,
        KILLED,
        NEARSHIP(Color.yellow);


        private Color color;

        State() {
            color = Color.RED;
        }

        State(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }
}
