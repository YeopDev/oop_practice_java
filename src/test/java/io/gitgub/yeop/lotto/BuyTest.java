package io.gitgub.yeop.lotto;

import io.gitgub.yeop.lotto.create.CreateLottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class BuyTest {
    private Buy buy;

    @BeforeEach
    void setup() {
        buy = new Buy();
    }

    @ParameterizedTest
    @ValueSource(ints = {6})
    @DisplayName("로또를_구입하다")
    void addNoThrownBy(int size) {
        assertThatCode(
                () -> {
                    buy.add(new Lotto(CreateLottoNumbers.AUTO.create(size)));
                }
        ).doesNotThrowAnyException();
    }

}