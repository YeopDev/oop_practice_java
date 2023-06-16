package io.gitgub.yeop.alarm_clock;

import java.util.Scanner;

public class AlaramRunner {
    public static void main(String[] args) {
        Clock clock = new Clock();
        Alarms alarms = new Alarms();

        clock.start();

        Scanner scanner = new Scanner(System.in);
        alarms.add(new Time(scanner.nextLine()));
        alarms.start();
    }
}
