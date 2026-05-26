package com.example.uce;
import java.util.Random;
import java.util.Scanner;

class BingoCard {
    int[][] numbers = new int[5][5];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("===== BINGO =====");

        BingoCard playerCard = createBingoCard(random);

        System.out.println("\nTu tarjeta:");
        displayCard(playerCard);

        while (true) {

            System.out.println("\nPresiona ENTER para sacar un número...");
            scanner.nextLine();

            int drawnNumber = generateRandomNumber(random, 1, 25);

            System.out.println("\nNúmero sorteado: " + drawnNumber);

            markNumber(playerCard, drawnNumber);

            System.out.println("\nTu tarjeta:");
            displayCard(playerCard);

            if (hasBingo(playerCard)) {
                System.out.println("\n¡¡BINGO!! Has ganado.");
                break;
            
            }
        }

        scanner.close();
    }

    private static int generateRandomNumber(Random random, int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    private static BingoCard createBingoCard(Random random) {

        BingoCard card = new BingoCard();

        int[] nums = new int[25];

        for (int i = 0; i < 25; i++) {
            nums[i] = i + 1;
        }

        for (int i = 0; i < 25; i++) {
            int j = random.nextInt(25);

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int index = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                card.numbers[i][j] = nums[index++];
            }
        }

        return card;
    }

    private static void markNumber(BingoCard card, int number) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (card.numbers[i][j] == number) {
                    card.numbers[i][j] = 0;
                }
            }
        }
    }

    private static boolean hasBingo(BingoCard card) {

        for (int i = 0; i < 5; i++) {

            boolean row = true;

            for (int j = 0; j < 5; j++) {
                if (card.numbers[i][j] != 0) {
                    row = false;
                    break;
                }
            }

            if (row) {
                return true;
            }
        }

        for (int j = 0; j < 5; j++) {

            boolean column = true;

            for (int i = 0; i < 5; i++) {
                if (card.numbers[i][j] != 0) {
                    column = false;
                    break;
                }
            }

            if (column) {
                return true;
            }
        }

        boolean diagonal1 = true;

        for (int i = 0; i < 5; i++) {
            if (card.numbers[i][i] != 0) {
                diagonal1 = false;
                break;
            }
        }

        if (diagonal1) {
            return true;
        }

        boolean diagonal2 = true;

        for (int i = 0; i < 5; i++) {
            if (card.numbers[i][4 - i] != 0) {
                diagonal2 = false;
                break;
            }
        }

        return diagonal2;
    }

    private static void displayCard(BingoCard card) {

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                if (card.numbers[i][j] == 0) {
                    System.out.print("X\t");
                } else {
                    System.out.print(card.numbers[i][j] + "\t");
                }
            }

            System.out.println();
        }
    }
}
