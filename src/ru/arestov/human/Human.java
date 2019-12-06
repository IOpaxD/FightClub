package ru.arestov.human;


import ru.arestov.arena.Arena;

public class Human {
    String name;
    String gender;
    int health;

    public Human(String name) {
        this.name = name;
        this.health = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return name;
    }

    String s = Arena.s;


    public void hitSelection() {

        System.out.println(s+"(1) Удар в голову"+s+"\n" +
                s+"(2) Удар в грудь"+s+"\n" +
                s+"(3) Удар в живот"+s+"\n" +
                s+"(4) Удар в пояс/пах"+s+"\n" +
                s+"(5) Удар в ноги"+s);
    }

    public void blokSelection() {
        System.out.println(s+"(1) Блок головы"+s+"\n" +
                s+"(2) Блок груди"+s+"\n" +
                s+"(3) Блок живота"+s+"\n" +
                s+"(4) Блок пояса"+s+"\n" +
                s+"(5) Блок ног"+s);
    }


}



