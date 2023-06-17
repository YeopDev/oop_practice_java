package io.gitgub.yeop.numberBaseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {
    @ParameterizedTest
    @ValueSource(strings = {"123"})
    @DisplayName("숫자를 입력받는다.")
    void constructorNoThrownBy(String target) {
        assertThatCode(() -> new Numbers(target)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"12"})
    @DisplayName("입력받는 길이가 3 미만의 값이 들어왔을 경우")
    void constructorThrownBy(String target) {
        assertThatThrownBy(() -> new Numbers(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 길이는 %d 보다 작아야 합니다. (현재 값 %d)".formatted(3, target.length()));
    }
}