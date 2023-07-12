package io.gitgub.yeop.search;

import java.util.Scanner;

public enum City {
    SEOUL(200),
    BUSAN(100),
    JEJU(50);
    private int population;

    City(int population) {
        this.population = population;
    }

    class CityMain{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String where = scanner.nextLine().toUpperCase();

            City dest = City.valueOf(City.class,where);
        }
}
}
