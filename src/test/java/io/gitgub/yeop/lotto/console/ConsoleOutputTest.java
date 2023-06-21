package io.gitgub.yeop.lotto.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsoleOutputTest {
    private ConsoleOutput output;

    @BeforeEach
    void setup() {
        output = new ConsoleOutput();
    }

    @Test
    @DisplayName("선언해_놓은_메시지를_출력한다")
    void printBuyAmountMessageNoThrownBy(){
        assertThatCode(
                () -> {
                    output.printBuyAmountMessage();
                }
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("총_몇장의_로또용지를_구매했는지_출력한다_success")
    void printBuyConfirmationMessageNoThrownBy(int buyOfNumber){
        assertThatCode(
                () -> {
                    output.printBuyConfirmationMessage(buyOfNumber);
                }
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    @DisplayName("총_몇장의_로또용지를_구매했는지_출력한다_fail")
    void printBuyConfirmationMessageThrownBy(int buyOfNumber){
        assertThatThrownBy(
                () -> {
                    output.printBuyConfirmationMessage(buyOfNumber);
                }
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("최소 %d장 이상 구입해야 합니다. (현재 값 %d)".formatted(1, buyOfNumber));
    }
}