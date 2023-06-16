package io.gitgub.yeop.alarm_clock;

@FunctionalInterface
public interface TimeConsumer {
    Time consumeTime(String currentTime);
}