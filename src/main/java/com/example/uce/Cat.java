package com.example.uce;

public final class Cat {

    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Thomas");
        cats[1] = new Cat("Behemoth");
        cats[2] = new Cat("Lionel");

        int[][] matrix = new int[10][3];

        for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j]+ " ");
    }
    System.out.println();
}

    }
}
