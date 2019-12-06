package ru.arestov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Arena arena;
        int j;
        int n;
        List<String> list = new ArrayList<>();
        String s = Arena.s;
        String s2 = Arena.s2;

        list.add("Сергей");
        list.add("Юрий");
        list.add("Виктория");
        list.add("Евгений");
        list.add("Алексей");
        list.add("Александр");
        list.add("Грант");
        list.add("Виктор");


        System.out.println(s2 + "\n  Добро пожаловать в Fight club\n" + s2);

        System.out.printf("%22s%n", "Выберите игрока");
        System.out.println(s2);

        for (int i = 0; i < list.size() - 1; i++) {
            j = i + 1;
            n = j + 1;

            System.out.printf("%-20s  %-20s%n", "(" + j + ")" + list.get(i), "(" + n + ")" + list.get(j));
            i++;
        }
        System.out.println(s2);

        int numb = numberFormat();
        Human human = new Human(list.get(numb - 1));

        System.out.println(s2 + "\n" + s + "Выбран(а) " + list.get(numb - 1) + s + "\n" + s2);

        Thread.sleep(2000);
        System.out.println(s + "Выберите противника" + s + "\n" + s2);
        for (int i = 0; i < list.size() - 1; i++) {
            j = i + 1;
            n = j + 1;
            System.out.printf("%-20s  %-20s%n", "(" + j + ")" + list.get(i), "(" + n + ")" + list.get(j));
            i++;
        }
        System.out.println(s2);
        int numb2 = numberFormat();
        System.out.println(s2);

        Human human2 = new Human(list.get(numb2 - 1));
        System.out.println(s + "Выбран " + list.get(numb2 - 1) + s + "\n" + s2);

        arena = new Arena();
        arena.addList(human);
        arena.addList(human2);
        arena.start();
    }

    public static int numberFormat() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num;
        while (true) {
            System.out.print("Введите число:  ");
            try {
                num = Integer.parseInt(bufferedReader.readLine());
                if (num > 0 && num < 9) {
                    break;
                } else
                    System.out.println(Arena.s + "Введите число от 1 до 8");
            } catch (NumberFormatException | IOException e) {
                System.out.println(Arena.s + "Неверный формат");
            }
        }
        return num;
    }

}
