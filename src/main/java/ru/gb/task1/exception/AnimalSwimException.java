package ru.gb.task1.exception;

public class AnimalSwimException extends AnimalActionException{

    public AnimalSwimException(String message, String name, int distance) {
        super(message, name, distance);
    }
}
