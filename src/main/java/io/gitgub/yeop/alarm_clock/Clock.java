package io.gitgub.yeop.alarm_clock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public record Clock() {
    private static final int FIX_SECOND = 1_000;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm:ss");

    public void start(TimeConsumer consumer) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime localDateTime = LocalDateTime.now();
                String now = localDateTime.format(DATE_TIME_FORMATTER);
                consumer.consumeTime(now);
            }
        };

        timer.scheduleAtFixedRate(task, 0, FIX_SECOND);
    }
}