package ru.cinimex.seabattle;

import ru.cinimex.seabattle.model.Game;
import ru.cinimex.seabattle.ui.GameFrame;


public class SeaBattle {
    public static void main(String[] a) {
        new GameFrame(900, 800, new Game()).display();
    }
}
