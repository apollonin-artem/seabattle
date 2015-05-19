package ru.cinimex.seabattle.model;

/**
 * Created by aapollonin on 18.05.2015.
 */
public class ShipType {
    private final int maxCount;
    private int count;

    public ShipType(int maxCount) {
        this.maxCount = maxCount;
    }

    public void addShip() {
        count += 1;
    }

    public boolean isComplete() {
        return count >= maxCount;
    }
}
