// Написать программу, показывающую последовательность действий для игры “Ханойская башня”

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество колец: ");
        int n = sc.nextInt();
        sc.close();
        System.out.println("\nНачальные параметры:\nКолец задано = " + n + " и 3 стержня.\nПоследовательность для решения:");
        move(n, 1, 3);
    }

    public static void move(int n, int start, int end) {
        if (n == 0) {
            return;
        }
        int middle = 6 - start - end;
        move(n - 1, start, middle);
        System.out.println("Перемещаем диск " + n + " со штыря № " + start + " на штырь №  " + end);
        move(n - 1, middle, end);
    }
}


