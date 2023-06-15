package io.gitgub.yeop.alarm_clock;

@FunctionalInterface
public interface TimeConsumer {
    void consumeTime(String currentTime);
}