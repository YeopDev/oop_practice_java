package io.gitgub.yeop.alarm_clock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TimeTest {
    @ParameterizedTest
    @ValueSource(strings = {"0:00:00"})
    @DisplayName("입력받은 문자열이 parse 되었을 경우")
    void timeNoThrownBy(String time) {
        assertDoesNotThrow(() -> new Time(time));
    }

    @ParameterizedTest
    @ValueSource(strings = {"000000"})
    @DisplayName("입력받은 문자열이 parse되지 않았을 경우")
    void timeThrownBy(String time) {
        assertThatThrownBy(() -> new Time(time))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("입력시간 형식이 H:mm:ss가 아닙니다. (현재 값 %s)".formatted(time));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12:00:00"})
    @DisplayName("equals 확인")
    void timeEqaulsNoThrownBy(String time) {
        assertThatCode(
                () -> {
                    Time thisTime = new Time(time);
                    Time otherTime = new Time("12:00:00");
                    assertThat(thisTime).isEqualTo(otherTime);
                }
        ).doesNotThrowAnyException();
    }
}