package ru.gb.task1;

import ru.gb.task1.exception.AnimalNameException;
import ru.gb.task1.exception.AnimalRunException;
import ru.gb.task1.exception.AnimalSwimException;

public abstract class Animal {

    //region Fields
    protected final String name;
    //endregion

    //region Constructors

    /**
     * Создаёт новое животное
     * @param name
     * @throws AnimalNameException исключение при некорректном вводе имени
     */
    public Animal(String name) throws AnimalNameException {
        if (name == null || name.length() < 2)
            throw  new AnimalNameException("Имя некорректно.", name);

        this.name = name;
    }
    //endregion

    //region get and set
    public String getName() {
        return name;
    }
    //endregion

    /**
     * Абстрактный метод, что животное может плавать
     * @param distance
     */
    abstract void swim(int distance) throws AnimalSwimException;

    /**
     * Абстрактный метод, что животное может бегать
     * @param distance
     */
    abstract void run(int distance) throws AnimalRunException;
}
