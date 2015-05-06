package ru.cinimex.seabattle.model;

class Cell {
    private boolean isShip;
    private boolean isFree = true;
    private boolean isShot;

    public boolean isShip() {
        return isShip;
    }

    public void setIsShip(boolean isShip) {
        this.isShip = isShip;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public boolean isShot() {
        return isShot;
    }

    public void setIsShot(boolean isShot) {
        this.isShot = isShot;
    }
}
