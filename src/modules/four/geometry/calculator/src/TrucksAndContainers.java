package modules.four.geometry.calculator.src;

/*
Вы доставляете гуманитарную помощь в ящиках одинакового размера. У вас есть грузовики и контейнеры.
В каждый грузовик помещается максимум 12 контейнеров.
В каждый контейнер — не более 27 ящиков.
Ящики, контейнеры и грузовики пронумерованы.
Напишите программу, которая распределит ящики по контейнерам и грузовикам в зависимости от их количества.
Программа должна выводить необходимое для этого число грузовиков и контейнеров.

Принцип работы программы
Указываем число ящиков — получаем результат в виде строк:
Грузовик 1:
    Контейнер 1:
      Ящик 1
      Ящик 2
      Ящик 3
      …
  Контейнер 2
      Ящик 28
      Ящик 29
 …
Необходимо:
грузовиков — 1 шт.
контейнеров — 10 шт.
 */


import java.util.Scanner;

public class TrucksAndContainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countBoxes = scanner.nextInt();
        int countContainers, countTrucks;
        int maxBoxes = 27;
        int maxContainers = 12;
        countContainers = (int) Math.ceil((double) countBoxes / maxBoxes);
        countTrucks = (int) Math.ceil((double) countContainers / maxContainers);

        for (int i = 0; i < countTrucks; i++) {
            System.out.println("Грузовик " + (i + 1) + ":");
            for (int j = 0; j < maxContainers && (i * maxContainers + j) < countContainers; j++) {
                System.out.println("\tКонтейнер " + (i * maxContainers + j + 1) + ":");
                for (int k = 0; k < maxBoxes && ((i * maxContainers + j) * maxBoxes + k) < countBoxes; k++) {
                    System.out.println("\t\tЯщик " + ((i * maxContainers + j) * maxBoxes + k + 1));
                }
            }
        }

    }
}
