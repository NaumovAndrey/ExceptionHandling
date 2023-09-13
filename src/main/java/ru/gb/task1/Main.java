package ru.gb.task1;

import ru.gb.task1.exception.AnimalNameException;
import ru.gb.task1.exception.AnimalRunException;
import ru.gb.task1.exception.AnimalSwimException;

import java.util.Random;

public class Main {
    private static Random random = new Random();
    public static void main(String[] args) {
        try {
            Animal cat = new Cat("Барсик");
            Animal cat2 = new Cat("Мурзик");

            Animal[] animals = new Animal[]{cat, cat2};
            for (int i = 0; i < animals.length; i++){
                for (int j = 0; j < 10; j++){
                    int k = random.nextInt(2);
                    try {
                        switch (k){
                            case 0 -> {
                                animals[i].swim(j * 10);
                                System.out.printf("Животное проплыло %d метров.\n", i * 10);
                            }
                            case 1 -> {
                                animals[i].run(j * 10);
                                System.out.printf("Животное пробежао %d метров.\n", i * 10);
                            }
                        }
                    }
                    catch (AnimalSwimException e){
                        System.out.printf("Ошибка при попытке %s проплыть %d метров (%s)\n", e.getName(), e.getDistance(), e.getMessage());
                    }
                    catch (AnimalRunException e){
                        System.out.printf("Ошибка при попытке %s пробежать %d метров (%s)\n", e.getName(), e.getDistance(), e.getMessage());
                    }

                }
            }
        }
        catch (AnimalNameException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}