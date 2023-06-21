package io.gitgub.yeop.lotto;

import io.gitgub.yeop.lotto.create.CreateLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @ParameterizedTest
    @ValueSource(ints = {6})
    @DisplayName("로또 번호 생성")
    void createLottoNumbers(int size) {
        assertDoesNotThrow(() -> new Lotto(CreateLottoNumbers.AUTO.create(size)));
    }
}
