package io.gitgub.yeop.lotto.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CreateLottoNumbersTest {
    private CreateLottoNumbers createLottoNumbers;

    @BeforeEach
    void setup() {
        createLottoNumbers = CreateLottoNumbers.AUTO;
    }

    @ParameterizedTest
    @ValueSource(ints = {6})
    @DisplayName("랜덤_숫자_생성_중복검사")
    void createNoThrownBy(int size) {
        assertThatCode(
                () -> {
                    Set<Integer> numbers = new HashSet<>(createLottoNumbers.create(size));
                    assertThat(numbers.size()).isEqualTo(size);
                }
        ).doesNotThrowAnyException();
    }

}