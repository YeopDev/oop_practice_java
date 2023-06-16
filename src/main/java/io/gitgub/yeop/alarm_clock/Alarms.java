package io.gitgub.yeop.alarm_clock;

import java.util.*;

final class Alarms extends Thread {
    private final List<Time> times;

    public Alarms() {
        times = new ArrayList<>();
    }

    public void add(Time time) {
        times.add(time);
    }

    /**
     * ifPresentOrElse  - 값이 존재할때와 존재하지 않을때 사용
     * ifPresent - 값이 존재할때만 사용
     */
    @Override
    public void run() {
        while (true) {
            catcher(Clock.start(Time::new)).ifPresent(action -> System.out.println("알람이 울립니다!!!"));
        }
    }

    public Optional<Time> catcher(Time time) {
        if (times.removeIf(time::equals)) {
            return Optional.of(time);
        }
        return Optional.empty();
    }
}
