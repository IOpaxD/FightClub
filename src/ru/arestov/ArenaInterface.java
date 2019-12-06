package ru.arestov;

import java.io.IOException;

public interface ArenaInterface {
    public void start() throws InterruptedException, IOException;
    public void fight() throws IOException, InterruptedException;
    public void round(int hit, int bb, int bb2, int hitB, int bp, int bp2) throws IOException, InterruptedException;
    public int random();
    public int randomSay(int j);
    public static int numberFormat() {
        return 0;
    }
}
