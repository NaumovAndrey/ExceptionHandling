package ru.gb.task1.exception;

public class AnimalNameException extends Exception{
    private String name;

    public AnimalNameException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
