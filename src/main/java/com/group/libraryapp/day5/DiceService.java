package com.group.libraryapp.day5;

public class DiceService {

    public int[] createDice(int size) {
        int[] r = new int[size];
        for (int i : r) {
            i = 0;
        }
        return r;
    }

    public void iterate(int[] dice, int a) {
        for (int i = 0; i < a; i++) {
            int b = (int) (Math.random() * dice.length);
            dice[b]++;
        }
    }

    public void printDiceResult(int[] r) {
        for (int i = 0; i < r.length; i++) {
            System.out.printf("%d은 %d번 나왔습니다.\n", i + 1, r[i]);
        }
    }
}
