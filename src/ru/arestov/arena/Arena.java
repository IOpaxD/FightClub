package ru.arestov.arena;



import ru.arestov.human.Human;
import ru.arestov.human.HumanSay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena implements ArenaInterface {

    int hitPlayer;
    int blockPlayer;
    int blockPlayer2;
    int hitPlayerBot;
    int blockPlayerBot;
    int blockPlayerBot2;
    int healthOne;
    int healthTwo;
    private static final int PLAYER_ONE = 0;
    private static final int PLAYER_TWO = 1;
    static int count = 1;
    public static String s = "     ";
    public static String s2 = "====================================";
    HumanSay say = new HumanSay();

    List<Human> humanList = new ArrayList<>();

    public List<Human> addList(Human human) {
        humanList.add(human);
        return humanList;
    }

    String nameOne;
    String nameTwo;

    public void start() throws InterruptedException, IOException {
        nameOne = humanList.get(PLAYER_ONE).getName();//берем имена в переменную
        nameTwo = humanList.get(PLAYER_TWO).getName();

        System.out.println(s + "Добро пожаловать на арену \n" + s + nameOne + " и " + nameTwo + s + "\n");
        System.out.println(s + "Бой начнется через" + s + "\n");

        //цикл который выводит 3 2 1
        for (int i = 3; i > 0; i--) {
            System.out.print(s + i + ".................");
            Thread.sleep(1500);
            System.out.println("\n");
        }

        fight();
    }

    public void fight() throws IOException, InterruptedException {
        healthOne = humanList.get(PLAYER_ONE).getHealth();//берем хп в переменную
        healthTwo = humanList.get(PLAYER_TWO).getHealth();
        //пока у всех хп больше 0
        while (healthOne > 0 & healthTwo > 0) {

            //рандомные числа блока для бота
            blockPlayerBot = random();
            blockPlayerBot2 = random();

            System.out.println(s2 + "\n" + s + s + "ROUND " + count + "\n" + s2);
            count++;

            //выбор удара для игрока
            humanList.get(PLAYER_ONE).hitSelection();
            System.out.println(s2);

           // System.out.println(blockPlayerBot + " " + blockPlayerBot2);

            System.out.print(s + "Удар:  ");
            //метод ввода чисел и проверка на коректные числа
            hitPlayer = numberFormat();

            System.out.println(s2);
            round(hitPlayer, blockPlayerBot, blockPlayerBot2);
            System.out.println(s2);
            Thread.sleep(1000);
            //вывод в консоль варианты блока для игрока
            humanList.get(PLAYER_ONE).blokSelection();
            System.out.println(s2);
            //рандомное число удара для бота
            hitPlayerBot = random();

           // System.out.println(hitPlayerBot);

            System.out.print(s + "Блок левой рукой:   ");
            //ждем ввод чисел и проверка на коректные числа
            blockPlayer = numberFormat();

            System.out.print(s + "Блок правой рукой:  ");
            //ждем ввод чисел и проверка на коректные числа
            blockPlayer2 = numberFormat();

            System.out.println(s2);
            //передаем полученые данные в метод
            round2(hitPlayerBot, blockPlayer, blockPlayer2);
        }
        //проверка кто выйграл
        if (healthOne > healthTwo)
            System.out.println(s + "Победил(а) " + nameOne);
        else if (healthOne < healthTwo)
            System.out.println(s + "Победил(а) " + nameTwo);
        else
            System.out.println(s + "Ничья");
    }

    public void round(int hit, int bb, int bb2) throws  InterruptedException

    {
        //Имя и рандомный замах
        System.out.print(s + nameOne + say.list1.get(randomSay(say.list1.size())));
        //Игрок бьет Бота

        //если блокировал Бот
        if (hit == bb | hit == bb2) {
            System.out.println(say.list2.get(randomSay(say.list2.size())) + say.list5.get(hit));
            System.out.println(s + nameTwo + say.list3.get(randomSay(say.list3.size())) +
                    say.list4.get(randomSay(say.list4.size())) );
            //если Игрок попал
        } else {
            System.out.println(say.list2.get(randomSay(say.list2.size())) + say.list5.get(hit));
            System.out.println(s + nameTwo + say.list6.get(randomSay(say.list6.size())) + say.list5.get(hit));
            healthTwo -= 20;

        }
        Thread.sleep(4000);
    }
        public void round2(int hitB, int bp, int bp2) throws InterruptedException {
        //Бот бьет Игрока
        //Имя, замах
        System.out.print(s + nameTwo + say.list1.get(randomSay(say.list1.size())));
        //если блокировал Игрок
        if (hitB == bp | hitB == bp2) {
            System.out.println(say.list2.get(randomSay(say.list2.size())) + say.list5.get(hitB) + "\n" + s + nameOne + say.list3.get(randomSay(say.list3.size())) +
                    say.list4.get(randomSay(say.list4.size())) );
            //если Бот попал
        } else {
            System.out.println(say.list2.get(randomSay(say.list2.size())) + say.list5.get(hitB));
            System.out.println(s + nameOne + say.list6.get(randomSay(say.list6.size())) + say.list5.get(hitB));
            healthOne -= 20;
        }
        System.out.println(s2);
        Thread.sleep(4000);
        //Вывод хр игроков
        System.out.println(s + nameOne + " " + healthOne + " XP");
        System.out.println(s + nameTwo + " " + healthTwo + " XP");
        Thread.sleep(1000);

    }

    //рандом для бота
    public int random() {
        Random random = new Random();
        return 1 + random.nextInt(6 - 1);
    }

    //рандом для текста в бою
    public int randomSay(int j) {
        Random random = new Random();
        return 1 + random.nextInt(j - 1);
    }

    //проверка на ввод чисел
    public static int numberFormat() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num;
        while (true) {
            try {
                num = Integer.parseInt(bufferedReader.readLine());
                if (num > 0 && num < 6) {
                    break;
                } else
                    System.out.println(s + "Введите число от 1 до 5");
            } catch (NumberFormatException | IOException e) {
                System.out.println(s + "Неверный формат");
            }
            bufferedReader.close();
        }
        return num;
    }

}
