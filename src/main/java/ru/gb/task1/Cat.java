package ru.gb.task1;

import ru.gb.task1.exception.AnimalNameException;
import ru.gb.task1.exception.AnimalRunException;
import ru.gb.task1.exception.AnimalSwimException;

public class Cat extends Animal {
    public Cat(String name) throws AnimalNameException {
        super(name);
    }

    @Override
    void swim(int distance) throws AnimalSwimException {
        throw new AnimalSwimException("Кот не плавает", name, distance);
    }

    @Override
    void run(int distance) throws AnimalRunException {
        if (distance < 50){
            //todo
        }
        else {
            throw new AnimalRunException("Большое растояние для кота", name, distance);
        }
    }
}
