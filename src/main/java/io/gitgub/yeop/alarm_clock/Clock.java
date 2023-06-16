package io.gitgub.yeop.alarm_clock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Thread {
    private static final int FIX_SECOND = 1_000;
    private static final int FIX_DELAY = 1_000;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm:ss");

    @Override
    public void run() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new PrintTimeTask(), FIX_DELAY, FIX_SECOND);
    }

    public static Time start(TimeConsumer consumer) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String now = localDateTime.format(DATE_TIME_FORMATTER);
        return consumer.consumeTime(now);
    }

    private static class PrintTimeTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("현재시간: %s".formatted(Clock.start(Time::new)));
        }
    }
}