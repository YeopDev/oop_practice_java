package io.gitgub.yeop.alarm_clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public record Time(String now) {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm:ss");

    public Time {
        validateTimeFormat(now.trim());
    }

    @Override
    public String toString() {
        return "Time[%s]".formatted(now);
    }

    /**
     * LocalDateTime.parse(now, DATE_TIME_FORMATTER);
     * Java는 날짜 값을 DateTime으로 허용하지 않는 것으로 나타났습니다. LocalDateTime 대신 LocalDate를 사용하면 문제가 해결됩니다.
     *
     * @param now
     */
    private void validateTimeFormat(String now) {
        try {
            LocalTime.parse(now, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException dateTimeParseException) {
            throw new IllegalStateException("입력시간 형식이 H:mm:ss가 아닙니다. (현재 값 %s)".formatted(now), dateTimeParseException);
        }
    }
}
