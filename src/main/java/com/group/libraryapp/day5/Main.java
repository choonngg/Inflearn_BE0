package com.group.libraryapp.day5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final DiceService service = new DiceService();

        //몇번 던질지 입력
        int a = inputNumber();

        //주사위가 1부터 몇까지 있는지? (보통 6개)
        int size = inputNumber();
        int[] r = service.createDice(size);

        //주사위를 a번 던지기
        service.iterate(r, a);

        //결과 출력
        service.printDiceResult(r);
    }

    static int inputNumber() {
        System.out.print("숫자를 압력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        return number;
    }
}
