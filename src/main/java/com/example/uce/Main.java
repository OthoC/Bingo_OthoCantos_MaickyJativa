package com.example.uce;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("BINGO");

        String[][] bingo;
        bingo = new String[5][5];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo.length; j++) {
                int aux;
                boolean repetido;
                do {
                    aux = (int) (Math.random() * 100);
                    repetido = false;

                    for (int f = 0; f < bingo.length; f++) {
                        for (int c = 0; c < bingo.length; c++) {

                            if (bingo[f][c] != null && bingo[f][c].equals(String.valueOf(aux))) {
                                repetido = true;
                            }
                        }
                    }

                } while (repetido);

                bingo[i][j] = String.valueOf(aux);
            }
        }

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo.length; j++) {
                System.out.print(bingo[i][j] + "\t");
            }
            System.out.println();
        }

        while (true) {

            System.out.println("Ingrese fila: ");
            int fila = sc.nextInt();

            System.out.println("Ingrese columna: ");
            int columna = sc.nextInt();

            if (fila < 0 || fila >= bingo.length ||
                    columna < 0 || columna >= bingo[0].length) {

                System.out.println("Posición inválida");
                continue;
            }
            bingo[fila][columna] = "X";

            for (int i = 0; i < bingo.length; i++) {
                for (int j = 0; j < bingo.length; j++) {
                    System.out.print(bingo[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}