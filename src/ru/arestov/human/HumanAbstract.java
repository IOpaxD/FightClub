package ru.arestov.human;
import ru.arestov.arena.Arena;

import java.util.Random;

public class HumanAbstract {
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

    public int random() {
        Random random = new Random();
        return 1 + random.nextInt(6 - 1);
    }


}
