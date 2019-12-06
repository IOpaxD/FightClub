package ru.arestov.human;



public class Human extends HumanAbstract {
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



}
