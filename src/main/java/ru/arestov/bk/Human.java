package ru.arestov.bk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static ru.arestov.bk.Constant.*;


public class Human {
    private static Logger log = LogManager.getLogger("class Human");
    private String name;
    private int health;

    public Human(String name) {
        this.name = name;
        this.health = 100;
        log.info("Выбран {} health={}", name, this.health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        log.info("health, было:{}, стало:{} ", this.health, health);
        this.health = health;

    }

    public void printHit() {
        System.out.printf("%s(%d) Удар в голову\n%s(%d) Удар в грудь\n%s(%d) Удар в живот\n%s(%d) Удар в пояс/пах\n%s(%d) Удар в ноги\n%s\n", S, 1, S, 2, S, 3, S, 4, S, 5,S2);
    }

    public void printBlock() {
        System.out.printf("%s(%d) Блок головы\n%s(%d) Блок груди\n%s(%d) Блок живота\n%s(%d) Блок пояса/пах\n%s(%d) Блок ног\n%s\n", S, 1, S, 2, S, 3, S, 4, S, 5,S2);
    }

    public int inputNumb(int count) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num;
        while (true) {
            if (count % 2 == 1) {
                System.out.printf("%sУдар:  ", S);
            } else {
                System.out.printf("%sБлок:   ", S);
            }
            try {
                num = Integer.parseInt(bufferedReader.readLine());

                if (num > 0 && num < 6) {
                    break;
                } else
                    System.out.printf("%sВведите число от 1 до 5\n", S);
            } catch (NumberFormatException s) {
                System.out.printf("%sНеверный формат\n", S);
            }
        }
        log.debug("нажата клавиша  {}", num);
        return num;
    }

    public int random() {
        Random random = new Random();
        int i = 1 + random.nextInt(6 - 1);
        log.debug("рандомное значение: {}", i);
        return i;
    }

    @Override
    public String toString() {
        return name;
    }
}




