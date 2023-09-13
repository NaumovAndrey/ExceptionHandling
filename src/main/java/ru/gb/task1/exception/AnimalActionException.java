package ru.gb.task1.exception;

public abstract class AnimalActionException extends AnimalNameException{
    private final int distance;

    public AnimalActionException(String message, String name, int distance) {
        super(message, name);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
