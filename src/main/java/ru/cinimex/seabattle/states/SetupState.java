package ru.cinimex.seabattle.states;


import ru.cinimex.seabattle.model.Cell;
import ru.cinimex.seabattle.model.Grid;
import ru.cinimex.seabattle.model.ShipType;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by aapollonin on 07.05.2015.
 */
public class SetupState extends State {

    private Map<Integer, ShipType> shipTypes = new HashMap<Integer, ShipType>();

    public SetupState() {
        shipTypes.put(1, new ShipType(4));
        shipTypes.put(2, new ShipType(3));
        shipTypes.put(3, new ShipType(2));
        shipTypes.put(4, new ShipType(1));
    }

    public ShipType getShipType(int hitPoints) {
        return shipTypes.get(hitPoints);
    }

    public static class Ship {

        private int hitPoints;

        private Direction direction = Direction.HORIZONTAL;

        public enum Direction {
            HORIZONTAL,
            VERTICAL
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public Direction getDirection() {
            return direction;
        }

        public int getHitPoints() {

            return hitPoints;
        }
    }

    public boolean handleCellClick(Ship ship, Cell cell, Grid grid) {
        if (ship.getDirection() == Ship.Direction.HORIZONTAL) {
            if (grid.setHorizontalShip(cell.getX(), cell.getY(), ship.getHitPoints())) {
                ShipType shipType = shipTypes.get(ship.getHitPoints());
                shipType.addShip();
                return true;
            }


        } else if (grid.setVerticalShip(cell.getX(), cell.getY(), ship.getHitPoints())) {
            ShipType shipType = shipTypes.get(ship.getHitPoints());
            shipType.addShip();
            return true;
        }
        return false;

    }
}
