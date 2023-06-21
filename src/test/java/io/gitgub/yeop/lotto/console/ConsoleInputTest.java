package io.gitgub.yeop.lotto.console;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class ConsoleInputTest {
    @ParameterizedTest
    @ValueSource(strings = {"2000"})
    @DisplayName("로또_구입을_위해_금액입력_success")
    void buyAmountNoThrownBy(String inputString) {
        assertThatCode(
                () -> {
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
                    System.setIn(inputStream);

                    ConsoleInput input = new ConsoleInput();
                    int purchaseAmount = input.buyAmount();
                    assertThat(purchaseAmount).isEqualTo(2_000);
                }
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"500"})
    @DisplayName("로또_구입을_위해_금액입력_fail")
    void buyAmountThrownBy(String inputString) {
        assertThatThrownBy(
                () -> {
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
                    System.setIn(inputStream);

                    ConsoleInput input = new ConsoleInput();
                    int purchaseAmount = input.buyAmount();
                    assertThat(purchaseAmount).isEqualTo(500);
                }
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("로또 구입을 위한 지불금액은 최소 %d원 이상 입력해야합니다. (현재 값 %d)".formatted(1_000, 500));
    }
}