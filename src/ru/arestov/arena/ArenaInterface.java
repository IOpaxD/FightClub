package ru.arestov.arena;

import java.io.IOException;

public interface ArenaInterface {
    void start() throws InterruptedException, IOException;

    void fight() throws IOException, InterruptedException;

    void round(int hit, int bb, int bb2) throws IOException, InterruptedException;

    void round2(int hitB, int bp, int bp2) throws InterruptedException;

    int random();

    int randomSay(int j);

    static int numberFormat() {
        return 0;
    }
}
