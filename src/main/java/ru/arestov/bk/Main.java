package ru.arestov.bk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ru.arestov.bk.Constant.S;
import static ru.arestov.bk.Constant.S2;

public class Main {
    static Logger log = LogManager.getLogger("Main");

    public static void main(String[] args) throws IOException, InterruptedException {
        log.info("Начало работы программы");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        list.add("");
        list.add("Сергей");
        list.add("Юрий");
        list.add("Виктория");
        list.add("Евгений");
        list.add("Алексей");
        list.add("Александр");
        list.add("Грант");
        list.add("Виктор");

        System.out.printf("%s\n Добро пожаловать в Fight club\n%s\n", S2, S2);
        System.out.printf("%sВыберите режим игры: \n\n(%d) Авторежим   %s(%d) Ручной режим\n%s\n", S, 1, S, 2, S2);
        if (inputNumbAuto(reader) == 1)
            log.info("Авторежим включен");
            Arena.autoFight = true;

        System.out.printf("%sВыберите игрока\n%s\n", S, S2);
        printList(list);

        Human human = new Human(list.get(inputNumb(reader)));
        System.out.printf("%sВыбран(а) %s\n%s\n", S, human.getName(), S2);


        Thread.sleep(2000);

        System.out.printf("%sВыберите противника\n%s\n", S, S2);

        printList(list);
        Human human2 = new Human(list.get(inputNumb(reader)));
        System.out.printf("%sВыбран(а) %s\n%s\n", S, human2.getName(), S2);

        Arena arena = new Arena();
        arena.addList(human);
        arena.addList(human2);
        arena.start();
        reader.close();
    }

    public static void printList(List<String> list) {
        int j;
        for (int i = 1; i < list.size() - 1; i++) {
            j = i + 1;
            System.out.printf(" (%d)%-20s(%d)%s%n", i, list.get(i), j, list.get(j));
            i++;
        }
        System.out.println(S2);
    }

    public static int inputNumb(BufferedReader reader) throws IOException {
        int i;
        if (Arena.autoFight) {
            Random random = new Random();
            i = 1 + random.nextInt(9 - 1);
            log.debug("рандомное значение: {}",i);
        } else {
            while (true) {
                System.out.printf("%sВведите число:  ", S);
                try {
                    i = Integer.parseInt(reader.readLine());
                    log.debug("нажата клавиша  {}",i);
                    if (i > 0 && i < 9) {
                        break;
                    } else
                        System.out.printf("%sВведите число от 1 до 8\n", S);
                } catch (NumberFormatException s) {
                    System.out.printf("%sНеверный формат\n", S);
                }
            }
        }
        return i;

    }

    public static int inputNumbAuto(BufferedReader reader) throws IOException {
        int i;
        while (true) {
            System.out.printf("%sВведите число:  ", S);
            try {
                i = Integer.parseInt(reader.readLine());

                if (i > 0 && i < 3) {
                    break;
                } else
                    System.out.printf("%sВведите 1 или 2\n", S);
            } catch (NumberFormatException s) {
                System.out.printf("%sНеверный формат\n", S);
            }
        }
        log.debug("нажата клавиша  {}",i);
        return i;
    }

}
