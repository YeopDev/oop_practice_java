package io.gitgub.yeop.alarm_clock;

import java.util.Scanner;

public class AlaramRunner {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.start(currentTime -> System.out.println("현재시간: " + currentTime));

        Alarms alarms = new Alarms();

        Scanner scanner = new Scanner(System.in);

        Time time = new Time(scanner.nextLine());
    }
}
