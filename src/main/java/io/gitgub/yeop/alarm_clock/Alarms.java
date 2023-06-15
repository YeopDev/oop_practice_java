package io.gitgub.yeop.alarm_clock;

import java.util.ArrayList;
import java.util.List;

final class Alarms {
    private final List<Time> times;

    public Alarms() {
        times = new ArrayList<>();
    }

    public void add(Time time) {
        times.add(time);
    }
}
