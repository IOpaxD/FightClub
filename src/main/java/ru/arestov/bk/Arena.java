package ru.arestov.bk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static ru.arestov.bk.Constant.*;

public class Arena {
    private static Logger log = LogManager.getLogger("Арена");

    static boolean autoFight = false;
    private static int count = 1;
    private static Scanner in;

    private List<Human> humanList = new ArrayList<>();

    public void addList(Human human) {
        humanList.add(human);
        log.info("Добавлен(а) {} в humanList",human);
    }

    public void start() throws InterruptedException, IOException {

        System.out.printf("%sДобро пожаловать на арену \n", S);
        System.out.printf("%sБой начнется через\n", S);

        for (int i = 3; i > 0; i--) {
            System.out.printf("%s%d............. \n", S, i);
            Thread.sleep(1000);
        }
        fight(humanList.get(PLAYER), humanList.get(BOT));
    }

    private void fight(Human player, Human bot) throws IOException, InterruptedException {
        log.info("Начало боя");
        while (player.getHealth() > 0 & bot.getHealth() > 0) {

            if (count % 2 == 1) {
                System.out.printf("%s\n%s%sROUND\n%s\n", S2, S, S, S2);
                player.printHit();
                if (autoFight)
                    round(player.random(), bot.random(), bot.random(), player, bot);
                else
                    round(player.inputNumb(count), bot.random(), bot.random(), player, bot);
            } else {
                player.printBlock();
                if (autoFight)
                    round(bot.random(), player.random(), player.random(), bot, player);
                else
                    round(bot.random(), player.inputNumb(count), player.inputNumb(count), bot, player);
            }
            count++;
        }
        if (player.getHealth() > bot.getHealth())
            System.out.printf("%sПобедил(а) %s\n", S, player.getName());

        else if (player.getHealth() < bot.getHealth())
            System.out.printf("%sПобедил(а) %s\n", S, bot.getName());
        else
            System.out.printf("%sНичья\n", S);
        in.close();
    }

    private void round(int hit, int block, int block2, Human attack, Human protecting) throws InterruptedException {

        log.debug("{} удар ({}){}",attack,hit,readFile(TEXT5,hit));
        log.debug("{} блок ({}){} блок ({}){}",protecting,block, readFile(TEXT5,block),block2,readFile(TEXT5,block2));

        System.out.printf("%s%s%s", S, attack.getName(), readFile(TEXT1, 0));

        if (hit == block | hit == block2) {
            System.out.printf("%s%s\n%s%s%s%s\n%s\n", readFile(TEXT2, 0), readFile(TEXT5, hit),
                    S, protecting.getName(), readFile(TEXT3, 0), readFile(TEXT4, 0), S2);
            log.info("{} промах по {}",attack,protecting);
        } else {
            System.out.printf("%s%s\n%s%s%s%s\n%s\n", readFile(TEXT2, 0), readFile(TEXT5, hit),
                    S, protecting.getName(), readFile(TEXT6, 0), readFile(TEXT5, hit), S2);
            protecting.setHealth(protecting.getHealth() - 20);
            log.info("{} попал по {}",attack,protecting);
        }
        Thread.sleep(4000);

        if (count % 2 == 0) {
            System.out.printf("%s%s %s XP\n", S, protecting.getName(), protecting.getHealth());
            System.out.printf("%s%s %s XP\n", S, attack.getName(), attack.getHealth());
            Thread.sleep(1000);
        }
    }


    private static String readFile(String fileName, int i) {

        List<String> list = new ArrayList<>();
        String s = "src\\main\\resources\\text\\" + fileName + ".txt";

        try {
            in = new Scanner(new File(s));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }
        if (in != null) {
            while (in.hasNextLine()) {
                list.add(in.nextLine());
            }
        }
        if (i == 0) {
            i = list.size();
            Random random = new Random();
            return list.get(1 + random.nextInt(i - 1));
        } else {
            return list.get(i);
        }

    }


}