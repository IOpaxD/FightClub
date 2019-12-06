package ru.arestov;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HumanSay {
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    List<String> list3 = new ArrayList<>();
    List<String> list4 = new ArrayList<>();
    List<String> list5 = new ArrayList<>();
    List<String> list6 = new ArrayList<>();

    public List<String> listAdd(List<String> list, String s) {
        list.add(s);
        return list;
    }

    public HumanSay() {
        initList();
    }

    public void attackSay() {
        listAdd(list1, "");
        listAdd(list1, " с разгону");
        listAdd(list1, " в прыжке");
        listAdd(list1, " исподтишка");
        listAdd(list1, " в ярости");
        listAdd(list1, " со словами \"я хотел(а) эту футболку\"");
        listAdd(list1, " в бешенстве");
        listAdd(list1, " спотыкаясь");
        listAdd(list1, " с разбега");
        listAdd(list1, " делая маневр");
        listAdd(list1, " с места");
        listAdd(list1, " в полете");
        listAdd(list1, " сжимая в руках кастет");
        listAdd(list1, " прицелившись");
        listAdd(list1, " не моргнув глазом");
        listAdd(list1, " поймав момент");
    }

    public void attackSay2() {
        listAdd(list2, "");
        listAdd(list2, " наносит удар");
        listAdd(list2, " производит хук правой");
        listAdd(list2, " с вертухи бьет");
        listAdd(list2, " левым хуком бьет");
        listAdd(list2, " с ноги бьет");
        listAdd(list2, " наносит удар коленом");
        listAdd(list2, " локтем бьет");
        listAdd(list2, " наносит удар за ударом");
        listAdd(list2, " лупит");
        listAdd(list2, " наносит удар");

    }

    public void missSay() {
        listAdd(list3, "");
        listAdd(list3, " присев");
        listAdd(list3, " падая");
        listAdd(list3, " подпрыгнув");
        listAdd(list3, " выпрыгивая");
        listAdd(list3, " пригибаясь");
        listAdd(list3, " прикурив сигарету");
        listAdd(list3, " приугадав");
        listAdd(list3, " попивая кофе");
        listAdd(list3, " показав средний палец");

    }

    public void missSay2() {
        listAdd(list4, "");
        listAdd(list4, " отбивает удар");
        listAdd(list4, " ставит блок");
        listAdd(list4, " уворачивается");
        listAdd(list4, " блокирует удар");
        listAdd(list4, " ставит блок");

    }

    public void hit() {
        listAdd(list5, " ");
        listAdd(list5, " в голову ");
        listAdd(list5, " в грудь ");
        listAdd(list5, " в живот ");
        listAdd(list5, " в пояс/пах ");
        listAdd(list5, " в ноги ");

    }

    public void missed() {
        listAdd(list6, "");
        listAdd(list6, " получает удар");
        listAdd(list6, " получает подачу");


    }

    public void initList() {
        attackSay();
        attackSay2();
        missSay();
        missSay2();
        hit();
        missed();
    }


}
